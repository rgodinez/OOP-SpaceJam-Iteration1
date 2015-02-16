package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;





import javax.swing.JComponent;

import utilities.Scaling;
import model.Avatar;
import model.Entity;

/*

EntityView Class
Contains an instance of an Entity to be rendered as part of a Tile

*/

public class EntityView extends JComponent{
	private Avatar avatar;
	
	public EntityView(Avatar avatar) {
		this.avatar = avatar;
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		BufferedImage image = avatar.getImage();
		g.drawImage(image,300 ,300, null);
		repaint();
	}
}