package utils;

public abstract class ErathosteneUtil {

    /**
     * Set multiples of position to false into the array
     * @param primeNumbers boolean[] who represent prime numbers
     * @param position the position you want to keep but remove is multiples
     */
    public static void removeMultiple(boolean[] primeNumbers, int position) {
        for (int j = position * position; j > 0 && j < primeNumbers.length; j += position) {
            primeNumbers[j] = false;
        }
    }
}
