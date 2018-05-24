import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BookLibraryModification {
    public static void main(String[] args) {
        ArrayList<MyBook> books = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            books.add(readBook(scan));
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(scan.nextLine(), df);
        books.stream()
                .filter((x) -> x.getReleaseDate().isAfter(date))
                .sorted(Comparator.comparing(MyBook::getReleaseDate)
                        .thenComparing(MyBook::getTitle))
                .forEach((x) -> System.out.printf("%s -> %s%n", x.getTitle(), x.getReleaseDate().format(df)));
    }

    private static MyBook readBook(Scanner scan) {
        String[] inputs = scan.nextLine().split(" ");
        String title = inputs[0];
        String author = inputs[1];
        String publisher = inputs[2];
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate releaseDate = LocalDate.parse(inputs[3], df);
        int ISBN = Integer.parseInt(inputs[4]);
        double price = Double.parseDouble(inputs[5]);
        return new MyBook(title, author, publisher, releaseDate, ISBN, price);
    }
}

class MyBook {
    private String title;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    private int ISBN;
    private double price;

    public MyBook(String title, String author, String publisher, LocalDate releaseDate, int ISBN, double price) {
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