import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Parser {
	public void parse(){
		try {
			String line;
		    Process p = Runtime.getRuntime().exec("ps -e");
		    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        
		    boolean first = true;
		    int index = 0;
		    while ((line = input.readLine()) != null) {
		    	if(first){
		    		index = line.lastIndexOf('C');
		    		first = false;
		    	} else {
		    		System.out.println(line.substring(index));
		    	}
		    }
		    input.close();
		} catch (Exception err) {
		    err.printStackTrace();
		}
	}
}
