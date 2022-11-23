package cn.vxnm.component.jdk11.math;

import java.util.Random;

public class ProbabilityCalculator {

    Random random = new Random();

    /**
     * 给一个 0 - 100 以内的整数作为概率，返回这个概率发生的结果。
     *
     * 比如输入 95，则有 95% 的概率返回 true.
     */
    public boolean calculate(Integer probability) {
        if (probability <= 0) {
            return false;
        }

        if (probability >= 100) {
            return true;
        }

        double random_double = random.nextDouble() * 100;
        double probability_double = Double.valueOf(probability);

        return random_double <= probability_double;
    }
}
