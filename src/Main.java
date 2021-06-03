import models.Benchmark;

public class Main {

    public static void main(String[] args) {
        /*
         TODO:
         - JUnit 5 test
         - Make interfaces
         */
        int tests = 1;
        int maxRange = Integer.MAX_VALUE -2;

        System.out.println("-----------------------------------");
        System.out.println("| models.Crible of erathostene benchmark |");
        System.out.println("------ -----------------------------");

        System.out.printf("Number of tests: %d\n", tests);
        System.out.printf("Max range of prime numbers: %d\n\n", maxRange);

        System.out.println("Monothread ->");
        Benchmark.erathostene(tests, maxRange, false, false);
        System.out.println("\nMultithread ->");
        Benchmark.erathostene(tests, maxRange, true, false);

    }
}
