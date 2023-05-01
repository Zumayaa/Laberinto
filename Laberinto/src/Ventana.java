import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.management.timer.Timer;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Color;

public class Ventana extends JFrame {
	public int super_x = 2;
	public int super_y = 2;
	private JLabel timer;
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
		
		timer = new JLabel ("00:00:00");
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
		
		JButton reinicio = new JButton("Reiniciar");
		panel.add(reinicio);
		
		reinicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cronometro.reiniciar(timer);
				Cronometro.iniciar(timer);
				
				super_x = 2;
				super_y = 2;
				
				repaint();
				revalidate();
				juego.setFocusable(true);
				juego.requestFocus();
			}
			
		});
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
			
			Rect pared37 = new Rect(300, 300, 3, 140, Color.decode("#00ffff"));
			g.setColor(pared37.c);
			g.fillRect(pared37.x, pared37.y, pared37.w, pared37.h);
			
			Rect pared38 = new Rect(330, 300, 3, 120, Color.decode("#00ffff"));
			g.setColor(pared38.c);
			g.fillRect(pared38.x, pared38.y, pared38.w, pared38.h);
			
			Rect pared39 = new Rect(360, 300, 3, 120, Color.decode("#00ffff"));
			g.setColor(pared39.c);
			g.fillRect(pared39.x, pared39.y, pared39.w, pared39.h);
	
			Rect pared40 = new Rect(110, 320, 90, 3, Color.decode("#00ffff"));
			g.setColor(pared40.c);
			g.fillRect(pared40.x, pared40.y, pared40.w, pared40.h);
			
			Rect pared41 = new Rect(110, 390, 63, 3, Color.decode("#00ffff"));
			g.setColor(pared41.c);
			g.fillRect(pared41.x, pared41.y, pared41.w, pared41.h);
			
			Rect pared42 = new Rect(200, 280, 3, 100, Color.decode("#00ffff"));
			g.setColor(pared42.c);
			g.fillRect(pared42.x, pared42.y, pared42.w, pared42.h);
			
			Rect pared43 = new Rect(260, 290, 3, 80, Color.decode("#00ffff"));
			g.setColor(pared43.c);
			g.fillRect(pared43.x, pared43.y, pared43.w, pared43.h);
			
			Rect pared44 = new Rect(200, 370, 63, 3, Color.decode("#00ffff"));
			g.setColor(pared44.c);
			g.fillRect(pared44.x, pared44.y, pared44.w, pared44.h);
			
			Rect pared45 = new Rect(230, 290, 3, 30, Color.decode("#00ffff"));
			g.setColor(pared45.c);
			g.fillRect(pared45.x, pared45.y, pared45.w, pared45.h);
			
			Rect pared46 = new Rect(203, 280, 30, 3, Color.decode("#00ffff"));
			g.setColor(pared46.c);
			g.fillRect(pared46.x, pared46.y, pared46.w, pared46.h);
			
			Rect pared47 = new Rect(170, 220, 3, 80, Color.decode("#00ffff"));
			g.setColor(pared47.c);
			g.fillRect(pared47.x, pared47.y, pared47.w, pared47.h);
			
			Rect pared48 = new Rect(200, 220, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared48.c);
			g.fillRect(pared48.x, pared48.y, pared48.w, pared48.h);
			
			Rect pared49 = new Rect(320, 220, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared49.c);
			g.fillRect(pared49.x, pared49.y, pared49.w, pared49.h);
			
			Rect pared50 = new Rect(330, 300, 60, 3, Color.decode("#00ffff"));
			g.setColor(pared50.c);
			g.fillRect(pared50.x, pared50.y, pared50.w, pared50.h);
			
			Rect pared51 = new Rect(320, 270, 180, 3, Color.decode("#00ffff"));
			g.setColor(pared51.c);
			g.fillRect(pared51.x, pared51.y, pared51.w, pared51.h);
			
			Rect pared52 = new Rect(390, 330, 110, 3, Color.decode("#00ffff"));
			g.setColor(pared52.c);
			g.fillRect(pared52.x, pared52.y, pared52.w, pared52.h);
			
			Rect pared53 = new Rect(360, 360, 110, 3, Color.decode("#00ffff"));
			g.setColor(pared53.c);
			g.fillRect(pared53.x, pared53.y, pared53.w, pared53.h);
			
			Rect pared54 = new Rect(450, 290, 3, 40, Color.decode("#00ffff"));
			g.setColor(pared54.c);
			g.fillRect(pared54.x, pared54.y, pared54.w, pared54.h);
			
			Rect pared55 = new Rect(420, 290, 3, 40, Color.decode("#00ffff"));
			g.setColor(pared55.c);
			g.fillRect(pared55.x, pared55.y, pared55.w, pared55.h);
			
			Rect pared56 = new Rect(480, 270, 3, 40, Color.decode("#00ffff"));
			g.setColor(pared56.c);
			g.fillRect(pared56.x, pared56.y, pared56.w, pared56.h);
			
			Rect pared57 = new Rect(360, 390, 110, 3, Color.decode("#00ffff"));
			g.setColor(pared57.c);
			g.fillRect(pared57.x, pared57.y, pared57.w, pared57.h);
			
			Rect pared58 = new Rect(390, 410, 110, 3, Color.decode("#00ffff"));
			g.setColor(pared58.c);
			g.fillRect(pared58.x, pared58.y, pared58.w, pared58.h);
			
			Rect pared59 = new Rect(260, 220, 3, 40, Color.decode("#00ffff"));
			g.setColor(pared59.c);
			g.fillRect(pared59.x, pared59.y, pared59.w, pared59.h);
			
			Rect pared60 = new Rect(290, 220, 3, 60, Color.decode("#00ffff"));
			g.setColor(pared60.c);
			g.fillRect(pared60.x, pared60.y, pared60.w, pared60.h);
			
			Rect pared61 = new Rect(200, 250, 30, 3, Color.decode("#00ffff"));
			g.setColor(pared61.c);
			g.fillRect(pared61.x, pared61.y, pared61.w, pared61.h);
			
			Rect pared62 = new Rect(140, 190, 30, 3, Color.decode("#00ffff"));
			g.setColor(pared62.c);
			g.fillRect(pared62.x, pared62.y, pared62.w, pared62.h);
			
			Rect pared63 = new Rect(80, 0, 3, 50, Color.decode("#00ffff"));
			g.setColor(pared63.c);
			g.fillRect(pared63.x, pared63.y, pared63.w, pared63.h);
			
			Rect pared64 = new Rect(50, 0, 3, 30, Color.decode("#00ffff"));
			g.setColor(pared64.c);
			g.fillRect(pared64.x, pared64.y, pared64.w, pared64.h);
			
			Rect pared65 = new Rect(180, 0, 3, 130, Color.decode("#00ffff"));
			g.setColor(pared65.c);
			g.fillRect(pared65.x, pared65.y, pared65.w, pared65.h);
			
			Rect pared66 = new Rect(140, 0, 3, 130, Color.decode("#00ffff"));
			g.setColor(pared66.c);
			g.fillRect(pared66.x, pared66.y, pared66.w, pared66.h);
			
			Rect pared67 = new Rect(110, 0, 3, 130, Color.decode("#00ffff"));
			g.setColor(pared67.c);
			g.fillRect(pared67.x, pared67.y, pared67.w, pared67.h);
			
			Rect pared68 = new Rect(330, 15, 180, 03, Color.decode("#00ffff"));
			g.setColor(pared68.c);
			g.fillRect(pared68.x, pared68.y, pared68.w, pared68.h);
			
			Rect pared69 = new Rect(330, 40, 180, 03, Color.decode("#00ffff"));
			g.setColor(pared69.c);
			g.fillRect(pared69.x, pared69.y, pared69.w, pared69.h);
			
			Rect pared70 = new Rect(350, 60, 170, 03, Color.decode("#00ffff"));
			g.setColor(pared70.c);
			g.fillRect(pared70.x, pared70.y, pared70.w, pared70.h);
			
			Rect pared71 = new Rect(320, 80, 150, 03, Color.decode("#00ffff"));
			g.setColor(pared71.c);
			g.fillRect(pared71.x, pared71.y, pared71.w, pared71.h);
			
			Rect pared72 = new Rect(350, 105, 150, 03, Color.decode("#00ffff"));
			g.setColor(pared72.c);
			g.fillRect(pared72.x, pared72.y, pared72.w, pared72.h);
			
			Rect pared73 = new Rect(200, 130, 120, 03, Color.decode("#00ffff"));
			g.setColor(pared73.c);
			g.fillRect(pared73.x, pared73.y, pared73.w, pared73.h);
			
			Rect pared74 = new Rect(200, 100, 120, 03, Color.decode("#00ffff"));
			g.setColor(pared74.c);
			g.fillRect(pared74.x, pared74.y, pared74.w, pared74.h);
			
			Rect pared75 = new Rect(160, 100, 20, 03, Color.decode("#00ffff"));
			g.setColor(pared75.c);
			g.fillRect(pared75.x, pared75.y, pared75.w, pared75.h);
			
			Rect pared76 = new Rect(160, 70, 20, 03, Color.decode("#00ffff"));
			g.setColor(pared76.c);
			g.fillRect(pared76.x, pared76.y, pared76.w, pared76.h);
			
			Rect pared77 = new Rect(160, 35, 20, 03, Color.decode("#00ffff"));
			g.setColor(pared77.c);
			g.fillRect(pared77.x, pared77.y, pared77.w, pared77.h);
			
			Rect pared78 = new Rect(180, 70, 80, 03, Color.decode("#00ffff"));
			g.setColor(pared78.c);
			g.fillRect(pared78.x, pared78.y, pared78.w, pared78.h);
			
			Rect pared79 = new Rect(200, 20, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared79.c);
			g.fillRect(pared79.x, pared79.y, pared79.w, pared79.h);
			
			Rect pared80 = new Rect(220, 0, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared80.c);
			g.fillRect(pared80.x, pared80.y, pared80.w, pared80.h);
			
			Rect pared81 = new Rect(240, 20, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared81.c);
			g.fillRect(pared81.x, pared81.y, pared81.w, pared81.h);
			
			Rect pared82 = new Rect(260, 0, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared82.c);
			g.fillRect(pared82.x, pared82.y, pared82.w, pared82.h);
			
			Rect pared83 = new Rect(280, 0, 03, 80, Color.decode("#00ffff"));
			g.setColor(pared83.c);
			g.fillRect(pared83.x, pared83.y, pared83.w, pared83.h);
			
			Rect pared84 = new Rect(300, 70, 20, 3, Color.decode("#00ffff"));
			g.setColor(pared84.c);
			g.fillRect(pared84.x, pared84.y, pared84.w, pared84.h);
			
			Rect pared85 = new Rect(310, 0, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared85.c);
			g.fillRect(pared85.x, pared85.y, pared85.w, pared85.h);
			
			Rect pared86 = new Rect(350, 105, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared86.c);
			g.fillRect(pared86.x, pared86.y, pared86.w, pared86.h);
			
			Rect pared87 = new Rect(350, 155, 120, 03, Color.decode("#00ffff"));
			g.setColor(pared87.c);
			g.fillRect(pared87.x, pared87.y, pared87.w, pared87.h);
			
			Rect pared88 = new Rect(350, 200, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared88.c);
			g.fillRect(pared88.x, pared88.y, pared88.w, pared88.h);
			
			Rect pared89 = new Rect(370, 200, 03, 50, Color.decode("#00ffff"));
			g.setColor(pared89.c);
			g.fillRect(pared89.x, pared89.y, pared89.w, pared89.h);
			
			Rect pared90 = new Rect(380, 180, 120, 03, Color.decode("#00ffff"));
			g.setColor(pared90.c);
			g.fillRect(pared90.x, pared90.y, pared90.w, pared90.h);
			
			Rect pared91 = new Rect(400, 220, 100, 03, Color.decode("#00ffff"));
			g.setColor(pared91.c);
			g.fillRect(pared91.x, pared91.y, pared91.w, pared91.h);
			
			Rect pared92 = new Rect(420, 195, 03, 60, Color.decode("#00ffff"));
			g.setColor(pared92.c);
			g.fillRect(pared92.x, pared92.y, pared92.w, pared92.h);
			
			Rect pared93 = new Rect(440, 195, 03, 60, Color.decode("#00ffff"));
			g.setColor(pared93.c);
			g.fillRect(pared93.x, pared93.y, pared93.w, pared93.h);
			
			Rect pared94 = new Rect(455, 195, 03, 60, Color.decode("#00ffff"));
			g.setColor(pared94.c);
			g.fillRect(pared94.x, pared94.y, pared94.w, pared94.h);
			
			Rect pared95 = new Rect(473, 195, 03, 60, Color.decode("#00ffff"));
			g.setColor(pared95.c);
			g.fillRect(pared95.x, pared95.y, pared95.w, pared95.h);
			
			Rect pared96 = new Rect(490, 195, 03, 60, Color.decode("#00ffff"));
			g.setColor(pared96.c);
			g.fillRect(pared96.x, pared96.y, pared96.w, pared96.h);
			
			Rect pared97 = new Rect(390, 240, 03, 30, Color.decode("#00ffff"));
			g.setColor(pared97.c);
			g.fillRect(pared97.x, pared97.y, pared97.w, pared97.h);
			
			Rect pared98 = new Rect(370, 105, 03, 30, Color.decode("#00ffff"));
			g.setColor(pared98.c);
			g.fillRect(pared98.x, pared98.y, pared98.w, pared98.h);
			
			Rect pared99 = new Rect(390, 125, 03, 30, Color.decode("#00ffff"));
			g.setColor(pared99.c);
			g.fillRect(pared99.x, pared99.y, pared99.w, pared99.h);
			
			Rect pared100 = new Rect(410, 125, 03, 30, Color.decode("#00ffff"));
			g.setColor(pared100.c);
			g.fillRect(pared100.x, pared100.y, pared100.w, pared100.h);
			
			Rect pared101 = new Rect(430, 105, 03, 30, Color.decode("#00ffff"));
			g.setColor(pared101.c);
			g.fillRect(pared101.x, pared101.y, pared101.w, pared101.h);
			
			Rect pared102 = new Rect(450, 105, 03, 30, Color.decode("#00ffff"));
			g.setColor(pared102.c);
			g.fillRect(pared102.x, pared102.y, pared102.w, pared102.h);
			
			Rect pared103 = new Rect(467, 125, 03, 30, Color.decode("#00ffff"));
			g.setColor(pared103.c);
			g.fillRect(pared103.x, pared103.y, pared103.w, pared103.h);
			
			Rect pared104 = new Rect(330, 32, 03, 20, Color.decode("#00ffff"));
			g.setColor(pared104.c);
			g.fillRect(pared104.x, pared104.y, pared104.w, pared104.h);
			
			Rect pared105 = new Rect(350, 32, 03, 20, Color.decode("#00ffff"));
			g.setColor(pared105.c);
			g.fillRect(pared105.x, pared105.y, pared105.w, pared105.h);
			
			Rect pared106 = new Rect(380, 32, 03, 20, Color.decode("#00ffff"));
			g.setColor(pared106.c);
			g.fillRect(pared106.x, pared106.y, pared106.w, pared106.h);
			
			Rect pared107 = new Rect(420, 32, 03, 20, Color.decode("#00ffff"));
			g.setColor(pared107.c);
			g.fillRect(pared107.x, pared107.y, pared107.w, pared107.h);
			
			Rect pared108 = new Rect(200, 400, 03, 20, Color.decode("#00ffff"));
			g.setColor(pared108.c);
			g.fillRect(pared108.x, pared108.y, pared108.w, pared108.h);
			
			Rect pared109 = new Rect(170, 390, 03, 20, Color.decode("#00ffff"));
			g.setColor(pared109.c);
			g.fillRect(pared109.x, pared109.y, pared109.w, pared109.h);
			
			Rect pared110 = new Rect(140, 370, 03, 40, Color.decode("#00ffff"));
			g.setColor(pared110.c);
			g.fillRect(pared110.x, pared110.y, pared110.w, pared110.h);
			
			Rect pared111 = new Rect(160, 370, 03, 20, Color.decode("#00ffff"));
			g.setColor(pared111.c);
			g.fillRect(pared111.x, pared111.y, pared111.w, pared111.h);
			
			Rect pared112 = new Rect(155, 425, 03, 15, Color.decode("#00ffff"));
			g.setColor(pared112.c);
			g.fillRect(pared112.x, pared112.y, pared112.w, pared112.h);
			
			Rect pared113 = new Rect(20, 355, 15, 03, Color.decode("#00ffff"));
			g.setColor(pared113.c);
			g.fillRect(pared113.x, pared113.y, pared113.w, pared113.h);
			
			Rect pared114 = new Rect(20, 270, 15, 03, Color.decode("#00ffff"));
			g.setColor(pared114.c);
			g.fillRect(pared114.x, pared114.y, pared114.w, pared114.h);
			
			Rect pared115 = new Rect(40, 220, 10, 03, Color.decode("#00ffff"));
			g.setColor(pared115.c);
			g.fillRect(pared115.x, pared115.y, pared115.w, pared115.h);
			
			Rect pared116 = new Rect(40, 190, 10, 03, Color.decode("#00ffff"));
			g.setColor(pared116.c);
			g.fillRect(pared116.x, pared116.y, pared116.w, pared116.h);
			
			//#FF0000
			Rect ganar = new Rect(490, 0, 10, 10, Color.decode("#23c423"));
			g.setColor(ganar.c);
			g.fillRect(ganar.x, ganar.y, ganar.w, ganar.h);
			
			if(player.colision(ganar)) {
				super_x = 2;
				super_y = 2;
				
				String tiempo = "";
				tiempo = timer.getText();
				
				
				JOptionPane.showMessageDialog(null, "Tu tiempo fue: " + tiempo,"FELICIDADES!",JOptionPane.INFORMATION_MESSAGE);
				
				Cronometro.reiniciar(timer);
				Cronometro.iniciar(timer);
				
				repaint();
				revalidate();
				
			}
			
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



