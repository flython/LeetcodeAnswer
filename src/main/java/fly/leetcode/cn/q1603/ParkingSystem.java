package fly.leetcode.cn.q1603;


/**
 * 这道题真是浪费人生啊……
 */
class ParkingSystem {
    int counts;

    public ParkingSystem(int big, int medium, int small) {
        counts = (small << 20) | (medium << 10) | big;
    }

    public boolean addCar(int carType) {
        int bit = ((carType-1)*10);
        if (((counts >> bit) & 0b1111111111) <= 0){
            return false;
        } else {
            counts -= 1 << bit;
            return true;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */