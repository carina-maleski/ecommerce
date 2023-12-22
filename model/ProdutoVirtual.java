package ecommerce.model;

public class ProdutoVirtual extends Produto {
	
	private String codigoAcesso;

	public ProdutoVirtual(int id, int quantidade, String descricao, float preco, int tipo, String codigoAcesso) {
		super(id, quantidade, descricao, preco, tipo);
		this.codigoAcesso = codigoAcesso;
	}

	public String getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Código de acesso virtual: "+ this.codigoAcesso);
	}
	
}
