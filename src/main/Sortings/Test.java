public class Test {
    public static void main(String[] args) {
        int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1, 10};

        //MergeSort.mergeSort(array);
        //QuickSort.quickSort(array, 0, array.length-1);
        //SelectionSort.selectionSort(array);
        //InsertionSort.insertionSort(array);
        BubbleSort.flaggedbubbleSort(array);

        for(int i : array) {
            System.out.print(i + " ");
        }

    }
}
