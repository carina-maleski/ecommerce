package ecommerce.controller;

import java.util.ArrayList;
import ecommerce.model.Produto;
import ecommerce.repository.EcommerceRepository;

public class EcommerceController implements EcommerceRepository {

	private ArrayList<Produto> listaProduto = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\nO produto número: " + id + " não foi encontrado!");
	}

	@Override
	public void listarTodos() {
		for (var produto : listaProduto) {
			produto.visualizar();
		}

	}

	@Override
	public void cadastrar(Produto produto) {
		listaProduto.add(produto);
		System.out.println("\nO produto número: " + produto.getId() + " foi criado com sucesso!");

	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto != null) {
			listaProduto.set(listaProduto.indexOf(buscaProduto), produto);
			System.out.println("\nO produto número: " + produto.getId() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO produto número: " + produto.getId() + " não foi encontrado!");
		}
	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			if (listaProduto.remove(produto) == true)
				System.out.println("\nO produto número: " + id + " foi deletado com sucesso!");
		} else
			System.out.println("\nO produto número: " + id + " não foi encontrado!");
	}

	@Override
	public void realizarVenda(int id, int quantidade) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			if (produto.realizarVenda(quantidade) == true)
				System.out.println("\nA venda de " + quantidade + " unidades do Produto " + produto.getDescricao()
						+ " (id " + produto.getId() + ") foi efetuada com sucesso! Valor final: "+(produto.getPreco()*quantidade));
		} else
			System.out.println("\nO produto número: " + id + " não foi encontrado!");
	}

	@Override
	public void reporEstoque(int id, int quantidade) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			produto.reporEstoque(quantidade);
			System.out.println("\nA reposição de " + quantidade + " unidades do Produto " + produto.getDescricao() + " (id "
					+ produto.getId() + ") foi efetuada com sucesso no estoque!");
		} else
			System.out.println("\nO produto número: " + id + " não foi encontrado!");

	}

	public int gerarId() {
		return ++id;
	}

	public Produto buscarNaCollection(int id) {
		for (var produto : listaProduto) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
}
