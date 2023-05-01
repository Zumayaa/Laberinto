import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public int super_x = 2;
	public int super_y = 2;
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
		
		JLabel timer = new JLabel ("00:00:00");
		panel.add(timer);
		Cronometro.iniciar(timer);
		
		
		JPanel juego = new JPanel();
		juego.setBackground(Color.black);
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
				if((e.getKeyCode() == 83 || e.getKeyCode() == 40) && super_y <430) {
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
			
			g.setColor(Color.gray);
	        g.drawRect(0, 0, 499, 440);
			
			Rect player = new Rect(super_x,super_y,10,10, Color.red);
			g.setColor(player.c);
			g.fillRect(player.x, player.y, player.w, player.h);
			
			//					  x   y w  h
			Rect pared = new Rect(13, 0,3,50,Color.decode("#00ffff"));
			g.setColor(pared.c);
			g.fillRect(pared.x, pared.y, pared.w, pared.h);
			
			Rect pared2 = new Rect(13, 50,20,3,Color.decode("#00ffff"));
			g.setColor(pared2.c);
			g.fillRect(pared2.x, pared2.y, pared2.w, pared2.h);
			
			Rect pared3 = new Rect(30, 30,3,60,Color.decode("#00ffff"));
			g.setColor(pared3.c);
			g.fillRect(pared3.x, pared3.y, pared3.w, pared3.h);
			
			Rect pared4 = new Rect(30, 90,20,3,Color.decode("#00ffff"));
			g.setColor(pared4.c);
			g.fillRect(pared4.x, pared4.y, pared4.w, pared4.h);
			
			Rect pared5 = new Rect(30, 130,20,3,Color.decode("#00ffff"));
			g.setColor(pared5.c);
			g.fillRect(pared5.x, pared5.y, pared5.w, pared5.h);
			
			Rect pared6 = new Rect(50, 90,3,300,Color.decode("#00ffff"));
			g.setColor(pared6.c);
			g.fillRect(pared6.x, pared6.y, pared6.w, pared6.h);
			
			Rect pared7 = new Rect(20, 160,3,260,Color.decode("#00ffff"));
			g.setColor(pared7.c);
			g.fillRect(pared7.x, pared7.y, pared7.w, pared7.h);
			
			Rect pared8 = new Rect(20, 420,90,3,Color.decode("#00ffff"));
			g.setColor(pared8.c);
			g.fillRect(pared8.x, pared8.y, pared8.w, pared8.h);
			
			Rect pared9 = new Rect(110, 420,3,20,Color.decode("#00ffff"));
			g.setColor(pared9.c);
			g.fillRect(pared9.x, pared9.y, pared9.w, pared9.h);
			
			Rect pared10 = new Rect(50, 390,60,3,Color.decode("#00ffff"));
			g.setColor(pared10.c);
			g.fillRect(pared10.x, pared10.y, pared10.w, pared10.h);
			
			Rect pared11 = new Rect(110, 363,3,30,Color.decode("#00ffff"));
			g.setColor(pared11.c);
			g.fillRect(pared11.x, pared11.y, pared11.w, pared11.h);
			
			Rect pared12 = new Rect(80, 220, 3, 150, Color.decode("#00ffff"));
			g.setColor(pared12.c);
			g.fillRect(pared12.x, pared12.y, pared12.w, pared12.h);
			
			Rect pared13 = new Rect(80, 220, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared13.c);
			g.fillRect(pared13.x, pared13.y, pared13.w, pared13.h);
			
			Rect pared14 = new Rect(110, 150, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared14.c);
			g.fillRect(pared14.x, pared14.y, pared14.w, pared14.h);
			
			Rect pared15 = new Rect(80, 70, 3, 130, Color.decode("#00ffff"));
			g.setColor(pared15.c);
			g.fillRect(pared15.x, pared15.y, pared15.w, pared15.h);
			
			Rect pared16 = new Rect(50, 70,60,3, Color.decode("#00ffff"));
			g.setColor(pared16.c);
			g.fillRect(pared16.x, pared16.y, pared16.w, pared16.h);
			
			Rect pared17 = new Rect(50, 70,60,3, Color.decode("#00ffff"));
			g.setColor(pared17.c);
			g.fillRect(pared17.x, pared17.y, pared17.w, pared17.h);
			
			Rect pared18 = new Rect(110, 180, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared18.c);
			g.fillRect(pared18.x, pared18.y, pared18.w, pared18.h);
			
			Rect pared19 = new Rect(110, 280, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared19.c);
			g.fillRect(pared19.x, pared19.y, pared19.w, pared19.h);
			
			Rect pared20 = new Rect(140, 220, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared20.c);
			g.fillRect(pared20.x, pared20.y, pared20.w, pared20.h);
			
			Rect pared21 = new Rect(140, 150, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared21.c);
			g.fillRect(pared21.x, pared21.y, pared21.w, pared21.h);
			
			Rect pared22 = new Rect(140, 280, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared22.c);
			g.fillRect(pared22.x, pared22.y, pared22.w, pared22.h);
			
			Rect pared23 = new Rect(170, 150, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared23.c);
			g.fillRect(pared23.x, pared23.y, pared23.w, pared23.h);
			
			Rect pared24 = new Rect(170, 350, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared24.c);
			g.fillRect(pared24.x, pared24.y, pared24.w, pared24.h);
			
			Rect pared25 = new Rect(200, 150, 3, 130, Color.decode("#00ffff"));
			g.setColor(pared25.c);
			g.fillRect(pared25.x, pared25.y, pared25.w, pared25.h);
			
			Rect pared26 = new Rect(200, 350, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared26.c);
			g.fillRect(pared26.x, pared26.y, pared26.w, pared26.h);
			
			Rect pared27 = new Rect(230, 283, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared27.c);
			g.fillRect(pared27.x, pared27.y, pared27.w, pared27.h);
			
			Rect pared28 = new Rect(230, 150, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared28.c);
			g.fillRect(pared28.x, pared28.y, pared28.w, pared28.h);
			
			Rect pared29 = new Rect(260, 220, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared29.c);
			g.fillRect(pared29.x, pared29.y, pared29.w, pared29.h);
			
			Rect pared30 = new Rect(260, 150, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared30.c);
			g.fillRect(pared30.x, pared30.y, pared30.w, pared30.h);
			
			Rect pared31 = new Rect(260, 280, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared31.c);
			g.fillRect(pared31.x, pared31.y, pared31.w, pared31.h);
			
			Rect pared32 = new Rect(290, 150, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared32.c);
			g.fillRect(pared32.x, pared32.y, pared32.w, pared32.h);
			
			Rect pared33 = new Rect(320, 70, 3, 203, Color.decode("#00ffff"));
			g.setColor(pared33.c);
			g.fillRect(pared33.x, pared33.y, pared33.w, pared33.h);
			
			Rect pared34 = new Rect(260, 280, 3, 70, Color.decode("#00ffff"));
			g.setColor(pared34.c);
			g.fillRect(pared34.x, pared34.y, pared34.w, pared34.h);
			
			Rect pared35 = new Rect(220, 390, 80, 3, Color.decode("#00ffff"));
			g.setColor(pared35.c);
			g.fillRect(pared35.x, pared35.y, pared35.w, pared35.h);
			
			Rect pared36 = new Rect(220, 420, 80, 3, Color.decode("#00ffff"));
			g.setColor(pared36.c);
			g.fillRect(pared36.x, pared36.y, pared36.w, pared36.h);
			
			Rect pared37 = new Rect(300, 300, 3, 120, Color.decode("#00ffff"));
			g.setColor(pared37.c);
			g.fillRect(pared37.x, pared37.y, pared37.w, pared37.h);
			
			Rect pared38 = new Rect(330, 300, 3, 120, Color.decode("#00ffff"));
			g.setColor(pared38.c);
			g.fillRect(pared38.x, pared38.y, pared38.w, pared38.h);
			
			Rect pared39 = new Rect(360, 300, 3, 120, Color.decode("#00ffff"));
			g.setColor(pared39.c);
			g.fillRect(pared39.x, pared39.y, pared39.w, pared39.h);
	
			
			System.out.println(player.colision(pared));
			
			if(player.colision(pared)) {
				super_x -= 2;
			}
			
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



