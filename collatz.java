public class collatz {

/*
 Collatz-Problem:
 Gegeben ist eine positive ganze Zahl n.
 Wenn n gerade ist → teile sie durch 2 → n = n / 2
 Wenn n ungerade ist → rechne n = 3 * n + 1
 Wiederhole diesen Vorgang mit dem neuen n
 Das Ganze machst du so lange, bis du bei 1 ankommst.
 */

    public static int[] collatz(int start, int n) {
        int[] result = new int[n];

        if (start == 0 || start == 1) {
            result[0] = 1;
            return result;
        }
        result[0] = start;
        for (int i = 1; i < result.length; i++) {
            if (start % 2 == 0) {
                start /= 2;
                result[i] = start;
            } else {
                start = 3 * start + 1;
                result[i] = start;
            }
        }
        return result;
           /*  while (n != 1) {
            if (start % 2 == 1) {
                start = 3 * start + 1;
                result[i] = n;
                i++;
            } else {
                n = start / 2;
                result[i] = n;
                i++;
            }
        } */
    }

    public static void main(String[] args) {
        int bspStart = 19;
        int bspN = 30;
        int[] ergebnis = collatz(bspStart, bspN);
        System.out.print("[");
        for (int i = 0; i < ergebnis.length; i++) {
            System.out.print(ergebnis[i]);
            if (i < ergebnis.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
