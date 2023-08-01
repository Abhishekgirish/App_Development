
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 interface Borrowable {
    // void viewBooks();
    int w=0;
    String m="";
    String n="";
    void deleteBook(int w);
    // void addBook(String m, String n);
    void borrowBook(int w);
    void closeConnection();
}
class Jambo{
     private List<Book> books=new ArrayList<Book>();
    private Connection connection;
    private final String DB_URL = "jdbc:mysql://localhost:3306/LMS?serverTimezone=UTC";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "Kannan327#";
     public void addBook(String title, String author) {
        try {
            String query = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setBoolean(3, true);
            statement.executeUpdate();

            Book book = new Book(title, author);
            System.out.print(book);

            books.add(book);

            statement.close();
            System.out.println("Book '" + title + "' by " + author + " added to the library.");
        } catch (SQLException e) {
            System.out.println("Error adding book to the database: " + e.getMessage());
        }
    }

}

public class  Library extends Jambo implements Borrowable{
    private List<Book> books;
    private Connection connection;
    private final String DB_URL = "jdbc:mysql://localhost:3306/LMS?serverTimezone=UTC";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "Kannan327#";
    public Library() {
        books = new ArrayList<>();  
        if (connectToDatabase()) {
            loadBooksFromDatabase();
        } else {
            System.out.println("Failed to connect to the database. Exiting Library Management System.");
            System.exit(1);
        }
    }

    private boolean connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the database.");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return false;
    }

    private void loadBooksFromDatabase() {
        try {
            String query = "SELECT * FROM books";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                boolean available = resultSet.getBoolean("available");
                Book book = new Book(title, author);
                book.setAvailable(available);
                books.add(book);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error loading books from the database: " + e.getMessage());
        }
    }
    
    
    
   
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
        } else {
            System.out.println("Available books in the library:");
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                String availability = book.isAvailable() ? "Available" : "Not Available";
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + " - " + availability);
            }
        }
    }


    public void borrowBook(int bookIndex) {
        if (bookIndex >= 1 && bookIndex <= books.size()) {
            Book book = books.get(bookIndex - 1);
            if (book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have borrowed '" + book.getTitle() + "' by " + book.getAuthor() + ".");
            } else {
                System.out.println("Sorry, the book is not available for borrowing.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
    


    public void deleteBook(int bookIndex) {
        if (bookIndex >= 1 && bookIndex <= books.size()) {
            Book book = books.get(bookIndex - 1);
            try {
                String query = "DELETE FROM books WHERE title=? AND author=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, book.getTitle());
                statement.setString(2, book.getAuthor());
                statement.executeUpdate();

                books.remove(book);
                statement.close();
                System.out.println("Book '" + book.getTitle() + "' by " + book.getAuthor() + " deleted from the library.");
            } catch (SQLException e) {
                System.out.println("Error deleting book from the database: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }
}
