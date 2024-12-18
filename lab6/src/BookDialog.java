import javax.swing.*;
import java.awt.*;

public class BookDialog {
    public static Book showDialog(JFrame parent) {
        return showDialog(parent, null);
    }

    public static Book showDialog(JFrame parent, Book existingBook) {
        JTextField titleField = new JTextField(existingBook != null ? existingBook.getTitle() : "", 20);
        JTextField authorField = new JTextField(existingBook != null ? existingBook.getAuthor() : "", 20);
        JTextField yearField = new JTextField(existingBook != null ? String.valueOf(existingBook.getYear()) : "", 20);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Название книги:"));
        panel.add(titleField);
        panel.add(new JLabel("Автор:"));
        panel.add(authorField);
        panel.add(new JLabel("Год издания:"));
        panel.add(yearField);

        int result = JOptionPane.showConfirmDialog(parent, panel, "Данные книги",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                int year = Integer.parseInt(yearField.getText().trim());
                if (!title.isEmpty() && !author.isEmpty()) {
                    return new Book(title, author, year);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent, "Некорректный формат года", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
}
