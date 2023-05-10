package myjava.dayone;

/**
 * 1.选择排序
 * 2.冒泡排序
 * 3.插入排序
 */
public class DayOne {
    /**
     *
     */
    public static int[] selectSort(int[] needToBeSortArray) {
        for (int i = 0; i < needToBeSortArray.length; i++) {
            for (int j = i; j < needToBeSortArray.length; j++) {
                if (needToBeSortArray[i] > needToBeSortArray[j]) {
                    swap(needToBeSortArray, i, j);
                }
            }

        }
        return needToBeSortArray;
    }

    /**
     *
     * @param needToBeSortArray
     * @return
     */
    public static int[] bubbleSort(int[] needToBeSortArray) {
        for (int i = 0; i < needToBeSortArray.length; i++) {

            for(int j = 0; j< needToBeSortArray.length-i-1; j++){
                if (needToBeSortArray[j] > needToBeSortArray[j + 1]) {
                    swap(needToBeSortArray, j, j + 1);
                }
            }

        }
        return needToBeSortArray;

    }

    public static int[] insertSort(int[] needToBeSortArray) {
        for (int i = 0; i < needToBeSortArray.length; i++) {
           for(int j = i+1;j>0 && j<needToBeSortArray.length;j--){
               if(needToBeSortArray[j-1] > needToBeSortArray[j]){
                   swap(needToBeSortArray,j-1,j);
               }
           }
        }
        return needToBeSortArray;

    }

        /**
         *
         */
    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
