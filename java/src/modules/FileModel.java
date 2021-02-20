package modules;

import java.util.ArrayList;
import java.util.List;

public class FileModel{
    int booksCount;
    int libraryCount;
    int time;
    int[] bookValues;


    List<Library> libraries;

    public FileModel(int booksCount, int libraryCount, int time, int[] bookValues) {
        this.booksCount = booksCount;
        this.libraryCount = libraryCount;
        this.time = time;
        this.bookValues = bookValues;
        this.libraries = new ArrayList<>();
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

    public int getLibraryCount() {
        return libraryCount;
    }

    public void setLibraryCount(int libraryCount) {
        this.libraryCount = libraryCount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int[] getBookValues() {
        return bookValues;
    }

    public void setBookValues(int[] bookValues) {
        this.bookValues = bookValues;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }


    public void addLibrary(Library l) {
        this.libraries.add(l);
    }

}