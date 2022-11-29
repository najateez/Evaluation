package EvaluationOne;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;


public class Main {

	public static void main(String[] args) {
		//najat
		Scanner in= new Scanner(System.in);

		try {
				
		   while(true) {
				System.out.println("Evaluation One");
				System.out.println("*******************************");
				System.out.println("Menu:");
				System.out.println("Consume API");
				System.out.println("0:Write response in a file.");
				System.out.println("1:Exit");
				System.out.println("2:Search from file a String which is user input.(Search String can be more than one but they must all be unique even if user gives duplicate input).");
				System.out.println("*******************************");
				System.out.println("Enter a number from menu: ");
				int choice=in.nextInt();
				
				switch(choice) {
				case 0:{
					System.out.println("First,I created a file (.txt) and i wrote anything inside it, then i will read it and display it here as output");
					
					System.out.println("Enter file name to read things/text inside it:");
					String filename=in.next(); 
					
					FileInputStream fileLocation= new FileInputStream("C:\\Users\\Acer\\eclipse-workspace\\Evaluation\\" + filename);
					BufferedReader br=new BufferedReader(new InputStreamReader(fileLocation));
					
					String thingsInsideFile;
					
					//read everything inside file line by line
					while((thingsInsideFile= br.readLine()) !=null)
			        {
			        	System.out.println(thingsInsideFile);
			        }
			        
			        //close input stream
			        fileLocation.close();
			        break;
				}case 1:{
					return;
				}case 2:{
					System.out.println("(Search String can be more than one but they must all be unique even if user gives duplicate input).");
					
					System.out.println("Enter any word from your json in your file:"); //(.txt) file
					String word = in.next();
					
					//will search input word from this location if found or no
					Scanner in2 = new Scanner(new FileInputStream("C:\\Users\\Acer\\eclipse-workspace\\Evaluation\\searchWordFromThisFileIfFoundOrNo.txt"));
					
					boolean found = false;
					
					//here will decide if found that word or no
					while (in2.hasNextLine()) { 
						String wordInFile = in2.nextLine();
						if (wordInFile.indexOf(word) != -1) {
							found = true;

						}
					}
					if (found) { 
						System.out.println("File contains this word: " + word);
					} else {
						System.out.println("File does not contain the word entered.");
					}

					break;				
				}default:{
					System.out.println("It is not an option, try again and choose a number from menu above");
					break;
				}
				}}
			}catch(Exception e) {
				System.out.println("Error!!");
			}
			

	}

}
