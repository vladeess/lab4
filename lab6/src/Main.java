import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("Центральная библиотека");
        library.addBook(new Book("1984", "Джордж Оруэлл", 1949));
        library.addBook(new Book("Скотный двор", "Джордж Оруэлл", 1945));
        library.addBook(new Book("Убить пересмешника", "Харпер Ли", 1960));

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(library);
            mainFrame.setVisible(true);
        });
    }
}
