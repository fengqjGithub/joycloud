package com.link;

/**
 * @Project: joycloud
 * @Package: com.link
 * @Author: 冯前进
 * @Date: 2020-01-03 13:08
 * @Description: TODO
 **/
public class TestNode {
    public static void main(String[] args) throws InterruptedException {
        NodeList list = new NodeList();
        System.out.println("构造长度为10的双向链表");
        for (int i = 0; i < 10; i++) {
            int r = (int)(Math.random() * 100);
            Node node = new Node(r);
            if (i == 0) {
                list.head = node;// 头节点
            } else {
                list.head.append(node);
            }
            list.last = node;// 尾节点
        }

        // 遍历
        System.out.println(list.toString());

        // 倒置反转
        System.out.println(list.reverse());

    }
}
