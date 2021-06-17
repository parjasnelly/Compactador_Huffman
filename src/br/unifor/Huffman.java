package br.unifor;
import java.io.*;

public class Huffman {
    BufferedReader input;
    BufferedWriter output;
    String fileName;
    PriorityQueue queue;
    BinaryTree tree;
    String file;
    int[] ascii;

    public Huffman(String fileName){
        this.fileName = fileName;
        try {
            file = fileName;
            input = new BufferedReader(new FileReader(file));
            System.out.println("Arquivo selecionado: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
        }
    }

    public void compress() throws IOException {
        ascii = new int[255];
        ascii[10]= -1;
        queue = new PriorityQueue();
        // Gera o histograma com a frequencia de caracteres do input
        while(input.ready()){
            char[] line = input.readLine().toCharArray();
            for (char character: line) {
                ascii[character]++;
            }
            ascii[10]++;
        }
        input.close();
        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] > 0) {
                queue.enqueue((char) i, ascii[i]); // Coloca os caracteres na lista de prioridade
            }
        }
        tree = new BinaryTree(queue.genHuffmanTree()); // Gera a arvore de Huffman
        tree.setCont(queue.size());
        output = new BufferedWriter(new FileWriter(fileName.replace(".txt","")+"_compressed.txt"));

        output.write(tree.toString()+"\n"); // Escreve a arvore na primeira linha
        String[][] table= tree.generateTable();
        input = new BufferedReader(new FileReader(file));// Reseta o BufferedReader para ler o input novamente

        while(input.ready()){
            char[] line = input.readLine().toCharArray();
            // Escreve a mensagem comprimida
            for (char character: line) {
                for (var i = 0; i < tree.getCont(); i++) {
                    if (table[i][0].charAt(0)==character) {
                        output.write(table[i][1]);
                    }
                }
            }
        }
        output.close();
    }
    public void extract() throws IOException {
        output = new BufferedWriter(new FileWriter(fileName.replace(".txt","")+"_extracted.txt"));
        output.close();

    }
}
