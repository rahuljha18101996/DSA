/*
Stats for Insertion Sort

    Input Size       Time(ms)
    10                 0
    100                0
    1,000              2
    10,000             14
    100,000            814
    1,000,000          80,289   It took more than a minute to finish  :(

PC Specification: i9 12th Gen
*/

public class InsertionSort {
    public static void main(String[] args) {
        int n = 1000000;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) array[i] = n--;
        //printArray(array,'o');
        long t1 = System.currentTimeMillis();
        sort(array,array.length);
        t1 = System.currentTimeMillis() - t1;
        //printArray(array,'f');
        System.out.printf("Time taken to sort array is %d ms%n",t1);
    }
    private static void sort(int[] array,int n) {
        for (int i = 1; i < n; i++) {
            int pos = i - 1;
            int val = array[i];
            //In case of reverse sort replace the less than with greater than
            while (pos >= 0 && val < array[pos]) {
                array[pos + 1] = array[pos];
                pos--;
            }
            array[pos  + 1] = val;
        }
    }

    private static void printArray(int[] a,char variableName) {
        if (a.length == 0) {
            System.out.printf("%c = []",variableName);
            return;
        }
        System.out.printf("%c = [%d",variableName,a[0]);
        for (int i = 1; i < a.length; i++) System.out.printf(",%d",a[i]);
        System.out.printf("]%n");
    }
}
