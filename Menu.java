package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import ecommerce.util.Cores; //3

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in); // 1
		int opcao;

		while (true) { // 2
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("*************************************************");
			System.out.println("*                                               *");
			System.out.println("*         Nossa Lojinha na Internet             *");
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
			System.out.println("*   8 - Realizar uma venda                      *"); // transferência
			System.out.println("*   9 - Sair                                    *");
			System.out.println("*                                               *");
			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println("Entre com a opção desejada:                      ");
			System.out.println("                                                 ");
			System.out.println(Cores.TEXT_RESET);

			try { // 4
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite os valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) { // 5
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nNossa lojinha na Internet");
				assinatura();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:

				keyPress();
				break;
			case 2:

				keyPress();
				break;
			case 3:

				keyPress();
				break;
			case 4:

				keyPress();
				break;
			case 6:

				keyPress();
				break;
			case 7:

				keyPress();
				break;
			case 8:

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente!");
		}
	}

	public static void assinatura() { // 6
		System.out.println("\n*****************************************");
		System.out.println("Projeto Desenvolvido por:");
		System.out.println("Carina Maleski");
		System.out.println("https://github.com/carina-maleski");
		System.out.println("*****************************************");
	}
}
