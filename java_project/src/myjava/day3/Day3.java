package myjava.day3;

import java.util.Arrays;

/**
 * 1.数组中随机挑一个数,把小于他的放于左边,大于的放于右边,等于他的放到中间要求O(n)  荷兰旗问题
 *
 */
public class Day3 {

    public static int[] smallLeftBigRight(int[] array, int numPosition){
        int num = array[numPosition];
        System.out.println("需要被比较的数字为"+num);

        int leftPosition=0;
        int rightPosition=array.length-1;
        int currentPosition=0;
        while ( currentPosition <= rightPosition){
            if(array[currentPosition]<num){
                swap(array,leftPosition,currentPosition);
                leftPosition++;
                currentPosition++;
            } else if (array[currentPosition]==num){
                currentPosition++;
            } else if(array[currentPosition]>num){
                swap(array,currentPosition,rightPosition);
                rightPosition--;
            }
        }
        return array;
    }

    /**
     *
     */
    public static void swap(int[] array, int i, int j) {
        if(i==j){
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
