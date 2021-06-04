package models;

import interfaces.iErathostene;
import static utils.ErathosteneUtil.removeMultiple;

import java.util.ArrayList;

/**
 * Erathostene class that allows you to find all prime numbers between 0 to a range you give
 *
 * How that's work ?
 * You have an boolean array witch contains all number between 0 to maxRange (3 as min).
 * Before the treatment we set all the values on true, but we have few exceptions:
 * - 0, 1 aren't prime numbers so we dont need to set them on true
 * - 2 is the only pair prime numbers, 4; 6; 8; 10. ... are not so we dont need to set them on true too
 * In the treatment we do this:
 * for each value on array that is true we remove all multiple (we set them on false),
 * example for 3 we remove 9; 12; ....
 * At the end the values sets on true in the array are prime numbers
 */
public class Erathostene implements iErathostene {

    boolean[] primeNumbers;

    double sqrtArrayLength;

    boolean isSorted;

    /**
     * Initial state of erathostene
     * @param maxRange The max range of prime numbers we were searching for, [2 .. maxRange(3 as min)]
     */
    public Erathostene(int maxRange) {
        if (maxRange < 3) {
            throw new IllegalArgumentException("max range cannot be < 3");
        }
        primeNumbers = generateDefaultArray(maxRange);

        sqrtArrayLength = Math.sqrt(primeNumbers.length);
    }

    private boolean[] generateDefaultArray(int size) {
        boolean[] primeNumbers = new boolean[size];

        // tips: an non init boolean is false by default
//      primeNumbers[0] = false;
//      primeNumbers[1] = false;
        primeNumbers[2] = true;

        // 2 is the only pair prime numbers so we dont need to set others pair on true
//        for (int position = 4; position < size; position += 2) {
//            primeNumbers[position] = false;
//        }

        for (int position = 3; position < size; position += 2) {
            primeNumbers[position] = true;
        }

        return primeNumbers;
    }

    private void monothread() {
        for (int position = 3; position < sqrtArrayLength; position += 2) {
            if (primeNumbers[position]) {
                removeMultiple(primeNumbers, position);
            }
        }
    }

    private void multithread() {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int position = 3; position < sqrtArrayLength; position += 2) {
            if (primeNumbers[position]) {
                Crible crible = new Crible(primeNumbers, position);
                crible.start();

                threads.add(crible);
            }
        }
        
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void displayPrimeNumbers() {
        if (!isSorted) {
            multithread();
            isSorted = true;
        }

        for (int number = 3; number < primeNumbers.length; number =+ 2) {
            if (primeNumbers[number]) {
                System.out.println(number);
            }
        }
    }

    @Override
    public boolean[] crible(boolean multithreading) {

        if (!isSorted) {
            if (multithreading) {
                multithread();
            } else {
                monothread();
            }
            isSorted = true;
        }

        return primeNumbers;
    }
}
