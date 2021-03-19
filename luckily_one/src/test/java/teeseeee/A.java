package teeseeee;

public class A {
    public static void main(String[] args) {
        int b = 7;
        int a = b / 2 + 1;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

        for (int i = a -1 ; i > 0; i--) {
            for (int j = 0; j < a - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
