package tests;

import models.Erathostene;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ErathosteneTests {

    private final int RANGE = 0;
    private final int NB_PRIME_NUMBERS = 1;

    private final List<int[]> PRIME_NUMBERS_PER_RANGE = new ArrayList<>(List.of(
        /** [2 .. RANGE] Number of prime numbers in this range
         *          |   |
         *          v   v    */
        new int[]{ 10, 4 },
        new int[]{ 100, 25 },
        new int[]{ 1000, 168 },
        new int[]{ 10000, 1229 }
    ));

    @Test()
    public void testCount() {

        for (int[] fixture: PRIME_NUMBERS_PER_RANGE) {
            Erathostene erathostene = new Erathostene(fixture[RANGE]);
            boolean[] primeNumbers = erathostene.crible(true);

            int nbPrimeNumbers = 0;
            for (int multiple = 0; multiple < primeNumbers.length; multiple ++) {
                if (primeNumbers[multiple]) {
                    // System.out.println(multiple);
                     nbPrimeNumbers++;
                }
            }

            assertEquals(fixture[NB_PRIME_NUMBERS], nbPrimeNumbers);
        }
    }

}
