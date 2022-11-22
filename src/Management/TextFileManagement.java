package Management;

import java.io.*;

public class TextFileManagement {
    public static void writeToFile(String text,String fileName) {
        try {
            FileWriter fileOut = new FileWriter( "ProgramFiles/" + fileName);
            BufferedWriter bw = new BufferedWriter(fileOut);
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("File can not be written!");
        }
    }

        public static String readFromFile(String fileName){
        String temp = "";
            try{
                FileReader fr = new FileReader( "ProgramFiles/" + fileName);
                BufferedReader br = new BufferedReader(fr);
                temp = br.readLine();
                }   catch (IOException e){
                    System.out.println("File was not found or is empty!");
                    }
            return temp;
        }
}
