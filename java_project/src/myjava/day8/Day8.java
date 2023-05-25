package myjava.day8;

class Node{
    public int value;
    public Node next;
    Node(int value){this.value = value;}
}
public class Day8 {
    public static Node createNodeByValue(int size){
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
        System.out.println(currentNode.value);
        while (currentNode.next!=null){
            currentNode = currentNode.next;
            System.out.println(currentNode.value);

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
}
