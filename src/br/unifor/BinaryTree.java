package br.unifor;


public class BinaryTree {
    private Node root;
    private String line = "";
    private String treeCode;
    private String[][] table;
    private int cont = 0;
    private int i;

    public BinaryTree(Node root) {
        this.root = root;
    }
    public BinaryTree(String treeCode){
        this.treeCode = treeCode;
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

    public void reGenerateTree(){
       this.root = new Node('\0');
        reGenerateTree(root);
    }

    private void reGenerateTree(Node root) {
        if (!treeCode.equals("")) {
            if (treeCode.charAt(0) == '1') {
                root.data = (char) Integer.parseInt(treeCode.substring(1, 9), 2);
                treeCode = treeCode.substring(8);
                return;
            }
            root.left = new Node('\0');
            treeCode = treeCode.substring(1);
            reGenerateTree(root.left);
            root.right = new Node('\0');
            treeCode = treeCode.substring(1);
            reGenerateTree(root.right);
        }
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

    public String decode (String code){
        String decodedLine = "";
        Node aroot = root;
        while (!code.equals("")){
            if (aroot.data != '\0') {
                decodedLine += String.valueOf(aroot.data);
                aroot = root;
            }
            if (code.charAt(0) == '0') {
                aroot = aroot.left;
                code = code.substring(1);
            } else{
                aroot = aroot.right;
                code = code.substring(1);
            }
        }
        decodedLine += String.valueOf(aroot.data);
        return decodedLine;
    }

    public String toString() {
        line = "";
        if (root != null) {
            toString(root);
        }
        return line;
    }

    private void toString(Node root) {
        if (root.data == '\0') line += "0";

        else {
            String binary = Integer.toBinaryString(root.data);
            while (binary.length() < 8) {
                binary = "0" + binary;
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
