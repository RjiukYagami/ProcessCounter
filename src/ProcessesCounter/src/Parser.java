import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Parser {
	public void parse(HashMap<String, Integer> counter){
		try {
			String line;
		    Process p = Runtime.getRuntime().exec("ps -e");
		    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        
		    
		    /*
		     * in first line we check where "CMD" string begins so we substring 
		     * all names from it, it's good that ps is actually so well formated
		     */
		    boolean first = true;
		    int index = 0;// index where we begin substring
		    
		    while ((line = input.readLine()) != null) {
		    	if(first){
		    		index = line.lastIndexOf('C');
		    		first = false;
		    	} else {
		    		String command = line.substring(index);
		    		if(counter.containsKey(command)){
		    			counter.replace(command, counter.get(command)+1);
		    		}
		    		else 
		    			counter.put(command, 1);
		    		
		    	}
		    }
		    input.close();
		} catch (Exception err) {
		    err.printStackTrace();
		}
	}
}
