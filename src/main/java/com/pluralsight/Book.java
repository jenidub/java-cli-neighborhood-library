package com.pluralsight;

public class Book {
    // Class Book property variables
    int id;
    String isbn;
    String title;
    Boolean isCheckedOut;
    String checkedOutTo;

    // Constructor
    public Book (int id, String isbn, String title, Boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(Boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Methods
    public void checkOut (String name) {
        //        When a book is checked out
        //        o the books checkedOutTo variable should be set to the name
        //                provided
        //        o the isCheckedOut variable should be set to true
        setCheckedOutTo(name);
        setIsCheckedOut(true);
    }

    public void checkIn () {
        //        When a book is checked in
        //        o the books checkedOutTo variable should be set to ""
        //        o the isCheckedOut variable should be set to false
        setCheckedOutTo("");
        setIsCheckedOut(false);
    }

}
