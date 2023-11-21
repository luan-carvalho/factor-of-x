import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Factor {

    public static void main(String[] args) {

        while (true) {

            try {

                Scanner sc = new Scanner(System.in);

                System.out.print("Enter an integer number: ");
                int x = sc.nextInt();

                if (x == 1) {

                    System.out.println("The number 1 doesn't have prime factors");
                    break;

                }

                System.out.println(
                        "The prime factor" + (factor(x).size() == 1 ? "" : "s")
                                + " of " + x + (factor(x).size() == 1 ? " is: " : " are: ")
                                + factor(x));

                sc.close();

                break;

            } catch (InputMismatchException e) {
                System.out.println("\nPlease, enter a valid number!!\n");
                continue;
            }

        }

    }

    public static List<Integer> factor(int x) {

        List<Integer> factors = new ArrayList<>();

        int division = x;

        for (int prime : primeNumbersTill(x)) {

            while (division != 1) {

                if (division % prime == 0) {

                    factors.add(prime);
                    division = division / prime;
                    continue;

                }

                break;

            }

        }

        return factors;

    }

    public static List<Integer> primeNumbersTill(int x) {

        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i <= x; i++) {

            if (isPrime(i))
                primeNumbers.add(i);

        }

        return primeNumbers;

    }

    public static boolean isPrime(int x) {

        for (int i = 2; i < x; i++) {
            if (x % i == 0)
                return false;
        }

        return true;

    }
}