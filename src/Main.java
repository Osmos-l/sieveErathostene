import models.ErathosteneBenchmark;

public class Main {

    public static void main(String[] args) {
        /*
         TODO:
         - JUnit 5 test
         */
        int tests = 1;
        int maxRange = Integer.MAX_VALUE -2;

        ErathosteneBenchmark benchmark = new ErathosteneBenchmark(tests, maxRange);

        System.out.println("-----------------------------------");
        System.out.println("| Crible of erathostene benchmark |");
        System.out.println("------------------------------------");

        System.out.printf("Number of tests: %d\n", tests);
        System.out.printf("Max range of prime numbers: %d\n\n", maxRange);

        System.out.println("Monothread ->");
        benchmark.run(false, false);
        System.out.println("\nMultithread ->");
        benchmark.run( true, false);

    }
}
