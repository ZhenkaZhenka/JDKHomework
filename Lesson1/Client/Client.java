package Client;

import Server.ChatServer;

import javax.swing.*;
import java.io.IOException;

public class Client implements ClientView{
    String name;
    ClientGUI clientGUI;
    ChatServer chatServer;
    private boolean connected;

    Client(ClientGUI cc, ChatServer cs){
        clientGUI = cc;
        chatServer = cs;
    }

    @Override
    public void connectToServer() {
        if (clientGUI.checkLogin(clientGUI.getTab1().getValueAt(1, 0).toString())
                && clientGUI.checkPassword(clientGUI.getTab2().getValueAt(1, 0).toString())) {
            setConnected(true);
            name = clientGUI.getTab1().getValueAt(1, 0).toString();
            clientGUI.remove(clientGUI.getHeader());
            clientGUI.repaint();
            JOptionPane.showMessageDialog(clientGUI, "Log in successful");
        } else {
            JOptionPane.showMessageDialog(clientGUI, "Wrong login or password");
        }
    }

    @Override
    public void sendMessage(JTextField ta){
        try {
            if(chatServer.getStatus()) {
                if(isConnected()) {
                    chatServer.sendTextIntoDatabase(ta.getText());
                    ta.setText(null);
                    System.out.println("Сообщение отправлено");
                    clientGUI.update();
                    clientGUI.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(clientGUI,"You didn't sign in");
                }
            } else {
                JOptionPane.showMessageDialog(clientGUI,"Server is stopped, you can't send messages");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void disconnectFromServer() {
        setConnected(false);
        JOptionPane.showMessageDialog(clientGUI,"You was disconnected from server");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientGUI getChatClient() {
        return clientGUI;
    }

    public void setChatClient(ClientGUI clientGUI) {
        this.clientGUI = clientGUI;
    }

    public ChatServer getChatServer() {
        return chatServer;
    }

    public void setChatServer(ChatServer chatServer) {
        this.chatServer = chatServer;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
