// Zhen Xu
// HeapSort v 1.0
// This program complete the basic function of sorting using heapsort
// algorithm.

// Heapsort: buildHeap, then deleteMin till everything is dequeued
// buildHeap:
// using an array

import org.apache.commons.lang3.ArrayUtils;
public class HeapSort {
    private int[] arr;
    private int size;
    
    // Pre: if there is anything in this structure,
    // calling this constructor will not store any
    // previous data.
    // Post: construct a heap structure
    public HeapSort() {
        size = 0;
        arr = new int[17];
    }
    
    // Pre: the other array
    // Construct a heap structure from another array
    public HeapSort(int[] other) {
        this.arr = new int[other.length + 1];
        for(int i = 0; i < other.length; i++) {
            this.arr[i + 1] = other[i];
        }        
        this.size = other.length;
        buildHeap();
    }
    
    // Pre: the heap structure has already been created
    // Post: all data are already in the right order of 
    // a heap
    public void buildHeap() {
        for(int i = size / 2; i > 0; i--) {
            int val = arr[i];
            int hole = percolateDown(i, val);
            arr[hole] = val;
        }      
    }
    
    public void insert(int val) {
        if(size == arr.length - 1) {
            resize();
        }
        size = size + 1;
        int hole = percolateUp(size, val);
        arr[hole] = val;   
    }
    
    public int deleteMin() {
        if(this.arr.length == 0) {
            throw new IllegalArgumentException();
        }
        int ans = arr[1];
        int hole = percolateDown(1, arr[size]);
        arr[hole] = arr[size];
        size = size - 1;
        return ans;
    } 
    
    private int percolateUp(int hole, int val) {
        while(hole > 1 && val < arr[hole/2]) {
            arr[hole] = arr[hole/2];
            hole = hole/2;
        }
        return hole;       
    }
    
    private int percolateDown(int hole, int val) {
        while(2 * hole <= size) {
            int left = 2 * hole;
            int right = left + 1;
            int target = 0;
            // determine if the index of any child is out of bound
            if(right > size || arr[left] < arr[right]) {
                target = left;
            } else {
                target = right;
            }
            if(arr[target] < val) {
                arr[hole] = arr[target];
                hole = target;
            } else {
                break;
            }   
        }
        return hole;
    }
    
    // Pre: the arr must be constructed before this method can be use
    // Post: the size of the array will be doubled afterwards
    public void resize() {
        int[] copyArr = new int[this.size * 2];
        System.arraycopy(this.arr, 0, copyArr, 0, size);  
        this.arr = copyArr;  
    }
    
    public String toString() {
        String str = "";
        for(int i = 1; i < this.size + 1; i++) {
            str = str + this.arr[i] + " ";
        }
        return str;
    }
    
    // Pre: an input of an array consists of all integer numbers.
    // Post: output an array that is in ascending order.
    public int[] sort() {
        int n = size;
        int[] sorted = new int[n];
        for(int i = 1; i < n; i++) {
            this.arr[n + 1 - i] = deleteMin();
        }
        System.arraycopy(this.arr, 1, sorted, 0, n);
        ArrayUtils.reverse(sorted);
        // restore the size of the binary heap
        this.size = n;
        return sorted;
    }
    
}