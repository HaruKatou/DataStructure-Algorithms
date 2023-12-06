public class BubbleSort {
    //Bubble Sort: về cơ bản, ta sẽ cố gắng sắp xếp các phần tử từ cuối lên đầu
    //              (tìm phần tử lớn nhất đẩy xuống cuối).
    //              (khác với Selection sort, ta xếp các phần tử từ đầu đến cuối)

    //Time complexity:
    //                 Best: O(n)
    //                 Average: O(n^2)
    //                 Worst: O(n^2)
    //*Stable*

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    public static void flaggedbubbleSort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            if(flag == false)
                break;
        }
    }
}
