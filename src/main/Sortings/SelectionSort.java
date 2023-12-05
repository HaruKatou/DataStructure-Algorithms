public class SelectionSort {

    // Selection Sort = index i seperate the array into the sorted and the unsorted.
    //      repeatedly SELECTing the smallest element from the unsorted portion
    //      and moving it to the sorted portion of the list.

    // Time Complexity: Best case O(n^2)
    //                  Average case O(n^2)
    //                  Worst case O(n^2)

    // Space Complexity: O(1)
    // *Unstable*
    public static void selectionSort(int[] array) {
        for(int i = 0; i < array.length-1; i++) {
            int min_idx = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[j] < array[min_idx])
                    min_idx = j;
            }
            int tmp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = tmp;
        }
    }
}
