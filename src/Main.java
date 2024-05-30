import implementations.MyArrayList;
import sorts.QuickSort;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.add(12);
        myArrayList.add(15);
        System.out.println(myArrayList.toString());

        int[] arr = {1,3,4,2,3,6,7,3,8,2};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        for (int element : arr) {
            System.out.println(element);
        }
    }
}