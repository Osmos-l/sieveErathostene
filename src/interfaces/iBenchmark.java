package interfaces;

public interface iBenchmark {

    /**
     * Benchmark of erathostene crible
     * @param isMultithread true for multithread execution, false in other case
     * @param print Display prime numbers at the end
     */
    void run(boolean isMultithread, boolean print);
}
