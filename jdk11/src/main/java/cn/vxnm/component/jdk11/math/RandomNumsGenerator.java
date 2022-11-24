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
        return nextFloat(min, max, 0);
    }

    /**
     * [min, max]
     * @param step 单位步长
     *             比如 1.1  1.2  1.3  1.4  1.5  1.6  1.7  1.8  1.9 => step 为 0.1
     *             比如 1.01  1.02  1.03  1.04  1.05  1.06  1.07  1.08  1.09 => step 为 0.01
     */
    public float nextFloat(float min, float max, float step) {
        return random.nextFloat() * (max + step - min) + min;
    }

    /**
     * [min, max)
     */
    public double nextDouble(double min, double max) {
        return nextDouble(min, max, 0);
    }

    /**
     * [min, max]
     *
     * @param step 单位步长
     *             比如 1.1  1.2  1.3  1.4  1.5  1.6  1.7  1.8  1.9 => step 为 0.1
     *             比如 1.01  1.02  1.03  1.04  1.05  1.06  1.07  1.08  1.09 => step 为 0.01
     */
    public double nextDouble(double min, double max, double step) {
        return random.nextDouble() * (max + step - min) + min;
    }
}
