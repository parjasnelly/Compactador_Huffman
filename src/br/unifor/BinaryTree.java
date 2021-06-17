package br.unifor;


public class BinaryTree {
    private final Node root;
    private String line = "";
    private String[][] table;
    private int cont = 0;
    private int i;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public String[][] generateTable() {
        if (root != null) {
            i= 0;
            line = "";
            table = new String[cont][2];
            generateTable(root);
            line = "";
        }
        return table;
    }

    private void generateTable(Node root) {
        if (root.data != '\0') {
            //Armazena no vetor o Caractere e qual é seu código  binário compactado
            table[i][0] = Character.toString(root.data);
            table[i][1] = line;
            i++;
        }

        if (root.left != null) {
            line += "0";
            generateTable(root.left);
            line = line.substring(0, line.length() - 1);
        }

        if (root.right != null) {
            line += "1";
            generateTable(root.right);
            line = line.substring(0, line.length() - 1);
        }
    }

    public String toString() {
        if (root != null) {
            toString(root);
        }
        return line;
    }

    private void toString(Node root) {
        if (root.data == '\0') line += "0";

        else {
            String binary = Integer.toBinaryString(root.data);
            if (binary.length() < 8) {
                binary = 0 + binary;
            }
            line += "1" + binary;
        }

        if (root.left != null) toString(root.left);

        if (root.right != null) toString(root.right);
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
}
