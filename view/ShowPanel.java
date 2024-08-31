package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import components.CustomButton;
import models.PasswordData;
import utils.FileReadWrite;
import utils.Poppins;

public class ShowPanel extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    Image back = new ImageIcon(getClass().getResource("/res/images/back.png")).getImage();
    CustomButton go_back;

    public ShowPanel(){
       
        go_back = new CustomButton("", 12, Color.white, 10);
        go_back.setIcon(new ImageIcon(getClass().getResource("/res/images/back.png")));
        go_back.setBounds(25,25,40,40);
        add(go_back);
        go_back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               AppWindow.update_panel(new SavePanel());
            }
            
        });

        model = new DefaultTableModel(new String[] {"Id", "Website", "Email", "Password", "Saved Date"}, 0);
        
        table = new JTable();
        table.setModel(model);

        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        table.getTableHeader().setBackground(Color.decode("#000080"));
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(Poppins.getPoppinsBold(12));
        table.getTableHeader().setPreferredSize(new Dimension(100,40));
        

        table.setShowGrid(false);
        table.setRowHeight(40);
        table.setBackground(Color.white);
        table.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        // scrollPane.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.black));
        scrollPane.setBounds(AppWindow.MAIN_WIDTH/2 - 300 ,100,600,450);
        scrollPane.getViewport().setBackground(Color.white);
        add(scrollPane);

        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
       
       
        ArrayList<PasswordData> data_list = FileReadWrite.read_file();
        for (PasswordData data : data_list) {
            model.addRow(new Object[]{data.getId(), data.getWebsite(), data.getEmail(), data.getPassword(), data.getDate()});
        }

        setLayout(null);
        // setBackground(Color.yellow);
        setBackground(null);
    }

}
