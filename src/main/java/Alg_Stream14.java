// File Alg_Stream14.java
/* ------------------------------------------------------------------------
This program Alg_Stream14 demonstrates the difference between
sequential streams and parallel streams.
The time needed to execute this program depends on how many kernels
(or "hardware threads") your computer has.
------------------------------------------------------------------------ */
import java.util.stream.IntStream;

public class Alg_Stream14 {
   // ---------------------------------------------------------------------
   // The following method is used to detect prime numbers. It is
   // deliberately rather simple, because here only relative execution
   // times are important (sequential stream vs. parallel stream).

   static boolean isPrime(int n) {
      // Returns true, iff n is greater than 1 and a prime number.
      if (n<=1)   return false;
      if (n==2)   return true;
      if (n==3)   return true;
      int sqr = (int) Math.sqrt(n);
      for (int dor=2; dor<=sqr; dor++) if (n%dor==0) return false;
      return true;
   }
   // ---------------------------------------------------------------------
   // The difference between the following 2 methods is mainly one word:
   // "parallel" (countPrimes01 lacks it, countPrimes02 has it).
   // ---------------------------------------------------------------------
   static void countPrimes01(final int MAX) {
      IntStream is = IntStream.iterate(2, n -> n+1).limit(MAX);

      long      start      = System.currentTimeMillis();
      IntStream ps         = is.filter(n -> isPrime(n));
      long      nrOfPrimes = ps.count();
      long      timeUsed   = System.currentTimeMillis() - start;

      printResults("sequential", MAX, nrOfPrimes, timeUsed);
   }
   // ---------------------------------------------------------------------
   static void countPrimes02(final int MAX) {
      IntStream is = IntStream.iterate(2, n -> n+1).parallel().limit(MAX);

      long      start      = System.currentTimeMillis();
      IntStream ps         = is.filter(n -> isPrime(n));
      long      nrOfPrimes = ps.count();
      long      timeUsed   = System.currentTimeMillis() - start;

      printResults("parallel", MAX, nrOfPrimes, timeUsed);
   }
   // ---------------------------------------------------------------------
   static void printResults(String sp, int MAX, long nrOfPrimes, long timeUsed){
      printf("With %s streams:%n", sp);
      printf("Searched for primes in interval [2..%,10d]%n", MAX);
      printf("Number of primes found:             %,10d %n", nrOfPrimes);
      printf("Time used (in milliseconds):        %,10d %n", timeUsed);
   }
   // ---------------------------------------------------------------------
   static public void main(String[] args) {
      printf("Alg_Stream14: Here we go!%n");
      printf("------------------------%n");
      countPrimes01(1000);
      printf("------------------------%n");
      countPrimes02(1000);
      printf("------------------------%n");
      countPrimes01(40_000_000);
      printf("------------------------%n");
      countPrimes02(40_000_000);
      printf("------------------------%n");
      printf("Alg_Stream14: That's all!%n");
   } // main
   // ---------------------------------------------------------------------
   // A Method with a short name:
   static void printf(String f, Object... v) {System.out.printf(f, v);}
   // ---------------------------------------------------------------------
} // class Alg_Stream14
/* ------------------------------------------------------------------------
Output of this program:

Alg_Stream14: Here we go!
------------------------
With sequential streams:
Searched for primes in interval [2..     1.000]
Number of primes found:                    168
Time used (in milliseconds):                 6
------------------------
With parallel streams:
Searched for primes in interval [2..     1.000]
Number of primes found:                    168
Time used (in milliseconds):                70
------------------------
With sequential streams:
Searched for primes in interval [2..40.000.000]
Number of primes found:              2.433.654
Time used (in milliseconds):            51.392
------------------------
With parallel streams:
Searched for primes in interval [2..40.000.000]
Number of primes found:              2.433.654
Time used (in milliseconds):            26.696
------------------------
Alg_Stream14: That's all!
------------------------------------------------------------------------ */
