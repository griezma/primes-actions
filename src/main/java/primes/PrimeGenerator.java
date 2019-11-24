package primes;

import io.reactivex.rxjava3.core.Observable;

import java.util.Iterator;

public class PrimeGenerator implements Iterable<Number> {

    static class PrimeIterator implements Iterator<Number> {
        private Number current;

        public PrimeIterator(Number current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Number next() {
            return current = Primes.nextPrime(current.longValue());
        }
    }

    private Number start;

    public PrimeGenerator(long start) {
        this.start = start;
    }

    @Override
    public Iterator<Number> iterator() {
        return new PrimeIterator(start);
    }

    public Observable<Number> observable() { return Observable.fromIterable(this); }
}
