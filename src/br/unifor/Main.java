package br.unifor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
		Scanner dado = new Scanner(System.in);

		System.out.println("Por favor digite o nome de um arquivo do tipo texto (.txt)");
		Huffman huffman = new Huffman(dado.next());
		System.out.println("Por favor digite  operação a ser realizada com o arquivo");
		System.out.println("1 -> Compactar \n2 -> Descompactar");

		int option = dado.nextInt();
		if (option == 1) {
			huffman.compress();
			System.out.println("Operação realizada com sucesso!");
		} else if (option == 2) {
			huffman.extract();
			System.out.println("Operação realizada com sucesso!");
		} else{
			System.out.println("Escolha uma opção válida!");
		}

    }
}
