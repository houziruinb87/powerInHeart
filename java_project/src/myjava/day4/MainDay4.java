package myjava.day4;

import myjava.day3.Day3;

import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDay4 {
 public static    int[] array={1,52,5,234,23,1324,876,8678,5,67,456,345,345,34,56,4526,5,54,3425,435,45,34,52,1,4,4,56,67,457,56,34,5,3456};
 public static    int[] array2={1,52,5,234,5};

    public static void main(String[] args) {
//       System.out.println(Arrays.toString(Day4.partition(array,0,array.length-1)));
//       System.out.println(Arrays.toString(Day4.quickSort(array)));
//       System.out.println(Arrays.toString(Day4.heapInsert(array2)));
       System.out.println(Arrays.toString(Day4.heapify(array)));
//       System.out.println(Day4.findMaxNumByProcess(array)+"");

    }


}