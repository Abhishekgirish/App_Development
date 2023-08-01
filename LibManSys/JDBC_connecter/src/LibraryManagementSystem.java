import java.util.Scanner;
import java.sql.*;

public class LibraryManagementSystem {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    public static void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Borrow Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
    }

    public static boolean login()throws ClassNotFoundException,SQLException{
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public class User {
        private String username;
        private String password;
    
        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    
        public boolean authenticate(String inputUsername, String inputPassword) {
            return username.equals(inputUsername) && password.equals(inputPassword);
        }
    }
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose 1(user) or 2(admin)");

        int n = sc.nextInt();
        if (n==1)
         {
            
        System.out.print("Enter your username: ");
        String username = sc.next();
        System.out.print("Enter your password: ");
        String password = sc.next();
                      Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS","root", "Kannan327#");
   String s = "insert into users value(?,?)";
PreparedStatement st = connection.prepareStatement(s);
st.setString(1, username);
st.setString(2, password);
st.executeUpdate();
         }
         else
         {
             
             if (!login()) {
                 System.out.println("Invalid credentials. Exiting the Library Management System.");
                 return;
                }else{
                    System.out.println(ADMIN_USERNAME+" Welcome");
                }
                
                Library library = new Library();
                Scanner scanner = new Scanner(System.in);
                
                while (true) {
                    displayMenu();
                    System.out.print("Enter your choice (1/2/3/4/5): ");
                    String choice = scanner.nextLine();
                    
                    if (choice.equals("1")) {
                        System.out.print("Enter the title of the book: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter the author of the book: ");
                        String author = scanner.nextLine();
                        library.addBook(title, author);
                    } else if (choice.equals("2")) {
                        library.viewBooks();
                    } else if (choice.equals("3")) {
                        library.viewBooks();
                        System.out.print("Enter the index of the book you want to borrow: ");
                        int bookIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        library.borrowBook(bookIndex);
                    } else if (choice.equals("4")) {
                        library.viewBooks();
                        System.out.print("Enter the index of the book you want to delete: ");
                        int bookIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        library.deleteBook(bookIndex);
                    } else if (choice.equals("5")) {
                        System.out.println("Exiting the Library Management System. Goodbye!");
                        library.closeConnection();
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
                }
                
                sc.close();
            }
        }
        