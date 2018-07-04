package fileIO;
/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileReplace {
	
	List<String> lines = new ArrayList<String>();
	String line = null;
	public void  main() {
	try {
	    File f1 = new File("data/Fit_StratABM_Cal.gms");
	    FileReader fr = new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr);
	    while ((line = br.readLine()) != null) {
	        if (line.contains("gn_inAnalysis ="))
	        	System.out.println(this.line);
	            //line = line.replace(this.line, String.format("gn_inAnalysis =%d", 100));
	        lines.add(line);
	    }
	    fr.close();
	    br.close();
	
	    FileWriter fw = new FileWriter(f1);
	    BufferedWriter out = new BufferedWriter(fw);
	    for(String s : lines)
	         out.write(s);
	    out.flush();
	            
	    out.close();
	    } 
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	}
}







         try
             {
             File file = new File("data/Fit_StratABM_Cal.gms");
             BufferedReader reader = new BufferedReader(new FileReader(file));
             String line = "", oldScript = "";
             while((line = reader.readLine()) != null)
                 {
                 oldScript += line + "\r\n";
             }
             
             reader.close();
             
             System.out.println(oldScript);
             // replace a word in a file
             //String newScript = oldScript.replaceAll("drink", "Love");
            
             //To replace a line in a file
             
             String newScript = oldScript.replaceAll("gn_inAnalysis =20;", String.format("gn_inAnalysis =%d", 100));
             System.out.println(newScript.length());
             FileWriter writer = new FileWriter("data/Fit_StratABM_Cal_new.gms");
             writer.write(newScript);
             writer.close();
             
         }
         catch (IOException ioe)
             {
             ioe.printStackTrace();
         }


*/