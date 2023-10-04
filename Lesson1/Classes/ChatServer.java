package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class ChatServer extends JFrame {
    private String path = "./Lesson1/dataStorage.txt";

    private static final String LOGIN = "1111";
    private static final String PASSWORD = "1111";

    protected ChatClient cc;

    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;

    private boolean loginStatus = false;
    private boolean serverStatus = false;

    public Boolean getStatus(){
        return serverStatus;
    }

    ChatServer(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("ChatServer");

        add(getButtons());

        setVisible(true);
    }

    /**
     * Создание кнопок в окне работы с сервером. Если логирование не произошло, то
     * сервер не запустится.
     * @return Возвращает JPanel с кнопка вкл/выкл сервера
     */
    private Component getButtons(){
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        JButton btnStart = new JButton("Start server");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!serverStatus) {
                    if (loginStatus) {
                        serverStatus = true;
                        cc.add(cc.panMid);
                        repaint();
                        JOptionPane.showMessageDialog(ChatServer.this, "Server was turned on");
                    } else {
                        JOptionPane.showMessageDialog(ChatServer.this, "You haven't signed in");
                    }
                } else {
                    JOptionPane.showMessageDialog(ChatServer.this, "Server is already turned on");
                }
            }
        });

        JButton btnStop = new JButton("Stop server");

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(serverStatus) {
                    serverStatus = false;
                    loginStatus = false;
                    clearData();
                    JOptionPane.showMessageDialog(ChatServer.this, "Server was stopped");
                } else {
                    JOptionPane.showMessageDialog(ChatServer.this, "Server is already stopped");
                }
            }
        });
        panButtons.add(btnStart);
        panButtons.add(btnStop);
        return panButtons;
    }

    /**
     * Метод записи сообщения в файл
     * @param text - текст из сообщения
     * @throws IOException - появится, если файл не будет найден
     */
    protected void sendTextIntoDatabase(String text) throws IOException {
        LocalDate ld = LocalDate.now();
        Date dt = new Date();
        try(FileWriter fr = new FileWriter(path, true)){
            fr.append(ld.now() + "_" + dt.getHours() + ":" + dt.getMinutes() + " ");
            fr.append(text);
            fr.append("\n");
        }
    }

    /**
     * Сборка текста из файла для добавления в чат
     * @return Возвращает String значение с HTML-тегами для форматирования JLabel
     * @throws IOException - появится, если файл не будет найден
     */
    protected String getText() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("<br>");
            }
        }
        sb.append("<html>");
        return sb.toString();
    }
    protected String getLogin(){
        return LOGIN;
    }
    protected String getPassword(){
        return PASSWORD;
    }
    protected void setLogin(){
        loginStatus = true;
    }

    /**
     * Отчистка данных после остановки работы сервера
     */
    private void clearData(){
        cc.remove(cc.panMid);
        cc.setPanTop();
        cc.add(cc.panTop, BorderLayout.NORTH);
    }
}
