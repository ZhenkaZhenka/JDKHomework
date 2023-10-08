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

    protected Component header, log, footer;

    public ChatClient(ChatServer chatServer) throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("ChatClient");

        cs = chatServer;

        getHeader();
        getLog();
        getFooter();

        add(header, BorderLayout.NORTH);
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Создание меню логирования и обработчиков событий для него
     * @return
     */
    private void getHeader(){
        JPanel jp = new JPanel(new GridLayout(1,3));
        JTable tab1 = new JTable(2,1);
        JTable tab2 = new JTable(2,1);
        setValuesOfTabs(tab1,tab2,"IP","1111","PORT","1111");
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (checkLogin(tab1.getValueAt(1, 0).toString())
                            && checkPassword(tab2.getValueAt(1, 0).toString())) {
                        cs.setLogin();
                        remove(header);
                        repaint();
                        JOptionPane.showMessageDialog(ChatClient.this, "Log in successful");
                    } else {
                        JOptionPane.showMessageDialog(ChatClient.this, "Wrong login or password");
                    }
            }
        });

        jp.add(tab1);
        jp.add(tab2);
        jp.add(btnLogin);

        header = jp;
    }

    /**
     * Создание визуального отображения чата
     * @return
     * @throws IOException
     */
    private void getLog() throws IOException {
        JLabel jl = new JLabel(cs.getText());
        jl.setVerticalAlignment(1);
        log = jl;
    }

    /**
     * Создание меню ввода и отправки сообщения
     * @return
     */
    void getFooter(){
        GridLayout gl = new GridLayout(1,2);
        JPanel footer = new JPanel(gl);

        JTextField ta = new JTextField();

        JButton btnSend = new JButton("Send");
        ta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    sendMessage(ta);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(ta);
            }
        });

        footer.add(ta);
        footer.add(btnSend);
        this.footer = footer;
    }
    private void sendMessage(JTextField ta){
        try {
            if(cs.getStatus()) {
                cs.sendTextIntoDatabase(ta.getText());
                ta.setText(null);
                System.out.println("Сообщение отправлено");
                update();
                repaint();
            } else {
                JOptionPane.showMessageDialog(ChatClient.this,"Server is stopped, you can't send messages");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    private void update() throws IOException {
        this.remove(log);
        getLog();
        this.add(log);
        repaint();
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
