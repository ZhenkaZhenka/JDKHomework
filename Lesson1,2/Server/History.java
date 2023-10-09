package Server;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class History  implements WorkingWithText{
    private String path;
    History(String path) throws IOException {
        if(Files.exists(Path.of(path))){
            this.path = path;
        } else {
            Files.createFile(Path.of(path));
        }
    }
    /**
     * Метод записи сообщения в файл
     * @param text - текст из сообщения
     * @param name - Логин пользователя
     * @throws IOException - появится, если файл не будет найден
     */
    public void sendTextIntoDatabase(String text, String name) {
        Date dt = new Date();
        try(FileWriter fr = new FileWriter(path, true)){
            fr.append(dt.getHours() + ":" + dt.getMinutes() + " " + name + ":");
            fr.append(text);
            fr.append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Сборка текста из файла для добавления в чат
     * @return Возвращает String значение с HTML-тегами для форматирования JLabel
     */
    public String getText() throws IOException {
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
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
