public class QuickSort {

    // Quick Sort = moves smaller elements to left of the pivot.
    //              recursively divide the array into 2 partitions.

    // Time Complexity = Best case O(n log n)
    //                  Average case O(n log n)
    //                  Worst case O(n^2) if sorted already

    // Space Complexity = O(log n) due to recursion.
    // *Unstable*
    public static void quickSort(int[] array, int start, int end) {
        if (end <= start)
            return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }

    //Find the pivot.
    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start-1;

        for(int j = start; j < end; j++) {
            if(array[j] < pivot) {
                i++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        i++;
        int tmp = array[i];
        array[i] = array[end];
        array[end] = tmp;

        return i;
    }
}
