package com.link;

/**
 * 节点实体类
 *
 * @Project: joycloud
 * @Package: com.link
 * @Author: 冯前进
 * @Date: 2020-01-03 13:06
 * @Description: TODO
 **/
public class Node {
    private Node pre;// 上一个节点
    private Node next;// 下一个节点
    private int data;// 数据

    public Node(int data) {
        this.data = data;
    }

    public void append(Node node) {
        if (this.next == null) {
            this.next = node;
            node.pre = this;
        } else {
            this.next.append(node);
        }

    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean hasPre() {
        return this.pre != null;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public int getData() {
        return data;
    }
}

