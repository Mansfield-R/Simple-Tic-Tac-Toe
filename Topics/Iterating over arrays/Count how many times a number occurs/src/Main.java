import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int counter = 0; // Counter and Display at the end
        int arraySizeNumber = scanner.nextInt(); // Array Size
        int[] numberArray = new int[arraySizeNumber]; // Set array size

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = scanner.nextInt();
        }

        // 3rd Variable:
        int givenNumber = scanner.nextInt(); // Given Number N

        // Final Loop:
        for (int j : numberArray) {
            if (j == givenNumber) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
