package com.chungnh.simple.weather.utility.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileCache {
    private static final File CACHE_DIR = new File("caches");

    static {
        if (!CACHE_DIR.exists()) {
            CACHE_DIR.mkdirs();
        }
    }

    public void store(String key, BufferedImage bufferedImage) {
        try {
            File file = new File(CACHE_DIR, key);
            if (file.exists() || file.createNewFile()) {
                ImageIO.write(bufferedImage, "png", file);
            }
        } catch (IOException ignored) {
        }
    }

    public BufferedImage get(String key) {
        try {
            String file = new File(CACHE_DIR, key).getAbsolutePath();
            return ImageIO.read(new FileInputStream(file));
        } catch (IOException e) {
            return null;
        }
    }
}
