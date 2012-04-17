/**
 * 
 * @author Christoper.Barham
 * @version $Id$, $Rev$
 * 
 */

package com.akqa.trials;


public class PrimeNumberValidator {
    public Boolean validate(final Integer primeNumber) {
        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) { return false; }
        }

        return true;
    }
}
