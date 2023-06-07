package myjava.day10;

import myjava.day9.Day9;

import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDay10 {
    public static void main(String[] args) {
        NodeTree fullBTHead = Day10.createFullBT();
//        Day10.processNode(fullBTHead);
//        Day10.processNode2(fullBTHead);
//        Day10.processNode3(fullBTHead);
        Day10.processMiddle(fullBTHead);
//        System.out.println("当前最宽有多少个节点--"+ Day10.getWidth(fullBTHead));

    }


}