package net.scriptgate.engine;

public class Key {

    public final int keyCode;
    private final String keyName;
    public final boolean shiftPressed;
    public final boolean ctrlPressed;

    public Key(int keyCode, String keyName, boolean shiftPressed, boolean ctrlPressed) {
        this.keyCode = keyCode;
        this.keyName = keyName;
        this.shiftPressed = shiftPressed;
        this.ctrlPressed = ctrlPressed;
    }

    public String getKeyName() {
        return keyName;
    }

    public static Key from(int keyCode, String keyName, boolean shiftPressed, boolean ctrlPressed) {

        keyName = keyName == null || shiftPressed ? keyName : keyName.toLowerCase();
        if (keyName != null && keyName.equals("-") && shiftPressed) {
            keyName = "_";
        }

        return new Key(keyCode, keyName, shiftPressed, ctrlPressed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (keyCode != key.keyCode) return false;
        if (shiftPressed != key.shiftPressed) return false;
        return keyName != null ? keyName.equals(key.keyName) : key.keyName == null;

    }

    @Override
    public int hashCode() {
        int result = keyCode;
        result = 31 * result + (keyName != null ? keyName.hashCode() : 0);
        result = 31 * result + (shiftPressed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Key{" +
                "keyCode=" + keyCode +
                ", keyName='" + keyName + '\'' +
                ", shiftPressed=" + shiftPressed +
                '}';
    }
}
