public class HeapSortClient {
    public static void main(String args[]) {
        HeapSort hs = new HeapSort();
        hs.insert(1);
        hs.insert(13);
        hs.insert(100);
        hs.insert(3);
        hs.insert(2);
        System.out.println(hs.toString());
        int[] arr = new int[10];
        for(int i = 10; i > 0; i--) {
            arr[10 - i] = i;
        }
        // function: insert -> pass
        
        HeapSort hs2 = new HeapSort(arr);
        System.out.println(hs2.toString());
        // function: toString -> pass
        System.out.println(hs2.deleteMin());
        // function: return the smallest number in the array -> pass
        System.out.println(hs2.toString());
        // function: keep the structure of heap after we deleteMin() -> seems pass
        int[] mySortedArray = hs2.sort();
        for(int i = 0; i < mySortedArray.length; i++) {
        	System.out.print(mySortedArray[i] + " ");
        }
    }
}