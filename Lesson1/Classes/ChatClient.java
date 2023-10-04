package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChatClient extends JFrame{
    private static final int WINDOW_HEIGHT = 400;
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_POSX = 500;
    public static final int WINDOW_POSY = 100;

    protected static ChatServer cs;

    protected Component panTop, panMid, panBot;

    public ChatClient() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("ChatClient");

        cs = new ChatServer();
        cs.cc = this;

        setPanTop();
        setPanMid();
        setPanBot();

        add(panTop, BorderLayout.NORTH);
        add(panBot, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Создание меню логирования и обработчиков событий для него
     * @return
     */
    private Component getTopMenu(){
        JPanel jp = new JPanel(new GridLayout(1,3));
        JTable tab1 = new JTable(2,1);
        JTable tab2 = new JTable(2,1);
        setValuesOfTabs(tab1,tab2,"IP","LOGIN","PORT","PASSWORD");
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (checkLogin(tab1.getValueAt(1, 0).toString())
                            && checkPassword(tab2.getValueAt(1, 0).toString())) {
                        cs.setLogin();
                        remove(panTop);
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(ChatClient.this, "Wrong login or password");
                    }
            }
        });

        jp.add(tab1);
        jp.add(tab2);
        jp.add(btnLogin);

        return jp;
    }

    /**
     * Создание визуального отображения чата
     * @return
     * @throws IOException
     */
    private Component getMiddleMenu() throws IOException {
        JLabel jl = new JLabel(cs.getText());
        jl.setVerticalAlignment(1);
        return jl;
    }

    /**
     * Создание меню ввода и отправки сообщения
     * @return
     */
    private Component getBottomMenu(){
        GridLayout gl = new GridLayout(1,2);
        JPanel pan = new JPanel(gl);

        JTextArea ta = new JTextArea(0,20);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        JButton btnSend = new JButton("Send");
        ta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        cs.sendTextIntoDatabase(ta.getText());
                        ta.setText("");
                        update();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(cs.getStatus()) {
                        cs.sendTextIntoDatabase(ta.getText());
                        System.out.println("Сообщение отправлено");
                        update();
                    }
                    else{
                        JOptionPane.showMessageDialog(cs,"Server is stopped");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                ta.setText("");
            }
        });

        pan.add(ta);
        pan.add(btnSend);
        return pan;
    }

    protected void setPanTop() {
        this.panTop = getTopMenu();
    }

    protected void setPanMid() throws IOException {
        this.panMid = getMiddleMenu();
    }

    protected void setPanBot() {
        this.panBot = getBottomMenu();
    }

    private void update() throws IOException {
        remove(panMid);
        setPanMid();
        add(panMid);
    }
    private boolean checkLogin(String value){
        if(cs.getLogin().equals(value)){
            return true;
        }
        return false;
    }
    private boolean checkPassword(String value){
        if(cs.getPassword().equals(value)){
            return true;
        }
        return false;
    }

    /**
     * Метод добавления первоначальных значений в JTable
     */
    protected void setValuesOfTabs(JTable tab1, JTable tab2, String val1, String val2, String val3, String val4){
        tab1.setValueAt(val1, 0,0);
        tab1.setValueAt(val2, 1,0);
        tab2.setValueAt(val3, 0,0);
        tab2.setValueAt(val4, 1,0);
    }
}
