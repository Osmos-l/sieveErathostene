package models;

/**
 *
 */
public abstract class Benchmark {

    /**
     * Benchmark of erathostene crible
     * @param tests The number of test
     * @param maxRange The max range of prime numbers we were searching for, [2 .. maxRange]
     * @param isMultithread true for multithread execution, false in other case
     * @param print Display prime numbers at the end
     */
    public static void erathostene(int tests, int maxRange, boolean isMultithread, boolean print) {
        double totalDuration = 0;

        for (int test = 0; test < tests; test ++) {
            Erathostene erathostene = new Erathostene(maxRange);

            double duration = System.currentTimeMillis();
            erathostene.crible(isMultithread);
            totalDuration += System.currentTimeMillis() - duration;

            if (print) {
                erathostene.displayPrimeNumbers();
            }

        }

        System.out.printf("%f ms\n", totalDuration / tests);
    }

}
