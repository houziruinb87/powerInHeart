package myjava.day9;

import java.util.Random;

//partitionArray中的左列表中的👉🏻节点记得-1
//partitionArray中的右列表中的起始节点记得+1
public class Day9 {
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static void merge(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        int leftP = l;
        int rightP = m + 1;
        int p = 0;
        int[] mergedArray = new int[r - l + 1];
        while (leftP <= m || rightP <= r) {
            if (leftP > m) {
                mergedArray[p++] = array[rightP++];
                continue;
            }
            if (rightP > r) {
                mergedArray[p++] = array[leftP++];
                continue;
            }
            if (array[leftP] <= array[rightP]) {
                mergedArray[p++] = array[leftP++];
            } else {
                mergedArray[p++] = array[rightP++];
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
        int leftP = l;
        int currentP = l;
        int rightP = r;
        while (currentP <= rightP) {
            if (array[currentP] < num) {
                swap(array, leftP++, currentP++);
            } else if (array[currentP] == num) {
                currentP++;
            } else {
                swap(array, currentP, rightP--);
            }
        }
        return new int[]{leftP, rightP};
    }

    //partitionArray中的左列表中的👉🏻节点记得-1
    //partitionArray中的右列表中的起始节点记得+1
    public static void partitionArray(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
//l-r范围挑选随机数,与r替换
        Random random = new Random();
        int randomNum
                = random.nextInt(r - l + 1);
        int randomPosition = randomNum + l;
        swap(array, randomPosition, r);
        int[] partitionPosition = partition(array, l, r);
        partitionArray(array, l, partitionPosition[0] - 1);
        partitionArray(array, partitionPosition[1] + 1, r);
    }

    public static int[] quickSort(int[] array) {
        partitionArray(array, 0, array.length - 1);
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

    public static void heapify(int[] array, int position, int heapSize) {
        while (position < heapSize) {
            int leftChildP = position * 2 + 1;
            int rightChildP = position * 2 + 2;

            //左child越界,
            if (leftChildP > heapSize - 1) {
                return;
            }
           //左child没越界,右边child越界
            if (rightChildP > heapSize - 1) {
                if (array[position] < array[leftChildP]) {
                    swap(array, position, leftChildP);
                }
                position = leftChildP;
                return;
            }

//            都没越界
            int leftChild =array[leftChildP];
            int rightChild =array[rightChildP];
            int maxPosition;
            int maxChild;
            if(leftChild>=rightChild){
                maxPosition =leftChildP;
                maxChild =leftChild;
            }else {
                maxPosition =rightChildP;
                maxChild =rightChild;
            }
            if(maxChild>array[position]){
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

        for(;heapSize>0;heapSize--){
            swap(array,0,heapSize-1);
            heapify(array,0,heapSize-1);
        }
        return  array;
    }
}
