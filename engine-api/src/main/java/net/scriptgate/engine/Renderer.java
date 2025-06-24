package net.scriptgate.engine;

import net.scriptgate.common.Color3f;
import net.scriptgate.common.Color4f;
import net.scriptgate.common.Point;
import net.scriptgate.common.Rectangle;

public interface Renderer {

    void translate(int x, int y);

    default void setColor(Color3f color) {
        setColor(color.r, color.g, color.b);
    }

    default void setColor(float a, Color3f color) {
        setColor(a, color.r, color.g, color.b);
    }

    default void setColor(Color4f color) {
        setColor(color.a, color.r, color.g, color.b);
    }

    void setOpacity(float a);

    void setColor(float r, float g, float b);

    void setColor(float a, float r, float g, float b);

    Rectangle drawText(int x, int y, String text);

    void drawImage(int x, int y, String path);

    void drawImage(String imagePath, Point position, Point offset, Point size);

    void drawLine(int x1, int y1, int x2, int y2);

    void drawCircle(int x, int y, int radius);

    void fillCircle(int x, int y, int radius);

    void drawRect(int x, int y, int width, int height);

    default void fillRect(Rectangle rectangle) {
        fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    void fillRect(int x, int y, int width, int height);

    Rectangle getBounds(int x, int y, String text);
}
