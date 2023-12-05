public class InsertionSort {

    // InsertionSort = divide the array into a sorted one and one still to sort.
    //                Initially, the sorted sublist is made up of just one element and it gets progressively filled.
    //                For every iteration, the algorithm picks an element on the unsorted sublist
    //                and inserts it at the right place in the sorted sublist.

    // Time Complexity = Best case O(n^2)
    //                  Average case O(n)
    //                  Worst case O(n^2)

    // Space Complexity = O(1)
    // *Stable*
    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}
