package models;

import interfaces.iBenchmark;

public class ErathosteneBenchmark implements iBenchmark {

    int tests;
    int maxRange;

    /**
     * Initial state of benchmark
     * @param tests The number of test you want to execute
     * @param maxRange The max range of prime numbers we were searching for, [2 .. maxRange]
     */
    public ErathosteneBenchmark(int tests, int maxRange) {
        this.tests = tests;
        this.maxRange = maxRange;
    }

    @Override
    public void run(boolean inMultithread, boolean print) {
        double totalDuration = 0;

        for (int test = 0; test < tests; test ++) {
            Erathostene erathostene = new Erathostene(maxRange);

            double duration = System.currentTimeMillis();
            erathostene.crible(inMultithread);
            totalDuration += System.currentTimeMillis() - duration;

            if (print) {
                erathostene.displayPrimeNumbers();
            }

        }

        System.out.printf("%f ms\n", totalDuration / tests);
    }

}
