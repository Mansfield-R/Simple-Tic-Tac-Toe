import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxProduct = 0;
        int sizeOfArray = scanner.nextInt(); // First Variable
        int[] numberArray = new int[sizeOfArray];

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = scanner.nextInt();
        }

        for (int i = 0; i < numberArray.length - 1; i++) {
            int multipliedIndexes = numberArray[i] * numberArray[i + 1];
            if (multipliedIndexes > maxProduct) {
                maxProduct = multipliedIndexes;
            }
        }
        System.out.println(maxProduct);
    }
}
