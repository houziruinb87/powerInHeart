package myjava.day8;

class Node{
    public int value;
    public Node next;
    public Node last;
    Node(int value){this.value = value;}
}
public class Day8 {
    public static Node createSingleNodeByValue(int size){
        Node head =null;
        Node current  = null;
        for(int i = 0; i<size;i++){
            if(head == null){
                head = new Node(i);
                current = head;
            }else {
                Node node = new Node(i);
                current.next = node;
                current = node;
            }

        }
        return head;
    }
    public static void printNode(Node node){
        Node currentNode = node;
        System.out.println(currentNode.value+"--current="+node+"--last="+node.last+"---next="+node.next);

        while (currentNode.next!=null){
            currentNode = currentNode.next;
            System.out.println(currentNode.value+"--current="+currentNode+"--last="+currentNode.last+"---next="+currentNode.next);

        }
        System.out.println("-----------------------------------");

    }

    /**
     * 逆转链表
     * @param node
     * @return
     */
    public static Node reverseNodeList(Node node){
        if(node != null && node.next!=null){
           Node pre = null;
           Node current = node;
           Node curNext;
           Node newHead = null;
           while (current!=null){
               if(current.next==null){
                   newHead = current;
               }
               curNext = current.next;
               current.next = pre;
               pre = current;
               current = curNext;
           }
            return newHead;
        }else {
            return node;
        }
    }


    /**
     * 构建双向链表
     * @param doubleNodeListSize
     * @return
     */
    public static Node createDoubleNodeByValue(int doubleNodeListSize){
        Node head = null;
        Node pre = null;
        Node current =null;
        for(int i =0;i<doubleNodeListSize;i++){

            Node newNode = new Node(i);
            //头知道上一个不知道下一个
            if(head == null){
                head = newNode;
                current = head;
            }else {
                current.next = newNode;
                current = newNode;

            }
            current.last = pre;
            pre = current;
        }
        return head;
    }

    /**
     * 逆转双向链表
     * @param node
     * @return
     */
    public  static Node reversDoubleNodeList(Node node){
        Node head = null;
        Node pre = null;
        Node current = node;
        Node curNext ;
        while (current!=null){
            //没有下一个
            if(current.next==null){
                head = current;
            }
            curNext = current.next;
            current.next = pre;
            current.last = curNext;
            pre = current;
            current = curNext;
        }
        return  head;
    }
}
