/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jose Andres Rosario
 */
public class Intermediate {

    /**
     * We want make a package of goal kilos of chocolate. We have small bars (1
     * kilo each) and big bars (5 kilos each). Return the number of small bars
     * to use, assuming we always use big bars before small bars. Return -1 if
     * it can't be done.
     *
     * @param small
     * @param big
     * @param goal
     * @return
     */
    public static int makeChocolate(int small, int big, int goal) {
        int remainder = goal;
        int i = 0;
        while ((remainder >= 5) && (i < big)) {
            remainder = (remainder - 5);
            i = (i + 1);
        }
        if (remainder > small) {
            return (-1);
        } else {
            return remainder;
        }
    }

    /**
     * Given three ints, a b c, one of them is small, one is medium and one is
     * large. Return true if the three values are evenly spaced, so the
     * difference between small and medium is the same as the difference between
     * medium and large.
     *
     * @param a a given int
     * @param b a given int
     * @param c a given int
     * @return true if the difference between the smallest and medium number is
     * equal to the difference between the medium and largest number
     */
    public static boolean evenlySpaced(int a, int b, int c) {
        int[] numbers = {a, b, c};
        Arrays.sort(numbers);
        int diffSM = (numbers[1] - numbers[0]);
        int diffML = (numbers[2] - numbers[1]);
        return (diffSM == diffML);
    }

    /**
     * Given a string, return the sum of the digits 0-9 that appear in the
     * string, ignoring all other characters. Return 0 if there are no digits in
     * the string.
     *
     * @param str a string
     * @return sum of all digits in the string
     */
    public static int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (Character.isDigit(temp)) {
                sum = sum + Character.getNumericValue(temp);
            }
        }
        return sum;
    }

    /**
     * Given a string, return the longest substring that appears at both the
     * beginning and end of the string without overlapping. For example,
     * sameEnds("abXab") is "ab".
     *
     * @param string a given string
     * @return the longest substring
     */
    public static String sameEnds(String string) {
        int length = ((string.length()) / 2);
        String subscript = "";
        for (int i = length; i > 0; i--) {
            if (string.endsWith(string.substring(0, i))) {
                subscript = string.substring(0, i);
                break;
            }
        }
        return subscript;
    }

    /**
     * Given n>= 0, create an array length n*n with the follwoing pattern, shown
     * here for n = 3: {0,0,1,0,2,1,3,2,1}
     *
     * @param n an integer greater than or equal to 0
     * @return an array of length n^2
     */
    public static int[] squareUp(int n) {
        int[] square = new int[n * n];
        for (int i = 0, zeros = n - 1; i < square.length; zeros--) {
            int temp = zeros;
            for (int j = n; j > 0; j--) {
                if (temp == 0) {
                    square[i] = j;
                }
                i++;
                temp--;
                if (temp < 0) {
                    temp = 0;
                }
            }
        }
        return square;
    }

    /**
     * Given n>=0, create a array with the pattern similar to a series of size n
     *
     * @param n an integer greater than 0
     * @return an array with the size of sum (1+...+n)
     */
    public static int[] seriesUp(int n) {
        int[] series = new int[n * (n + 1) / 2];
        for (int i = 0, length = 1; length <= n; length++) {
            for (int j = 1; j <= length; j++, i++) {
                series[i] = j;
            }
        }

        return series;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text;
        Scanner console = new Scanner(System.in);

        System.out.println("makeChocolate(4, 1, 9) -> " + makeChocolate(4, 1, 9));
        System.out.println("makeChocolate(4, 1, 10) -> " + makeChocolate(4, 1, 10));
        System.out.println("makeChocolate(4, 1, 7) -> " + makeChocolate(4, 1, 7));
        System.out.println("makeChocolate(6, 2, 7) -> " + makeChocolate(6, 2, 7));
        System.out.println("makeChocolate(4, 1, 5) -> " + makeChocolate(4, 1, 5));
        do {
            System.out.print("Would you like run makeChocoate (y/n)? ");
            text = console.next();

            if (text.compareToIgnoreCase("y") == 0) {
                System.out.print("Input three numbers (small bars, big bars, goal): ");
                String i = console.next();
                String j = console.next();
                String k = console.next();
                i = i.replaceAll("[^0-9]", "");
                j = j.replaceAll("[^0-9]", "");
                k = k.replaceAll("[^0-9]", "");
                if (i.isEmpty() || j.isEmpty() || k.isEmpty()) {
                    System.out.println("Invalid entry/entries");
                    continue;
                }
                int i1 = Integer.parseInt(i);
                int j1 = Integer.parseInt(j);
                int k1 = Integer.parseInt(k);
                if (i1 < 0 || j1 < 0 || k1 < 0) {
                    System.out.println("Invalid entry/entries");
                } else {
                    System.out.format("makeChocolate(%d, %d, %d) -> %d\n", i1, j1, k1, makeChocolate(i1, j1, k1));
                }
            }

        } while (text.compareToIgnoreCase("y") == 0);

        System.out.println("evenlySpaced(2, 4, 6) -> " + evenlySpaced(2, 4, 6));
        System.out.println("evenlySpaced(4, 6, 2) -> " + evenlySpaced(4, 6, 2));
        System.out.println("evenlySpaced(4, 6, 3) -> " + evenlySpaced(4, 6, 3));
        System.out.println("evenlySpaced(6, 2, 4) -> " + evenlySpaced(6, 2, 4));
        System.out.println("evenlySpaced(6, 2, 8) -> " + evenlySpaced(6, 2, 8));
        do {
            System.out.print("Would you like run evenlySpaced (y/n)? ");
            text = console.next();

            if (text.compareToIgnoreCase("y") == 0) {
                System.out.print("Input three numbers: ");
                String i = console.next();
                String j = console.next();
                String k = console.next();
                i = i.replaceAll("[^0-9]", "");
                j = j.replaceAll("[^0-9]", "");
                k = k.replaceAll("[^0-9]", "");
                if (i.isEmpty() || j.isEmpty() || k.isEmpty()) {
                    System.out.println("Invalid entry/entries");
                    continue;
                }
                int i1 = Integer.parseInt(i);
                int j1 = Integer.parseInt(j);
                int k1 = Integer.parseInt(k);
                System.out.format("evenlySpaced(%d, %d, %d) -> %d\n", i1, j1, k1, evenlySpaced(i1, j1, k1));
            }

        } while (text.compareToIgnoreCase("y") == 0);

        System.out.println("sameEnds(\"abXYab\") -> " + sameEnds("abXYab"));
        System.out.println("sameEnds(\"xx\") -> " + sameEnds("xx"));
        System.out.println("sameEnds(\"xxx\") -> " + sameEnds("xxx"));
        System.out.println("sameEnds(\"javaXYZjava\")  -> " + sameEnds("javaXYZjava"));
        System.out.println("sameEnds(\"Hello! and Hello!\") -> " + sameEnds("Hello! and Hello!"));
        do {
            System.out.print("Would you like run sameEnds (y/n)? ");
            text = console.next();

            if (text.compareToIgnoreCase("y") == 0) {
                System.out.print("Input phrase: ");
                String i = console.next();
                if (i.isEmpty()) {
                    System.out.println("Invalid entry/entries");
                } else {
                    System.out.format("sameEnds(%s) -> %s\n", i, sameEnds(i));
                }
            }

        } while (text.compareToIgnoreCase("y") == 0);

        System.out.println("sumDigits(\"aa1bc2d3\") -> " + sumDigits("aa1bc2d3"));
        System.out.println("sumDigits(\"aa11b33\") -> " + sumDigits("aa11b33"));
        System.out.println("sumDigits(\"Chocolate\") -> " + sumDigits("Chocolate"));
        System.out.println("sumDigits(\"5hoco1a1e\") -> " + sumDigits("5hoco1a1e"));
        System.out.println("sumDigits(\"123abc123\")  -> " + sumDigits("123abc123"));
        do {
            System.out.print("Would you like run sumDigits (y/n)? ");
            text = console.next();

            if (text.compareToIgnoreCase("y") == 0) {
                System.out.print("Input phrase: ");
                String i = console.next();
                if (i.isEmpty()) {
                    System.out.println("Invalid entry/entries");
                } else {
                    System.out.format("sumDigits(%s) -> %s\n", i, sumDigits(i));
                }
            }

        } while (text.compareToIgnoreCase("y") == 0);

        System.out.println("squareUp(3) -> " + Arrays.toString(squareUp(3)));
        System.out.println("squareUp(2) -> " + Arrays.toString(squareUp(2)));
        System.out.println("squareUp(4) -> " + Arrays.toString(squareUp(4)));
        System.out.println("squareUp(1) -> " + Arrays.toString(squareUp(1)));
        System.out.println("squareUp(0) -> " + Arrays.toString(squareUp(0)));
        do {
            System.out.print("Would you like run squareUp (y/n)? ");
            text = console.next();

            if (text.compareToIgnoreCase("y") == 0) {
                System.out.print("Input a number: ");
                String i = console.next();
                i = i.replaceAll("[^0-9]", "");
                if (i.isEmpty()) {
                    System.out.println("Invalid entry/entries");
                    continue;
                }
                int i1 = Integer.parseInt(i);
                if (i1 < 0) {
                    System.out.println("Invalid entry/entries");
                } else {
                    System.out.format("squareUp(%d) -> %s\n", i1, Arrays.toString(squareUp(i1)));
                }
            }

        } while (text.compareToIgnoreCase("y") == 0);

        System.out.println("seriesUp(3) -> " + Arrays.toString(seriesUp(3)));
        System.out.println("seriesUp(2) -> " + Arrays.toString(seriesUp(2)));
        System.out.println("seriesUp(4) -> " + Arrays.toString(seriesUp(4)));
        System.out.println("seriesUp(1) -> " + Arrays.toString(seriesUp(1)));
        System.out.println("seriesUp(0) -> " + Arrays.toString(seriesUp(0)));
        do {
            System.out.print("Would you like run seriesUp (y/n)? ");
            text = console.next();

            if (text.compareToIgnoreCase("y") == 0) {
                System.out.print("Input a number: ");
                String i = console.next();
                i = i.replaceAll("[^0-9]", "");
                if (i.isEmpty()) {
                    System.out.println("Invalid entry/entries");
                    continue;
                }
                int i1 = Integer.parseInt(i);
                if (i1 < 0) {
                    System.out.println("Invalid entry/entries");
                } else {
                    System.out.format("seriesUp(%d) -> %s\n", i1, Arrays.toString(seriesUp(i1)));
                }
            }

        } while (text.compareToIgnoreCase("y") == 0);
    }

}
