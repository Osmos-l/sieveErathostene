public abstract class Benchmark {

    private static void erathosteneBenchmark(int tests, int maxRange, boolean isMultithread) {
        double totalDuration = 0;

        for (int test = 0; test < tests; test ++) {
            boolean[] primeNumbers = Erathostene.generateDefaultArray(maxRange);

            double duration = System.currentTimeMillis();
            if (isMultithread) {
                Erathostene.multithread(primeNumbers);
            } else {
                Erathostene.monothread(primeNumbers);
            }

            totalDuration += System.currentTimeMillis() - duration;
        }

        System.out.printf("%f ms\n", totalDuration / tests);
    }

    public static void erathosteneMonoThread(int tests, int maxRange) {
        erathosteneBenchmark(tests, maxRange, false);
    }

    public static void erathosteneMultiThread(int tests, int maxRange) {
        erathosteneBenchmark(tests, maxRange, true);
    }
}
