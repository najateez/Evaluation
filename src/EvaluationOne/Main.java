package EvaluationOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Set;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


import com.google.gson.Gson;


public class Main {

	public static void main(String[] args) {
		// najat
		Scanner in = new Scanner(System.in);

		// TODO: Handle specific exceptions instead of general
		try {
			while(true) {
				System.out.println("Evaluation One");
				System.out.println("*******************************");
				System.out.println("Menu:");
				System.out.println("Consume API");
				System.out.println("0:Write response in a file.");
				System.out.println("1:Exit");
				System.out.println("2:Search from file a String which is user input.(Search String can be more than one but they must all be unique even if user gives duplicate input).");
				System.out.println("3:Just another way solution of case(2)");
				System.out.println("4:Ask user pdf or txt,then search a word in that file. When you find a word move it to new directory.");
				System.out.println("*******************************");
				System.out.println("Enter a number from menu: ");
				int choice=in.nextInt();

				switch(choice) {
					case 0:{
						// TODO: Make the error message more meaningful
						System.out.println("First,I created a file (.txt) and i wrote anything inside it, then i will read it and display it here as output");
	
						System.out.println("Enter file name to read things/text inside it:");
						String filename=in.next(); 
	
						FileInputStream fileLocation= new FileInputStream("C:\\Users\\Acer\\eclipse-workspace\\Evaluation\\" + filename);
						BufferedReader br=new BufferedReader(new InputStreamReader(fileLocation));
	
						String thingsInsideFile;
	
						// Read everything inside file line by line
						while((thingsInsideFile= br.readLine()) !=null)
						{
							System.out.println(thingsInsideFile);
						}
	
						// Close input stream
						fileLocation.close();
						break;
					}case 1:{
						return;
					}case 2:{
						System.out.println("(Search String can be more than one but they must all be unique even if user gives duplicate input).");
	
						ArrayList<String> theDuplicateString = new ArrayList<>();
						Set<String> uniqueStringHS = new HashSet<>();
	
						boolean isExit = true;
	
						while(isExit) {
							System.out.println("Enter any word from your json in your file:"); //(.txt) file
							String word = in.next();
							uniqueStringHS.add(word);
	
							// TODO: Use meaningful variable names
							//will search input word from this location if found or no
							Scanner fileInputStreamInstance = new Scanner(new FileInputStream("C:\\Users\\Acer\\eclipse-workspace\\Evaluation\\searchWordFromThisFileIfFoundOrNo.txt"));
	
							boolean found = false;
	
							// TODO: Can use IDE's refactor to rename variables in a given scope. 
							//here will decide if found that word or no
							while (fileInputStreamInstance.hasNextLine()) { 
								String wordInFile = fileInputStreamInstance.nextLine();
								if (wordInFile.indexOf(word) != -1) {
									found = true;
								}
							}
	
							if (found) { 
								System.out.println("File contains this word: " + word);
								if(!theDuplicateString.contains(word)) {
									theDuplicateString.add(word);
								}
								//	 System.out.println(theDuplicateString);
							} else {
								System.out.println("File does not contain the word entered.");
							}
	
							System.out.println("press 0 to continue or press 1 to exit");
							int num = in.nextInt();
							if(num == 1) {
								isExit=false;
							}
						}
						// TODO: Create a method to avoid writing duplicate code below.
						// TODO: Call it here. Example: generateReport(theDuplicateString)
						generateReport(theDuplicateString);
						break;	
					}case 3:{
						System.out.println("Another way solution:-");
	
						ArrayList<String> theDuplicateString= new ArrayList<>();
						Set<String> uniqueStringHS= new HashSet<>();
	
						System.out.println("How many word string do you want to enter"); //(.txt) file
						int amtOfWord = in.nextInt();
	
						for(int i=0;i<amtOfWord;i++) {
							System.out.println("Enter any word from your json in your file:"); //(.txt) file
							String word = in.next();
							uniqueStringHS.add(word);
	
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
								if(!theDuplicateString.contains(word)) {
									theDuplicateString.add(word);
								}
								//	 System.out.println(theDuplicateString);
							} else {
								System.out.println("File does not contain the word entered.");
							}
						}
						// TODO: The code below 
						generateReport(theDuplicateString);
						break;
					}case 4:{
						
						// i download for it to work fine: pdfbox.jar and fontbox.jar.
						//fontbox from this website: https://repo1.maven.org/maven2/org/apache/pdfbox/fontbox/2.0.2/
						readUsingPdfBox();
						break;						
					}default:{
						System.out.println("It is not an option, try again and choose a number from menu above");
						break;
					} 
				}
			}
		}catch(Exception e) {
			System.out.println("Error!!");
		}
	}

	private static void generateReport(ArrayList<String> data) {
		System.out.println("Output Report:");
		System.out.println(data);
		System.out.println("*******************************");
	}
	private static void generateReportForPdf(ArrayList<String> data1) {
		System.out.println("Output Report:");
		System.out.println(data1);
		System.out.println("*******************************");
	}
	
	//Reading from pdf file
	public static void readUsingPdfBox() throws IOException {
	    System.out.println("Enter File You Want to Use");
	    Scanner scanner = new Scanner(System.in);
	    String fileToUse = scanner.next();
	    PDDocument pdDocument = PDDocument.load(new File(System.getProperty("user.dir") + "\\" + fileToUse + ".pdf"));
	    PDFTextStripper textStripper = new PDFTextStripper();
	    String textFromFile = textStripper.getText(pdDocument);
	    System.out.println("Enter Word You Want to Search\n");
	    Scanner scannerObject = new Scanner(System.in);
	    String wordToSearch = scannerObject.next();
	    if(textFromFile.contains(wordToSearch)){
	        System.out.println(wordToSearch + " found!!");
	    } else {
	        System.out.println(wordToSearch + " Not found");
	    }
	    pdDocument.close();
	}
}
