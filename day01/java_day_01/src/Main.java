import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1,44,55,6,77,1123,456,567,2,54,67,7,8,45,7,54,6,456,45,645,63,5,6,3456,3,562,57};

        System.out.println("原始数据为:\n"+Arrays.toString(array));

        System.out.println("插入排序_降序:\n"+Arrays.toString(selectToSort(array)));
//        Thread.sleep(10000);
        System.out.println("冒泡排序_升序:\n"+Arrays.toString(bubbleToSort(array)));

    }
    public  static int[] selectToSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j =i+1;j<array.length;j++){
                if(array[j]>array[i]){
                    swap(array,i,j);
                }
            }
        }
        return array;
    }
    public static void swap(int[] array,int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }

    public static int[] bubbleToSort(int[] array){
        int arrayLength = array.length;
        for(int i=0; i<arrayLength && arrayLength>1;arrayLength--){
             for(int j=0;j<arrayLength-1;j++){
                 if(array[j+1]<array[j]){
                     swap(array,j,j+1);
                 }
             }
        }
        return array;
    }



}