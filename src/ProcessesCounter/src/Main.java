import java.util.HashMap;
import java.util.Map.Entry;


public class Main {
	
	public static void main(String[] args){
		final Parser par = new Parser();
		final HashMap<String, Integer> counter = new HashMap<String, Integer>();
		
		Thread th1 = new Thread(new Runnable(){

			public void run() {
				while(true){
					par.parse(counter);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(Entry<String, Integer> pair : counter.entrySet()){
						System.out.println(pair);
					}
				}
				
			}
			
		});
		
		th1.start();
		
		try {
			th1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
