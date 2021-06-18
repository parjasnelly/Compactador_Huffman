package br.unifor;

public class Node {
    public char data;
    public Node next;
    public Node right;
    public Node left;
    int priority;

    public Node(char data, int priority){
        this.data = data;
        this.next = null;
        this.left = null;
        this.right = null;
        this.priority = priority;
    }
    public Node(int priority, Node left, Node right){
        this.next = null;
        this.left = left;
        this.right = right;
        this.priority = priority;
    }
    public Node(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

