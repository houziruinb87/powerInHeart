package myjava.day2;

import java.util.ArrayList;

/**
 * 递归
 * 1.查找最大值
 * 2.归并排序
 */
public class Day2 {
    /**
     * 寻找数组array中的最大值
     *
     * @param array
     * @return
     */
    public static int findMath(int[] array) {
        return process(array, 0, array.length - 1);
    }

    public static int process(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }
//        int mid = left+(right-left)/2;
        int mid = left + ((right - left) >> 1);
        int leftMax = process(array, left, mid);
        int rightMax = process(array, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

    public static int[]  mergeSort(int[] array){
       return process2(array,0,array.length-1);
    }


    public static int[] process2(int[] array, int left, int right) {
        if (left == right) {
            int value = array[left];
            int[] arrayValue ={value};
            return arrayValue;
        }
//        int mid = left+(right-left)/2;
        int mid = left + ((right - left) >> 1);
        int[] leftMax = process2(array, left, mid);
        int[] rightMax = process2(array, mid + 1, right);
        return merge(leftMax,rightMax);

    }

    public static  int[] merge(int[] array1,int[] array2){
        ArrayList<Integer> helpArray=new ArrayList<>();
        int array1Index = 0;
        int array2Index = 0;
        while (array1Index<=array1.length){
            //第二个数组已经遍历完了
            if(array2Index ==array2.length){
               for(int i=array1Index;i<array1.length;i++){
                   helpArray.add(array1[i]);
               }
               return helpArray.stream().mapToInt(Integer::intValue).toArray();
            }
            //第一个数组已经遍历完了
            if(array1Index ==array1.length){
                for(int i=array2Index;i<array2.length;i++){
                    helpArray.add(array2[i]);
                }
                return helpArray.stream().mapToInt(Integer::intValue).toArray();
            }
            //都没遍历完,继续
            if(array1[array1Index]<array2[array2Index] ){
                helpArray.add(array1[array1Index++]);
            }else {
                helpArray.add(array2[array2Index++]);
            }
        }
        return helpArray.stream().mapToInt(Integer::intValue).toArray();

    }
}
