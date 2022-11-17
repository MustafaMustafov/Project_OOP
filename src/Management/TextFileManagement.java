package Management;

import java.io.*;
import java.util.ArrayList;

public class TextFileManagement {
    public static void writeToFile(String text,String fileName) {
        try {
            FileWriter fileOut = new FileWriter( "project/ProgramFiles/" + fileName);
            BufferedWriter bw = new BufferedWriter(fileOut);
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("File can not be written!");
        }
        System.out.println("file was written!");
    }

        public static String readFromFile(String fileName){
        String temp = "";
            try{
                FileReader fr = new FileReader( "project/ProgramFiles/" + fileName);
                BufferedReader br = new BufferedReader(fr);
                temp = br.readLine();
                }   catch (IOException e){
                    System.out.println("File was not found or is empty!");
                    }
            return temp;
        }
}
