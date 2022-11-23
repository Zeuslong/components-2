package cn.vxnm.component.jdk11.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProbabilityCalculatorTest {

    ProbabilityCalculator probabilityCalculator = new ProbabilityCalculator();

    @Test
    public void calculate() {
        for (int j = 0; j < 10; j ++) {

            int times_true = 0;
            int times_false = 0;

            for (int i = 0; i < 100; i++) {
                boolean result = probabilityCalculator.calculate(90);
                if (result) {
                    times_true++;
                } else {
                    times_false++;
                }
            }

            System.out.printf("times of true: %d, times of false: %d\n", times_true, times_false);
        }
    }
}