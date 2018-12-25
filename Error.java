package Swing;

import layout.TableLayout;

import javax.swing.*;
import java.awt.*;

public class Error extends JFrame{
    public Error(){
        JLabel idUser = new JLabel("Ошибка!");
        JLabel idUser1 = new JLabel("Неправильный ID пользователя или пароль");
        JPanel panel = new JPanel(new BorderLayout());
        double size[][] =
                {{TableLayout.FILL},
                        {30, 30}};
        panel.setLayout(new TableLayout(size));
        panel.add(idUser,"0,0");
        panel.add(idUser1,"0,1");
        add(panel, BorderLayout.CENTER);

        pack();
        setSize(300,150);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
