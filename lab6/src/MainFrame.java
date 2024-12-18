import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Library library;

    public MainFrame(Library library) {
        this.library = library;
        setTitle("Управление библиотекой");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Панель для отображения списка книг
        JTextArea bookDisplayArea = new JTextArea();
        bookDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookDisplayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Панель управления
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 3));

        // Кнопка "Добавить книгу"
        JButton addBookButton = new JButton("Добавить книгу");
        addBookButton.addActionListener(e -> {
            Book book = BookDialog.showDialog(this);
            if (book != null) {
                library.addBook(book);
                updateBookDisplay(bookDisplayArea);
            }
        });
        controlPanel.add(addBookButton);

        // Кнопка "Удалить книгу"
        JButton removeBookButton = new JButton("Удалить книгу");
        removeBookButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(this, "Введите название книги для удаления:");
            if (title != null && !title.trim().isEmpty()) {
                library.removeBook(new Book(title, "", 0)); // Поиск по названию
                updateBookDisplay(bookDisplayArea);
            }
        });
        controlPanel.add(removeBookButton);

        // Кнопка "Обновить книгу"
        JButton updateBookButton = new JButton("Обновить книгу");
        updateBookButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(this, "Введите название книги для обновления:");
            if (title != null && !title.trim().isEmpty()) {
                Book oldBook = library.getBooksByAuthor("").stream()
                        .filter(book -> book.getTitle().equalsIgnoreCase(title))
                        .findFirst().orElse(null);

                if (oldBook != null) {
                    Book newBook = BookDialog.showDialog(this, oldBook);
                    if (newBook != null) {
                        library.updateBook(oldBook, newBook);
                        updateBookDisplay(bookDisplayArea);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Книга не найдена!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        controlPanel.add(updateBookButton);

        add(controlPanel, BorderLayout.SOUTH);
        updateBookDisplay(bookDisplayArea);
    }

    private void updateBookDisplay(JTextArea bookDisplayArea) {
        StringBuilder displayText = new StringBuilder();
        for (Book book : library.getBooksByAuthor("")) {
            displayText.append(book).append("\n");
        }
        bookDisplayArea.setText(displayText.toString());
    }
}
