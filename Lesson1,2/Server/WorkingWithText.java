package Server;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface WorkingWithText {
    void sendTextIntoDatabase(String text, String name);
    String getText() throws IOException;
}
