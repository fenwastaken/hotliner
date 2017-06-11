package dev.gui;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dev.assets.IconLoader;
import dev.main.DateLabelFormatter;

public class GUI extends JFrame{

	public Bullet selected;
	public Vector<Bullet> vecBullet = new Vector<Bullet>();
	public IconLoader il = new IconLoader();
	public JLabel labEvent;
	public JDialog frame;
	JPanel zoneClient = (JPanel) this.getContentPane();
	JButton btAdd = new JButton("Créer");
	JTextField tfClient = new JTextField();
	JTextField tfDossier = new JTextField();

	JPanel panTop = new JPanel();
	JPanel panLeft = new JPanel();
	JScrollPane spanLeft = new JScrollPane(panLeft);
	TextArea ta = new TextArea();
	JScrollPane spanCenter = new JScrollPane(ta);

	public GUI(){

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		this.setTitle("Hotliner");
		this.setSize(((int)(width) - 287), (int)(height));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(0,0);
		this.setResizable(true);

		initControles();

	}

	public void initControles(){

		Font taFont = new Font(ta.getFont().getFontName(), Font.BOLD, ta.getFont().getSize() + 4);
		ta.setFont(taFont);

		//panTop.setBorder(BorderFactory.createLineBorder(Color.black));
		panTop.setBorder(BorderFactory.createEtchedBorder());
		//spanLeft.setBorder(BorderFactory.createLineBorder(Color.blue));
		panLeft.setBorder(BorderFactory.createEtchedBorder());

		panTop.setPreferredSize(new Dimension(800, 100));

		Dimension dSpanLeft = new Dimension(555, 600);
		Dimension dpanLeft = new Dimension(540, 600);
		spanLeft.setMaximumSize(dSpanLeft);
		spanLeft.setPreferredSize(dSpanLeft);
		panLeft.setMaximumSize(dpanLeft);
		panLeft.setPreferredSize(dpanLeft);

		zoneClient.setLayout(new BorderLayout());
		zoneClient.add(panTop, BorderLayout.NORTH);
		zoneClient.add(spanLeft, BorderLayout.WEST);
		zoneClient.add(spanCenter, BorderLayout.CENTER);

		panLeft.setLayout(new BoxLayout(panLeft, BoxLayout.Y_AXIS));

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panTop.add(datePicker);

		JLabel labTfClient = new JLabel("Client");
		tfClient = new JTextField();
		JLabel labTfDossier = new JLabel("Dossier");
		tfDossier = new JTextField();

		panTop.add(labTfClient);
		panTop.add(tfClient);

		panTop.add(labTfDossier);
		panTop.add(tfDossier);

		Font biggerFont = new Font(labTfClient.getFont().getFontName(), labTfClient.getFont().getStyle(), labTfClient.getFont().getSize() + 4);
		labTfClient.setFont(biggerFont);
		labTfDossier.setFont(biggerFont);

		tfClient.setFont(biggerFont);
		tfDossier.setFont(biggerFont);

		tfClient.setPreferredSize(new Dimension(200, 30));
		tfDossier.setPreferredSize(new Dimension(200, 30));

		labEvent = new JLabel(new ImageIcon(il.imgNew));


		panTop.add(labEvent);
		panTop.add(btAdd);

		labEvent.addMouseListener(new appMouseListener());
		btAdd.addActionListener(new appActionListener());
		ta.addMouseListener(new appMouseListener());



	}

	class appActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btAdd){
				Date date = new Date();
				String name = tfClient.getText();
				String file = tfDossier.getText();
				Icon img = labEvent.getIcon();

				Bullet blt = new Bullet(GUI.this, date, name, file, img, "");
			}
		}

	}

	class appMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			if(e.getSource() == ta){
				tfClient.setText("");
				tfDossier.setText("");
			}
			else if(e.getSource() == labEvent){
				System.out.println("plop");
				frame = new JDialog();
				frame.setTitle("Choose an event");
				JPanel frameClient = (JPanel) frame.getContentPane();
				frameClient.setLayout(new GridLayout(6, 3));

				for(Image img : il.vecImage){
					JLabel lab = new JLabel(new ImageIcon(img));
					frameClient.add(lab);
					lab.addMouseListener(new appMouseListener());
				}

				frame.setSize(300,  300);
				frame.setLocationRelativeTo(null);
				frame.setModalityType(ModalityType.APPLICATION_MODAL);
				frame.setVisible(true);

			}
			else{
				System.out.println(e.getSource());
				JLabel lab = (JLabel)(e.getSource());
				labEvent.setIcon(lab.getIcon());
				frame.dispose();
			}


		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

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



