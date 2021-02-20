package matteo;

import matteo.beans.Book;
import matteo.beans.Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HashCodeMain {

    public static void main(String[] args) throws IOException {

        // model
        int totalBooks;
        int totalLibraries;
        int totalDays;
        ArrayList<Book> allBooks = new ArrayList<>();
        ArrayList<Library> allLibraries = new ArrayList<>();

        // per leggere da file
        String input    = null;
        String[] words  = null;
        BufferedReader reader = new BufferedReader(new FileReader("java/resources/a.in"));


        // leggo prima riga
        input = reader.readLine();
        words = input.split(" ");
        totalBooks      = Integer.parseInt(words[0]);
        totalLibraries  = Integer.parseInt(words[1]);
        totalDays       = Integer.parseInt(words[2]);

        // leggo seconda riga
        input = reader.readLine();
        // Creo una lista di libri con id, valore
        words = input.split(" ");
        for (int i=0; i<totalBooks; i++){
            allBooks.add(       // Book(id, score)
                    new Book(i, Integer.parseInt(words[i])));
        }

        // Creo una lista di librerie con id, giorni per registrazione, libri al giorno, lista di libri posseduti
        for (int i=0; i<totalLibraries; i++){
            input = reader.readLine();
            words = input.split(" ");
            int numberOfBooks = Integer.parseInt(words[0]);
            allLibraries.add(       // Library(id, signupDays, booksPerDay)
                    new Library(i, Integer.parseInt(words[1]), Integer.parseInt(words[2])));

            input = reader.readLine();
            words = input.split(" ");
            ArrayList<Book> booksOfThisLibrary = new ArrayList<>();
            // Creo lista di libri posseduti con id, valore
            for (int j=0; j<numberOfBooks; j++){
                booksOfThisLibrary.add(      // Book(id, score)
                        new Book(Integer.parseInt(words[j]), allBooks.get(Integer.parseInt(words[j])).getScore()));
            }

            // ordino i libri per valore decrescente
            Collections.sort(booksOfThisLibrary, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    if (o1.getScore() > o2.getScore())
                        return -1;
                    if (o1.getScore() < o2.getScore())
                        return  11;
                    else
                        return 0;
                }
            });

            allLibraries.get(i).setBooksList(booksOfThisLibrary);
        }


        /////////////////////////////////

        for (Library l : allLibraries){

        }







        // try to print out total value of books owned by all libraries
        int totalScore = 0;
        for (Library l: allLibraries){
            for (Book b: l.getBooksList()){
                System.out.println("score " + b.getScore());
                totalScore += b.getScore();
            }
        }
        System.out.println(totalScore);

    }
}
