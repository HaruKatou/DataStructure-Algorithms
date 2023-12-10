import java.util.ArrayList;
import java.util.*;

public class SleepSort {
    public static void sleepSort(ArrayList<Integer> arr) {
        ArrayList<Thread> threads = new ArrayList<>();  // Create an ArrayList to hold threads

        for (int num : arr) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(num);  // Sleep for 'num' milliseconds
                    System.out.print(num + " ");  // Print the number after sleeping
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            threads.add(thread); // Add the thread to the ArrayList
            thread.start(); // Start the thread
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(34);   // Add elements to the ArrayList
        arr.add(23);
        arr.add(122);
        arr.add(9);

        sleepSort(arr); // Call the sleepSort function to sort the ArrayList
    }
}
