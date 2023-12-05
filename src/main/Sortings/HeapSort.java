import java.util.Collections;

public class HeapSort {
    /**
     * HeapSort = Using a max heap
     */

    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Xây dựng Heap tối ưu từ mảng
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Loại bỏ các phần tử từ Heap một cách lần lượt
        for (int i = n - 1; i > 0; i--) {
            // Di chuyển phần tử lớn nhất (gốc Heap) đến cuối mảng
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Gọi heapify trên Heap đã giảm kích thước
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i;  // Khởi tạo giả sử lớn nhất là gốc
        int left = 2 * i + 1; // Chỉ mục của con trái
        int right = 2 * i + 2; // Chỉ mục của con phải

        // Nếu con trái lớn hơn gốc
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Nếu con phải lớn hơn gốc
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Nếu gốc không phải là lớn nhất
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Gọi đệ quy để heapify đoạn con bị ảnh hưởng
            heapify(arr, n, largest);
        }
    }

}