package MovimentoViaTecado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoverTeclado extends JFrame {
	ImageIcon imgPino, imgTabuleiro;
	JLabel lbPino;
	JBackGroundPanel jbgTabuleiro;
	JPanel pnTabuleiro;
	int posPinoX = 230, posPinoY = 75;

	public MoverTeclado() {
		// Inicializando Componentes
		imgPino = new ImageIcon(getClass().getResource("Macaco.png"));
		// imgTabuleiro = new ImageIcon(getClass().getResource("Tabulei.png"));

		try {
			jbgTabuleiro = new JBackGroundPanel("imagi/Tabulei.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		lbPino = new JLabel(imgPino);
		pnTabuleiro = new JPanel();

		editarJanela();
		editarComponentes();
		addMovimento();
	}

	public void addMovimento() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 38) {
					posPinoY -= 10;
				}
				if (e.getKeyCode() == 40) {
					posPinoY += 10;
				}
				if (e.getKeyCode() == 37) {
					posPinoX -= 10;
				}
				if (e.getKeyCode() == 39) {
					posPinoX += 10;
				}
				lbPino.setBounds(posPinoX, posPinoY, 100, 100);
			}
		});
	}

	public void editarComponentes() {
		jbgTabuleiro.setBounds(230, 70, 900, 596);
		lbPino.setBounds(posPinoX, posPinoY, 100, 100);
	}

	public void editarJanela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		setVisible(true);
		setLayout(null);

		add(lbPino);
		add(jbgTabuleiro);
	}

	public static void main(String[] args) {
		new MoverTeclado();

	}

}
