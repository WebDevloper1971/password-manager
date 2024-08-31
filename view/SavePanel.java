package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import components.CustomButton;
import components.CustomInput;
import models.PasswordData;
import utils.FileReadWrite;
import utils.PasswordGenerator;
import utils.Poppins;

public class SavePanel extends JPanel{
    

    JLabel main_title;
    CustomButton search_password, generate_password, save_password, show_all_password;

    Image security_img = new ImageIcon(getClass().getResource("/res/images/lock.png")).getImage();

    Color btn_color_one = Color.decode("#000080");
    Color btn_color_two = Color.decode("#002D00");
    Color btn_color_three = Color.decode("#3939FF");

    public SavePanel(){

        main_title = new JLabel("TMP: The Password Manager",SwingConstants.CENTER);
        main_title.setFont(Poppins.getPoppinsBold(24));
        main_title.setBounds(AppWindow.MAIN_WIDTH/2 - 200,50,400,40);
        // main_title.setBorder(BorderFactory.createLineBorder(Color.black));
        add(main_title);
  

        search_password = new CustomButton("Search Password",14,btn_color_three,10);
        generate_password = new CustomButton("Generate Password",14,btn_color_two,10);
        save_password = new CustomButton("Save Password",14,btn_color_one,10);
        show_all_password = new CustomButton("Show Password",14,btn_color_one,10);


        int x = 50;
        int y = 300;
        int btn_width = 180;
        int btn_height = 40;
        
        CustomInput website_fld = new CustomInput("Website");
        website_fld.setBounds(x,y,400,40);;
        add(website_fld);

        search_password.setBounds(x+website_fld.getWidth()+10, y, btn_width, btn_height);
        search_password.setForeground(Color.white);
        add(search_password);
        search_password.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordData p = FileReadWrite.search_password_data(website_fld.getFieldInput().toLowerCase());
                website_fld.setFieldInput("");
                JOptionPane.showMessageDialog(getParent(),p.toString());


            }
            
        });

        CustomInput email_fld = new CustomInput("Email");
        email_fld.setBounds(x,website_fld.getY()+website_fld.getHeight()+20,400,40);;
        add(email_fld);

        CustomInput password_fld = new CustomInput("Password");
        password_fld.setBounds(x,email_fld.getY()+email_fld.getHeight()+20,400,40);;
        add(password_fld);

        generate_password.setBounds(x+password_fld.getWidth()+10, password_fld.getY(), btn_width, btn_height);
        generate_password.setForeground(Color.white);
        add(generate_password);
        generate_password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String password = PasswordGenerator.generatePassword(website_fld.getFieldInput(), email_fld.getFieldInput());
                // JOptionPane.showMessageDialog(getParent(), password);
                password_fld.setFieldInput(password);
            }
        });


        save_password.setBounds(x+100, password_fld.getY()+password_fld.getHeight()+50, btn_width, btn_height);
        save_password.setForeground(Color.white);
        add(save_password);
        save_password.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = FileReadWrite.write_file(website_fld.getFieldInput().toLowerCase(),email_fld.getFieldInput().toLowerCase(),password_fld.getFieldInput());
                website_fld.setFieldInput("");
                email_fld.setFieldInput("");
                password_fld.setFieldInput("");
                JOptionPane.showMessageDialog(getParent(),message);
            }
        });

        show_all_password.setBounds(x+save_password.getWidth()+btn_width, save_password.getY(), btn_width, btn_height);
        show_all_password.setForeground(Color.white);
        add(show_all_password);
        show_all_password.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               AppWindow.update_panel(new ShowPanel());
            }
            
        });


        setLayout(null);
        // setBackground(Color.yellow);
        setBackground(null);
    }

    public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(security_img, AppWindow.MAIN_WIDTH/2 - 50,120,100,100,null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

}
