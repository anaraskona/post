package Swing;

import API.ApiUsServ;
import API.Objects.User;
import com.caucho.hessian.client.HessianProxyFactory;
import layout.TableLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class Passwordtransform extends JFrame {
    public Passwordtransform(String id) throws MalformedURLException {
        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        ApiUsServ api = (ApiUsServ) factory.create(ApiUsServ.class, serverAddress + "DataService");

        JLabel newpassword = new JLabel("Новый пароль");
        JTextField newpassword1 = new JTextField();
        JLabel newpasswords = new JLabel("Повторите пароль");
        JTextField newpasswords1 = new JTextField();
        JButton save = new JButton("Сохранить");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pasnew = newpassword1.getText();
                api.pas(id,pasnew);
                setVisible(false);
            }
        });
        JButton cancel = new JButton("Отмена");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        JPanel pas = new JPanel();
        double size[][] =
                {{TableLayout.FILL, TableLayout.FILL},
                        {30, 30, 30}};
        pas.setLayout(new TableLayout(size));
        pas.add(newpassword,"0,0");
        pas.add(newpassword1,"1,0");
        pas.add(newpasswords,"0,1");
        pas.add(newpasswords1,"1,1");
        pas.add(save,"0,2");
        pas.add(cancel,"1,2");

        add(pas);
        pack();
        setSize(250,130);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
