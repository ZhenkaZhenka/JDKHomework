package Server;

import Client.ClientGUI;
import Client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ChatServer extends JFrame {
    private String path = "./Lesson1/dataStorage.txt";

    private static final String LOGIN = "1111";
    private static final String PASSWORD = "1111";

    protected ClientGUI chatClient;
    private History history;

    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;

    private boolean serverStatus = false;

    private ArrayList<Client> clients;

    public Boolean getStatus(){
        return serverStatus;
    }

    public ChatServer() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("ChatServer");

        history = new History(path);
        chatClient = new ClientGUI(this);

        add(getButtons());

        setVisible(true);
    }

    /**
     * Создание кнопок в окне работы с сервером. Если логирование не произошло, то
     * сервер не запустится.
     * @return Возвращает JPanel с кнопками вкл/выкл сервера
     */
    private Component getButtons(){
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        JButton btnStart = new JButton("Start server");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!serverStatus) {
                    if (chatClient.getClient().isConnected()) {
                        serverStatus = true;
                        chatClient.add(chatClient.getLog());
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
                    chatClient.clearData();
                    chatClient.getClient().disconnectFromServer();
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
    public String getLogin(){
        return LOGIN;
    }
    public String getPassword(){
        return PASSWORD;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
