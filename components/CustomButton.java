package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

import utils.Poppins;

public class CustomButton extends JButton {

	String button_text;
	float font_size;
	Color bg_color;
	int border_radius;

	public CustomButton(String button_text, float font_size, Color bg_color, int border_radius) {
		this.button_text = button_text;
		this.font_size = font_size;
		this.bg_color = bg_color;
		this.border_radius = border_radius;
		
		setText(button_text);
		setFont(Poppins.getPoppins(font_size));
		setBackground(bg_color);
		setOpaque(false);		
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
	}


	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    if (getModel().isArmed()) {
	      g2d.setColor(Color.orange);
	    } else {
	      g2d.setColor(getBackground());
	    }
	    
	    g2d.fillRoundRect(0, 0, getWidth()-1,getHeight()-1,10,10);
	    
	    super.paintComponent(g2d);
	  }


	

}
