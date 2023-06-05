package myjava.day10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class NodeTree{
    public int value;
    public NodeTree left;
    public NodeTree right;
     NodeTree(int value){
         this.value = value;
     }

}
public class Day10 {
public static NodeTree createFullBT(){
    NodeTree nodeTree1 = new NodeTree(1);
    NodeTree nodeTree2 = new NodeTree(2);
    NodeTree nodeTree3 = new NodeTree(3);
    NodeTree nodeTree4 = new NodeTree(4);
    NodeTree nodeTree5 = new NodeTree(5);
    NodeTree nodeTree6 = new NodeTree(6);
    NodeTree nodeTree7 = new NodeTree(7);
    NodeTree nodeTree8 = new NodeTree(8);
    NodeTree nodeTree9 = new NodeTree(9);
    NodeTree nodeTree10 = new NodeTree(10);
    NodeTree nodeTree11 = new NodeTree(11);
    NodeTree nodeTree12 = new NodeTree(12);
    NodeTree nodeTree13 = new NodeTree(13);
    NodeTree nodeTree14 = new NodeTree(14);
    NodeTree nodeTree15 = new NodeTree(15);

    nodeTree1.left = nodeTree2;
    nodeTree1.right = nodeTree3;
    nodeTree2.left=nodeTree4;
    nodeTree2.right=nodeTree5;
    nodeTree3.left = nodeTree6;
    nodeTree3.right = nodeTree7;
    nodeTree4.left = nodeTree8;
    nodeTree4.right = nodeTree9;
    nodeTree5.left=nodeTree10;
    nodeTree5.right=nodeTree11;
    nodeTree6.left = nodeTree12;
    nodeTree6.right = nodeTree13;
    nodeTree7.left = nodeTree14;
    nodeTree7.right = nodeTree15;

    return nodeTree1;
}

public static void  processNode(NodeTree nodeTree){
    if(nodeTree == null){
        return;
    }
    processNode(nodeTree.left);
    processNode(nodeTree.right);
    System.out.println(nodeTree.value+"");
}

    public static void  processNode2(NodeTree nodeTree) {

        Stack<NodeTree> stack = new Stack<>();
        stack.add(nodeTree);
        while (!stack.isEmpty()){
            NodeTree popNode = stack.pop();
            System.out.println(popNode.value+"");
            if(popNode.right!=null){
                stack.push(popNode.right);
            }
            if(popNode.left!=null){
                stack.push(popNode.left);
            }

        }

    }
    public static void  processNode3(NodeTree headNodeTree) {
        Queue<NodeTree> queue = new LinkedList<>();


    }


}
