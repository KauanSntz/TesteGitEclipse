package MovimentoViaTecado;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tabuleiro extends JFrame {

	JPanel t;
	int cont = 9;
	JPanel[] area = new JPanel[cont];
	JPanel[] c = new JPanel[cont];

	public Tabuleiro() {
		super("Tabuleiro que promete andar com o jogador");
		setSize(700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		t = new JPanel(new GridLayout(3, 3));
		t.setBackground(Color.GREEN);

		for (int i = 0; i < cont; i++) {
			area[i] = new JPanel(null);
		}

		t.add(area[0]);
		t.add(area[1]);
		t.add(area[2]);
		t.add(area[3]);
		t.add(area[4]);
		t.add(area[5]);
		t.add(area[6]);
		t.add(area[7]);
		t.add(area[8]);

		for (int i = 0; i < cont; i++) {
			c[i] = new JPanel(new FlowLayout());
			c[i].setBackground(Color.CYAN);
			c[i].setBounds(10, 10, (700 / 3) - 10, (700 / 3) - 10);
		}

		area[0].add(c[0]);
		area[1].add(c[1]);
		area[2].add(c[2]);
		area[3].add(c[7]);
		area[4].add(c[8]);
		area[5].add(c[3]);
		area[6].add(c[6]);
		area[7].add(c[5]);
		area[8].add(c[4]);

		add(t);

		setVisible(true);
	}

	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro();
		t.new Move();
	}

	public class Move extends Thread {
		public Move() {
			start();
		}

		@Override
		public void run() {
			Scanner s = new Scanner(System.in);
			JLabel pessoa = new JLabel("to aqui");

			for (int i = 0; i < 9; i++)
				c[i].add(new JLabel("" + i));
			c[0].add(pessoa);
			int posicaoAntiga = 0, posicaoNova;

			while (true) {
				System.out.print("Digita um numero para avançar casas pfvzinho:");
				int num = s.nextInt();

				do {
					try {
						sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						c[posicaoAntiga].remove(pessoa);
						
						System.out.println("Andando...");

						posicaoNova = posicaoAntiga + 1;

						if (posicaoNova == 8)
							posicaoNova = 0;

						posicaoAntiga = posicaoNova;

						c[posicaoNova].add(pessoa);
						
						repaint();
						num--;
					}
				} while (num != 0);
			}
		}
	}
}