package cn.vxnm.component.jdk11.math;

import java.util.Random;

public class RandomNumsGenerator {

    private final Random random = new Random();

    /**
     * [min, max)
     */
    public int nextIntClosedInterval(int min, int max) {
        return Double.valueOf(random.nextFloat() * (max - min)).intValue() + min;
    }

    /**
     * [min, max]
     */
    public int nextInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * [min, max)
     */
    public float nextFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    /**
     * [min, max)
     */
    public double nextDouble(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }
}
