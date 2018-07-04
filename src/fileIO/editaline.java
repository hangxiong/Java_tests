package fileIO;

import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
/*
public class editaline {
    public static void main(String[] args) throws Exception {               
        File file = null;
        FileReader fr = null;
        LineNumberReader lnr = null;
 
        try {
            Scanner input=new Scanner(System.in);
            System.out.print("Enter record to edit ");
            String word=input.next();
            file = new File("file.txt");
            fr = new FileReader(file);            
            lnr = new LineNumberReader(fr);
            String line = "";
 
            while ((line = lnr.readLine()) != null) {
                if(line.startsWith(word)){
 
                System.out.println("Line Number " + lnr.getLineNumber() + ": " + line);
                String[] st = line.split(" ");
                String date = st[0];
                String event = st[1];
 
                System.out.print("Replace With: ");
                String newtext=input.next();
                FileWriter writer = new FileWriter("file.txt");
                writer.write(line.replace(event, newtext));
                writer.close();
                }     
 
            }
        } 
       finally {
            if (fr != null) {
                fr.close();
            }
            if (lnr != null) {
                lnr.close();
            }
        }
    }
}

*/