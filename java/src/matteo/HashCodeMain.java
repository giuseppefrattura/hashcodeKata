package matteo;

import matteo.beans.Book;
import matteo.beans.Library;
import matteo.beans.LibraryResult;
import matteo.beans.Result;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class HashCodeMain {

    public static void main(String[] args) throws IOException {

        // model
        int totalBooks;
        int totalLibraries;
        int totalDays;
        ArrayList<Book> allBooks = new ArrayList<>();
        ArrayList<Book> scannedBooks = new ArrayList<>();
        HashMap<Integer, Book> mapIdToScannedBook = new HashMap<>();
        HashMap<Integer, Library> mapBookIdToLibrary = new HashMap<>();
        ArrayList<Library> allLibraries = new ArrayList<>();
        ArrayList<Library> signedUpLibraries = new ArrayList<>();

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
                        return 1;
                    else
                        return 0;
                }
            });

            allLibraries.get(i).setBooksList(booksOfThisLibrary);
        }


        /////////////////////////////////

        for (int actualDay=0; actualDay < totalDays; actualDay++) {

            // calcolo il coefficiiente
            for (Library l : allLibraries) {
                int remainingDays = totalDays - l.getSignupDays() - actualDay;
                int totalBooksValue = 0;
                for (Book currentBook : l.getBooksList()) {
                    totalBooksValue += currentBook.getScore();
                }

                l.setCoefficient(totalBooksValue * remainingDays / l.getSignupDays());
            }

            // ordino le librerie per coefficiente
            Collections.sort(allLibraries, new Comparator<Library>() {
                @Override
                public int compare(Library o1, Library o2) {
                    if (o1.getCoefficient() > o2.getCoefficient())
                        return 1;
                    if (o1.getCoefficient() < o2.getCoefficient())
                        return -1;
                    else
                        return 0;
                }
            });

            if (allLibraries.get(0).getSignupDays() > 0) {
                // la libreria si sta iscrivendo
                allLibraries.get(0).decrementSignupDays();
            }
            else if (allLibraries.get(0).getSignupDays() == 0){
                // la libreria è iscritta
                signedUpLibraries.add( allLibraries.remove(0));
            }

            for (Library l : signedUpLibraries){
                //inviamo i libri
                for (int k=0; k < l.getBooksPerDay(); k++){
                    // map ID -> BOOK     --> duplicati gestiti correttamente
                    if (mapIdToScannedBook.get(l.getBooksList().get(0).getId()) == null){
                        // ancora da inviare
                        mapBookIdToLibrary.put(l.getBooksList().get(0).getId(), l); //mappa x risultato
                        mapIdToScannedBook.put(l.getBooksList().get(0).getId(), l.getBooksList().remove(0));
                    }
                    else {
                        // già inviato. rimuovere
                        l.getBooksList().remove(0);
                    }

                }
            }

        }

        Result result = new Result();
        for (Library l : signedUpLibraries){
            LibraryResult libRes = new LibraryResult(l.getId());
            for (Integer bookId : mapBookIdToLibrary.keySet()){
                if (mapBookIdToLibrary.get(bookId).getId() == l.getId()){
                    // FIXME
                    libRes.addBook(allBooks.get(bookId));
                }
            }
            result.addLibrary(libRes);
        }

        MyFileWriter writer = new MyFileWriter();
        writer.writeFile(result);
        

    }
}
