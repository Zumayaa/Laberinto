import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Color;

public class Ventana extends JFrame {
	public int super_x = 20;
	public int super_y = 10;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Reiniciar");
		panel.add(btnNewButton);
		
		JPanel juego = new JPanel();
		juego.setBackground(new Color(245, 222, 179));
		contentPane.add(juego, BorderLayout.CENTER);
		juego.add(new MyGraphics());
		juego.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyCode());
				
				if((e.getKeyCode() == 87 || e.getKeyCode() == 38) && super_y>0) {
					super_y -= 2;
				}
				if((e.getKeyCode() == 83 || e.getKeyCode() == 40) && super_y <420) {
					super_y += 2;
				}
				if((e.getKeyCode() == 65 || e.getKeyCode() == 37) && super_x > 0) {
					super_x -= 2;
				}
				if((e.getKeyCode() == 68 || e.getKeyCode() == 39) && super_x < 490) {
					super_x += 2;
				}
				juego.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		juego.setFocusable(true);
		juego.requestFocus();
	}
	
	public class MyGraphics extends JComponent{
		private static final long serialVersionUID = 1L;
		
		MyGraphics(){
			setPreferredSize(new Dimension(500,500));
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			Rect player = new Rect(super_x,super_y,10,10, new Color(0,0,0));
			g.setColor(player.c);
			g.fillRect(player.x, player.y, player.w, player.h);
			
			Rect pared = new Rect(300, 60,40,200,Color.decode("#A1FF94"));
			g.setColor(pared.c);
			g.fillRect(pared.x, pared.y, pared.w, pared.h);
			
			System.out.println(player.colision(pared));
			
			
		}
	}
	
	public class Rect{
		int x = 0;
		int y = 0;
		int w = 0;
		int h = 0;
		Color c = Color.black;
		
		Rect(int x, int y, int w, int h, Color c){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.c = c;
		}
		
		public Boolean colision(Rect target) {
			if(this.x < target.x + target.w && 
					this.x + this.w > target.x &&
					this.y < target.y + target.h &&
					this.y + this.h > target.y) {
				return true;
			}
			return false;
		}
	}
}



