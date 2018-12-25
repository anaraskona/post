package Swing;

import API.ApiUsServ;
import com.caucho.hessian.client.HessianProxyFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Authorization {
    public static void main (String[] args) throws IOException {

        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        ApiUsServ api = (ApiUsServ) factory.create(ApiUsServ.class, serverAddress + "DataService");

        JFrame frame = new JFrame("Авторизация");
        JLabel label1 = new JLabel("ID");
        label1.setHorizontalAlignment(JLabel.RIGHT);
        JTextField textField = new JTextField();
        JLabel label2 = new JLabel("Password");
        label2.setHorizontalAlignment(JLabel.RIGHT);
        JPasswordField passwordField = new JPasswordField();
        JButton button1 = new JButton("Ок");
        JButton button2 = new JButton("Отмена");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });


        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 10));
        panel.add(label1);
        panel.add(textField);
        panel.add(label2);
        panel.add(passwordField);
        JPanel panel2 = new JPanel();
        panel2.add(button1);
        panel2.add(button2);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);



        frame.pack();
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idUsers = textField.getText();
                String pasUsers = passwordField.getText();
                System.out.println(idUsers);
                System.out.println(pasUsers);
                System.out.println(api.flag(idUsers,pasUsers));
                //new Frames().setVisible(true);
                //frame.setVisible(false);
            }
        });

        /*String idUsers = api.userId(textField.getText());
        String pasUsers = api.userPas(passwordField.getText());
        System.out.println(idUsers);
        System.out.println(api.flag(idUsers,pasUsers));
        if(api.flag(idUsers,pasUsers)==true){
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Frames().setVisible(true);
                    frame.setVisible(false);
                }
            });
        } else {
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Error().setVisible(true);
                }
            });
        }*/
    }




}
