package model;

public class Floor {
    private int numberOfPassengers;

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        if (numberOfPassengers < 0) {
            this.numberOfPassengers = 0;
            return;
        }
        if (numberOfPassengers > 10) {
            throw new RuntimeException("A lot of people on a floor");
        }
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return String.valueOf(numberOfPassengers);
    }
}
