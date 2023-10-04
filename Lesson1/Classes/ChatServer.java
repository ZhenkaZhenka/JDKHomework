package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ChatServer extends JFrame {
    private String path = "C:/Users/Евгений/Desktop/JDKHomework/Lesson1/Classes/Text.txt";

    private static final String LOGIN = "1111";
    private static final String PASSWORD = "1111";

    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;

    private boolean status = false;

    public Boolean getStatus(){
        return status;
    }

    ChatServer() throws IOException {
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
                status = true;
                System.out.println("Server turned on");
            }
        });

        JButton btnStop = new JButton("Stop server");

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status = false;
                System.out.println("Server stopped");
            }
        });
        panButtons.add(btnStart);
        panButtons.add(btnStop);
        return panButtons;
    }

    protected void sendTextIntoDatabase(String text) throws IOException {
        try(FileWriter fr = new FileWriter(path, true)){
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
}
