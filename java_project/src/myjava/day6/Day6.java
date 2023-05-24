package myjava.day6;

import java.util.Random;

/**
 * 归并,快拍,堆排需要继续刷
 */
public class Day6 {
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];

    }

    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i && j + 1 < array.length; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        for (int i = 2; i <= array.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j - 1, j);
                }
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        return processArray(array, 0, array.length - 1);
    }

    public static int[] processArray(int[] array, int l, int r) {
        if (l == r) {
            return new int[]{array[l]};
        }
        int[] leftArray = processArray(array, l, l + (r - l) / 2);
        int[] rightArray = processArray(array, l + (r - l) / 2 + 1, r);
        return mergeArray(leftArray, rightArray);
    }

    public static int[] mergeArray(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int leftPosition = 0;
        int rightPosition = 0;
        int currentPosition = 0;
        while (leftPosition < leftArray.length || rightPosition < rightArray.length) {
            //左侧遍历完了,把右侧全塞进去
            if (leftPosition == leftArray.length) {
                mergedArray[currentPosition++] = rightArray[rightPosition++];
                continue;
            }
            //右侧遍历完了,把左侧塞进去
            if (rightPosition == rightArray.length) {
                mergedArray[currentPosition++] = leftArray[leftPosition++];
                continue;
            }
            //两侧都没遍历完,进行比较
            if (leftArray[leftPosition] <= rightArray[rightPosition]) {
                mergedArray[currentPosition++] = leftArray[leftPosition++];
            } else {
                mergedArray[currentPosition++] = rightArray[rightPosition++];
            }
        }
        return mergedArray;
    }


    public static int[] quickSort(int[] array) {

//        int[] partitionPositions = partition(array, 0, array.length - 1);
        sortArray(array, 0, array.length - 1);
//        sortArray(array, partitionPositions[1],array.length - 1 );
        return array;

    }

    public static int[] partition(int[] array, int l, int r) {
        int num = array[r];
        int currPosition = l;

        while (currPosition <= r) {
            if (array[currPosition] < num) {
                swap(array, l++, currPosition++);
            } else if (array[currPosition] == num) {
                currPosition++;
            } else {
                swap(array, currPosition, r--);
            }
        }
        return new int[]{l, r};
    }


    public static void sortArray(int[] array, int l, int r) {
        if (l <= r) {
            int[] partitionPositions = partition(array, l, r);
            sortArray(array, l, partitionPositions[0] - 1);
            sortArray(array, partitionPositions[1] + 1, r);
        }
    }

    public static int[] partitionArrayByLR(int[] arrray, int l, int r) {
        int num = arrray[r];
        int leftPosition = l;
        int currentPosition = leftPosition;
        int rightPosition = r;
        while (currentPosition <= rightPosition) {
            if (arrray[currentPosition] < num) {
                swap(arrray, leftPosition++, currentPosition++);
            } else if (arrray[currentPosition] == num) {
                currentPosition++;
            } else {
                swap(arrray, currentPosition, rightPosition--);
            }
        }
        return new int[]{leftPosition, rightPosition};
    }

    public static void sortArrayByPartition(int[] array, int l, int r) {
        if (l <= r) {
            int random = new Random().nextInt(r - l + 1);
            int randomPosition = l + random;
            swap(array, randomPosition, r);
            int[] partitionPositions = partitionArrayByLR(array, l, r);
            sortArrayByPartition(array, l, partitionPositions[0] - 1);
            sortArrayByPartition(array, partitionPositions[1] + 1, r);
        }
    }

    public static int[] quickSort2(int[] array){
        sortArrayByPartition(array,0,array.length-1);
        return  array;
    }


    public static int[] heapInsert(int[] array,int position ){
              while ((position-1)/2 <position){
                  if(array[position]>array[(position-1)/2]){
                      swap(array,(position-1)/2,position);
                  }
                  position = (position-1)/2;

              }
              return array;
    }


    public static int[] heapify(int[] array,int position,int heapSize){
      while (position*2+1<=heapSize-1 || position*2+2<=heapSize-1){
          //到头没有child2
          if(position*2+1 ==heapSize-1){
              if(array[position]<array[position*2+1]){
                  swap(array,position,position*2+1);
              }
              position = position*2+1;

          }
          //到头是child2
          if(position*2+2 <=heapSize-1){
              int max = array[position*2+2];
              int maxPosition = position*2+2;
              if(array[position*2+1]>array[position*2+2]){
                  max = array[position*2+1];
                  maxPosition = position*2+1;
              }
              if(array[position]<max){
                  swap(array,position,maxPosition);
              }
              position = maxPosition;

          }
      }
      return array;
    }

    public static int[] heapSort(int[] array){
        int heapSize =0;
        for(;heapSize<array.length;heapSize++){
            heapInsert(array,heapSize);
        }

        for(;heapSize>0;heapSize--){
            swap(array,0,heapSize-1);
            heapify(array,0,heapSize-1);
        }

        return  array;
    }


}

