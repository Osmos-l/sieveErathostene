import java.util.ArrayList;

public abstract class Erathostene {

    /**
     * Generate the default array necessary to crible of erathosthene
     * @param size the size of the future array
     * @return boolean[] the array generated
     */
    public static boolean[] generateDefaultArray(int size) {
        boolean[] primeNumbers = new boolean[size];

        for (int position = 2; position < size; position ++) {
            primeNumbers[position] = true;
        }

        return primeNumbers;
    }

    public static void removeMultiple(boolean[] primeNumbers, int position) {
        for (int j = position * position; j < primeNumbers.length; j += position) {
            primeNumbers[j] = false;
        }
    }

    private static void removePairMultiples(boolean[] primeNumbers) {
        for (int position = 4; position < primeNumbers.length; position += 2) {
            primeNumbers[position] = false;
        }
    }

    /**
     * Crible of erathostene to find prime numbers but in monothread.
     * primeNumbers[x] = false -> isn't a prime number, true if it s
     * @param primeNumbers Array boolean[] of prime numbers
     */
    public static void monothread(boolean[] primeNumbers) {
        removePairMultiples(primeNumbers);

        double maxRange = Math.sqrt(primeNumbers.length);
        for (int position = 3; position < maxRange; position += 2) {
            if (primeNumbers[position]) {
                removeMultiple(primeNumbers, position);
            }
        }

    }

    /**
     * Crible of erathostene to find prime numbers but in multithread.
     * primeNumbers[x] = false -> isn't a prime number, true if it s
     * @param primeNumbers Array boolean[] of prime numbers
     */
    public static void multithread(boolean[] primeNumbers) {
       removePairMultiples(primeNumbers);

        ArrayList<Thread> threads = new ArrayList<>();
        double maxRange = Math.sqrt(primeNumbers.length);
        for (int position = 3; position < maxRange; position += 2) {
            if (primeNumbers[position]) {
                Crible crible = new Crible(primeNumbers, position);
                crible.start();
                threads.add(crible);
            }
        }

        while (threads.size() > 0) {
            for (int position = 0; position < threads.size(); position ++) {
                if (!threads.get(position).isAlive()) {
                    threads.remove(position);
                }
            }
        }

    }
}
