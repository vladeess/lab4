import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.removeIf(b -> b.getTitle().equalsIgnoreCase(book.getTitle()));
    }

    public List<Book> getBooksByAuthor(String author) {
        if (author == null || author.isEmpty()) {
            return new ArrayList<>(books);
        }
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
        }
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }
}
