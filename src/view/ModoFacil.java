package view;

/**Andre Kaled Duarte - 30/09/2022
 * Sarah Pinheiro Antunes - 29/09/2022
 * Graziela da Costa Ralph - 16/10/2022
 * Sarah Pinheiro Antunes - 17/10/2022
 * Graziela da Costa Ralph - 17/10/2022
 * Graziela da Costa Ralph - 23/10/2022
 * 
 * Modo facil
 * essa classe deve ser um dos modos de jogo escolhido pelo usuï¿½rio, as configurï¿½ï¿½es do jogo sï¿½o
 * definidas para iniciantes porï¿½m a interface continua a mesma, aqui ï¿½ onde serï¿½ a area principal do jogo pois
 * ï¿½ onde os jogadores passarï¿½o mais tempo.
 * 
 * Dado? ok
 * Vez do jogador a mostra? ok
 * Tabuleiro? X
 * Conectado posiï¿½ï¿½o do personagem? X
 * Lista de compras do Jogador? X
 * */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Dado;

public class ModoFacil extends JPanel {

	private JPanel areaDado, painelVez;
	private JButton btRolar, btVoltar, btLista, btMenu;
	private JLabel resultado, areaVez, moeda, quantMoeda, personagem, nome, lbDado, lbPino;
	private int rolaDado = 0, dadoAntigo = 0, posPinoX = 100, posPinoY = 20;
	JBackgroundPanel jbgTabuleiro;

	ImageIcon imgFundo = new ImageIcon("Imagens/area-jogador-da-vez.png"),
			imgLista = new ImageIcon("Imagens/imagens/botao lista.png"),
			imgMoeda = new ImageIcon("Imagens/moeda-java.png"), imgPersonagem = new ImageIcon("Imagens/personagem.png"),
			imgNome = new ImageIcon("Imagens/nome.png"), imgMenu = new ImageIcon("Imagens/botao-menu.png"),
			imgVoltar = new ImageIcon("Imagens/botao voltar.png"),
			imgRolar = new ImageIcon("Imagens/botao-rola-dado.png"),
			imgPino = new ImageIcon(getClass().getResource("PinoAzul.png"));
	ImageIcon DadoIcon;

	private String imgDado[] = { "1", "2", "3", "4", "5", "6" };

	public ModoFacil() {
		setLayout(null);
		setBackground(new Color(200, 133, 238));
		setName("MODO FACIL");
		areaDado = new JPanel();
		btRolar = new JButton(imgRolar);
		btVoltar = new JButton(imgVoltar);
		resultado = new JLabel(imgDado[0]);
		btMenu = new JButton(imgMenu);

		DadoIcon = new ImageIcon(imgDado[0] + ".png"); // acessa as imagens
		lbDado = new JLabel(DadoIcon);

		configmovimento();
		configuraDado();
		configuraBtVoltar();
		configuraVez();
		configuraBtMenu();
		addMovimento();
	}

	// arrumando movimento
	private void configmovimento() {
		lbPino = new JLabel(imgPino);

		try {
			jbgTabuleiro = new JBackgroundPanel("imagens/tabuleiro.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		jbgTabuleiro.setBounds(300, 40, 800, 500);
		lbPino.setBounds(posPinoX, posPinoY, 100, 100);

		add(jbgTabuleiro);
		add(lbPino);
	}

	public void addMovimento() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("tecla: " + e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("tecla: " + e.getKeyCode());

				/*
				 * if (e.getKeyCode() == 38) { posPinoY -= 10; } if
				 * (e.getKeyCode() == 40) { posPinoY += 10; } if (e.getKeyCode()
				 * == 37) { posPinoX -= 10; } if (e.getKeyCode() == 39) {
				 * posPinoX += 10; } lbPino.setBounds(posPinoX, posPinoY, 100,
				 * 100);
				 */
				repaint();
			}
		});
	}

	// configurando a aba de ver a vez do jogador
	private void configuraVez() {
		painelVez = new JPanel();
		painelVez.setLayout(null);
		painelVez.setBounds(508, 550, 350, 200);
		add(painelVez);
		painelVez.setOpaque(false);

		areaVez = new JLabel(imgFundo);
		// areaVez.setOpaque(true);
		areaVez.setBounds(painelVez.getBounds());

		btLista = new JButton(imgLista);
		// btLista.setBorderPainted(false);
		// btLista.setFocusable(false);
		// btLista.setContentAreaFilled(false);
		btLista.setBounds(100, 40, 62, 62);

		moeda = new JLabel(imgMoeda);
		moeda.setBounds(150, 40, 70, 70);

		personagem = new JLabel(imgPersonagem);
		personagem.setBounds(7, 10, 100, 100);

		nome = new JLabel(imgNome);
		nome.setBounds(110, -70, 200, 200);

		quantMoeda = new JLabel("XXX,XX");
		int x = moeda.getX();
		int y = moeda.getY();
		int w = moeda.getWidth();
		int h = moeda.getHeight();
		quantMoeda.setBounds(x + 60, y + 20, w, h - 50);
		// quantMoeda.setFont(font);

		add(areaVez);
		painelVez.add(btLista);
		painelVez.add(moeda);
		painelVez.add(quantMoeda);
		painelVez.add(personagem);
		painelVez.add(nome);
		eventoBtLista();
	}

	// configurando area do Dado
	private void configuraDado() {

		// config para o painel
		areaDado.setLayout(null);
		areaDado.setOpaque(false);

		// adicionando os componentes
		areaDado.add(btRolar);
		areaDado.add(lbDado);
		add(areaDado);

		// posicionamento e tamanho
		btRolar.setBounds(30, 200, 150, 150);
		lbDado.setBounds(-100, -70, 400, 500);
		areaDado.setBounds(1100, 400, 200, 400);

		// configuraçao da area do botao rolar dado
		btRolar.setContentAreaFilled(false);
		btRolar.setBorderPainted(false);

		btRolar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = Dado.rolar();

				DadoIcon = new ImageIcon("Imagens/Dado-" + imgDado[i - 1] + ".png"); // acessa
																						// o
																						// nome
																						// da
																						// imagem
				lbDado.setIcon(DadoIcon);

			}

		});
	}

	// configurando botao de voltar
	private void configuraBtVoltar() {
		btVoltar.setBounds(10, 10, 70, 70);
		btVoltar.setContentAreaFilled(false);
		btVoltar.setBorderPainted(false);
		add(btVoltar);
		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Menu.voltaTela();

			}

		});
	}

	private void configuraBtMenu() {
		btMenu.setBounds(1220, 30, 100, 105);
		btMenu.setBorderPainted(false);
		btMenu.setFocusable(false);
		btMenu.setContentAreaFilled(false);
		add(btMenu);
		btMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	private void eventoBtLista() {
		btLista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListaDeCompras l = new ListaDeCompras();
			}

		});
	}
}