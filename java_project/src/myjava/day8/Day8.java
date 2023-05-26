package myjava.day8;

import java.util.Stack;

/**
 * 链表问题,一般先判断是否为环形链表
 * 还需要再判断这个环形链表是否为首尾相接
 * 从而区分找到入环的节点
 */
class Node {
    public int value;
    public Node next;
    public Node last;

    Node(int value) {
        this.value = value;
    }
}

/**
 * 1. 逆转单向双向链表
 * 2. 打印两个链表公共部分
 * 3. 判断链表是否为回文结构
 */
public class Day8 {
    public static Node createSingleNodeByValue(int size) {
        Node head = null;
        Node current = null;
        for (int i = 0; i < size; i++) {
            if (head == null) {
                head = new Node(i);
                current = head;
            } else {
                Node node = new Node(i);
                current.next = node;
                current = node;
            }

        }
        return head;
    }

    public static void printNode(Node node) {
        Node currentNode = node;
        System.out.println(currentNode.value + "--current=" + node + "--last=" + node.last + "---next=" + node.next);

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.value + "--current=" + currentNode + "--last=" + currentNode.last + "---next=" + currentNode.next);

        }
        System.out.println("-----------------------------------");

    }

    /**
     * 逆转链表
     *
     * @param node
     * @return
     */
    public static Node reverseNodeList(Node node) {
        if (node != null && node.next != null) {
            Node pre = null;
            Node current = node;
            Node curNext;
            Node newHead = null;
            while (current != null) {
                if (current.next == null) {
                    newHead = current;
                }
                curNext = current.next;
                current.next = pre;
                pre = current;
                current = curNext;
            }
            return newHead;
        } else {
            return node;
        }
    }


    /**
     * 构建双向链表
     *
     * @param doubleNodeListSize
     * @return
     */
    public static Node createDoubleNodeByValue(int doubleNodeListSize) {
        Node head = null;
        Node pre = null;
        Node current = null;
        for (int i = 0; i < doubleNodeListSize; i++) {

            Node newNode = new Node(i);
            //头知道上一个不知道下一个
            if (head == null) {
                head = newNode;
                current = head;
            } else {
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
     *
     * @param node
     * @return
     */
    public static Node reversDoubleNodeList(Node node) {
        Node head = null;
        Node pre = null;
        Node current = node;
        Node curNext;
        while (current != null) {
            //没有下一个
            if (current.next == null) {
                head = current;
            }
            curNext = current.next;
            current.next = pre;
            current.last = curNext;
            pre = current;
            current = curNext;
        }
        return head;
    }

    //1 2 3  1224  123345
    public static boolean isNodeListIsHuiWen(Node node) {
        Node slowOPoint = node;
        Node fastPoint = node;
        Node middlePoint = null;
        Node middleLeftPoint = null;
        Node middleRightPoint = null;

        while (fastPoint.next != null && fastPoint.next.next != null) {
            slowOPoint = slowOPoint.next;
            fastPoint = fastPoint.next.next;
        }
        if (fastPoint.next != null) {
            //slowPoint位于中线前一个
            if (fastPoint.next.next == null) {
                middleLeftPoint = slowOPoint;
            }
            //slowPoint正位于中点
        } else {
            middlePoint = slowOPoint;
        }

//        reverseNodeList();

        return true;
    }


    public static boolean isPalindrome(Node head) {
        Node current = head;
        Stack<Node> stack = new Stack();
        stack.push(current);
        while (current.next != null) {
            stack.push(current.next);
            current = current.next;
        }
        current = head;
        while (!stack.empty()) {
            if (current.value != stack.pop().value) {
                return false;
            }
            current = current.next;
        }
        return true;
    }


    /**
     * AI生成的,判断链表是否为首尾相接的环
     *
     * @param head
     * @return
     */
    public static boolean isCircular(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast.next == null || fast.next.next == null) {
            return false;
        }
// 判断是否是头尾相接的圆环
        Node p = head;
        while (p != fast) {
            p = p.next;
            fast = fast.next;
        }
        return p == head;
    }

    /**
     * 判断一个链表是否为环
     * 如果非环返回null
     * 如果为环返回入环节点(考虑到了首尾相接)
     * @param head
     * @return
     */
    public static Node getEnterCircleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node fastP = head;
        Node slowP = head;
        while (fastP != null && slowP != null && fastP.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP) {
                break;
            }
        }
//        有环
        if (fastP == slowP) {
            //首尾相接
            if (fastP == head) {
                return head;
            } else {
                //不是首尾相接
                fastP = head;
                while (fastP != null && slowP != null) {
                    fastP = fastP.next;
                    slowP = slowP.next;
                    if (fastP == slowP) {
                        return fastP;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 打破环
     *
     * @param head
     * @param enterCircleNode
     * @return
     */
    public static Node breakCircle(Node head, Node enterCircleNode) {
        boolean hasAppear = false;
        while (head != null && head.next != null && enterCircleNode != null) {
            Node curNode = head;
            while (curNode != null && curNode.next != null) {
                if (curNode.next == enterCircleNode) {
                    if (!hasAppear) {
                        hasAppear = true;
                    } else {
                        curNode.next = null;
                        return head;
                    }
                }
                curNode = curNode.next;
            }

        }
        return null;
    }

    /**
     * 继续维持环结构
     * @param head
     * @param enterNode
     * @return
     */
    public static boolean continueCircle(Node head,Node enterNode){
        Node current = head;
        while (current!=null){
            if(current.next == null){
                current.next = enterNode;
                return  true;
            }
            current = current.next;
        }
        return false;
    }
}
