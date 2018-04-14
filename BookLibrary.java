import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BookLibrary {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            books.add(readBook(scan, authors));
        }
        authors.stream()
                .distinct()
                .sorted(Comparator.comparing((x) -> books.stream()
                        .filter((y) -> y.getAuthor().equals(x))
                        .mapToDouble(Book::getPrice)
                        .sum(), Comparator.reverseOrder())
                        .thenComparing(Object::toString))
                .forEach((x) -> System.out.printf("%s -> %.2f%n", x,
                        books.stream()
                                .filter((y) -> y.getAuthor().equals(x))
                                .mapToDouble(Book::getPrice)
                                .sum()));
    }

    private static Book readBook(Scanner scan, ArrayList<String> authors) {
        String[] inputs = scan.nextLine().split(" ");
        String title = inputs[0];
        String author = inputs[1];
        String publisher = inputs[2];
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate releaseDate = LocalDate.parse(inputs[3], df);
        int ISBN = Integer.parseInt(inputs[4]);
        double price = Double.parseDouble(inputs[5]);
        authors.add(author);
        return new Book(title, author, publisher, releaseDate, ISBN, price);
    }
}

class Book {
    private String title;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    private int ISBN;
    private double price;

    public Book(String title, String author, String publisher, LocalDate releaseDate, int ISBN, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }
}