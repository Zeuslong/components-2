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
     * [min, max]
     *
     * 由于 float 在两个整数之间存在的数特别多，所以 min 与 max 会生成，但是生成的概率特别低。
     *
     * Because float exists so many numbers between two integers, min and max are generated,
     * but the probability of them being generated is extremely low.
     */
    public float nextFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    /**
     * [min, max]
     *
     * 与 float 的情况类似，但两个整数之间 double 存在的数更多，所以 min 与 max 生成的概率更低。
     *
     * Similar to float, but with more doubles between the two integers,
     * min and max are less likely to be generated.
     */
    public double nextDouble(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }
}
