
public class PriceDemand2 {
	private double function;
	private double functionMR;
	private double functionAC;
	private double functionMC;
	private double functionDer;
	public static double[][] funcNumber = new double[4][6];
	
		//the user will put ar, ac, mr, mc functions into this array. We will take the functions from the array.
		//the user can overwrite functions, use the recent one if its not changed.

	
	public PriceDemand2(double[][] funcArrayConstructor) {
		
	//	double[][] parameters =new double[2][7];
		setArray(funcArrayConstructor);
		
	}
	public void setArrayForEachFunction(String nameOfFunction, int jPos, double value) {
		if (nameOfFunction=="AR") 	
			funcNumber[0][jPos]= value;
		
		else if (nameOfFunction=="AC") 
			funcNumber[1][jPos]= value;
		
		else if (nameOfFunction=="MR") 	
			funcNumber[2][jPos]= value;	
			
		else if (nameOfFunction=="MC") 
			funcNumber[3][jPos]= value;
			
		
	}
	public void resetTheRest(String nameOfFunction, int power) {
		int pos=6;
		if (nameOfFunction=="AR") pos=0;
		else if (nameOfFunction=="AC") pos=1;
		else if (nameOfFunction=="MR") pos=2;
		else if (nameOfFunction=="MC") pos=3;
		
		for(int i=power+1; i<6;i++) {
			funcNumber[pos][i]=0;
		}
		
	}
	
	public void setArray(double [][]funcArray) {
		for(int i=0; i<4;i++) {
			for(int j=0; j<6;j++) {
			//	if(funcArray[i][j]!=0)
					funcNumber[i][j]=funcArray[i][j];
			}
		}
	}
	public void setFunctionToM(String nameOfFunction,int newPower) {
		int row=15;
		if(nameOfFunction=="AC")
			row=1;
		else if (nameOfFunction=="AR")
			row=0;
		for(int j=0; j<newPower+1;j++) {
			funcNumber[row+2][j]=(j+1)*funcNumber[row][j];
		}
		resetTheRest(nameOfFunction,newPower);
		
	}
	
	public void setFunctionToA(String nameOfFunction,int newPower) {
		int row=15;
		String otherName=nameOfFunction;
		if(nameOfFunction=="MC") {
			row=3;
			otherName="AC";
			}
		else if (nameOfFunction=="MR") {
			row=2;
			otherName="AR";
			}
		for(int j=0; j<newPower+1;j++) {
			funcNumber[row-2][j]=funcNumber[row][j]/(j+1);
		}
		resetTheRest(otherName,newPower);
		
	}
	
	
	public double findFunction(String nameOfFunction,int newPower, double x) {
		int row;
		if(newPower>=0) {
			if (nameOfFunction=="AR") row=0;								
			else if(nameOfFunction=="AC") row=1;							
			else if(nameOfFunction=="MR") row=2;
			else if(nameOfFunction=="MC") row=3;
			else row=6;//out of bound
			function = funcNumber[row][0] + funcNumber[row][1]*x + funcNumber[row][2]*Math.pow(x, 2) + funcNumber[row][3]*Math.pow(x, 3) + funcNumber[row][4]*Math.pow(x, 4) + funcNumber[row][5]*Math.pow(x, 5);
		}
		else function=0;
		return function;
	}
	public String getFunction(String nameOfFunction,int newPower){
		String functionString="";
		int row;
		if(newPower>=0) {
			if(nameOfFunction=="AR") 	row=0;				
			else if(nameOfFunction=="AC")	row=1;				
			else if(nameOfFunction=="MR")	row=2;				
			else if(nameOfFunction=="MC")	row=3;
			else row=6;//out of bound		
			for(int i=newPower; i>0;i--) {
				functionString+= funcNumber[row][i]+"x^"+i+" + ";
			}
			functionString+=""+funcNumber[row][0];
		}	
		return functionString;
	}
	
	
	public String getMR(String nameOfFunction,int newPower){
		
		// write again. How do you find MR? First find TR, then take the derivative.
		String functionStringMR="";
		int row;
		if(newPower>=0) {
			if(nameOfFunction =="AR") 	row=0;
			else if(nameOfFunction=="MR") row=2;
			else if (nameOfFunction =="AC") row=1;
			else if (nameOfFunction =="MC") row=3;
			else row=6;//out of bound
			for(int i=newPower; i>0;i--) {
				functionStringMR+= (i+1)*funcNumber[row][i]+"x^"+i+" + ";				
			}
			functionStringMR+=""+funcNumber[row][0];
		}
		
		
		return functionStringMR;
	}
	public double findMR(String nameOfFunction,int newPower,double x){
		int row;
		if(newPower>=0) {
			if(nameOfFunction=="AR")  row=0;
			else if (nameOfFunction =="AC") row=1;
			else row=6;//out of bound			
			functionMR = funcNumber[row][0] + 2*funcNumber[row][1]*x+ 3*funcNumber[row][2]*Math.pow(x, 2)+ 4*funcNumber[row][3]*Math.pow(x, 3)+ 5*funcNumber[row][4]*Math.pow(x, 4)+ 6*funcNumber[row][5]*Math.pow(x, 5);
		}
		else functionMR=0;	
		
		return functionMR;
		
	}
	
	public double findDer(String nameOfFunction,int newPower,double x){
		int row;
		if(newPower>=0) {
			if(nameOfFunction=="MR")  row=2;
			else if (nameOfFunction =="MC") row=3;
			else if (nameOfFunction =="AR") row=0;
			else if (nameOfFunction =="AC") row=1;
			else row=6;//out of bound			
			functionDer = funcNumber[row][1]+ 2*funcNumber[row][2]*x+ 3*funcNumber[row][3]*Math.pow(x, 2)+ 4*funcNumber[row][4]*Math.pow(x, 3)+ 5*funcNumber[row][5]*Math.pow(x, 4);
		}
		else functionDer=0;	
		
		return functionDer;
	}
	
	public double findTR(double x) {
		double TRvalue=function*x;
		return TRvalue;
	}
	
	
	public double findAC(String nameOfFunction,int newPower, double x) {
		functionAC=findFunction(nameOfFunction,newPower, x);
		return functionAC;
	}
	
	public String getAC(String nameOfFunction,int newPower) {
		String functionStringAC="";
		functionStringAC = getFunction(nameOfFunction,newPower);
		return functionStringAC;
	}
	
	public double findTC(double x) {
		double TCvalue=functionAC*x;
		return TCvalue;	
	}
	
	public double findMC(String nameOfFunction,int newPower, double x) {		
		functionMC = findMR(nameOfFunction,newPower,x);
		return functionMC;
	}
	
	public String getMC(String nameOfFunction,int newPower) {
		String functionStringMC="";
		functionStringMC=getMR(nameOfFunction,newPower);
		return functionStringMC;
	}
	
	public double findEquilibrium(String func1,String func2,int newPower,int newCostPower){
		
		//program tries to reach 0.
		// TRY NEWTON'S METHOD YEEHAAA.
		//x1= x0 - f(x0)/f'(x0)
		double x;
		int count = 0;
		if(func1=="AR")
			setFunctionToM(func1,newPower);
		if(func1 == "AC")
			setFunctionToM(func2,newCostPower);
		
		if(newCostPower>0 && newPower>0){
			x=1;
			double result1=2;
			//cases: AR-AC, AR-MC,MR-AC,MR-MC
		//	double result2;
		//	double temp=0;
			while(Math.abs(result1)<0.001==false && count<60000) {
			//	temp=x;
			//		x=x-((findMC("MC",newCostPower,x)-findMR("MR",newPower,x))/(findDerMC("MC",newCostPower,x)-findDerMR("MR",newCostPower,x)));
				x=x-((findFunction("MC",newCostPower,x)-findFunction("MR",newPower,x))/(findDer("MC",newCostPower,x)-findDer("MR",newPower,x)));
				result1 = findFunction("MC",newCostPower,x)-findFunction("MR",newPower,x);	
				count++;
			}
			
		}
		else {
			x=Double.NaN;
		}
		if(count==6000000)	x=Double.NaN;
		return x;
	}
	public double findMaxProfit(String R, String C,int powerMR,int powerMC, double xVal){
		
		if(R=="MR") {
			setFunctionToA(R,powerMR );
		}
		if(C=="MC") {
			setFunctionToA(C,powerMC);
		}
		
		double profit=xVal*findFunction("AR",powerMR,xVal)-xVal*findFunction("AC",powerMC,xVal);
		
		
		return profit;
	}
	
}
