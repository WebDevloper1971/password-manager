package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Poppins;


public class CustomInput extends JPanel{
    
    private JLabel lbl;
    private JTextField txt;
    final int BORDER_RADIUS = 10;
    Color txt_field_color = Color.decode("#9494FF");

    public CustomInput(String field){
        lbl = new JLabel(field);
        txt = new JTextField();

        lbl.setBounds(10,0,80,40);
        lbl.setFont(Poppins.getPoppinsBold(14));
        // lbl.setBorder(BorderFactory.createLineBorder(Color.blue));


        txt.setBounds(lbl.getX()+lbl.getWidth()+10,0,290,40);
        txt.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        txt.setFont(Poppins.getPoppins(14));
        txt.setForeground(Color.black);
        txt.setCaretColor(Color.black);
        txt.setOpaque(false);

        add(lbl);
        add(txt);

        setLayout(null);
        setBackground(null);
    }

    public String getFieldInput(){
        return txt.getText();
    }

    public void setFieldInput(String input){
        txt.setText(input);
    }

      public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(txt_field_color);
        g2d.fillRoundRect(txt.getX() - 2, txt.getY() - 2, txt.getWidth() + 4, txt.getHeight() + 4, BORDER_RADIUS, BORDER_RADIUS);;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}
