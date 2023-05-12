package myjava.dayone;

import myjava.day2.Day2;

import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDayOne {
 public static    int[] array={1,5,234,23,1324,876,8678,5,67,456,345,345,34,56,4526,5,54,3425,435,45,34,52,1,4,4,56,67,457,56,34,5,3456};

 public static int[] array1={1,3,5,7,435,435,2,3254,5,2435,4,2,345};
 public static int[] array2={2,4,6,8,45,23,42,34,234,23,4,234,23,4,234,};
    public static void main(String[] args) {
//       System.out.println(Arrays.toString(DayOne.selectSort(array)));
//       System.out.println(Arrays.toString(DayOne.bubbleSort(array)));
//       System.out.println(Arrays.toString(DayOne.insertSort(array)));
//       System.out.println(Day2.findMath(array));
       System.out.println(Arrays.toString(Day2.mergeSort(array)));
//       System.out.println(Arrays.toString(Day2.merge(DayOne.selectSort(array1),DayOne.selectSort(array2))));

    }


}