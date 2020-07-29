import java.util.*;

public class DemProfitsClient {
	public static void main(String args[]) {
		//instead of adding each function to list, uses the latest function. ONLy changes it. 
		Scanner input = new Scanner(System.in);
		DemProfits commonArray;
		double[] functionArray;
		DemProfitsList commonArrayList= new DemProfitsList();
		String key="";
		String subKey;
		int power;
		boolean noSaid;
		
		
		while(!key.equalsIgnoreCase("QUIT")) {
			System.out.println("Which function do you want to input? AR, MR, AC, MC");
			System.out.println("If you have functions in, you can also look through them. SEARCH");	//add selecting
			System.out.println("Find the best amount of products, best price, maximum profit. MAX");
			System.out.println("You can quit by typing QUIT");
			
			key=input.next();
			
			if(key.equalsIgnoreCase("AR")||key.equalsIgnoreCase("MR")||key.equalsIgnoreCase("AC")||key.equalsIgnoreCase("MC")) {
				noSaid=true;
				while(noSaid) {
					System.out.println("What is the most power of this function? Type in number");
					power = input.nextInt();
					if(power>=0) {
						functionArray= new double[power+1];			//x^0 is also an element
						for(int i=0; i<power+1; i++) {
							System.out.println("Input the constant for x^"+i);
							functionArray[i]=input.nextDouble();
						}
						commonArray = new DemProfits(functionArray,key);
						System.out.println("Is this the function you wanted? If not type NO, otherwise type anything"+commonArray.toString());
						String pass = input.next(); 
						if(!pass.equalsIgnoreCase("NO")) {
							commonArrayList.addArray(commonArray);
							noSaid=false;
						}
						else {
							System.out.println("You can try again.");
						}
					}
					else {
						System.out.println("Wrong input");
					}
				}
			}
			
			if(key.equalsIgnoreCase("SEARCH")) {
				System.out.println("Which type of function do you want to search? AR, MR, AC, MC");
				subKey = input.next();
				if(subKey.equalsIgnoreCase("AR")||subKey.equalsIgnoreCase("MR")||subKey.equalsIgnoreCase("AC")||subKey.equalsIgnoreCase("MC")) {
					ArrayList <DemProfits> subCommonArrayList = commonArrayList.getFunctionsByType(subKey);
					
					System.out.println(subCommonArrayList.toString());
					
				}
				else {
					System.out.println("Wrong Input");
				}
			}
			if(key.equalsIgnoreCase("MAX")) {
				double[] subArray1;
				double[] subArray2;
				ArrayList <DemProfits> subCommonArrayList1 = commonArrayList.getFunctionsByType("AR");
				ArrayList <DemProfits> subCommonArrayList2 = commonArrayList.getFunctionsByType("MR");
				ArrayList <DemProfits> subCommonArrayList3 = commonArrayList.getFunctionsByType("AC");
				ArrayList <DemProfits> subCommonArrayList4 = commonArrayList.getFunctionsByType("MC");
				System.out.println(subCommonArrayList1.toString());
				System.out.println(subCommonArrayList2.toString());
				
				System.out.println("Select AR or MR. Input function type and the index of your function with space between. (ex: functionType index)");
				subKey =input.next();
				int index = input.nextInt();
				
				if (subKey.equalsIgnoreCase("AR")) {
					subArray1 = new double[subCommonArrayList1.get(index).getFunction().length];
					subArray1 = subCommonArrayList1.get(index).getFunction();	//return the selected AR function
				}
				else if (subKey.equalsIgnoreCase("MR")) {
					subArray1 = new double[subCommonArrayList2.get(index).getFunction().length];
					subArray1 = subCommonArrayList2.get(index).getFunction();
				}
				else {
					subArray1 = new double[1];
				}
				
				
				System.out.println(subCommonArrayList3.toString());
				System.out.println(subCommonArrayList4.toString());
				
				System.out.println("Select AC or MC. Input function type and the index of your function with space between. (ex: functionType index)");
				String subKey2 =input.next();
				index = input.nextInt();
				
				if (subKey2.equalsIgnoreCase("AC")) {
					subArray2 = new double[subCommonArrayList3.get(index).getFunction().length];
					subArray2 = subCommonArrayList3.get(index).getFunction();	//return the selected AR function
				}
				else if (subKey2.equalsIgnoreCase("MC")) {
					subArray2 = new double[subCommonArrayList4.get(index).getFunction().length];
					subArray2 = subCommonArrayList4.get(index).getFunction();
				}
				else {
					subArray2 = new double[1];
				}
				
				MaxProfits finalProfit = new MaxProfits(subKey, subArray1, subKey2, subArray2) ;
				System.out.println(finalProfit.toString());
				System.out.println();//empty line
			}
		//	System.out.println("\n");	//add a line after each loop
			
		}
		//DemProfitsList 
	//	commonArray.setFunction(doubleArray);
	//	System.out.println(commonArray.getFunction());
	}
}
