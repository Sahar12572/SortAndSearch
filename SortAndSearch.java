
import java.util.Arrays;

public class SortAndSearch {

    public static void main(String[] args) {
        int[] array = {27, -3, 4, 5, 35, 2, 1, -40, 7, 18, 9, -1, 16, 100};

        // Perform Linear Search for number 9
        System.out.println("Linear Search for 9: ");
        int linearSearchResult = linearSearch(array, 9);
        if (linearSearchResult != -1) {
            System.out.println("Found 9 at index: " + linearSearchResult);
        } else {
            System.out.println("9 not found in the array.");
        }

        // Sort the array using Insertion Sort
        System.out.println("\nSorting the array using Insertion Sort...");
        insertionSort(array);

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(array));

        // Perform Binary Search for number 9 in the sorted array
        System.out.println("\nBinary Search for 9: ");
        int binarySearchResult = binarySearch(array, 9);
        if (binarySearchResult != -1) {
            System.out.println("Found 9 at index: " + binarySearchResult);
        } else {
            System.out.println("9 not found in the array.");
        }
    }

    // Linear Search implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found the target
            }
        }
        return -1; // Target not found
    }

    // Insertion Sort implementation
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key, to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Binary Search implementation (requires sorted array)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
