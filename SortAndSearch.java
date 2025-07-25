import java.util.Arrays;
import java.util.Scanner;

public class SortAndSearch {

    public static void main(String[] args) {
        int[] array = {27, -3, 4, 5, 35, 2, 1, -40, 7, 18, 9, -1, 16, 100};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Original array: " + Arrays.toString(array));

        // Ask user for number to search
        System.out.print("\nEnter a number to search for: ");
        int target = scanner.nextInt();

        // Perform Linear Search
        System.out.println("\nLinear Search:");
        int linearSearchResult = linearSearch(array, target);
        if (linearSearchResult != -1) {
            System.out.println("Found " + target + " at index: " + linearSearchResult);
        } else {
            System.out.println(target + " not found in the array.");
        }

        // Sort array
        System.out.println("\nSorting the array using Insertion Sort...");
        insertionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        // Perform Binary Search
        System.out.println("\nBinary Search:");
        int binarySearchResult = binarySearch(array, target);
        if (binarySearchResult != -1) {
            System.out.println("Found " + target + " at index: " + binarySearchResult);
        } else {
            System.out.println(target + " not found in the sorted array.");
        }

        scanner.close();
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
