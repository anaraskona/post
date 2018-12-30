package Swing;

import API.ApiUsServ;
import API.Objects.User;
import com.caucho.hessian.client.HessianProxyFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;


public class Authorization {
    private static String idUsers;
    private static String pasUsers;
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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idUsers = textField.getText();
                pasUsers = passwordField.getText();
                User user = api.flag(idUsers,pasUsers);
                if (user !=null){
                    try {
                        new Frames(user).setVisible(true);
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    }
                    frame.setVisible(false);
                } else {
                    new Error().setVisible(true);
                }

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


    }


}


