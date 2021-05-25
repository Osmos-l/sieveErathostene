public class Crible extends Thread {

    private boolean[] primeNumbers;
    private int position;

    public Crible(boolean[] primeNumbers, int position) {
        this.primeNumbers = primeNumbers;
        this.position = position;
    }

    @Override
    public void run() {
        Erathostene.removeMultiple(primeNumbers, position);
    }
}
