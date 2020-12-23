package service;

import java.util.Random;
import model.Elevator;
import model.Floor;
import model.House;

public class WorkingElevator {
    House house = new House();
    Elevator elevator = house.getElevator();
    Floor[] floors = house.getFloors();
    int lastFloor;

    private boolean checkForEmpty() {
        for (int i = 0; i < floors.length; i++) {
            if (floors[i].getNumberOfPassengers() != 0) {
                return false;
            }
        }
        return true;
    }

    private void infoCurrent(int begin, int nextFloor) {
        System.out.println("Current floor - " + begin
                + ", waiting passengers - " + floors[begin].getNumberOfPassengers()
                + ", nextFloor - " + nextFloor);
        System.out.println("---------------------------------------------------------");
    }

    private int maxFloor(int begin, int length) {
        int repeat = new Random().nextInt(length);
        while (begin == repeat) {
            repeat = new Random().nextInt(length);
        }
        return repeat;
    }

    private int floorForExit() {
        return new Random().nextInt(floors.length);
    }

    private void goToElevator(int begin, int position) {
        while (elevator.getCurrentCapacity() < Elevator.getCapacity()) {
            if (begin > floorForExit()) {
                elevator.setCurrentCapacity(elevator.getCurrentCapacity() - 1);
            }
            if (floors[position].getNumberOfPassengers() != 0) {
                elevator.setCurrentCapacity(elevator.getCurrentCapacity() + 1);
                floors[position].setNumberOfPassengers(floors[position]
                        .getNumberOfPassengers() - 1);
            } else {
                break;
            }
        }
    }

    private void work(int begin) {
        int nextFloor = maxFloor(begin, floors.length);
        if (nextFloor < begin) {
            for (int i = begin; i > nextFloor; i--) {
                goToElevator(begin, i);
            }
        }
        if (nextFloor > begin) {
            for (int i = begin; i < nextFloor; i++) {
                goToElevator(begin, i);
            }
        }
        infoCurrent(begin, nextFloor);
        getInformationAboutFloors();
        elevator.setCurrentCapacity(0);
        lastFloor = nextFloor;
    }

    private void afterWork() {
        while (!checkForEmpty()) {
            work(lastFloor);
        }
    }

    private void getInformationAboutFloors() {
        System.out.println("INFO ABOUT FLOORS");
        for (int i = 0; i < floors.length; i++) {
            System.out.println("Passengers - " + floors[i]
                    .getNumberOfPassengers() + ", floor - " + i);
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        WorkingElevator workingElevator = new WorkingElevator();
        workingElevator.getInformationAboutFloors();
        workingElevator.work(0);
        workingElevator.afterWork();
        /*System.out.println("Length - " + workingElevator.floors.length);
        workingElevator.beforeElevator();
        workingElevator.getInformationAboutFloors();*/
    }
}
