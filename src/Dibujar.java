import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Dibujar extends JPanel implements ActionListener{

	private Monito Mono;
	private Timer timer;


	public Dibujar() {

		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new teclado());

		Mono = new Monito();
		timer = new Timer(5, this);
		timer.start();
	}

	public void paint(Graphics grafica) {
		super.paint(grafica);
		Graphics2D g2 = (Graphics2D) grafica;
		g2.drawImage(Mono.tenerImagen(), Mono.tenerX(), Mono.tenerY(), null);
	}

	public void actionPerformed(ActionEvent e) {
		Mono.mover();
		repaint();
	}

	private class teclado extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			Mono.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			Mono.keyPressed(e);
		}
	}
}