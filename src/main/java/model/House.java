package model;

import java.util.Random;

public class House {
    private int maxFloor = 20;
    private Floor[] floors;
    private Elevator elevator;

    public House() {
        generateFloor();
        createFloorAndElevator();
        generatePassengers();
    }

    private void generateFloor() {
        int currentFloor = new Random().nextInt(maxFloor);
        while (currentFloor < 5) {
            currentFloor = new Random().nextInt(maxFloor);
        }
        floors = new Floor[currentFloor];
    }

    private void createFloorAndElevator() {
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor();
        }
        elevator = new Elevator();
    }

    private void generatePassengers() {
        for (int i = 0; i < floors.length; i++) {
            floors[i].setNumberOfPassengers(new Random().nextInt(10));
        }
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Floor[] getFloors() {
        return floors;
    }
}
