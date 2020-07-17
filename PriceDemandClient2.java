import java.util.Scanner;

public class PriceDemandClient2 {
	public static void main(String args[]) {
		final int UPPER_DEFAULT=5;
		final int LOWER_DEFAULT=0;
		
		double ACx=0;
		double ARx=0;
		double MRx=0;
		double MCx=0;
		int newPowerMR=0;
		int newPowerMC=0;
		int newNewPowerMR=0;
		int newNewPowerMC=0;
		double [][] funcNumbers = new double [4][6]; 
		PriceDemand2 commonArray = new PriceDemand2(funcNumbers);
		int MCMRpowerMR=0;
		int MCMRpowerMC=0;
		Scanner input = new Scanner(System.in);
		int power=10;
		int costPower=10;
		String key="e";	
		while(key!="Q") {	
			System.out.println("Select what you want to do.\nFind Price at x (P), Find MR at x (MR), Find Cost at x (C), Find MC at x (MC), or Find Maximum Profit (MAX), Quit (Q)");
			String methodInput= input.next();
			if (methodInput.equalsIgnoreCase("P")) {
				System.out.println("AR Function. What is the most power? x^(?)  Can be Max 5.");
		
				power = input.nextInt();
				if(power>5) {
					power=UPPER_DEFAULT;
					System.out.println("max power is 5.");
				}
				else if (power<0) {
					power=LOWER_DEFAULT;
					System.out.println("max power is 0.");
				}
				
					double value=0;
					for(int i=0; i<power+1;i++) {						
						System.out.println("input the constant of x with "+i+"'th power");
						value=input.nextDouble();
						commonArray.setArrayForEachFunction("AR",i,value);
					}
					commonArray.resetTheRest("AR", power);
			
		//		commonArray.setArray(funcNumbers);
				System.out.println(commonArray.getFunction("AR", power));
				if(power!=0) {
					System.out.println("What is the Quantity Demanded (Qd = x) value?");
					ARx= input.nextDouble();
				}
		//		commonArray.setArray(funcNumbers);		
				System.out.println("Your price at "+ARx+" is: "+commonArray.findFunction("AR",power,ARx)+"\n");
			}
				
			else if(methodInput.equalsIgnoreCase("MR")) {
				System.out.println("Do you want to use the previous P-Q function's MR or want a seperate one? (1 or 2)");
				int ans1 = input.nextInt();
				if (ans1==1) {
				//	bFunction =new PriceDemand(power, a,b,c,d,e,f,ARx);
					System.out.println("Marginal Revenue Function:");
					System.out.println(commonArray.getMR("AR",power));
		
					if(power!=0) {
						System.out.println("What is the Quantity Demanded (Qd = x) value?");
						MRx= input.nextDouble();
					}
					System.out.println("Your Marginal Revenue at "+MRx+" is:");
					System.out.println(commonArray.findMR("AR",power,MRx)+"\n");
					System.out.println("Do you want to store this function as your Marginal Revenue Function? (Yes or No)");
					String storeAnswer = input.next();
					if(storeAnswer.equalsIgnoreCase( "Yes")) {
						commonArray.setFunctionToM("AR",power);
					}
				}
				else if (ans1 ==2 ) {
					System.out.println("MR Function. What is the most power? x^(?)  Can be Max 5.");
					newPowerMR = input.nextInt();
					if(newPowerMR>5) {
						newPowerMR=UPPER_DEFAULT;
						System.out.println("max power is 5.");
					}
					else if (newPowerMR<0) {
						newPowerMR=LOWER_DEFAULT;
						System.out.println("max power is 0.");
					}
					
					double value=0;
					for(int i=0; i<newPowerMR+1;i++) {						
						System.out.println("input the constant of x with "+i+"'th power");
						value=input.nextDouble();
						commonArray.setArrayForEachFunction("MR",i,value);
					}
					commonArray.resetTheRest("MR", newPowerMR);
					/*for(int i=0; i<newPowerMR+1;i++) {
						System.out.println("input the constant of x with "+i+"'th power");
						if(i==0) {
							MRa = input.nextDouble();
						}
						else if(i==1) {
							MRb = input.nextDouble();
						}
						else if(i==2) {
							MRc = input.nextDouble();
						}
						else if(i==3) {
							MRd = input.nextDouble();
						}
						else if(i==4) {
							MRe = input.nextDouble();
						}
						else if(i==5) {
							MRf = input.nextDouble();
						}*/
					
			//		bFunction = new PriceDemand(newPowerMR,MRa,MRb,MRc,MRd,MRe,MRf,MRx);
					System.out.println("Marginal Revenue Function:");
					System.out.println(commonArray.getFunction("MR",newPowerMR));//instead of getMR
					if(power!=0) {
						System.out.println("What is the Quantity Demanded (Qd = x) value?");
						MRx= input.nextDouble();
					}
					System.out.println("Your Marginal Revenue at "+MRx+" is:");
					System.out.println(commonArray.findFunction("MR",newPowerMR,MRx)+"\n");//instead of findMR
				}
				}
				
		
			else if(methodInput.equalsIgnoreCase("C")) {
				System.out.println("AC Function. What is the most power? x^(?)  Can be Max 5.");
				 costPower = input.nextInt();
				if(costPower>5) {
					costPower=UPPER_DEFAULT;
					System.out.println("max power is 5.");
				}
				else if (costPower<0) {
					costPower=LOWER_DEFAULT;
					System.out.println("max power is 0.");
				}

				double value=0;
				for(int i=0; i<costPower+1;i++) {						
					System.out.println("input the constant of x with "+i+"'th power");
					value=input.nextDouble();
					commonArray.setArrayForEachFunction("AC",i,value);
				}
				commonArray.resetTheRest("AC", costPower);
				/*
				for(int i=0; i<costPower+1;i++) {
					System.out.println("input the constant of x with "+i+"'th power");
					if(i==0) {
						ACa = input.nextDouble();
					}
					else if(i==1) {
						ACb = input.nextDouble();
					}
					else if(i==2) {
					ACc = input.nextDouble();
					}
					else if(i==3) {
				ACd = input.nextDouble();
					}
					else if(i==4) {
						ACe = input.nextDouble();
					}
					else if(i==5) {
					ACf = input.nextDouble();
					}
				}
				*/
				System.out.println(commonArray.getAC("AC",costPower));
				if(costPower!=0) {
					System.out.println("What is the Quantity Demanded (Qd = x) value?");
					ACx= input.nextDouble();
				}
			//	bFunction = new PriceDemand(costPower,ACa,ACb,ACc,ACd,ACe,ACf,ACx);
				
				System.out.println("Your Average Cost at "+ACx+" is:");
				System.out.println(commonArray.findAC("AC",costPower,ACx)+"\n");
				
				
				
			}
			else if(methodInput.equalsIgnoreCase("MC")) {
				System.out.println("Do you want to use the previous Cost-Q function's MC or want a seperate one? (1 or 2)");
				int ans1 = input.nextInt();
				if (ans1==1) {
				//	bFunction =new PriceDemand(costPower,ACa,ACb,ACc,ACd,ACe,ACf,ACx);
					System.out.println("Marginal Cost Function:");
					System.out.println(commonArray.getMC("AC",costPower));
	
					if(costPower!=0) {
						System.out.println("What is the Quantity Demanded (Qd = x) value?");
						MCx= input.nextDouble();
					}
					System.out.println("Your Marginal Cost at "+MCx+"  is:");
					System.out.println(commonArray.findMR("AC",costPower,MCx)+"\n");
					
					System.out.println("Do you want to store this function as your Marginal Cost Function? (Yes or No)");
					String storeAnswer = input.next();
					if(storeAnswer.equalsIgnoreCase( "Yes") ){
						commonArray.setFunctionToM("AC",costPower);
					}
					
					
					
				}
				
				else if (ans1 ==2 ) {
					System.out.println("MC Function. What is the most power? x^(?)  Can be Max 5.");
					newPowerMC = input.nextInt();
					if(newPowerMC>5) {
						newPowerMC=UPPER_DEFAULT;
						System.out.println("max power is 5.");
					}
					else if (newPowerMC<0) {
						newPowerMC=LOWER_DEFAULT;
						System.out.println("max power is 0.");
					}

					double value=0;
					for(int i=0; i<newPowerMC+1;i++) {						
						System.out.println("input the constant of x with "+i+"'th power");
						value=input.nextDouble();
						commonArray.setArrayForEachFunction("MC",i,value);
					}
					commonArray.resetTheRest("MC", newPowerMC);
					/*
					for(int i=0; i<newPowerMC+1;i++) {
						System.out.println("input the constant of x with "+i+"'th power");
						if(i==0) {
							MCa = input.nextDouble();
						}
						else if(i==1) {
							MCb = input.nextDouble();
						}
						else if(i==2) {
							MCc = input.nextDouble();
						}
						else if(i==3) {
							MCd = input.nextDouble();
						}
						else if(i==4) {
							MCe = input.nextDouble();
						}
						else if(i==5) {
							MCf = input.nextDouble();
						}
					}
					*/
					
			//		bFunction = new PriceDemand(newPowerMC,MCa,MCb,MCc,MCd,MCe,MCf,MCx);
					System.out.println("Marginal Cost Function:");
					System.out.println(commonArray.getFunction("MC",newPowerMC));//getMC takes the ac-tc-mc
					if(costPower!=0) {
						System.out.println("What is the Quantity Demanded (Qd = x) value?");
						MCx= input.nextDouble();
					}
					System.out.println("Your Marginal Cost  at "+MCx+" is:");
					System.out.println(commonArray.findFunction("MC",newPowerMC,MCx)+"\n");//instead of findMC
				}
				
				
			}
	/*	System.out.println("Your Marginal Cost Function is:");
		System.out.println(bFunction.getMC(costPower,ACa,ACb,ACc,ACd,ACe,ACf));
		
		if(power!=0) {
			System.out.println("What is the Quantity Demanded (Qd = x) value?");
			MCx= input.nextDouble();
		}
		System.out.println("Your Marginal Cost is:");		
		System.out.println(bFunction.findMC(costPower,ACa,ACb,ACc,ACd,ACe,ACf,MCx));
	*/	

			else if(methodInput.equalsIgnoreCase("MAX")) {		//MCMR is MAX now
				String func1="",func2="";
				System.out.println("Do you want to\n(1) define a new MC?\n(2) use the AC function you defined to find the MC? \n(3) use the MC function you defined previously?");
				int ans2 = input.nextInt();
				if(ans2==1) {
					System.out.println("MC Function. What is the most power? x^(?)  Can be Max 5.");
					newNewPowerMC = input.nextInt();
					if(newNewPowerMC>5) {
						newNewPowerMC=UPPER_DEFAULT;
						System.out.println("max power is 5.");
					}
					else if (newNewPowerMC<0) {
						newNewPowerMC=LOWER_DEFAULT;
						System.out.println("max power is 0.");
					}

					double value=0;
					for(int i=0; i<newNewPowerMC+1;i++) {						
						System.out.println("input the constant of x with "+i+"'th power");
						value=input.nextDouble();
						commonArray.setArrayForEachFunction("MC",i,value);
					}
					commonArray.resetTheRest("MC", newNewPowerMC);
					/*
					for(int i=0; i<newNewPowerMC+1;i++) {
						System.out.println("input the constant of x with "+i+"'th power");
						if(i==0) {
							MCa = input.nextDouble();
						}
						else if(i==1) {
							MCb = input.nextDouble();
						}
						else if(i==2) {
							MCc = input.nextDouble();
						}
						else if(i==3) {
							MCd = input.nextDouble();
						}
						else if(i==4) {
							MCe = input.nextDouble();
						}
						else if(i==5) {
							MCf = input.nextDouble();
						}
					}
					*/
				//	bFunction = new PriceDemand(newNewPowerMC,MCa,MCb,MCc,MCd,MCe,MCf,MCx);
					System.out.println("Marginal Cost Function:");
					System.out.println(commonArray.getFunction("MC",newNewPowerMC));
					MCMRpowerMC=newNewPowerMC;
					func2="MC";
					
				//	commonArray.parameter('c',newNewPowerMC,MCa,MCb,MCc,MCd,MCe,MCf);
				}
				else if(ans2==2){
				//	bFunction = new PriceDemand(costPower,ACa,ACb,ACc,ACd,ACe,ACf,ACx);
					System.out.println("Marginal Cost Function:");
					System.out.println(commonArray.getMC("AC",costPower));
					MCMRpowerMC=costPower;
					func2="AC";
			//		commonArray.parameter('c',costPower,ACa,ACb,ACc,ACd,ACe,ACf);
					

				}
				else if (ans2==3) {
				//	bFunction = new PriceDemand(costPower,MCa,MCb,MCc,MCd,MCe,MCf,MCx);
					System.out.println("Marginal Cost Function:");
					System.out.println(commonArray.getFunction("MC",newPowerMC));
					MCMRpowerMC=newPowerMC;
					func2="MC";
			//		commonArray.parameter('c',newPowerMC,MCa,MCb,MCc,MCd,MCe,MCf);

				}
				

				System.out.println("Do you want to\n(1) define a new MR?\n(2) use the AR function you defined to find the MR? \n(3) use the MR function you defined previously?");
				int ans3 = input.nextInt();
				if(ans3==1) {
					System.out.println("MR Function. What is the most power? x^(?)  Can be Max 5.");
					newNewPowerMR = input.nextInt();
					if(newNewPowerMR>5) {
						newNewPowerMR=UPPER_DEFAULT;
						System.out.println("max power is 5.");
					}
					else if (newNewPowerMR<0) {
						newNewPowerMR=LOWER_DEFAULT;
						System.out.println("max power is 0.");
					}
					double value=0;
					for(int i=0; i<newNewPowerMR+1;i++) {						
						System.out.println("input the constant of x with "+i+"'th power");
						value=input.nextDouble();
						commonArray.setArrayForEachFunction("MR",i,value);
					}
					commonArray.resetTheRest("MR", newNewPowerMR);
					/*
					for(int i=0; i<newNewPowerMR+1;i++) {
						System.out.println("input the constant of x with "+i+"'th power");
						if(i==0) {
							MRa = input.nextDouble();
						}
						else if(i==1) {
							MRb = input.nextDouble();
						}
						else if(i==2) {
							MRc = input.nextDouble();
						}
						else if(i==3) {
							MRd = input.nextDouble();
						}
						else if(i==4) {
							MRe = input.nextDouble();
						}
						else if(i==5) {
							MRf = input.nextDouble();
						}
					}
					*/
				//	bFunction = new PriceDemand(newNewPowerMR,MRa,MRb,MRc,MRd,MRe,MRf,MRx);
					System.out.println("Marginal Revenue Function:");
					System.out.println(commonArray.getFunction("MR",newNewPowerMR));
					MCMRpowerMR=newNewPowerMR;
					func1="MR";
			//		commonArray.parameter('p',newNewPowerMR,MRa,MRb,MRc,MRd,MRe,MRf);

				}
				else if(ans3==2){
				//	bFunction = new PriceDemand(power,a,b,c,d,e,f,x);
					System.out.println("Marginal Revenue Function:");
					System.out.println(commonArray.getMR("AR",power));
					MCMRpowerMR= power;
					func1="AR";
			//		commonArray.parameter('p',power,a,b,c,d,e,f);

				}
				else if (ans3==3) {
				//	bFunction = new PriceDemand(newPowerMR,MRa,MRb,MRc,MRd,MRe,MRf,MRx);
					System.out.println("Marginal Revenue Function:");
					System.out.println(commonArray.getFunction("MR",newPowerMR));
					MCMRpowerMR= newPowerMR;
					func1="MR";
			//		commonArray.parameter('p',newPowerMR,MRa,MRb,MRc,MRd,MRe,MRf);

				}
				//do the sames for the MR
				System.out.println("Your ideal Product Quantity is:");
		//		double[][] parameter =commonArray.getParameters();
				double productNum=0;
		/**/	double resultMCMR = commonArray.findEquilibrium(func1,func2,MCMRpowerMR,MCMRpowerMC);
				//sth is wrong
				System.out.println(resultMCMR+"\n");
				System.out.println("You can either make "+(int)resultMCMR+" number of products or "+(int)(resultMCMR+1) +" number of products" );
				if(resultMCMR-(int)resultMCMR<(int)(resultMCMR+1)-resultMCMR) {
					productNum = (int)resultMCMR;
				}
				else productNum= (int)resultMCMR+1;
				System.out.println(productNum+" products would lead to better profits.\n");	
				double profit = commonArray.findMaxProfit(func1,func2,MCMRpowerMR,MCMRpowerMC, productNum);
				System.out.println("Your profits at "+productNum+" number of products is "+profit+" dollars.");
				System.out.println();
			}
			
			else if(methodInput.equalsIgnoreCase("Q")) {
				key="Q";
			}
		}	
	}

}
