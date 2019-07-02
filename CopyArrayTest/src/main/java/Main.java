import java.util.Arrays;

public class Main {

    int[][] aa = {{0,1,2,3},{4,5,6,7}};
    int[] a = {0,1,2,3};

    int[][] bb = new int[4][4];
    int[] b = new int[4];

    public Main() {
       /* System.out.println(a[0] + " - " + a[1] + " - " +  a[2] + " - " +  a[3]);
        System.out.println(b[0] + " - " +  b[1] + " - " +  b[2] + " - " +  b[3]);
        System.out.println();

        b = Arrays.copyOf(a, a.length);

        System.out.println(a[0] + " - " + a[1] + " - " +  a[2] + " - " +  a[3]);
        System.out.println(b[0] + " - " +  b[1] + " - " +  b[2] + " - " +  b[3]);
        System.out.println();

        a[0] = 4;
        a[1] = 5;
        a[2] = 6;
        a[3] = 7;

        System.out.println(a[0] + " - " + a[1] + " - " +  a[2] + " - " +  a[3]);
        System.out.println(b[0] + " - " +  b[1] + " - " +  b[2] + " - " +  b[3]);
        System.out.println();*/

        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[0].length ; j++) {
                System.out.print(aa[i][j]);
                System.out.print("-");
            }
        }
        System.out.println();
        for (int i = 0; i < bb.length; i++) {
            for (int j = 0; j < bb[0].length ; j++) {
                System.out.print(bb[i][j]);
                System.out.print("-");
            }
        }


        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[0].length ; j++) {
                bb[i] = Arrays.copyOf(aa[i], aa[i].length);
            }
        }

        aa[0][0] = 9;
        aa[0][1] = 9;
        aa[1][0] = 9;

        System.out.println();
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[0].length ; j++) {
                System.out.print(aa[i][j]);
                System.out.print("-");
            }
        }
        System.out.println();
        for (int i = 0; i < bb.length; i++) {
            for (int j = 0; j < bb[0].length ; j++) {
                System.out.print(bb[i][j]);
                System.out.print("-");
            }
        }

    }

    public static void main(String[] args) {
        new Main();
    }
}
