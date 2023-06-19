package myjava.day9;

import java.util.Random;

//partitionArray中的左列表中的👉🏻节点记得-1
//partitionArray中的右列表中的起始节点记得+1

/***/
//mergeSort中,merged的起始索引为0,不是left
//mergeSort中,merged左列表或者右列表索引超过了mid或者right才将剩余的全部加上(非=时,而是=+1时)
public class Day9 {
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }


    public static int[] mergeSort(int[] array) {
        process(array, 0, array.length - 1);
        return array;
    }

    public static void process(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        process(array, left, (right - left) / 2 + left);
        process(array, (right - left) / 2 + left + 1, right);
        merge(array, left, right);
    }

    public static void merge(int[] array, int left, int right) {
        int leftP = left;
        int mid = (right - left) / 2 + left;
        int rightP = mid + 1;
        int[] mergedArray = new int[right - left + 1];
        int mergedP = 0;
        while (leftP <= mid || rightP <= right) {
            if (leftP == mid + 1) {
                mergedArray[mergedP++] = array[rightP++];
                continue;
            }
            if (rightP == right + 1) {
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
            array[left + i] = mergedArray[i];
        }

    }


    public static int[] partition(int[] array, int left, int right) {

        int leftP = left;
        int currP = left;
        int rightP = right;

        int num = array[right];
        while (currP <= rightP) {

            if (array[currP] < num) {
                swap(array, left, currP);
                currP++;
                leftP++;
            } else if (array[currP] == num) {
                currP++;
            } else {
                swap(array, rightP, currP);
                rightP--;
            }

        }
        return new int[]{leftP-1,rightP+1};

    }


    public static void sortByPartition(int[] array,int left,int right){
        if(right>=left){
            int[] partition = partition(array, left, right);
            sortByPartition(array,left,partition[0]);
            sortByPartition(array,partition[1],right);

        }

    }
    public static int[] quickSort(int []array){
        sortByPartition(array,0,array.length-1);
        return  array;
    }


    public static void heapInsert(int[] array ,int position){
       int parentPosition= (position -1)/2;
       while((position -1)/2  < position){
         if(array[(position -1)/2]<array[position]){
             swap(array,(position -1)/2,position);
         }
       }
    }

}
