package model;

public class Elevator {
    private static final int CAPACITY = 5;
    private int currentCapacity;

    public static int getCapacity() {
        return CAPACITY;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        if (currentCapacity < 0) {
            this.currentCapacity = 0;
            return;
        }
        this.currentCapacity = currentCapacity;
    }
}
