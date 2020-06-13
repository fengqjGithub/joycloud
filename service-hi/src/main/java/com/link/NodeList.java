package com.link;

/**
 * @Project: joycloud
 * @Package: com.link
 * @Author: 冯前进
 * @Date: 2020-01-03 13:07
 * @Description: TODO
 **/
public class NodeList {
    Node head;
    Node last;
    /**
     * 追加
     * @param node
     */
    public void append(Node node) {
        if (head.getNext() == null) {
            head.setNext(node);
            node.setPre(head);
        } else {
            head.getNext().append(node);
        }
    }

    /**
     * 遍历
     */
    public String toString() {
        Node curr = head;
        StringBuilder sBuilder = new StringBuilder();
        while (curr != null) {
            sBuilder.append(curr.getData()).append(curr.hasNext() ? "->" : "");
            curr = curr.getNext();
        }
        return sBuilder.toString();
    }

    /**
     * 倒置反转
     */
    public String reverse() {
        Node curr = head;
        Node newHead = null;
        Node newLast = null;
        while (curr != null) {
            Node pre = curr.getPre();
            Node next = curr.getNext();
            if (pre == null) newLast = curr; // 前一个节点为空，作为新的尾节点
            if (next == null) newHead = curr;// 后一个节点为空，作为新的头节点
            curr.setNext(pre);// 当前节点的下一个节点作为当前节点的上一个节点
            curr.setPre(next);// 当前节点的上一个节点作为当前节点的下一个节点
            curr = curr.getPre();// 继续处理原链表节点的下一个节点
        }
        head = newHead;// 设置头节点
        last = newLast;// 设置尾节点
        return this.toString();
    }
}

