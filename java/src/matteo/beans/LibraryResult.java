package matteo.beans;

import java.util.ArrayList;

public class LibraryResult {

    private int id;
    private ArrayList<Book> scannedBooks;

    public LibraryResult(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  void addBook (Book b){
        scannedBooks.add(b);
    }

    public ArrayList<Book> getBooksList() {
        return scannedBooks;
    }

    public void setScannedBooks(ArrayList<Book> scannedBooks) {
        this.scannedBooks = scannedBooks;
    }
}
