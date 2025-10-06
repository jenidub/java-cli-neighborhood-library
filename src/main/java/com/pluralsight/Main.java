package com.pluralsight;

import java.lang.reflect.Array;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Variable declarations
        //• Use an array to hold an inventory of 20 books of your choice
        Book[] inventory = new Book[20];
        inventory[0] = new Book(1, "9780061120084", "To Kill a Mockingbird", false, "");
        inventory[1] = new Book(2, "9780451524935", "1984", true, "Alice Johnson");
        inventory[2] = new Book(3, "9780743273565", "The Great Gatsby", false, "");
        inventory[3] = new Book(4, "9780141439518", "Pride and Prejudice", true, "Michael Chen");
        inventory[4] = new Book(5, "9780316769488", "The Catcher in the Rye", false, "");
        inventory[5] = new Book(6, "9780547928227", "The Hobbit", true, "Sophia Brown");
        inventory[6] = new Book(7, "9781503280786", "Moby Dick", false, "");
        inventory[7] = new Book(8, "9780199232765", "War and Peace", false, "");
        inventory[8] = new Book(9, "9780486415871", "Crime and Punishment", true, "David Kim");
        inventory[9] = new Book(10, "9780140268867", "The Odyssey", false, "");
        inventory[10] = new Book(11, "9780140448955", "The Divine Comedy", true, "Liam Davis");
        inventory[11] = new Book(12, "9780141441146", "Jane Eyre", false, "");
        inventory[12] = new Book(13, "9780060850524", "Brave New World", false, "");
        inventory[13] = new Book(14, "9781451673319", "Fahrenheit 451", true, "Olivia Garcia");
        inventory[14] = new Book(15, "9780544003415", "The Lord of the Rings", false, "");
        inventory[15] = new Book(16, "9780061122415", "The Alchemist", false, "");
        inventory[16] = new Book(17, "9780316769488", "Of Mice and Men", true, "Ethan Martinez");
        inventory[17] = new Book(18, "9780143039433", "Animal Farm", false, "");
        inventory[18] = new Book(19, "9780553213119", "Dracula", true, "Emma Thompson");
        inventory[19] = new Book(20, "9780060935467", "The Road", false, "");

        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to JeniDub's Neighborhood Library!");

        // Run application until the user exits
        while (true) {
            // The Store Home Screen - The home screen should display a list of options that a user can choose from.
            System.out.println("\nHome Option Menu");
            System.out.println("Please select one of the options below:");
            System.out.println("""
                    [1] Show Available Books
                    [2] Show Checked Out Books
                    [3] Exit the Application
                    """);

            // User selects option
            String selection = scanner.nextLine();

            // Run the selected option based on the user's response
            switch (selection) {
                case "1":
                    // loop through the inventory and show if the Book property is isCheckedOut = false
                    System.out.println("\nHere is the list of available books:");
                    for (int i = 0; i < inventory.length; i++) {
                        Book currentBook = inventory[i];
                        if (currentBook.getIsCheckedOut() == false) {
                            System.out.printf("Book #%s: %s - ISBN #%s%n", currentBook.getId(), currentBook.getTitle(), currentBook.getIsbn());
                        }
                    }

                    // Prompt the user to either select a book to check out, or exit to go back to the home screen
                    // System.out.println("Do you want to checkout a book today?  (Y/N)    ");
                    System.out.println("""
                             \nAvailable Book Options
                             ************************
                             Please choose from one of the following options:
                             [C] Check out a book
                             [X] Return to the Home Screen
                             """);
                    String checkoutChoiceOption1 = scanner.nextLine();

                    // If the user wants to check out a book, prompt them for their name then check out the book
                    if (checkoutChoiceOption1.equalsIgnoreCase("c")) {
                        // user picks the book by ID number
                        System.out.println("Which book do you want to checkout? Please enter the ID number     ");
                        int bookID = Integer.parseInt(scanner.nextLine());

                        // find the book in the inventory by using the ID number - 1 [zero index]
                        Book selectedBook = inventory[bookID - 1];

                        System.out.println("Please enter the borrower's name?    ");
                        String borrowerName = scanner.nextLine();
                        selectedBook.checkOut(borrowerName);
                        System.out.printf("Receipt: %s has borrowed %s - you can borrow the book for up to 21 days%n", selectedBook.getCheckedOutTo(), selectedBook.getTitle());
                    }
                    break;

                case "2":
                    System.out.println("Here is the list of checked out books:");
                    // loop through the inventory and show if the Book property isCheckedOut = true
                    for (int i = 0; i < inventory.length; i++) {
                        Book currentBook = inventory[i];
                        if (currentBook.getIsCheckedOut() == true) {
                            System.out.printf("Book #%s: %s - ISBN #%s | Checked out by %s%n", currentBook.getId(), currentBook.getTitle(), currentBook.getIsbn(), currentBook.getCheckedOutTo());
                        }
                    }

                    // Prompt the user to either select a book to check out, or exit to go back to the home screen
                    System.out.println("""
                             \nChecked Out Book Options
                             ************************
                             Please choose from one of the following options:
                             [C] Check in a book
                             [X] Return to the Home Screen
                             """);
                    String checkoutChoiceOption2 = scanner.nextLine();

                    // If the user wants to check a book back in, prompt them for their name then check out the book
                    if (checkoutChoiceOption2.equalsIgnoreCase("c")) {
                        // user picks the book by ID number
                        System.out.println("Which book do you want to check in? Please enter the ID number     ");
                        int bookID = Integer.parseInt(scanner.nextLine());

                        // find the book in the inventory by using the ID number - 1 [zero index]
                        Book selectedBook = inventory[bookID - 1];

                        System.out.println("Please enter the borrower's name?    ");
                        String borrowerName = scanner.nextLine();
                        selectedBook.checkIn();
                        System.out.printf("Receipt: %s has been returned and is now available for check-out%n", selectedBook.getTitle());
                    }
                    break;

                case "3":
                    System.out.println("Thank you for using our application. Have a nice day!");
                    return;
            }
        }
    }
}
