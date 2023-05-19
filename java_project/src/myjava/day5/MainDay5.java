package myjava.day5;

import myjava.day4.Day4;

import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDay5 {
 public static    int[] array={1,52,5,234,23,1324,876,8678,5,67,456,345,345,34,56,4526,5,54,3425,435,45,34,52,1,4,4,56,67,457,56,34,5,3456};
 public static    int[] array2={8,6,5,5,5,4,3,2};
 public static    int[] array3={8,6,5,1,5,4,3,2};

    public static void main(String[] args) {
//       System.out.println(Arrays.toString(Day4.partition(array,0,array.length-1)));
       System.out.println(Arrays.toString(Day5.heapSort(array)));
//       System.out.println(Arrays.toString(Day4.heapInsert(array2)));
//       System.out.println(Arrays.toString(Day5.heapInsert(array3,3)));
//       System.out.println(Arrays.toString(Day5.heapify(array3,3,8)));
//       System.out.println(Day4.findMaxNumByProcess(array)+"");

    }


}