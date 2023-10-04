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
    private Component getButtons(){
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        JButton btnStart = new JButton("Start server");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!serverStatus) {
                    if (loginStatus) {
                        serverStatus = true;
                        System.out.println("Server turned on");
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
                    System.out.println("Server stopped");
                } else {
                    JOptionPane.showMessageDialog(ChatServer.this, "Server is already stopped");
                }
            }
        });
        panButtons.add(btnStart);
        panButtons.add(btnStop);
        return panButtons;
    }

    protected void sendTextIntoDatabase(String text) throws IOException {
        LocalDate ld = LocalDate.now();
        Date dt = new Date();
        try(FileWriter fr = new FileWriter(path, true)){
            fr.append(ld.now() + "_" + dt.getHours() + ":" + dt.getMinutes() + " ");
            fr.append(text);
            fr.append("\n");
        }
    }
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
}
