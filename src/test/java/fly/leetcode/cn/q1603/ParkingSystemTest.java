package fly.leetcode.cn.q1603;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSystemTest {



    @Test
    void addCar() {
        ParkingSystem pk = new ParkingSystem(1,1,0);
        assertEquals(true,pk.addCar(1));
        assertEquals(true,pk.addCar(2));
        assertEquals(false,pk.addCar(3));
        assertEquals(false,pk.addCar(1));
    }

    @Test
    void addCar2() {
        ParkingSystem pk = new ParkingSystem(0,0,2);
        assertEquals(false,pk.addCar(1));
        assertEquals(false,pk.addCar(2));
        assertEquals(true,pk.addCar(3));
    }
}