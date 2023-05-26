package myjava.day8;

import myjava.day7.Day7;

import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDay8 {
    public static int[] array = {1, 52, 5, 234, 23, 1324, 876, 8678, 5, 67, 456, 345, 345, 34, 56, 4526, 5, 54, 3425, 435, 45, 34, 52, 1, 4, 4, 56, 67, 457, 56, 34, 5, 3456};
    public static int[] array2 = {8, 6, 5, 5, 5, 4, 3, 2};
    public static int[] array3 = {8, 6, 5, 1, 5, 4, 3, 2};

    public static void main(String[] args) {
//        Node doubleNodeByValue = Day8.createDoubleNodeByValue(10);
//        Day8.printNode(doubleNodeByValue);
//        Node reversDoubleNodeList = Day8.reversDoubleNodeList(doubleNodeByValue);
//        Day8.printNode(reversDoubleNodeList);

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node4_3 = new Node(3);
        Node node5_2 = new Node(2);
        Node node6_1 = new Node(1);
        Node node7_0 = new Node(0);

//        node0.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4_3;
//        node4_3.next = node5_2;
//        node5_2.next = node6_1;
//        node6_1.next = node7_0;
//        node7_0.next = node0;
//        if (Day8.isPalindrome(node0)) {
//            System.out.println("是回文");
//        } else {
//            System.out.println("不是回文");
//        }

//判断是否头尾相接
//
//        node0.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node0;
//        if (Day8.isCircular(node0)) {
//            System.out.println("是头尾相接");
//        } else {
//            System.out.println("不是头尾相接");
//        }



        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node0;
    //返回该链表入环node,如果不是环,返回null
    if(Day8.getEnterCircleNode(node0)!=null){
        Node enterNode = Day8.getEnterCircleNode(node0);
        System.out.println("是环,入环节点值为"+enterNode.value);
        Node headNode = Day8.breakCircle(node0,enterNode);
        Day8.printNode(node0);
        Day8.continueCircle(node0,enterNode);
        if(Day8.getEnterCircleNode(node0)!=null){
             enterNode = Day8.getEnterCircleNode(node0);
            System.out.println("是环,入环节点值为"+enterNode.value);
        }else {
            System.out.println("非环");

        }

    }    else {
            System.out.println("非环");

    }

//       System.out.println(Arrays.toString(Day4.partition(array,0,array.length-1)));
//       System.out.println(Arrays.toString(Day7.heapSort(array)));
//       System.out.println(Arrays.toString(Day6.heapInsert(array3,3)));
//       System.out.println(Arrays.toString(Day6.heapify(array3,3,array3.length)));
//       System.out.println(Day4.findMaxNumByProcess(array)+"");

    }


}