package eu.relcfart.conditionaltranformation.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarFactoryTest {

    @Test
    void fastCarForBigMoney() {
        Car car = CarFactory.getCar(500);
        assertEquals("fast", car.getDescription());
        assertEquals(1500, car.getMaxSpeed());
    }

    @Test
    void averageCarForAverageMoney() {
        Car car = CarFactory.getCar(200);
        assertEquals("average", car.getDescription());
        assertEquals(400, car.getMaxSpeed());
    }

    @Test
    void slowCarForSmallMoney() {
        Car car = CarFactory.getCar(199);
        assertEquals("slow", car.getDescription());
        assertEquals(199, car.getMaxSpeed());
    }

    @Test()
    void noCarForNoMoney() {
        assertThrows(RuntimeException.class, () -> CarFactory.getCar(0));
    }
}