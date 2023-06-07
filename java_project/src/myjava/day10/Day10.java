package myjava.day10;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
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

    /**
     * 非递归的先序
     * @param nodeTree
     */
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

    /**
     * 非递归后序
     * @param headNodeTree
     */
    public static void  processNode3(NodeTree headNodeTree) {
        Stack<NodeTree> stack = new Stack<>();
        Stack<NodeTree> stack2 = new Stack<>();
        stack.add(headNodeTree);
        while (!stack.isEmpty()){
            NodeTree popNode = stack.pop();
            stack2.push(popNode);
            if(popNode.left!=null){
                stack.push(popNode.left);
            }
            if(popNode.right!=null){
                stack.push(popNode.right);
            }


        }
       while (!stack2.isEmpty()){
           NodeTree popNode = stack2.pop();
           System.out.println(popNode.value+"");
       }


    }

    /**
     * 获取二叉树的最大宽度
     * 可以获取最大宽度在第几层
     * 可以获取每层有多少个节点
     * 可以获取一共有多少层,深度遍历
     * @param headNodeTree
     * @return
     */
    public static int getWidth(NodeTree headNodeTree){
        //当前层
        int currentLevel = 1;
        //当前层的节点数
        int currentLevelNodeNum =0;
        //最大节点数
        int maxNodeNums = 0;
        //存储节点与节点对应的层数
        HashMap<NodeTree,Integer> nodeAndLevelNum = new HashMap<>();
        //队列按照宽度遍历整个树
        Queue<NodeTree> nodeList = new LinkedList<>();

        nodeAndLevelNum.put(headNodeTree,1);
//        currentLevelNodeNum++;


        nodeList.offer(headNodeTree);
        while (!nodeList.isEmpty()){
            NodeTree pollNode = nodeList.poll();
            NodeTree left = pollNode.left;
            NodeTree right = pollNode.right;
            Integer currentLevelNum = nodeAndLevelNum.get(pollNode);
            if(left!=null){
                nodeList.offer(left);
                nodeAndLevelNum.put(left,currentLevelNum+1);
            }
            if(right!=null){
                nodeList.offer(right);
                nodeAndLevelNum.put(right,currentLevelNum+1);

            }
//            当前层和新节点位于同一层
            if(currentLevel == currentLevelNum){
                currentLevelNodeNum++;
            }else {
//                当前层与新节点不在同一层,结算
                currentLevel++;
                maxNodeNums = Math.max(currentLevelNodeNum,maxNodeNums);
                currentLevelNodeNum=1;
            }


        }

        ///!!!记得跳出循环后再结算一次,
        maxNodeNums = Math.max(currentLevelNodeNum,maxNodeNums);

//        return currentLevel;
        return maxNodeNums;
    }

    /**
     * 非递归中序遍历
     * @param headNode
     */
    public static void processMiddle(NodeTree headNode){
        Stack<NodeTree> stack = new Stack<>();
        stack.push(headNode);
        NodeTree cur =headNode;
        while (!stack.isEmpty()){
            if(cur.left!=null){
                stack.push(cur.left);
                cur = cur.left;
            }else {
                //当左边不再有下一个,把栈顶弹出
                NodeTree pop = stack.pop();
                System.out.println(pop.value);
                if(pop.right!=null){
                    cur = pop.right;
                    stack.push(cur);
                }
            }
        }
    }
}
