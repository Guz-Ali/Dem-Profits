import java.util.*;
public class MaxProfits {
//	double x = 200;	//default value, changes after findRoot() is called
	double x;
	double finalResult;
	double price;
	
	public MaxProfits(String subKey1, double[] subArray1, String subKey2, double[] subArray2) {
	//	System.out.println(subKey1+subArray1+subKey2+subArray2);
		findMaxProfits(subKey1, subArray1, subKey2, subArray2);
		
	}
	
	private double findMaxProfits(String subKey1, double[] subArray1, String subKey2, double[] subArray2) {
		double[] newSubArray1 = new double[subArray1.length];
		double[] newSubArray2 = new double[subArray1.length];
		double result;
		if(findFunction1Type(subKey1)) {
			newSubArray1=getMVersionOfFunction(subArray1);
		}
		else {
			newSubArray1=subArray1;
		}
		
		if(findFunction2Type(subKey2)) {
			newSubArray2 =getMVersionOfFunction(subArray2);
		}
		else {
			newSubArray2=subArray2;
		}
		
		//MR=MC find x
		//AR(x)-AC(x) = profit
		findRoot(newSubArray1, newSubArray2);
		result = findProfitARAC(subKey1, subArray1, subKey2, subArray2);
		return result;
	}
	
	private boolean findFunction1Type(String subKey1) {
		if(subKey1.equalsIgnoreCase("AR"))
			return true;
		else
			return false;
		
	}
	private boolean findFunction2Type(String subKey2) {
		if(subKey2.equalsIgnoreCase("AC"))
			return true;
		else
			return false;
		
	}
	
	private double[] getMVersionOfFunction(double[] subArray) {
		double[] newSubArray = new double[subArray.length];
		for(int i=0; i<subArray.length; i++) {
			newSubArray[i]=subArray[i]*(i+1);
		}
		return newSubArray;
	}
	
	private double[] getAVersionOfFunction(double[] subArray) {
		double[] newSubArray = new double[subArray.length];
		for(int i=0; i<subArray.length; i++) {
			newSubArray[i]=subArray[i]/(i+1);
		}
		
		return newSubArray;
	}
	
	
	private double findRoot(double[] subArray1, double[] subArray2) {
		double[] equilibriumFunction = createEquilibriumFunction(subArray1,subArray2);
		x = newtonsMethod(equilibriumFunction);		
		return x;
		}
	
	
	private double[] createEquilibriumFunction(double[] subArray1, double[] subArray2) {
		double[] mixedArray;
		if(subArray1.length>=subArray2.length) {			
			mixedArray = new double[subArray1.length];
			for(int i=0; i<subArray1.length;i++) {		//create a clone to subArray1
				mixedArray[i] = subArray1[i];
			}		
			for(int i=0;i<subArray2.length;i++) {
				mixedArray[i] = subArray1[i]-subArray2[i];
			}			
		}
		else {
			mixedArray = new double[subArray2.length];
			for(int i=0; i<subArray2.length;i++) {		//create a clone to subArray2
				mixedArray[i] = subArray2[i];
			}	
			for(int i=0;i<subArray1.length;i++) {
				mixedArray[i] = subArray1[i]-subArray2[i];
			}	
	}		
		return mixedArray;
		
	}
	private double newtonsMethod (double[] equilibriumFunction) {
		//x1 = x0 - f(x0)/f'(x0)	x1 is a better root for (xn, 0)
		//continue to do until the desired precision.	Precision set to 0.001
		x=200; //seems best for number of products, default
		double[] equilibriumDerFunction = getDerivativeFunction(equilibriumFunction);
		
		while(Math.abs(useArrayAsFunction(equilibriumFunction,x))>0.001) {
			x = x - ((useArrayAsFunction(equilibriumFunction,x))/(useArrayAsFunction(equilibriumDerFunction,x))) ;
		}
		
		
		return x; 
	}
	
	private double useArrayAsFunction(double[] equilibriumFunction, double xa) {
		double result=0;
		for(int i=0; i<equilibriumFunction.length;i++) {	//calculate ax^b
			result+=equilibriumFunction[i]*Math.pow(xa, i);
		}	
		return result;
	}
	
	private double[] getDerivativeFunction(double[] subArray) {
		double[] newSubArray;
		if(subArray.length>1) {
			newSubArray = new double[subArray.length-1];
			for(int i=0; i<newSubArray.length;i++) {
				newSubArray[i] = subArray[i+1]*(i+1);
			}	
		}
		else {
			newSubArray = new double[1];
			newSubArray[0]=0;
		}
		return newSubArray;
	}
	
	private double findProfitARAC(String subKey1, double[] subArray1, String subKey2, double[] subArray2) {
		double[] newSubArrayA;
		double[] newSubArrayB;
		if(subKey1.equalsIgnoreCase("AR")) {
			newSubArrayA = new double[subArray1.length];
			for(int i=0; i<newSubArrayA.length;i++) {
				newSubArrayA[i]=subArray1[i];
			}
		}
		else {
			newSubArrayA = getAVersionOfFunction(subArray1);
		}
		if(subKey2.equalsIgnoreCase("AC")) {
			newSubArrayB = new double[subArray2.length];
			for(int i=0; i<newSubArrayB.length;i++) {
				newSubArrayB[i]=subArray2[i];
			}
		}
		else {
			newSubArrayB = getAVersionOfFunction(subArray2);
		}
		finalResult = (useArrayAsFunction(newSubArrayA,x)-useArrayAsFunction(newSubArrayB,x))*x;
		findPrice(subKey1, subArray1);
		return finalResult;
	}
	
	private void findPrice(String subKey1, double[] subArray) {
		
		if(subKey1.equalsIgnoreCase("AR")) {
			price = useArrayAsFunction(subArray, x);
		}
		else if (subKey1.equalsIgnoreCase("MR")) {
			price = useArrayAsFunction(getAVersionOfFunction(subArray), x);
		}
		
	}

	public double getX() {
		return x;
	}

	public double getFinalResult() {
		return finalResult;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "Your maximum profits would be "+finalResult+ " if you produce " + x+" number of products. Your price should start at "+ price +" dollars.";
	}
}
