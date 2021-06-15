package br.unifor;

public class BinaryTree {
    private Node root;
    private String line = "";
    public BinaryTree() {
        root = null;
    }
    public BinaryTree(Node root){
        this.root = root;
    }
    public void add(char value) {
        if (root==null) root = new Node(value);
        else add(value, root);
    }
    public void add(char value, Node root){
        if (value<root.data){
            if (root.left == null) root.left = new Node(value);
            else add(value,root.left);
        } else if (value>root.data) {
            if (root.right == null) root.right = new Node(value);
            else add(value,root.right);
        }
    }

    public void clear(){
        root = null;
    }
    public boolean pesquisar(char value) {
        if (root == null) {
            return false;
        }
        else {
            return pesquisar(value, root);
        }
    }

    private boolean pesquisar(char value, Node root) {
        if (value == root.data) {
            return true;
        }
        else if (value < root.data) {
            if (root.left == null) {
                return false;
            }
            else {
                return pesquisar(value, root.left);
            }
        }
        else if (value > root.data) {
            if (root.right == null) {
                return false;
            }
            else {
                return pesquisar(value, root.right);
            }
        }

        return false;
    }

    public void print() {
        if (root != null) {
            printPre(root);
            System.out.println("Pre.:"+line);
            line = "";
            printIn(root);
            System.out.println("In..:"+line);
            line = "";
            printPos(root);
            System.out.println("Post:"+line);
            line = "";
            System.out.println("");
        }
    }

    private void printPre(Node root) {
        line+= " "+root.data + " = " + root.priority;

        if (root.left != null) {
            printPre(root.left);
        }

        if (root.right != null) {
            printPre(root.right);
        }
    }
    private void printIn(Node root) {
        if (root.left != null) {
            printIn(root.left);
        }

        line+= " "+root.data + " = " + root.priority;


        if (root.right != null) {
            printIn(root.right);
        }
    }
    private void printPos(Node root) {
        if (root.left != null) {
            printPos(root.left);
        }

        if (root.right != null) {
            printPos(root.right);
        }

        line+= " "+root.data + " = " + root.priority;
    }
}
