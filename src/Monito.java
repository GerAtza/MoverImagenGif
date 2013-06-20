import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Monito {

	private String enfrente="CaminaEnfrente.gif";
	private String atras="CaminaAtras.gif";
	private String izq="CaminaIzquierda.gif";
	private String der="CaminaDerecha.gif";
	private String paradoEnfrente="11.gif";
	private String paradoAtras="01.gif";
	private String paradoIzq="21.gif";
	private String paradoDer="31.gif";
	
	private int dx;
	private int dy;
	private int x;
	private int y;
	private ImageIcon img;
	private Image imagen;
	private boolean mueve=true;
	
	public Monito() {
		x = 40;
		y = 60;
		ImageIcon img = new ImageIcon(this.getClass().getResource(paradoEnfrente));
		imagen = img.getImage();
	}

	public void mover(){
		x += dx;
		y += dy;
	}
	
	public int tenerX() {
		return x;
	}

	public int tenerY() {
		return y;
	}

	public Image tenerImagen() {
		return imagen;
	}

	public void keyPressed(KeyEvent e) {
		mueve=true;
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_LEFT && mueve) {
			dx = -1;
			img = new ImageIcon(this.getClass().getResource(izq));
			imagen = img.getImage();
		}
		if(key == KeyEvent.VK_RIGHT && mueve) {
			dx = 1;
			img = new ImageIcon(this.getClass().getResource(der));
			imagen = img.getImage();
		}
		if(key == KeyEvent.VK_UP && mueve) {
			dy = -1;
			img = new ImageIcon(this.getClass().getResource(enfrente));
			imagen = img.getImage();
		}
		if(key == KeyEvent.VK_DOWN && mueve) {
			dy = 1;
			img = new ImageIcon(this.getClass().getResource(atras));
			imagen = img.getImage();
		}
	}
	
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
			img = new ImageIcon(this.getClass().getResource(paradoIzq));
			imagen = img.getImage();
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 0;
			img = new ImageIcon(this.getClass().getResource(paradoDer));
			imagen = img.getImage();
		}
		if(key == KeyEvent.VK_UP) {
			dy = 0;
			img = new ImageIcon(this.getClass().getResource(paradoAtras));
			imagen = img.getImage();
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
			img = new ImageIcon(this.getClass().getResource(paradoEnfrente));
			imagen = img.getImage();
		}
	}
}