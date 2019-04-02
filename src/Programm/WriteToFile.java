package Programm;

import java.io.*;

public class WriteToFile {
    File myFile = new File("text.txt");

        public void creationFunc(String str) {
            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
                writer.print(str);
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void deleteFunc() throws FileNotFoundException {
            PrintWriter pw = new PrintWriter("text.txt");
            pw.close();
         }

}
