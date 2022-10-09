/*
Stats for Selection Sort

    Input Size       Time(ms)
    10                0
    100               1
    1,000             2
    10,000            34
    100,000           2,157
    1,000,000         256,256  It took more than four minutes to finish  : (

PC Specification: i9 12th Gen
*/

public class SelectionSort {
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
        for (int i = 0; i < n - 1; i++) {
            int pos = i + 1;
            for (int j = i + 1; j < n; j++) {
                if (array[pos] > array[j]) {
                    pos = j;
                }
            }
            if (array[i] > array[pos]) {
                int temp = array[i];
                array[i] = array[pos];
                array[pos] = temp;
            }
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
