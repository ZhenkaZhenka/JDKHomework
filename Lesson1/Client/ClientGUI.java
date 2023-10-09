package Client;

import Server.ChatServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ClientGUI extends JFrame{
    private static final int WINDOW_HEIGHT = 400;
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_POSX = 500;
    public static final int WINDOW_POSY = 100;

    protected static ChatServer cs;
    private Client client;

    private JButton btnSend, btnLogin;
    private JTextField messageField;
    private JTable tab1, tab2;

    public Component header, log, footer;

    public ClientGUI(ChatServer chatServer) throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("ChatClient");

        cs = chatServer;
        client = new Client(this, cs);

        createHeader();
        createLog();
        createFooter();

        add(header, BorderLayout.NORTH);
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Создание меню логирования и обработчиков событий для него
     * @return
     */
    private void createHeader(){
        JPanel jp = new JPanel(new GridLayout(1,3));
        tab1 = new JTable(2,1);
        tab2 = new JTable(2,1);
        setValuesOfTabs(tab1,tab2,"IP","1111","PORT","1111");
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    client.connectToServer();
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
    private void createLog() throws IOException {
        JLabel jl = new JLabel(cs.getText());
        jl.setVerticalAlignment(1);
        log = jl;
    }

    /**
     * Создание меню ввода и отправки сообщения
     * @return
     */
    void createFooter(){
        GridLayout gl = new GridLayout(1,2);
        JPanel footer = new JPanel(gl);

        messageField = new JTextField();

        btnSend = new JButton("Send");
        messageField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    client.sendMessage(messageField);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.sendMessage(messageField);
            }
        });

        footer.add(messageField);
        footer.add(btnSend);
        this.footer = footer;
    }

    void update() throws IOException {
        this.remove(log);
        createLog();
        this.add(log);
        repaint();
    }
    protected boolean checkLogin(String value){
        if(cs.getLogin().equals(value)){
            return true;
        }
        return false;
    }
    protected boolean checkPassword(String value){
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
    public Component getHeader(){
        return header;
    }
    public Component getLog(){
        return log;
    }
    public Component getFooter(){
        return footer;
    }

    public static ChatServer getCs() {
        return cs;
    }

    public Client getClient() {
        return client;
    }

    public JButton getBtnSend() {
        return btnSend;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JTextField getMessageField() {
        return messageField;
    }

    public JTable getTab1() {
        return tab1;
    }

    public JTable getTab2() {
        return tab2;
    }
}
