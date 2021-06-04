package models;

import static utils.ErathosteneUtil.removeMultiple;

/**
 *
 */
public class Crible extends Thread {

    private boolean[] primeNumbers;
    private int multiple;

    /**
     * Initial state of crible
     * @param primeNumbers The prime numbers boolean array
     * @param multiple The initial multiple we keep
     */
    public Crible(boolean[] primeNumbers, int multiple) {
        // TODO: Throw exeception on primeNumbers array if isn't correctly init
        this.primeNumbers = primeNumbers;

        // TODO: Throw exeception if position < 0
        this.multiple = multiple;
    }

    @Override
    public void run() {
        removeMultiple(this.primeNumbers, this.multiple);
    }
}
