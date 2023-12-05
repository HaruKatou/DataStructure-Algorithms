public class MergeSort {

    // MergeSort = divide the array into 2, and then merge after sorting.
    //             (Divide and conquer)

    // Time Complexity = Best case O(n log n)
    //                  Average case O(n log n)
    //                  Worst case O(n log n)

    // Space Complexity = O(n) because create smaller arrays.
    public static void mergeSort(int[] array) {
        if (array.length <= 1)
            return;

        int mid = array.length / 2;

        //Split the array in 2.
        int i = 0, j = 0;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        for (; i < array.length; i++) {
            if (i < mid) {
                leftArray[i] = array[i];
            }
            else {
                rightArray[j] = array[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    //Merge the two arrays.
    public static void merge(int [] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int left = 0, right = 0;
        int i = 0;

        while (left < leftSize && right < rightSize) {
            if (leftArray[left] < rightArray[right]) {
                array[i] = leftArray[left];
                left++;
            }
            else {
                array[i] = rightArray[right];
                right++;
            }
            i++;
        }
        while (left < leftSize) {
            array[i] = leftArray[left];
            left++;
            i++;
        }
        while (right < rightSize) {
            array[i] = rightArray[right];
            right++;
            i++;
        }
    }
}
