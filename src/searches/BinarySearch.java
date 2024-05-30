package searches;

public class BinarySearch {
    public static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x) {
                return mid;
            }

            // If x greater, ignore left half
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                // If x is smaller, ignore right half
                high = mid - 1;
            }
        }
        return -1; // if the element is not present
    }
}

