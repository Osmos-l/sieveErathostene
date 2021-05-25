public class Crible extends Thread {

    private boolean[] primeNumbers;
    private int position;
    private double maxRange;

    public Crible(boolean[] primeNumbers, int position, double maxRange) {
        this.primeNumbers = primeNumbers;
        this.position = position;
        this.maxRange = maxRange;
    }

    private int findPositionOfNextPrimeNumber(boolean[] primeNumbers, int initialPosition) {
        int next = 0;

        int position = initialPosition;
        while (next == 0) {
            next = primeNumbers[position] == true ? position : next;
            position++;
        }

        return next;
    }

    @Override
    public void run() {

        Erathostene.removeMultiple(primeNumbers, position);

        System.out.println(findPositionOfNextPrimeNumber(primeNumbers, position +1));
        Crible crible = new Crible(primeNumbers,
                                    findPositionOfNextPrimeNumber(primeNumbers, position +1),
                                    maxRange);

        crible.run();
    }
}
