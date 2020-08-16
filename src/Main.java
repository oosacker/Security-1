import java.io.*;
import java.security.*;
import java.util.ArrayList;

public class Main {
	

	public Main() throws Exception {
		measureTime();
	}

	public static void main(String[] args) throws Exception {
		new Main();
	}
	
	public void measureTime() throws Exception {

		int num;
		int length;

		length = 1024;
		
		num = 10;
		generateKeys(num, length);

		num = 20;
		generateKeys(num, length);

		num = 50;
		generateKeys(num, length);

		num = 100;
		generateKeys(num, length);

		num = 200;
		generateKeys(num, length);

		num = 500;
		generateKeys(num, length);

		num = 1000;
		generateKeys(num, length);

		
		
		
//		length = 2048;
//		
//		num = 10;
//		generateKeys(num, length);
//
//		num = 20;
//		generateKeys(num, length);
//
//		num = 50;
//		generateKeys(num, length);
//
//		num = 100;
//		generateKeys(num, length);
//
//		num = 200;
//		generateKeys(num, length);
//
//		num = 500;
//		generateKeys(num, length);
//
//		num = 1000;
//		generateKeys(num, length);
		
		
	}
	
	
	
	public void generateKeys(int num, int length) throws Exception {
		
		ArrayList<String> times = new ArrayList<String>();
		long start, time;
		
		for(int i=0; i<num; i++) {
			
			start = System.nanoTime();
			
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(length);
			KeyPair pair = keyPairGen.generateKeyPair();
			
			time = System.nanoTime() - start;		
			times.add(Long.toString(time));
			
		}
		
		String filename = length+"length-"+num+"pairs.csv";
		PrintWriter writer = new PrintWriter(filename, "UTF-8");
		
		for(int i=0; i<times.size(); i++) {
			writer.print(times.get(i));
			writer.print(",\r\n");
		}
		writer.close();
		System.out.println(filename);
	}

}
