package modelo;
/**
 * Andr� Kaled Duarte - 25/09/2022
 * 
 * Classe usada para armazenar itens que estar�o
 * a venda nas lojas, contendo nome e o pre�o como
 * prioridade, que ser�o compradas pelo jogador
 * durante o jogo para preencher sua lista de
 * compras e vencer o jogo*/

public class Itens {
	private String item,descricao;
	private int preco;
	
	//construtor da classe
	public Itens(String item, String descricao, int preco) {
		this.item = item;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	//construtor sem descri��o
	public Itens(String item, int preco) {
		this.item = item;
		this.preco = preco;
	}

	//retorno o nome do item
	public String toString(){
		return item;
	}
	
	//metodo para ver o custo do item
	public int custo(){
		return preco;
	}

	//metodos de acesso
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}
}
