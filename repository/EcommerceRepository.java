package ecommerce.repository;

import ecommerce.model.Produto;

public interface EcommerceRepository {
	
		//CRUD do Produto
		public void procurarPorId(int id);
		public void listarTodas();
		public void cadastrar(Produto produto);
		public void atualizar(Produto produto);
		public void deletar(int id);
		
		//Métodos 
		public void realizarVenda(int id, int quantidade);
		public void reporEstoque(int id, int quantidade);		
}
