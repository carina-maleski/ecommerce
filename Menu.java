package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.util.Cores; //3

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in); //1
		int opcao;
		
		while (true) { //2
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("*************************************************");
			System.out.println("*                                               *");
			System.out.println("*          Lojinha na Internet                  *");
			System.out.println("*                                               *");
			System.out.println("*************************************************");
			System.out.println("*                                               *");
			System.out.println("*   1 - Adicionar Produto                       *");
			System.out.println("*   2 - Listar todos os Produtos                *");
			System.out.println("*   3 - Buscar Produtos por Id                  *");
			System.out.println("*   4 - Atualizar Dados do Produto              *");
			System.out.println("*   5 - Apagar Produto                          *");
			System.out.println("*   6 - Remover unidades do Produto do Estoque  *"); 
			System.out.println("*   7 - Reposição de Estoque                    *"); 
			System.out.println("*   8 - Realizar uma venda                      *"); //transferência
			System.out.println("*   9 - Sair                                    *");
			System.out.println("*                                               *");
			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println("Entre com a opção desejada:                      ");
			System.out.println("                                                 ");
			System.out.println(Cores.TEXT_RESET);
			
			try { //4
				opcao = leia.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nDigite os valores inteiros!");
					leia.nextLine();
					opcao = 0;
				}
			
			if (opcao == 9) { //5
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Java 71 - O seu futuro começa aqui!");
				assinatura();
				leia.close();
				System.exit(0);
			}
	}

}
		public static void assinatura() { //6
			System.out.println("\n*****************************************");
			System.out.println("Projeto Desenvolvido por:");
			System.out.println("Carina Maleski");
			System.out.println("https://github.com/carina-maleski");
			System.out.println("*****************************************");
	}}
