package Swing;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import API.ApiUsServ;
import API.Objects.User;
import API.Objects.Order;
import com.caucho.hessian.client.HessianProxyFactory;
import layout.TableLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Frames extends JFrame {

    public Frames(User user) throws MalformedURLException {

        String idUs = user.User();

        String serverAddress = "http://localhost:8080/";
        HessianProxyFactory factory = new HessianProxyFactory();
        ApiUsServ api = (ApiUsServ) factory.create(ApiUsServ.class, serverAddress + "DataService");

        JLabel active = new JLabel("Действующие");
        JLabel reception = new JLabel("Получения");
        JLabel departures = new JLabel("Отправления");
        JLabel archive = new JLabel("Архив");
        JLabel reception1 = new JLabel("Получения");
        JLabel departures1 = new JLabel("Отправления");
        Order order = api.order(idUs, "Получение", "Ожидается");
        JButton number = new JButton(order.Order());
        Order order1 = api.order(idUs, "Отправление", "Ожидается");
        JButton number1 = new JButton(order1.Order());
        Order order2 = api.order(idUs, "Получение", "Получено");
        JButton number2 = new JButton(order2==null?"":order2.Order());
        Order order3 = api.order(idUs, "Отправление", "Получено");
        JButton number3 = new JButton(order3.Order());
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(new URL(
                    "https://mysovets.ru/uploads/posts/2018-11/15419504781loading.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon1 = new ImageIcon(img1);
        JLabel icon2 = new JLabel(icon1);
        JLabel icon3 = new JLabel(icon1);
        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new URL(
                    "http://wot-news.com/images/icon_plus.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon4 = new ImageIcon(img2);
        JLabel icon5 = new JLabel(icon4);
        JLabel icon6 = new JLabel(icon4);
        JPanel panel1 = new JPanel();
        double size3[][] =
                {{TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}};
        panel1.setLayout(new TableLayout(size3));
        panel1.add(active,"0,0");
        panel1.add(reception,"0,1");
        panel1.add(icon2,"0,2");
        panel1.add(number,"1,2");
        panel1.add(departures,"0,3");
        panel1.add(icon3,"0,4");
        panel1.add(number1,"1,4");
        panel1.add(archive,"0,5");
        panel1.add(reception1,"0,6");
        panel1.add(icon5,"0,7");
        panel1.add(number2,"1,7");
        panel1.add(departures1,"0,8");
        panel1.add(icon6,"0,9");
        panel1.add(number3,"1,9");

       BufferedImage img = null;
        try {
            img = ImageIO.read(new URL(
                    "http://sites-new.kodeks.net/manage-template/image/map.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(img);
        JLabel karts = new JLabel(icon);
        JPanel panel2 = new JPanel();
        double size4[][] =
                {{TableLayout.FILL},
                        {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}};
        panel2.setLayout(new TableLayout(size4));
        panel2.add(karts,"0,0");


        JLabel trek = new JLabel("Номер посылки");
        JTextField trek1 = new JTextField();
        JLabel address1 = new JLabel("Адрес");
        JComboBox comboBox1 = new JComboBox(new String[] {"Новоизмайловский проспект","Ул. Профессора Попова"});
        JLabel data = new JLabel("Дата");
        JTextField data1 = new JTextField();
        JLabel time = new JLabel("Время");
        JTextField time1 = new JTextField();
        JLabel fio = new JLabel("ФИО");
        JTextField fio1 = new JTextField();
        JLabel telef = new JLabel("Телефон");
        JTextField telef1 = new JTextField();
        JLabel kommentar = new JLabel("Комментарий");
        JTextField kommentar1 = new JTextField();
        JButton ok = new JButton("Оформить заявку");
        JPanel receptions = new JPanel();
        double size5[][] =
                {{TableLayout.FILL, TableLayout.FILL},
                        {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,80,TableLayout.PREFERRED}};
        receptions.setLayout(new TableLayout(size5));
        receptions.add(trek,"0,0");
        receptions.add(trek1,"1,0");
        receptions.add(address1,"0,1");
        receptions.add(comboBox1,"1,1");
        receptions.add(data,"0,2");
        receptions.add(data1,"1,2");
        receptions.add(time,"0,3");
        receptions.add(time1,"1,3");
        receptions.add(fio,"0,4");
        receptions.add(fio1,"1,4");
        receptions.add(telef,"0,5");
        receptions.add(telef1,"1,5");
        receptions.add(kommentar,"0,6");
        receptions.add(kommentar1,"1,6");
        receptions.add(ok,"1,7");

        JLabel sender = new JLabel("Отправитель");
        JLabel fios = new JLabel("ФИО");
        JTextField fios1 = new JTextField();
        JLabel addresssen = new JLabel("Адрес");
        JComboBox comboBoxsen = new JComboBox(new String[] {"Новоизмайловский проспект","Ул. Профессора Попова"});
        JLabel telefon = new JLabel("Телефон");
        JTextField telefon1 = new JTextField();
        JLabel datas = new JLabel("Дата");
        JTextField datas1 = new JTextField();
        JLabel times = new JLabel("Время");
        JTextField times1 = new JTextField();
        JLabel recipient = new JLabel("Получатель");
        JLabel fior = new JLabel("ФИО");
        JTextField fior1 = new JTextField();
        JLabel addressr = new JLabel("Адрес");
        JTextField addressr1 = new JTextField();
        JLabel charact = new JLabel("Параметры");
        JComboBox comboBoxcharact = new JComboBox(new String[] {"С объявлением ценности","С наложным платежом","С описью"});
        JLabel notif = new JLabel("Уведомление");
        JComboBox comboBoxnot = new JComboBox(new String[] {"С простым уведомлением","С заказным уведомлением"});
        JLabel parcel = new JLabel("О посылке");
        JLabel sizes = new JLabel("Размер");
        JTextField sizes1 = new JTextField();
        JLabel mass = new JLabel("Масса");
        JTextField mass1 = new JTextField();
        JButton ok1 = new JButton("Оформить заявку");
        JPanel departure = new JPanel();
        double size6[][] =
                {{TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.FILL, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED,TableLayout.PREFERRED}};
        departure.setLayout(new TableLayout(size6));
        departure.add(sender,"0,0");
        departure.add(fios,"0,1");
        departure.add(fios1,"1,1");
        departure.add(addresssen,"0,2");
        departure.add(comboBoxsen,"1,2");
        departure.add(telefon,"0,3");
        departure.add(telefon1,"1,3");
        departure.add(datas,"0,4");
        departure.add(datas1,"1,4");
        departure.add(times,"0,5");
        departure.add(times1,"1,5");
        departure.add(recipient,"0,6");
        departure.add(fior,"0,7");
        departure.add(fior1,"1,7");
        departure.add(addressr,"0,8");
        departure.add(addressr1,"1,8");
        departure.add(charact,"0,9");
        departure.add(comboBoxcharact,"1,9");
        departure.add(notif,"0,10");
        departure.add(comboBoxnot,"1,10");
        departure.add(parcel,"0,11");
        departure.add(sizes,"0,12");
        departure.add(sizes1,"1,12");
        departure.add(mass,"0,13");
        departure.add(mass1,"1,13");
        departure.add(ok1,"1,14");

        JLabel actives = new JLabel("Действующие");
        JLabel treks = new JLabel("20 декабря (KWR87452HVH782)");
        treks.setForeground(Color.RED);
        JLabel treks1 = new JLabel("18 декабря (SJHV728398235)");
        treks1.setForeground(Color.RED);
        JLabel archives = new JLabel("Архив");
        JLabel treks2 = new JLabel("10 октября(KVWBR860WB087W)");
        treks2.setForeground(Color.BLUE);
        JLabel treks3 = new JLabel("5 сентября (KRVH89869WV96)");
        treks3.setForeground(Color.BLUE);
        JPanel application = new JPanel();
        double size7[][] =
                {{TableLayout.PREFERRED, TableLayout.FILL},
                        {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}};
        application.setLayout(new TableLayout(size7));
        application.add(actives,"0,0");
        application.add(treks,"1,1");
        application.add(treks1,"1,2");
        application.add(archives,"0,3");
        application.add(treks2,"1,4");
        application.add(treks3,"1,5");
        JPanel panel3 = new JPanel();
        JTabbedPane menu1 = new JTabbedPane(JTabbedPane.NORTH,JTabbedPane.WRAP_TAB_LAYOUT);
        menu1.add("Получение",receptions);
        menu1.add("Отправление",departure);
        menu1.add("Заявки", application);
        panel3.add(menu1);

        JLabel name = new JLabel("Имя");
        JTextField name1 = new JTextField(user.getName());
        JLabel fam = new JLabel("Фамилия");
        JTextField fam1 = new JTextField(user.getFam());
        JLabel ot = new JLabel("Отчество");
        JTextField ot1 = new JTextField(user.getOt());
        JLabel tel = new JLabel("Телефон");
        JTextField tel1 = new JTextField(user.getTel());
        JLabel email = new JLabel("Эл. почта");
        JTextField email1 = new JTextField(user.getEmail());
        JLabel city = new JLabel("Город");
        JTextField city1 = new JTextField(user.getCity());
        JLabel id = new JLabel("ID");
        JTextField id1 = new JTextField(idUs);
        id1.setEditable(false);
        JLabel passw = new JLabel("Пароль");
        JPasswordField passw1 = new JPasswordField(user.getPassword());
        passw1.setEditable(false);
        JLabel address = new JLabel("Адрес");
        JComboBox comboBox = new JComboBox(new String[] {"Новоизмайловский проспект","Ул. Профессора Попова"});
        JButton transform = new JButton("Изменить");
        transform.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User us = new User(idUs);
                try {
                    new Passwordtransform(us.User()).setVisible(true);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton maneg = new JButton("Управление");
        JButton save = new JButton("Сохранить");


        JPanel panel4 = new JPanel();
        double size[][] =
                {{80, TableLayout.FILL, TableLayout.PREFERRED},
                        {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}};
        panel4.setLayout(new TableLayout(size));
        panel4.add(name,"0,0");
        panel4.add(name1,"1,0");
        panel4.add(fam,"0,1");
        panel4.add(fam1,"1,1");
        panel4.add(ot,"0,2");
        panel4.add(ot1,"1,2");
        panel4.add(tel,"0,3");
        panel4.add(tel1,"1,3");
        panel4.add(email,"0,4");
        panel4.add(email1,"1,4");
        panel4.add(city,"0,5");
        panel4.add(city1,"1,5");
        panel4.add(id,"0,6");
        panel4.add(id1,"1,6");
        panel4.add(passw,"0,7");
        panel4.add(passw1,"1,7");
        panel4.add(transform,"2,7");
        panel4.add(address,"0,8");
        panel4.add(comboBox,"1,8");
        panel4.add(maneg,"2,8");
        panel4.add(save,"2,9");



        JLabel kart = new JLabel("Номер карты");
        JTextField numbers = new JTextField(user.getKart());
        numbers.setEditable(false);
        JLabel sum = new JLabel("Сумма на карте");
        JTextField sum1 = new JTextField(user.getSum());
        sum1.setEditable(false);
        JButton button = new JButton("Пополнить");

        JPanel panel5 = new JPanel();
        double size1[][] =
                {{TableLayout.FILL, TableLayout.FILL},
                        {50, 50, TableLayout.PREFERRED}};
        panel5.setLayout(new TableLayout(size1));
        panel5.add(kart,"0,0");
        panel5.add(numbers,"1,0");
        panel5.add(sum,"0,1");
        panel5.add(sum1,"1,1");
        panel5.add(button,"0,2");


        JLabel label1 = new JLabel("Уведомления на email");
        JCheckBox box = new JCheckBox();
        JLabel label4 = new JLabel("Вкл");
        JLabel label2 = new JLabel("Уведомления на телефон");
        JCheckBox box2 = new JCheckBox();

        JLabel label5 = new JLabel("Вкл");
        JLabel label3 = new JLabel("Обратная связь");
        JTextField textField = new JTextField();
        JButton button1 = new JButton("Отправить");
        JButton button2 = new JButton("О приложении");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Application().setVisible(true);
            }
        });

        JPanel panel6 = new JPanel();
        double size2[][] =
                {{TableLayout.PREFERRED, TableLayout.PREFERRED,TableLayout.FILL},
                        {TableLayout.PREFERRED, TableLayout.PREFERRED, 110, TableLayout.PREFERRED, TableLayout.PREFERRED}};
        panel6.setLayout(new TableLayout(size2));
        panel6.add(label1,"0,0");
        panel6.add(box,"1,0");
        panel6.add(label4,"2,0");
        panel6.add(label2,"0,1");
        panel6.add(box2,"1,1");
        panel6.add(label5,"2,1");
        panel6.add(label3,"0,2");
        panel6.add(textField,"2,2");
        panel6.add(button1,"2,3");
        panel6.add(button2,"0,4");

        JTabbedPane menu = new JTabbedPane(JTabbedPane.NORTH);
        menu.add("Отправления",panel1);
        menu.add("Отделения",panel2);
        menu.add("Курьер", panel3);
        menu.add("Личный кабинет", panel4);
        menu.add("Карта клиента", panel5);
        menu.add("Настройки", panel6);

        add(menu);
        pack();
        setSize(450,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
