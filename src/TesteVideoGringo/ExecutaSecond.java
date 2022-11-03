package TesteVideoGringo;

import javax.swing.JFrame;

public class ExecutaSecond extends JFrame{
	Second s;
	
	public ExecutaSecond() {
		super("Moving");
		s = new Second();
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(s);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ExecutaSecond();
	}

}
