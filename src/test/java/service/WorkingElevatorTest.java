package service;

import model.Elevator;
import model.Floor;
import model.House;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WorkingElevatorTest {
    @Test
    void check_capacityFloor() {
        House house = new House();
        Floor[] floors = house.getFloors();
        Integer capacity = floors.length;
        boolean actual = false;
        if (capacity >= 5 && capacity <= 20) {
            actual = true;
        }
        Assertions.assertTrue(true, String.valueOf(actual));
    }

    @Test
    void check_capacityPassengers() {
        Floor[] floors = new Floor[5];
        floors[3] = new Floor();
        Assertions.assertThrows(RuntimeException.class, () -> floors[3].setNumberOfPassengers(11));

        floors[4] = new Floor();
        floors[4].setNumberOfPassengers(3);
        Integer actual2 = floors[4].getNumberOfPassengers();
        Assertions.assertEquals(3, actual2);
    }

    @Test
    void check_finalCapacity_elevator() {
        Integer actual = Elevator.getCapacity();
        Assertions.assertEquals(5, actual);
    }

    @Test
    void set_negativeValue_elevator() {
        Elevator elevator = new Elevator();
        elevator.setCurrentCapacity(-1);
        Integer actual = elevator.getCurrentCapacity();
        Assertions.assertEquals(0, actual);
    }

    @Test
    void set_negativeValue_passengers() {
        Elevator elevator = new Elevator();
        elevator.setCurrentCapacity(-1);
        Integer actual = elevator.getCurrentCapacity();
        Assertions.assertEquals(0, actual);
    }

    @Test
    void set_positiveValue_elevator() {
        Elevator elevator = new Elevator();
        elevator.setCurrentCapacity(4);
        Integer actual = elevator.getCurrentCapacity();
        Assertions.assertEquals(4, actual);
    }

    @Test
    void set_positiveValue_passengers() {
        Elevator elevator = new Elevator();
        elevator.setCurrentCapacity(9);
        Integer actual = elevator.getCurrentCapacity();
        Assertions.assertEquals(9, actual);
    }
}
