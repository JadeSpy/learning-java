import java.util.Arrays;
import java.util.Scanner;
class PrimeFinder {
   public static void main(String args[])
   {	
	final long startTime = System.currentTimeMillis();
	int numbersUpTo=10000;
	
	//get the range to check for primes in
	Scanner scan= new Scanner(System.in);
	System.out.println("Enter the number that you want to check primes up to:");
	numbersUpTo=scan.nextInt();
    scan.close();
	
	
	int[] numbersUpToArray = new int[numbersUpTo-1];
	int arrayPos = 0;
	//fill in array
	for (int i=2;i<=numbersUpTo;i++) {
		//System.out.println(i);
		numbersUpToArray[arrayPos] = i;
		arrayPos++;
	}
	//perform non-prime removal
	final long mainPartStartTime = System.currentTimeMillis();
	for(int denominatorIndex=0; denominatorIndex<numbersUpToArray.length; denominatorIndex++) {
		int denominator = numbersUpToArray[denominatorIndex];
		if(denominator != 0) { //check to make sure this index actually exists (because 
			for(int numerator=denominator*2; numerator<numbersUpToArray.length+2; numerator+=denominator) {
				numbersUpToArray[numerator-2] = 0;
			}
		}
	}
	/*
	int numToDisplay = 1000;
	int numToDisplayCounter = 0;
	for(int i = numbersUpToArray.length-1; i>=0 && numToDisplayCounter<numToDisplay; i--) {
		if(numbersUpToArray[i]!=0) {
			numToDisplayCounter++;
			System.out.println(numbersUpToArray[i]);
		}
	}
	*/
	for(int i = 0; i<numbersUpToArray.length; i++) {
		if(numbersUpToArray[i]!=0) {
			System.out.println(numbersUpToArray[i]);
		}
	}
	//System.out.println(Arrays.toString(numbersUpToArray));
	System.out.println("finished in: "+((System.currentTimeMillis()-startTime)/1000) + " seconds");
   }
    	
	
}
