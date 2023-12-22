package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.model.ProdutoFisico;
import ecommerce.model.ProdutoVirtual;
import ecommerce.util.Cores; //3

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in); // 1

		int opcao, id, quantidade, tipo;
		String descricao, codigoAcesso;
		float preco, peso;

		EcommerceController produtos = new EcommerceController();

		ProdutoFisico pf1 = new ProdutoFisico(1, 5203, "Suporte de celular", 15.0f, 1, 300.0f);
		ProdutoFisico pf2 = new ProdutoFisico(2, 324, "Vaso de flor", 10.0f, 1, 300.0f);
		ProdutoVirtual pv1 = new ProdutoVirtual(3, 1000, "Vale presente 100", 100.0f, 2, "Asdh100");
		ProdutoVirtual pv2 = new ProdutoVirtual(4, 426, "Vale presente 150", 150.0f, 2, "Asdh150");

		pf1.visualizar();
		pf2.visualizar();
		pv1.visualizar();
		pv2.visualizar();

		while (true) { // 2
			System.out.println(Cores.TEXT_BLACK_BOLD+ Cores.ANSI_WHITE_BACKGROUND);
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
			System.out.println("*   6 - Realizar uma Venda                      *");
			System.out.println("*   7 - Reposição de Estoque                    *");
			System.out.println("*   8 - Sair                                    *");
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

			if (opcao == 8) { // 5
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nNossa lojinha na Internet");
				assinatura();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Adicionar Produto\n\n");

				System.out.println("Digite a Descrição do Produto: ");
				leia.skip("\\R?");
				descricao = leia.nextLine();

				System.out.println("Digite o Preço de venda do Produto: ");
				preco = leia.nextFloat();

				do {
					System.out.println("Digite o Tipo de Produto (1-Virtual e 2-Físico): ");
					tipo = leia.nextInt();
				} while (tipo < 1 || tipo > 2);

				System.out.println("Digite a quantidade adicionada ao estoque: ");
				quantidade = leia.nextInt();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Código de Acesso do Produto Virtual: ");
					leia.skip("\\R?");
					codigoAcesso = leia.nextLine();
					produtos.cadastrar(
							new ProdutoVirtual(produtos.gerarId(), quantidade, descricao, preco, tipo, codigoAcesso));
				}
				case 2 -> {
					System.out.println("Digite o peso do Produto Físico (g): ");
					peso = leia.nextFloat();
					produtos.cadastrar(new ProdutoFisico(produtos.gerarId(), quantidade, descricao, preco, tipo, peso));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todos os Produtos\n\n");
				produtos.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Buscar Produtos por Id\n\n");

				System.out.println("Digite o id do Produto: ");
				id = leia.nextInt();

				produtos.procurarPorId(id);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar Dados do Produto\n\n");

				System.out.println("Digite o id do Produto: ");
				id = leia.nextInt();

				var buscaProduto = produtos.buscarNaCollection(id);

				if (buscaProduto != null) {

					tipo = buscaProduto.getTipo();

					System.out.println("Digite a Descrição do Produto: ");
					leia.skip("\\R?");
					descricao = leia.nextLine();

					System.out.println("Digite o Preço de venda do Produto: ");
					preco = leia.nextFloat();

					System.out.println("Digite a quantidade adicionada ao estoque: ");
					quantidade = leia.nextInt();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Código de Acesso do Produto Virtual: ");
						leia.skip("\\R?");
						codigoAcesso = leia.nextLine();
						
						produtos.atualizar(new ProdutoVirtual(id, quantidade, descricao, preco, tipo,
								codigoAcesso));
					}
					case 2 -> {
						System.out.println("Digite o peso do Produto Físico (g): ");
						peso = leia.nextFloat();
						produtos.atualizar(
								new ProdutoFisico(id, quantidade, descricao, preco, tipo, peso));
					}
					default -> {
						System.out.println("\nTipo de produto inválido!");
					}
					}
				} else {
					System.out.println("\nO Produto não foi encontrado!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar Produto\n\n");

				System.out.println("Digite o id do Produto: ");
				id = leia.nextInt();

				produtos.deletar(id);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Realizar uma Venda\n\n");

				System.out.println("Digite o id do Produto: ");
				id = leia.nextInt();

				do {
					System.out.println("Digite a quantidade do Produto: ");
					quantidade = leia.nextInt();
				} while (quantidade <= 0);

				produtos.realizarVenda(id, quantidade);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Reposição de Estoque\n\n");

				System.out.println("Digite o id do Produto: ");
				id = leia.nextInt();
				
				do {
					System.out.println("Digite a Quantidade que será adicionada ao Estoque (un): ");
					quantidade = leia.nextInt();
				} while (quantidade <= 0);

				produtos.reporEstoque(id, quantidade);

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
