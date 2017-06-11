package dev.assets;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.imageio.ImageIO;

public class IconLoader {

	public static Image imgArrow;
	public static Image imgCallin;
	public static Image imgCallout;
	public static Image imgChecked;
	public static Image imgCheckedFiles;
	public static Image imgCoffee;
	public static Image imgDelete;
	public static Image imgEdit;
	public static Image imgEye;
	public static Image imgFire;
	public static Image imgGear;
	public static Image imgHourglass;
	public static Image imgHuh;
	public static Image imgInfo;
	public static Image imgMail;
	public static Image imgMailSent;
	public static Image imgNew;
	public static Image imgQuestion;


	public Vector<Image> vecImage = new Vector<>();
	
	public IconLoader(){
		try {
			imgArrow = ImageIO.read(this.getClass().getResource("/icons/arrow.png"));
			imgCallin = ImageIO.read(this.getClass().getResource("/icons/callin.png"));
			imgCallout = ImageIO.read(this.getClass().getResource("/icons/callout.png"));
			imgChecked = ImageIO.read(this.getClass().getResource("/icons/checked.png"));
			imgCheckedFiles = ImageIO.read(this.getClass().getResource("/icons/checkedfiles.png"));
			imgCoffee = ImageIO.read(this.getClass().getResource("/icons/coffee.png"));
			imgDelete = ImageIO.read(this.getClass().getResource("/icons/delete.png"));
			imgEdit = ImageIO.read(this.getClass().getResource("/icons/edit.png"));
			imgEye = ImageIO.read(this.getClass().getResource("/icons/eye.png"));
			imgFire = ImageIO.read(this.getClass().getResource("/icons/fire.png"));
			imgGear = ImageIO.read(this.getClass().getResource("/icons/gear.png"));
			imgHourglass = ImageIO.read(this.getClass().getResource("/icons/hourglass.png"));
			imgHuh = ImageIO.read(this.getClass().getResource("/icons/huh.png"));
			imgInfo = ImageIO.read(this.getClass().getResource("/icons/info.png"));
			imgMail = ImageIO.read(this.getClass().getResource("/icons/mail.png"));
			imgMailSent = ImageIO.read(this.getClass().getResource("/icons/mailsent.png"));
			imgNew = ImageIO.read(this.getClass().getResource("/icons/new.png"));
			imgQuestion = ImageIO.read(this.getClass().getResource("/icons/question.png"));
			
			
			vecImage.add(imgNew);
			vecImage.add(imgEdit);
			vecImage.add(imgCheckedFiles);
			vecImage.add(imgMail);
			vecImage.add(imgMailSent);
			vecImage.add(imgHourglass);
			vecImage.add(imgCallin);
			vecImage.add(imgCallout);
			vecImage.add(imgInfo);
			vecImage.add(imgHuh);
			vecImage.add(imgChecked);
			vecImage.add(imgCoffee);
			vecImage.add(imgArrow);
			vecImage.add(imgDelete);
			vecImage.add(imgQuestion);
			vecImage.add(imgEye);
			vecImage.add(imgGear);
			vecImage.add(imgFire);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
