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

            // showPrimeNumbers(primeNumbers);
            totalDuration += System.currentTimeMillis() - duration;
        }

        System.out.printf("%f ms\n", totalDuration / tests);
    }

    public static void showPrimeNumbers(boolean[] primeNumbers) {
        for (int number = 0; number < primeNumbers.length; number ++) {
            if (primeNumbers[number]) {
                System.out.println(number);
            }
        }
    }

    public static void erathosteneMonoThread(int tests, int maxRange) {
        erathosteneBenchmark(tests, maxRange, false);
    }

    public static void erathosteneMultiThread(int tests, int maxRange) {
        erathosteneBenchmark(tests, maxRange, true);
    }
}
