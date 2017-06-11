package dev.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.invoke.LambdaConversionException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Bullet extends JPanel{
	GUI gui;
	
	Date date;
	JLabel labTime;
	JLabel labName;
	JLabel labFile;
	JLabel labEvent;
	String note;

	JPanel panTime = new JPanel();
	JPanel panName = new JPanel();
	JPanel panFile = new JPanel();
	JPanel panEvent = new JPanel();
	JPanel panNote = new JPanel();
	
	public Bullet(GUI gui, Date date, String name, String file, Icon img, String note){
		
		this.gui = gui;
		this.note = note;
		
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		String time = df.format(date).replaceAll(":", "h");
		
		
		labTime = new JLabel(time);
		labName = new JLabel(name);
		labFile = new JLabel(file);
		labEvent = new JLabel();
		labEvent.setIcon(img);
		
		Font biggerFont = new Font(labTime.getFont().getFontName(), labTime.getFont().getStyle(), labTime.getFont().getSize() + 4);
		
		labTime.setFont(biggerFont);
		labName.setFont(biggerFont);
		labFile.setFont(biggerFont);

		
		panTime.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panName.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panFile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panEvent.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		panTime.setMaximumSize(new Dimension(80, 50));
		panEvent.setMaximumSize(new Dimension(50, 50));
		
		Dimension dName = new Dimension(300, 50);
		panName.setMinimumSize(dName);
		panName.setMaximumSize(dName);
		panName.setPreferredSize(dName);
		
		Dimension dFile = new Dimension(120, 50);
		panFile.setMinimumSize(dFile);
		panFile.setMaximumSize(dFile);
		panFile.setPreferredSize(dFile);
		
		panTime.add(labTime);
		panName.add(labName);
		panFile.add(labFile);
		panEvent.add(labEvent);
		
		Dimension dim = new Dimension(560, 50);
		
		this.setSize(dim);
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		this.setAlignmentX(LEFT_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		initControles();
	}
	
	public void initControles(){
		
		this.add(panTime);
		this.add(panName);
		this.add(panFile);
		this.add(panEvent);
		
		gui.vecBullet.add(this);
		System.out.println("Bullets: " + gui.vecBullet.size());
		gui.panLeft.add(this);
		gui.panLeft.repaint();
		gui.panLeft.revalidate();
		
		panEvent.addMouseListener(new appMouseListener());
		panName.addMouseListener(new appMouseListener());
		panFile.addMouseListener(new appMouseListener());
		
	}
	
	public void selectBullet(){
		if(gui.selected == this){
			gui.selected = null;
			this.panEvent.setBackground(null);
			this.note = gui.ta.getText();
			gui.ta.setText("");
		}
		else{
			if(gui.selected != null){
				gui.selected.note = gui.ta.getText();
			}
			gui.selected = this;
			for(Bullet blt:gui.vecBullet){
				blt.panEvent.setBackground(null);
			}
			panEvent.setBackground(new Color(150, 150, 255));
			gui.ta.setText(note);
			gui.panLeft.repaint();
			gui.panLeft.revalidate();
		}
		
	}

	class appMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panEvent){
				selectBullet();
			}
			
			if(e.getSource() == panName || e.getSource() == panFile){
				gui.tfClient.setText(labName.getText());
				gui.tfDossier.setText(labFile.getText());
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
