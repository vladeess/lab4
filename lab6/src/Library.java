import java.util.List;

public class Library {
    private String name;
    private BookRepository bookRepository;

    public Library(String name) {
        this.name = name;
        this.bookRepository = new BookRepository();
    }

    public String getName() {
        return this.name;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void removeBook(Book book) {
        bookRepository.removeBook(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author);
    }

    public void updateBook(Book oldBook, Book newBook) {
        bookRepository.updateBook(oldBook, newBook);
    }

    public void displayAllBooks() {
        bookRepository.displayAllBooks();
    }
}
