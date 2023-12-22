package ecommerce.model;

public abstract class Produto {
	
	private int id;
	private int quantidade;
	private String descricao;
	private float preco;
	private int tipo;
	
	public Produto(int id, int quantidade, String descricao, float preco, int tipo) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}	
	
	public boolean realizarVenda(int quantidade) {
		if (this.getQuantidade() < quantidade) {
			System.out.println("\nProduto sem estoque!");
			return false;
		}

		this.setQuantidade(this.getQuantidade() - quantidade);
		return true;
	}
	
	public void reporEstoque(int quantidade) {
		this.setQuantidade(this.getQuantidade() + quantidade);
	}

	public void visualizar() {
		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Produto Físico";
			break;
		case 2:
			tipo = "Produto Virtual";
			break;
		}

		System.out.println("\n\n********************************");
		System.out.println("* Dados do Produto");
		System.out.println("********************************");
		System.out.println("* Id do Produto: " + this.id);
		System.out.println("* Descrição do Produto: " + this.descricao);
		System.out.println("* Tipo: " + tipo);
		System.out.println("* Preço: " + this.preco);
		System.out.println("* Quantidade no Estoque: " + this.quantidade);

	}

}
