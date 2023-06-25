package myjava.day7;

import java.util.Random;

/**
 * mergeSort
 * quickSort
 * heapSort
 *
 * heapSort时,在heapify之前swap,然后记得heapify中的heapSize这个参数的值就变成了原来heapSize-1
 */
public class Day7_1 {
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

   public static int[] mergeSort(int[] array){
        process(array,0,array.length-1);
        return  array;
   }
    public static void process(int[] array,int leftP,int rightP){
        if(leftP == rightP ){
            return;
        }
        int mid = (leftP+(rightP-leftP)/2);
        process(array,leftP,mid);
        process(array,mid+1,rightP);
        merge(array,leftP,rightP);
    }

    public static void merge(int[] array,int leftP,int rightP){
        int mid = (leftP+(rightP-leftP)/2);

        int[] mergedArray =new int[rightP-leftP+1];

        int leftCurP=leftP;
        int curP = 0;
        int rightCurP= mid+1;

        while (curP <mergedArray.length){
//        while (leftCurP <=mid || rightCurP<=rightP){
            if(leftCurP>mid){
               mergedArray[curP++]=array[rightCurP++];
               continue;
            }
            if(rightCurP > rightP){
                mergedArray[curP++]=array[leftCurP++];
                continue;
            }

            if(array[leftCurP]>=array[rightCurP]){
                mergedArray[curP++] = array[rightCurP++];
            }else {
                mergedArray[curP++] = array[leftCurP++];
            }
        }

        for (int i=0;i<mergedArray.length;i++){
            array[leftP+i]=mergedArray[i];
        }
    }


    public static int[] partition(int[] array,int leftP,int rightP){
        int num = array[rightP];
        int leftCurP = leftP-1;
        int rightCurP = rightP;
        while (leftP<=rightCurP){
            if(array[leftP] < num){
                swap(array,leftP++,++leftCurP);

            }else if(array[leftP] == num){
                leftP++;
            }else {
                swap(array,leftP,rightCurP);
                rightCurP--;
            }
        }
        return new int[]{leftCurP+1,rightCurP};
    }


    public static void partitionArray(int[] array,int left,int right){
        if(left<=right){
            int[] partition = partition(array, left, right);

//partitionArray中的左列表中的👉🏻节点记得-1
//partitionArray中的右列表中的起始节点记得+1
            partitionArray(array,left,partition[0]-1);
            partitionArray(array,partition[1]+1,right);
        }

    }

    public static int[] quickSort(int[] array){
        partitionArray(array,0,array.length-1);
        return array;
    }

}