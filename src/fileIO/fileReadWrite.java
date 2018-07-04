package fileIO;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class fileReadWrite {
	
	List<String> lines = new ArrayList<String>();
	String line = null;
	public static void main(String[] args) {
        try
        {
            BufferedReader oldScript = new BufferedReader(new FileReader("data/Fit_StratABM_Cal.gms"));
            String line;
            String script = "";
            while ((line = oldScript.readLine()) != null) 
            {
                // Edit line in the script
            	// Modify number of agents
                if (line.contains("gn_inAnalysis ="))
                {
                    line = String.format("gn_inAnalysis =%d", 10000000);
                    System.out.println(line);
                }
             // Modify price
                if (line.contains("Price of silage maize"))
                {
                    line = String.format("p_cropPrice    \"Price of silage maize €/dt\" /%.4f/", 4.3784);
                    System.out.println(line);
                }
                // Modify year number (two lines concerned)
                if (line.contains("p_yieldMdm(gn,'t"))
                {
                    line = String.format("p_attyield(gn) =  p_yieldMdm(gn,'t%d')/p_drymatter * 10 * (1 + p_affYieldShare);", 2008);
                    System.out.println(line);
                }
                if (line.contains("p_TDistribution(gn,'t"))
                {
                    line = String.format("/ [100 * ( exp(p_CRate * p_TDistribution(gn,'t%d',s_process) )", 2008);
                    System.out.println(line);
                }
                
                script += line + '\n';
            }
            oldScript.close();
            FileOutputStream newScript = new FileOutputStream("data/Fit_StratABM_Cal.gms");
            newScript.write(script.getBytes());
            
            newScript.close();

        }
        catch (IOException ioe)
        {
        ioe.printStackTrace();
        }
	}
}