package cn.vxnm.component.jdk11.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNumsGeneratorTest {

    RandomNumsGenerator generator = new RandomNumsGenerator();

    @Test
    public void nextIntClosedInterval() {
        int min = 1;
        int max = 100;

        int min_times = 0;

        for (long i = 0; i < 10000000; i++) {
            int random = generator.nextIntClosedInterval(min, max);
            assertTrue(String.format("random = %d", random),min <= random);
            assertTrue(String.format("random = %d", random), random < max);

            if (min == random) {
                min_times++;
            }
        }

        System.out.printf("min times = %d%n", min_times);
    }

    @Test
    public void nextInt() {
        int min = 1;
        int max = 100;

        int min_times = 0;
        int max_times = 0;

        for (long i = 0; i < 10000000; i++) {
            int random = generator.nextInt(min, max);
            assertTrue(String.format("random = %d", random), min <= random);
            assertTrue(String.format("random = %d", random), random <= max);

            if (min == random) {
                min_times ++;
            }
            if (max == random) {
                max_times ++;
            }
        }

        System.out.printf("min times = %d  max times = %d%n", min_times, max_times);
    }

    @Test
    public void nextFloat() {
        float min = 1.0f;
        float max = 1.1f;

        int min_times = 0;
        int max_times = 0;

        for (long i = 0; i < 10000000; i++) {
            float random = generator.nextFloat(min, max);
            assertTrue(String.format("random = %f", random), min <= random);
            assertTrue(String.format("random = %f", random), random <= max);

            if (min == random) {
                min_times ++;
            }
            if (max == random) {
                max_times ++;
            }
        }

        System.out.printf("min times = %d  max times = %d%n", min_times, max_times);
    }

    @Test
    public void nextDouble() {
        double min = 1.0f;
        double max = 1.0000000001d;

        int min_times = 0;
        int max_times = 0;

        for (long i = 0; i < 10000000; i++) {
            double random = generator.nextDouble(min, max);
            assertTrue(String.format("random = %f", random), min <= random);
            assertTrue(String.format("random = %f", random), random <= max);

            if (min == random) {
                min_times ++;
            }
            if (max == random) {
                max_times ++;
            }
        }

        System.out.printf("min times = %d  max times = %d%n", min_times, max_times);
    }
}