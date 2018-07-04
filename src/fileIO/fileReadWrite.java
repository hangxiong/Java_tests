package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class fileReadWrite {
		
	
	
	public static void main(String[] args) {
		String MPspecificInputFile = "./data/yearly_prices.csv";
		
		String Line;
		ArrayList<String> yearPrice;
		BufferedReader Buffer = null;		
		Map<String, Double> year_priceMap = new HashMap<>();
		
		try {
 			// read input file
			Buffer = new BufferedReader(new FileReader(MPspecificInputFile));
			Line = Buffer.readLine();									       // first line with titles to throw away
			while ((Line = Buffer.readLine()) != null) { 
				yearPrice = CSVtoArrayList(Line);						   // Read farm's parameters line by line
				year_priceMap.put(yearPrice.get(0), Double.parseDouble(yearPrice.get(1)));
			}
			System.out.println(year_priceMap);
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (Buffer != null) Buffer.close();
			} catch (IOException Exception) {
				Exception.printStackTrace();
			}
		}
	}
	
	private static ArrayList<String> CSVtoArrayList(String CSV) {		       
		ArrayList<String> Result = new ArrayList<String>();
		
		if (CSV != null) {
			String[] splitData = CSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					Result.add(splitData[i].trim());
				}
			}
		}
		return Result;
	}
	
}


/* Code for editing the GAMS script

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
                    line = String.format("p_cropPrice    \"Price of silage maize Euro/dt\" /%.4f/", 4.3784);
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

*/