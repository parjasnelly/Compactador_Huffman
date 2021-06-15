package br.unifor;

import java.io.*;

public class Huffman {
    BufferedReader input;
    BufferedWriter output;
    String fileName;

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
    public void compress() throws IOException {
        output = new BufferedWriter(new FileWriter(fileName.replace(".txt","")+"_compressed.txt"));
        output.close();
    }
    public void extract() throws IOException {
        output = new BufferedWriter(new FileWriter(fileName.replace(".txt","")+"_extracted.txt"));
        output.close();

    }
}
