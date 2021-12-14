import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberGiven = scanner.nextInt(); // Variable for loop

        System.out.print(numberGiven + " ");

        // While given number isn't 1 automatically:
        while (numberGiven != 1) {
            // If even, else odd:
            if (numberGiven % 2 == 0) {
                numberGiven /= 2;
                System.out.print(numberGiven + " ");
            } else {
                numberGiven = numberGiven * 3 + 1;
                System.out.print(numberGiven + " ");
            }
        }
    }
}
