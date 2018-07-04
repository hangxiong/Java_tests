package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class fileReadWrite
{
     public static void main(String args[])
         {
    	 //List<String> lines = Files.readAllLines("data/Fit_StratABM_Cal.gms");
    	 //lines.set(100, "\"gn_inAnalysis =200;\"");
    	 //Files.write("data/Fit_StratABM_Calnewnew.gms", lines);
    	 Path gamsscript_path = Paths.get("data", "Fit_StratABM_Cal.gms");
    	    try {
    	        List<String> lines = Files.readAllLines(gamsscript_path,Charset.defaultCharset()); 

    	        //for (String line : lines) {
    	          //System.out.println(line);
    	        //}
    	        
    	        //System.out.println(lines.get(123));
    	        lines.set(123, "\"gn_inAnalysis =20000000000000000;\"");
    	      } catch (IOException e) {
    	        System.out.println(e);
    	      }
    	    
    	    
    	 
    	 //ReadFile file = new ReadFile("data/Fit_StratABM_Cal.gms");
         //String[] aryLines = file.OpenFile();
    	 


     }
}


