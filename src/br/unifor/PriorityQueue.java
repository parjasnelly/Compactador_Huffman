package br.unifor;

public class PriorityQueue {
    private Node first;
    private Node last;
    private int cont;
    private int i;

    public PriorityQueue() {
        cont = 0;
        first = null;
        last = null;
    }

    public void enqueue(char value, int  priority) {
        Node newNode  = new Node(value, priority);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else if (newNode.priority<first.priority) {
            newNode.next = first;
            first = newNode;
        }else if (newNode.priority>=last.priority){
            last.next = newNode;
            last = newNode;
        }
        else{
            Node past = null;
            Node curr = first;

            while(curr!= null && newNode.priority>=curr.priority){
                past = curr;
                curr = curr.next;
            }
            past.next = newNode;
            newNode.next = curr;
        }
        cont++;
    }
    public void enqueue(Node newNode) {
        if (first == null) {
            first = newNode;
            last = newNode;
        } else if (newNode.priority<first.priority) {
            newNode.next = first;
            first = newNode;
        }else if (newNode.priority>=last.priority){
            last.next = newNode;
            last = newNode;
        }
        else{
            Node past = null;
            Node curr = first;

            while(curr!= null && newNode.priority>=curr.priority){
                past = curr;
                curr = curr.next;
            }
            past.next = newNode;
            newNode.next = curr;
        }
        cont++;
    }
    public void dequeue() {
        if(first != null){
            if(first==last){
                cont = 0;
                first = null;
                last = null;
            } else {
                first = first.next;
                cont--;
            }
        }
    }
    public Node peek(){
        Node node = first;
        dequeue();
        return node;

    }
    public boolean isEmpty(){
        return cont == 0;
    }
    public boolean search(char value) {
        Node aux = first;
        for (int i = 0; i < cont; i++) {
            if (value==aux.data) return true;
            aux = aux.next;
        }
        return false;
    }
    public int searchIndex(char value) {
        Node aux = first;
        for (int i = 0; i < cont; i++) {
            if (value == aux.data) return i;
            aux = aux.next;
        }
        return -1;
    }
    public int size() {
        return i;
    }
    public void print() {
        Node curr = first;
        String line = "";
        while (curr != null) {
            line += curr.data + " = " + curr.priority + "\n";
            curr = curr.next;
        }
        System.out.println(line);

    }
    public Node genHuffmanTree(){
        i = cont;
        while (cont>1){
            Node A = this.peek();
            Node B = this.peek();
            Node C = new Node(A.priority+ B.priority, A ,B);
            this.enqueue(C);
        }
        return first;
    }
}