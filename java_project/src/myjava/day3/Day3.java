package myjava.day3;

import java.util.Arrays;
import java.util.Random;

/**
 * 1.数组中随机挑一个数,把小于他的放于左边,大于的放于右边,等于他的放到中间要求O(n)  荷兰旗问题  也称为分层过程partition
 * <p>
 * 2.快速排序如果从末尾取数进行分层时间复杂度为O(N^2)如果随机取数分层时间复杂度为O(NlogN)
 */
public class Day3 {
    public static int[] sArray;

    /**
     * 返回左索引和右索引
     * 分层算法
     * 输入一个数列,和一个左右索引
     * 此算法以输入的右索引的值为标杆
     * 将次数列中{leftPosition-rightPosition}范围内的数组进行分层
     * @param array
     * @return
     */
    public static int[] partition(int[] array, int leftPosition, int rightPosition) {


//        System.out.println("左索引为" + leftPosition);
//        System.out.println("右索引为" + rightPosition);
//        int numPosition = rightPosition;
//        if (rightPosition > 0) {
//
//            numPosition = (((new Random().nextInt(rightPosition))) + leftPosition);
//            if(numPosition>=rightPosition){
//                numPosition = rightPosition;
//            }
//
//        }
//        System.out.println("随机数索引为" + numPosition);
        int num = array[rightPosition];
//        System.out.println("随机数索引对应的值为" + num);
//交换随机索引位置的数与最后一个位置
//        swap(array,array[numPosition],array[rightPosition] );

        int currentPosition = leftPosition;
        while (currentPosition <= rightPosition) {
            if (array[currentPosition] < num) {
                swap(array, leftPosition, currentPosition);
                leftPosition++;
                currentPosition++;
            } else if (array[currentPosition] == num) {
                currentPosition++;
            } else if (array[currentPosition] > num) {
                swap(array, currentPosition, rightPosition);
                rightPosition--;
            }
        }
        return new int[]{leftPosition, rightPosition};
    }

    /**
     *
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

//    public int[] quickSort(int array) {
//
//    }

    public static int[] callByOutQuickSort(int[] array, int leftPosition, int rightPosition) {
        sArray = array;
        quickSortByPartition(sArray, leftPosition, rightPosition);
        return sArray;
    }

    /**
     * 快拍分层
     *
     * @param array
     * @param leftPosition
     * @param rightPosition
     */
    public static void quickSortByPartition(int[] array, int leftPosition, int rightPosition) {
      if(leftPosition<rightPosition){
          //为了让时间复杂度为O(NlogN),在当前数列随机取一个数,与末尾的数交换,然后在分层时,以末尾数为标杆数进行分层.
          int  numPosition = (((new Random().nextInt(rightPosition-leftPosition+1))) + leftPosition);
          System.out.println("随机索引为" + numPosition);
          swap(array,numPosition,rightPosition);
          int[] partition = partition(array, leftPosition, rightPosition);
//          if (partition[0] <=array.length-1 && partition[1] >=0) {
              quickSortByPartition(array, leftPosition, partition[0] - 1);
              quickSortByPartition(array, partition[1] + 1, rightPosition);
//          }
      }

    }
}
