import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfArray = scanner.nextInt(); // First Variable
        int[] numberArray = new int[sizeOfArray];

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = scanner.nextInt();
        }

        int comparator = scanner.nextInt();
        boolean isInArray = false;

        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] == comparator) {
                isInArray = true;
            }
        }

        System.out.println(isInArray);
    }
}
