import java.util.*;
public class DemProfits {
	private double[] function;
	private String type;
	static DemProfitsList functionsList = new DemProfitsList();
	
	public DemProfits(double[] function, String type) {
		setFunction(function);
		setType(type);
	} 
	
	private void setFunction(double[] function) {
		this.function = function;
	}
	
	private void setType(String type) {
		this.type = type;
	}
	
	public double[] getFunction() {
		return function;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		String output="\n"+type+" ";
		
		for(int i=function.length-1; i>=0;i--) {
			if(i!=0) {
				output= output+ function[i]+"x^"+i+" + ";
			}
			else {
				output= output+ function[i];
			}
			
		}
		
		
		return output;
	}
}
