
public enum MyMap {
    OFFLINE((int)0),
    ONLINE((int)1);

    private int value;

    MyMap(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


