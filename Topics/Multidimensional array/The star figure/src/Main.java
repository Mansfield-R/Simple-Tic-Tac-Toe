import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int arrayMultiplier = scanner.nextInt();
        int k = arrayMultiplier / 2;

        String[][] starArray = new String[arrayMultiplier][arrayMultiplier];

        for (int r = 0; r < starArray.length; r++) {
            for (int c = 0; c < starArray[r].length; c++) {
                if (starArray[r] == starArray[c]) {
                    starArray[r][c] = "*";
                } else if (starArray[r] == starArray[arrayMultiplier - c - 1]) {
                    starArray[r][c] = "*";
                } else if (r == k) {
                    starArray[r][c] = "*";
                } else if (c == k) {
                    starArray[r][c] = "*";
                } else {
                    starArray[r][c] = ".";
                }
            }
        }

        // Display:
        for (String[] strings : starArray) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
