package UI;

import Controller.BookController;
import Domain.Book;

import java.util.Scanner;

public class BookUI implements Runnable {
    private final BookController bookController;

    public BookUI(BookController bookController) {
        this.bookController = bookController;
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            Scanner input = new Scanner(System.in);
            System.out.println("===Books Interface===");
            System.out.println("1. Register new book");
            System.out.println("2. Remove book");
            System.out.println("3. Display all books");
            System.out.println("4. Update book data");
            System.out.println("5. Find book");
            System.out.println("6. Quit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    registerNewBookUI();
                    break;
                case 2:
                    removeBookUI();
                    break;
                case 3:
                    displayAllBooksUI();
                    break;
                case 4:
                    updateBookUI();
                    break;
                case 5:
                    findBookUI();
                    break;
                case 6:
                    running = false;
            }
        }
    }

    private void registerNewBookUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the book name: ");
        String bookName = input.nextLine();
        System.out.println("Please enter the author: ");
        String author = input.nextLine();
        long min = 100000000L;
        long max = 999999999L;
        long isbnGerado = (long) (Math.random() * (max - min + 1)) + min;
        int isbn = (int) (isbnGerado);
        bookController.registerNewBook(bookName, author, isbn);
    }

    private void removeBookUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the book isbn: ");
        int isbn = input.nextInt();
        System.out.println("Book removed with success! " + bookController.getBookRepo().getBookByISBN(isbn).toString());
        bookController.getBookRepo().removeBook(isbn);
    }

    public void findBookUI() {
        boolean loop = true;
        while (loop) {
            Scanner input = new Scanner(System.in);
            System.out.println("1. By name ?");
            System.out.println("2. By author ?");
            System.out.println("3. Quit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    finfBookByName();
                    break;
                case 2:
                    finfBookbyAuthor();
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }

    }

    private void finfBookByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Book name: ");
        String name = input.nextLine();
        System.out.println(bookController.getBookRepo().getBookByName(name).toString());
    }

    private void finfBookbyAuthor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Book Author: ");
        String author = input.nextLine();
        System.out.println(bookController.getBookRepo().getBookByAuthor(author).toString());
    }

    private void updateBookUI() {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter Book ISBN: ");
        int isbn = input.nextInt();
        System.out.println("Is Book Available? (Y/N): ");
        String av = input2.nextLine();
        if (av.equals("Y")) {
            bookController.getBookRepo().getBookByISBN(isbn).setAvailable(true);
        } else if (av.equals("N")) {
            bookController.getBookRepo().getBookByISBN(isbn).setAvailable(false);
        }
    }

    private void displayAllBooksUI() {
        for (Book book : bookController.getBookRepo().getAllBooks()) {
            System.out.println(book.toString());
        }
    }
}
