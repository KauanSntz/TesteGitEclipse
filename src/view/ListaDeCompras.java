package view;

import javax.swing.JFrame;

public class ListaDeCompras extends JFrame{
	
	public ListaDeCompras() {
		super("Lista De Compras");
		setResizable(false);   //N�o pemite editar o tamanho
		setSize(200,200);
		setLocationRelativeTo(null); //posicionando ao centro da tela
		setVisible(true);
		System.out.println("Janela ativada!");
	}
	
}
