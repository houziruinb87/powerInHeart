package myjava.day7;

import java.util.Random;

/**
 * mergeSort
 * quickSort
 * heapSort
 */
public class Day7 {
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int position1 = 0;
        int position2 = 0;
        int position = 0;
        int[] mergedArray = new int[array1.length + array2.length];
        while (position1 < array1.length || position2 < array2.length) {
            if (position1 == array1.length) {
                mergedArray[position++] = array2[position2++];
                continue;
            }
            if (position2 == array2.length) {
                mergedArray[position++] = array1[position1++];
                continue;
            }
            if (array1[position1] <= array2[position2]) {
                mergedArray[position++] = array1[position1++];
            } else {
                mergedArray[position++] = array2[position2++];
            }
        }
        return mergedArray;
    }

    public static void merge(int[] array, int l, int r) {
        int m = l + (r - l) / 2;
        int leftP = l;
        int rightP = m + 1;
        int[] mergedArray = new int[r - l + 1];
        int mergedP = 0;
        while (leftP <= m || rightP <= r) {
            if (leftP == m + 1) {
                mergedArray[mergedP++] = array[rightP++];
                continue;
            }
            if (rightP == r + 1) {
                mergedArray[mergedP++] = array[leftP++];
                continue;
            }
            if (array[leftP] <= array[rightP]) {
                mergedArray[mergedP++] = array[leftP++];
            } else {
                mergedArray[mergedP++] = array[rightP++];
            }
        }
        for (int i = 0; i < mergedArray.length; i++) {
            array[l + i] = mergedArray[i];
        }
    }

    public static void processArray(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        processArray(array, l, l + (r - l) / 2);
        processArray(array, l + (r - l) / 2 + 1, r);
        merge(array, l, r);
    }

    public static int[] mergeSort(int[] array) {
        processArray(array, 0, array.length - 1);
        return array;
    }


    public static int[] partition(int[] array, int l, int r) {
        int num = array[r];
        int leftPosition = l;
        int rightPosition = r;
        int currentPosition = l;
        while (currentPosition <= rightPosition) {
            if (array[currentPosition] < num) {
                swap(array, leftPosition++, currentPosition++);
            } else if (array[currentPosition] == num) {
                currentPosition++;
            } else {
                swap(array, currentPosition, rightPosition--);
            }
        }
        return new int[]{leftPosition, rightPosition};
    }

    public static void sortArrayByPartition(int[] array, int l, int r) {
        if (r >= l) {
            int random = new Random().nextInt(r - l + 1);
            int randomP = random + l;
            swap(array, randomP, r);
            int[] partition = partition(array, l, r);
            sortArrayByPartition(array, l, partition[0] - 1);
            sortArrayByPartition(array, partition[1] + 1, r);
        }
    }

    public static int[] quickSort(int[] array) {
        sortArrayByPartition(array, 0, array.length - 1);
        return array;
    }


    public static void heapInsert(int[] array, int position) {
        while ((position - 1) / 2 < position) {
            if (array[(position - 1) / 2] < array[position]) {
                swap(array, (position - 1) / 2, position);
            }
            position = (position - 1) / 2;
        }
    }

    public static void heapify(int[] array,int position,int heapSize){
        if(heapSize<2){
            return;
        }
        while (position < heapSize){
            int leftChildP = position*2+1;
            int rightChildP = position*2+2;
            if(leftChildP>heapSize-1){
                break;
            }
            if(rightChildP > heapSize-1){
                if(array[leftChildP]>array[position]){
                    swap(array,position,leftChildP);
                }
                break;
            }
            int max ;
            int maxPosition ;
            if(array[leftChildP]>=array[rightChildP]){
                max = array[leftChildP];
                maxPosition = leftChildP;
            }else {
                max=array[rightChildP];
                maxPosition = rightChildP;
            }
            if(max >array[position]){
                swap(array,position,maxPosition);
            }
            position = maxPosition;
        }
    }
    public static int[] heapSort(int[] array){
        int heapSize =0;
        for(;heapSize<array.length;heapSize++){
            heapInsert(array,heapSize);
        }

        for(;heapSize>1;heapSize--){
            swap(array,0,heapSize-1);
            heapify(array,0,heapSize-1);
        }
        return array;
    }
}