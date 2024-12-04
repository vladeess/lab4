public class Main {
    private Library library1;
    private Library library2;

    public Main() {
        library1 = new Library("Центральная библиотека");
        library2 = new Library("Сообщество библиотек");

        library1.addBook(new Book("1984", "Джордж Оруэлл", 1949));
        library1.addBook(new Book("Скотный двор", "Джордж Оруэлл", 1945));
        library1.addBook(new Book("Убить пересмешника", "Харпер Ли", 1960));

        library2.addBook(new Book("О дивный новый мир", "Олдос Хаксли", 1932));
        library2.addBook(new Book("1984", "Джордж Оруэлл", 1949));
    }

    public void displayBooksByAuthor(String author) {
        System.out.println("Книги автора " + author + " в " + library1.getName() + ":");
        for (Book book : library1.getBooksByAuthor(author)) {
            book.displayInfo();
        }

        System.out.println("\nКниги автора " + author + " в " + library2.getName() + ":");
        for (Book book : library2.getBooksByAuthor(author)) {
            book.displayInfo();
        }
    }

    public void displaySpecificBookInfo() {
        System.out.println("\nИнформация о конкретной книге:");
        Book specificBook = library1.getBooksByAuthor("Джордж Оруэлл").get(0);
        specificBook.displayInfo();
    }

    public void displayAllBooks() {
        System.out.println("\nВсе книги в " + library1.getName() + ":");
        library1.displayAllBooks();

        System.out.println("\nВсе книги в " + library2.getName() + ":");
        library2.displayAllBooks();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.displayBooksByAuthor("Джордж Оруэлл");
        main.displaySpecificBookInfo();
        main.displayAllBooks(); // Вызов нового метода
    }
}