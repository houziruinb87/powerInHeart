package myjava.day5;

import java.util.Arrays;

public class Day5 {

    public static int[] heapInsert(int[] array, int index) {
        while (index > (index - 1) / 2) {
            if (array[index] > array[(index - 1) / 2]) {
                swap(array, (index - 1) / 2, index);
            }
            index = (index - 1) / 2;
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];

    }


    public static int[] heapify(int[] array, int index,int heapSize) {
        int leftChildPosition = ((index * 2) + 1);
        int rightChildPosition = ((index * 2) + 2);
        while (leftChildPosition < heapSize) {
            int maxChild;
            int maxPosition;
            if (rightChildPosition <heapSize) {
                if (array[leftChildPosition] >= array[rightChildPosition]) {
                    maxChild = array[leftChildPosition];
                    maxPosition = leftChildPosition;
                } else {
                    maxChild = array[rightChildPosition];
                    maxPosition = rightChildPosition;

                }
            } else {
                maxChild = array[leftChildPosition];
                maxPosition = leftChildPosition;

            }
            if (array[index] < maxChild) {
                swap(array, index, maxPosition);
            }
            index = maxPosition;
            leftChildPosition = ((index * 2) + 1);
            rightChildPosition = ((index * 2) + 2);
        }
        return array;
    }


    public static int[] heapSort(int[] array){
        int heapSize = 1;
        for(;heapSize<=array.length;heapSize++){
            heapInsert(array,heapSize-1);
        }
//        System.out.println(String.valueOf(heapSize));
        heapSize--;
//        System.out.println(Arrays.toString(array));

        while (heapSize>0){
            swap(array,0,heapSize-1);
            heapSize--;
            heapify(array,0,heapSize);
        }

        return array;
    }


    public static int[] process(int[] array,int l,int r){
        if(l==r){
            return new int[]{array[l]};
        }
        int[] leftArray = process(array,l,l+(r-l)/2);
        int[] rightArray = process(array,l+(r-l)/2+1,r);
        return mergeArray(leftArray,rightArray);
    }

    public static int[] mergeArray(int[] leftArray,int[] rightArray){
        return leftArray;
    }
}
