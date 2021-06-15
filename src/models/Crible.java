package models;

import static utils.ErathosteneUtil.removeMultiple;

/**
 *
 */
public class Crible implements Runnable {

    private boolean[] primeNumbers;
    private int multiple;

    /**
     * Initial state of crible
     * @param primeNumbers The prime numbers boolean array
     * @param multiple The initial multiple we keep
     */
    public Crible(boolean[] primeNumbers, int multiple) {
        this.primeNumbers = primeNumbers;

        this.multiple = multiple;
    }

    @Override
    public void run() {
        removeMultiple(this.primeNumbers, this.multiple);
    }
}
