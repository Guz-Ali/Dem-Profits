import java.util.*;

public class DemProfitsList {
	
	private static ArrayList <DemProfits> functions = new ArrayList();
	
	public DemProfitsList() {}
	
	
	public void addArray(DemProfits function) {
		functions.add(function);
	}
	
/*	public int getFlag(String type) {
		int flag;
		if(type.equalsIgnoreCase("AR")) {
			flag=0;
		}	
		else if(type.equalsIgnoreCase("MR")) {
			flag=1;
		}	
		else if(type.equalsIgnoreCase("AC")) {
			flag=2;
		}	
		else if(type.equalsIgnoreCase("MC")) {
			flag=3;
		}
		else {
			flag=9;
		}
		
		return flag;
	}
	
*/
	
	public ArrayList<DemProfits> getFunctionsByType(String type) {
		int[] indexes = new int[functions.size()+1];
		ArrayList <DemProfits> fitFunctions = new ArrayList();;
		int counterForIndexes=0;
		for(int i=0; i<functions.size();i++) {
			if(functions.get(i).getType().equalsIgnoreCase(type)) {
				indexes[counterForIndexes]=i;
				counterForIndexes++;
			}
		}	
		for(int i=0; i<counterForIndexes;i++) {
			fitFunctions.add(functions.get(indexes[i]));
		}
		return fitFunctions;	//returns the selected functions as an array of DemProfits
	}
	
	public String toString(ArrayList<DemProfits> functions) {
		String output="";
		for(int i=0; i<functions.size(); i++) {
			output+=functions.get(i).toString();	//returns DemProfit objects as strings
		}
		
		return output;
	}
	
}
