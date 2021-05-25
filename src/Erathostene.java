public abstract class Erathostene {

    /**
     * Generate the default array necessary to crible of erathosthene
     * @param size the size of the future array
     * @return boolean[] the array generated
     */
    public static boolean[] generateDefaultArray(int size) {
        boolean[] primeNumbers = new boolean[size];

        for (int position = 0; position < size; position ++) {
            primeNumbers[position] = true;
        }

        return primeNumbers;
    }

    public static void removeMultiple(boolean[] primeNumbers, int position) {
        for (int j = position * position; j < primeNumbers.length; j += position) {
            primeNumbers[j] = false;
        }
    }

    private static void removeDefaultMultiples(boolean[] primeNumbers) {
        primeNumbers[0] = false;
        primeNumbers[1] = false;
    }

    /**
     * Crible of erathostene to find prime numbers but in monothread.
     * primeNumbers[x] = false -> isn't a prime number, true if it s
     * @param primeNumbers Array boolean[] of prime numbers
     */
    public static void monothread(boolean[] primeNumbers) {
        removeDefaultMultiples(primeNumbers);

        double maxRange = Math.sqrt(primeNumbers.length);
        for (int position = 2; position < maxRange; position ++) {
            if (primeNumbers[position]) {
                removeMultiple(primeNumbers, position);
            }
        }

        // TODO: Return primeNumbers
    }

    /**
     * Crible of erathostene to find prime numbers but in multithread.
     * primeNumbers[x] = false -> isn't a prime number, true if it s
     * @param primeNumbers Array boolean[] of prime numbers
     */
    public static void multithread(boolean[] primeNumbers) {
        // TODO: exception if size < 3

        removeDefaultMultiples(primeNumbers);

        Crible crible = new Crible(primeNumbers, 2, Math.sqrt(primeNumbers.length));
        crible.run();

        try {
            crible.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }


        // TODO: Return primeNumbers
    }
}
