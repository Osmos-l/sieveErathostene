package interfaces;

public interface iErathostene {

    /**
     * Find all prime numbers between 2 .. maxRange in mono or multithread
     * @param multithreading Execution on multithreading ?
     * @return boolean[] with all prime numbers on true
     */
    boolean[] crible(boolean multithreading);

    /**
     * Display all prime numbers between 2 .. maxRange
     */
    void displayPrimeNumbers();
}
