package com.chungnh.simple.weather.view.custom;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class ImageView extends JLabel {
    public ImageView() {
        setOpaque(false);
    }

    private Color shadowColor = Color.BLACK;
    private float shadowOpacity = 0.5f;
    private int shadowY;
    private int shadowX;
    private int shadowSize = 3;
    private BufferedImage icon;

    public void setShadowOpacity(float shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }

    public void setShadowPosition(int shadowX, int shadowY) {
        this.shadowX = shadowX;
        this.shadowY = shadowY;
    }

    public void setShadowSize(int shadowSize) {
        this.shadowSize = shadowSize;
    }

    public void setIcon(BufferedImage icon) {
        super.setIcon(new ImageIcon(icon));
        this.icon = icon;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (icon != null) {
            g.drawImage(createDropShadow(icon, shadowSize), shadowX, shadowY, null);
        }
        super.paint(g);
    }

    private void applyShadow(BufferedImage image, int shadowSize) {
        int dstWidth = image.getWidth();
        int dstHeight = image.getHeight();

        int left = (shadowSize - 1) >> 1;
        int right = shadowSize - left;
        int xStop = dstWidth - right;
        int yStop = dstHeight - right;

        int shadowRgb = shadowColor.getRGB() & 0x00ffffff;
        int[] aHistory = new int[shadowSize];
        int historyIdx;
        int aSum;

        int[] dataBuffer = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        int lastPixelOffset = right * dstWidth;
        float sumDivider = shadowOpacity / shadowSize;

        // horizontal pass
        for (int y = 0, bufferOffset = 0; y < dstHeight; y++, bufferOffset = y * dstWidth) {
            aSum = 0;
            historyIdx = 0;
            for (int x = 0; x < shadowSize; x++, bufferOffset++) {
                int a = dataBuffer[bufferOffset] >>> 24;
                aHistory[x] = a;
                aSum += a;
            }

            bufferOffset -= right;

            for (int x = left; x < xStop; x++, bufferOffset++) {
                int a = (int) (aSum * sumDivider);
                dataBuffer[bufferOffset] = a << 24 | shadowRgb;

                // subtract the oldest pixel from the sum
                aSum -= aHistory[historyIdx];

                // get the latest pixel
                a = dataBuffer[bufferOffset + right] >>> 24;
                aHistory[historyIdx] = a;
                aSum += a;

                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
        }

        // vertical pass
        for (int x = 0, bufferOffset = 0; x < dstWidth; x++, bufferOffset = x) {
            aSum = 0;
            historyIdx = 0;
            for (int y = 0; y < shadowSize; y++, bufferOffset += dstWidth) {
                int a = dataBuffer[bufferOffset] >>> 24;
                aHistory[y] = a;
                aSum += a;
            }

            bufferOffset -= lastPixelOffset;

            for (int i = left; i < yStop; i++, bufferOffset += dstWidth) {
                int a = (int) (aSum * sumDivider);
                dataBuffer[bufferOffset] = a << 24 | shadowRgb;

                // subtract the oldest pixel from the sum
                aSum -= aHistory[historyIdx];

                // get the latest pixel
                a = dataBuffer[bufferOffset + lastPixelOffset] >>> 24;
                aHistory[historyIdx] = a;
                aSum += a;

                if (++historyIdx >= shadowSize) {
                    historyIdx -= shadowSize;
                }
            }
        }
    }


    private BufferedImage prepareImage(BufferedImage image, int shadowSize) {
        int width = image.getWidth() + (shadowSize * 2);
        int height = image.getHeight() + (shadowSize * 2);
        BufferedImage subject = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = subject.createGraphics();
        g2.drawImage(image, null, shadowSize, shadowSize);
        g2.dispose();
        return subject;
    }

    public Image createDropShadow(BufferedImage image, int shadowSize) {
        BufferedImage subject = prepareImage(image, shadowSize);
        applyShadow(subject, shadowSize);
        return subject;
    }
}