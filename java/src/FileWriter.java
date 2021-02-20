
import matteo.beans.Book;
import matteo.beans.Library;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;


public class FileWriter {

    public void writeFile1() throws IOException {
        File fout = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        //Logica
        for (int i = 0; i < 10; i++) {
            bw.write("something");
            bw.newLine();
        }


        bw.close();
    }

}
