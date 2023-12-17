package com.chungnh.simple.weather.utility.image;

import com.chungnh.simple.weather.utility.task.Consumer;
import com.chungnh.simple.weather.utility.task.Observable;
import com.chungnh.simple.weather.utility.task.SimpleSubscriber;
import com.chungnh.simple.weather.view.custom.ImageView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageLoader {
    private static final Dimension ICON_DIMENSION = new Dimension(48, 48);
    private static final FileCache FILE_STORE = new FileCache();
    private static final LRUCache<String, BufferedImage> IMAGE_LRU_CACHE = new LRUCache<>(30);

    public static void load(final String url, final Dimension size, JLabel label) {
        load(url, size, bufferedImage -> label.setIcon(new ImageIcon(bufferedImage)));
    }

    public static void load(final String url, final Dimension size, Consumer<BufferedImage> consumer) {
        if (url == null) return;
        Observable.fromCallable(() -> {
            try {
                String cacheKey = makeCacheKey(url, size);
                BufferedImage bufferedImage = IMAGE_LRU_CACHE.get(cacheKey);
                if (bufferedImage != null) {
                    return bufferedImage;
                }
                bufferedImage = FILE_STORE.get(cacheKey);
                if (bufferedImage != null) {
                    IMAGE_LRU_CACHE.put(cacheKey, bufferedImage);
                    return bufferedImage;
                }
                boolean shouldCache = true;
                if (url.startsWith("http")) {
                    bufferedImage = ImageIO.read(new URL(url));
                } else {
                    URL resource;
                    if (url.startsWith("drawable")) {
                        resource = FILE_STORE.getClass().getResource("/" + url);
                    } else {
                        resource = FILE_STORE.getClass().getResource("/drawable/" + url);
                    }
                    if (resource != null) {
                        bufferedImage = ImageIO.read(resource);
                        System.out.println("Size=" + bufferedImage.getWidth());
                    }
                    shouldCache = false;
                }
                if (size != null) {
                    final BufferedImage resized = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
                    final Graphics2D g = resized.createGraphics();
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g.drawImage(bufferedImage, 0, 0, size.width, size.height, null);
                    g.dispose();
                    bufferedImage = resized;
                }

                IMAGE_LRU_CACHE.put(cacheKey, bufferedImage);
                if (shouldCache) {
                    FILE_STORE.store(cacheKey, bufferedImage);
                }
                return bufferedImage;
            } catch (IOException e) {
                return null;
            }
        }).subscribe(new SimpleSubscriber<>() {
            @Override
            public void onNext(BufferedImage o) {
                consumer.accept(o);
            }
        });
    }

    public static void loadSmIcon(final String url, Consumer<BufferedImage> consumer) {
        load(url, ICON_DIMENSION, consumer);
    }

    public static void loadSmIcon(String url, JLabel label) {
        load(url, ICON_DIMENSION, bufferedImage -> label.setIcon(new ImageIcon(bufferedImage)));
    }

    private static String makeCacheKey(String url, Dimension dimension) {
        if (dimension == null) return String.valueOf(url.hashCode());
        return url.hashCode() + "." + dimension.hashCode();
    }

    public static void loadSmIconWithShadow(String imageUrl, JLabel label) {
        loadSmIcon(imageUrl, bufferedImage -> ((ImageView) label).setIcon(bufferedImage));
    }
}
