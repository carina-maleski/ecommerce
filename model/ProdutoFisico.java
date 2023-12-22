package ecommerce.model;

public class ProdutoFisico extends Produto {

	private float peso;

	public ProdutoFisico(int id, int quantidade, String descricao, float preco, int tipo, float peso) {
		super(id, quantidade, descricao, preco, tipo);
		this.peso = peso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Peso do Produto: " + this.peso);
	}

}
