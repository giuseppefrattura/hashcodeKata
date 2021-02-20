
import matteo.beans.Book;
import matteo.beans.Library;
import matteo.beans.Result;

import java.io.*;


public class FileWriter {

    public void writeFile(Result result) throws IOException {
        File fout = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        int totLibraries = result.getAllLibraries().size();
        bw.write(String.valueOf(totLibraries));
        bw.newLine();

        //Logica
        Library library;
        for (int i = 0; i < totLibraries; i++) {
            library = result.getAllLibraries().get(i);
            bw.write(String.valueOf(library.getId()) +" " + String.valueOf(library.getBooksList().size()));
            bw.newLine();
            String bookIdString= "";
            for (Book booksList : library.getBooksList()){
                bookIdString += booksList.getId() + " ";
            }
            bw.write(bookIdString);
            bw.newLine();
        }

        bw.close();
    }

}
