import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        // Take N and M:
        int[] nm = new int[2];
        for (int i = 0; i < nm.length; i++) {
            nm[i] = scanner.nextInt();
        }

        // Un-Rotated Array:
        int[][] unrotated = new int[nm[0]][nm[1]];

        // Loop the elements into the unrotated array:
        for (int r = 0; r < unrotated.length; r++) {
            for (int c = 0; c < unrotated[r].length; c++) {
                unrotated[r][c] = scanner.nextInt();
            }
        }

        rotateClockWise(unrotated);

    }

    public static void rotateClockWise(int[][] unrotatedArray) {
        final int m = unrotatedArray.length;
        final int n = unrotatedArray[0].length;
        int[][] ret = new int[n][m];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                ret[c][m-1-r] = unrotatedArray[r][c];
            }
        }

        for (int[] ints : ret) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
