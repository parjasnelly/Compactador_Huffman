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
        this.right = null;
        this.left = null;
        this.priority = priority;
    }
    public Node(int priority, Node right, Node left){
        this.next = null;
        this.right = right;
        this.left = left;
        this.priority = priority;
    }
    public Node(char data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

