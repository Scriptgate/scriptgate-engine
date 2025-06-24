package net.scriptgate.engine;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public abstract class InputComponent {

    private final Set<Key> pressedKeys;

    private int mouseX = 0;
    private int mouseY = 0;

    private int screenWidth = Engine.WIDTH;
    private int screenHeight = Engine.HEIGHT;

    private boolean shiftPressed = false;
    private boolean ctrlPressed = false;
    private boolean mousePressed = false;

    public InputComponent() {
        this.pressedKeys = new HashSet<>();
    }

    public int getMouseX() {
        return this.mouseX;
    }

    public int getMouseY() {
        return this.mouseY;
    }

    public void mouseMoved(int x, int y) {
        this.mouseX = x;
        this.mouseY = y;
    }

    public boolean isShiftPressed() {
        return shiftPressed;
    }

    public void setShiftPressed(boolean shiftPressed) {
        this.shiftPressed = shiftPressed;
    }

    public boolean isCtrlPressed() {
        return ctrlPressed;
    }

    public void setCtrlPressed(boolean ctrlPressed) {
        this.ctrlPressed = ctrlPressed;
    }

    public Stream<Key> getPressedKeys() {
        return pressedKeys.stream();
    }

    public void keyPressed(Key key) {
        if (!pressedKeys.contains(key)) {
            pressedKeys.add(key);
        }
    }

    public void keyReleased(Key key) {
        if (pressedKeys.contains(key)) {
            pressedKeys.remove(key);
        }
    }

    public void setMousePressed() {
        mousePressed = true;
    }

    public void setMouseReleased() {
        mousePressed = false;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setScreenSize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}

