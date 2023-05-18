package myjava.day4;

import java.util.Random;

public class Day4 {
    public static void swap(int array[], int i, int j) {
        if(i==j){
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    //选择
    public static int[] selectSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    //冒泡
    public static int[] bubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;

    }

//插入

    public static int[] insertSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j - 1, j);
                } else {
                    break;
                }
            }
        }
        return array;
    }


    public static int findMaxNumByProcess(int[] array) {
        return processNum(array, 0, array.length - 1);
    }

    public static int processNum(int[] array, int l, int r) {
        if (l == r) {
            return array[l];
        }
        return Math.max(processNum(array, l, l + ((r - l) >> 1)), processNum(array, l + ((r - l) >> 1) + 1, r));
    }

    public static int[] mergeSort(int[] array) {
        return processArray(array, 0, array.length - 1);
    }

    public static int[] sArray;

    public static int[] quickSort(int[] array) {

        sArray = array;
        processArrayByPartition(array, 0, array.length - 1);
        return sArray;
    }

    public static int[] processArray(int[] array, int l, int r) {
        if (l == r) {
            int[] a = {array[l]};
            return a;
        }
        int[] arrayL = processArray(array, l, l + ((r - l) >> 1));
        int[] arrayR = processArray(array, l + ((r - l) >> 1) + 1, r);
        return mergeTwoArray(arrayL, arrayR);
    }

    public static int[] mergeTwoArray(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < array1.length && p2 < array2.length) {
            if (array1[p1] <= array2[p2]) {
                array[p++] = array1[p1++];
            } else {
                array[p++] = array2[p2++];
            }
        }
        if (p1 == array1.length) {
            while (p2 < array2.length) {
                array[p++] = array2[p2++];
            }
        }
        if (p2 == array2.length) {
            while (p1 < array1.length) {
                array[p++] = array1[p1++];
            }
        }
        return array;
    }


    public static int[] partition(int[] array, int l, int r) {
        int num = array[r];
        int currentPosition = l;
        while (currentPosition <= r) {
            if (array[currentPosition] < num) {
                swap(array, l, currentPosition);
                l++;
                currentPosition++;
            }
           else if (array[currentPosition] == num) {
                currentPosition++;
            }
           else  {
                swap(array, currentPosition, r);
                r--;
            }
        }
        return new int[]{l, r};
    }


    public static void processArrayByPartition(int[] array, int l, int r) {
        if (r > l) {
            //在l-r随机找  5 3  [0-2)  [3-5)
            int i = new Random().nextInt(r - l + 1);
            int randomPosition = l + i;
            swap(array, randomPosition, r);
            int[] partition = partition(array, l, r);
            processArrayByPartition(array, l, partition[0] - 1);
            processArrayByPartition(array, partition[1] + 1, r);
        }

    }





    public static int[] heapInsert(int[] array){
        int heapSize =0;
        for(;heapSize<array.length;heapSize++){
            int currentPosition = heapSize;
            while (currentPosition!=0){
                if(array[currentPosition]>array[(currentPosition-1)>>1]){
                    swap(array,(currentPosition-1)>>1,currentPosition);
                }
                currentPosition = (currentPosition-1)>>1;
            }
        }
          return array;
    }


    public static int[] heapify(int[] array){
        int heapSize =0;
        for(;heapSize<array.length;heapSize++){
            int currentPosition = heapSize;
            while (currentPosition!=0){
                if(array[currentPosition]<array[(currentPosition-1)>>1]){
                    swap(array,(currentPosition-1)>>1,currentPosition);
                }
                currentPosition = (currentPosition-1)>>1;
            }
        }
        return array;
    }

          
}
