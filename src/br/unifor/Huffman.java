package br.unifor;
import java.io.*;

public class Huffman {
    BufferedReader input;
    BufferedWriter output;
    String fileName;
    PriorityQueue queue;
    BinaryTree tree;
    int[] ascii;

    public Huffman(String fileName){
        this.fileName = fileName;
        try {
            input = new BufferedReader(new FileReader(fileName));
            System.out.println("Arquivo selecionado: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
            return;
        }
    }
    private void genHuffmanTree(){

    }
    public void compress() throws IOException {
        ascii = new int[255];
        queue = new PriorityQueue();
        // Gera o histograma com a frequencia de caracteres do input
        while(input.ready()){
            char[] line = input.readLine().toCharArray();
            for (char character: line) {
                ascii[character]++;
            }
        }

        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] != 0) {
                queue.enqueue((char) i, ascii[i]); // Coloca os caracteres na lista de prioridade
            }
        }
        tree = new BinaryTree(queue.genHuffmanTree()); // Gera a arvore de Huffman

        output = new BufferedWriter(new FileWriter(fileName.replace(".txt","")+"_compressed.txt"));
        output.close();
    }
    public void extract() throws IOException {
        output = new BufferedWriter(new FileWriter(fileName.replace(".txt","")+"_extracted.txt"));
        output.close();

    }
}
