package Client;

import javax.swing.*;

public interface ClientView {
    void connectToServer();
    void sendMessage(JTextField tf);
    void disconnectFromServer();
}
