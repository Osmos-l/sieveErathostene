public class Main {

    public static void main(String[] args) {

        int tests = 1;
        int maxRange = 2000000000;

        System.out.println("-----------------------------------");
        System.out.println("| Crible of erathostene benchmark |");
        System.out.println("-----------------------------------");

        System.out.printf("Number of tests: %d\n", tests);
        System.out.printf("Max range of prime numbers: %d\n\n", maxRange);

        System.out.println("Monothread ->");
        Benchmark.erathosteneMonoThread(tests, maxRange);
        System.out.println("\nMultithread ->");
        Benchmark.erathosteneMultiThread(tests, maxRange);

    }
}
