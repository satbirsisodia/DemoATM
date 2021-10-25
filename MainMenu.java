package atmApp;

import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;


public class MainMenu extends Account{

	
		Scanner menuInput = new Scanner(System.in);
		DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00"); //in which we want to currency to be displayed that is your account
		
		HashMap<Integer, Integer> data = new HashMap<Integer, Integer>(); 
//		in hashmap set of records or mapping wherein we have cust no. and pin no. 
//		which is associated with a particular cust no.

		public void getLogin() throws IOException {
			int x=1;
			do {
				try {
					data.put(987678, 9900);
					data.put(987679, 9966);
					data.put(987676, 9955);
					data.put(987675, 9977);
					
					System.out.println("Welcome to the DEMO ATM!!");
					System.out.println("Enter your customer number:");
					setCustomerNumber(menuInput.nextInt());
					
					System.out.println("Enter your PIN number:");
					setPinNumber(menuInput.nextInt());
				
					
				} catch (Exception e) {
					System.out.println("\n" + "Invalid Character(s). Only Numbers."+ "\n");
					x=2;
				}
				
				int cn = getCustomerNumber();
				int pn = getPinNumber();
				
				if(data.containsKey(cn) && data.get(cn)==pn) {
					getAccountType();
				}else
					System.out.println("\n"+ "Wrong Customer NUmber or PIN Number"+ "\n");
			
			} while(x==1);
		}		
				
			private void getAccountType() {
				System.out.println("Select the Account you want to Access:");
				System.out.println("Press 1 - Current Account");
				System.out.println("Press 2 - Saving Account");
				System.out.println("Press 3 - Exit");
				
				int selection = menuInput.nextInt();
				switch(selection) {
				case 1:
					getCurrent();
					break;
				case 2:
					getSaving();
					break;
				case 3:
					System.out.println("Thankyou for using this ATM.\n\n");
					break;
				default:
					System.out.println("\n" + "Invalid Choice." + "\n");
					getAccountType();
				}
					
			}
					
			private void getCurrent() {
				System.out.println("Current Account:");
				System.out.println("Press 1 - View Balance");
				System.out.println("Press 2 - Withdraw Funds");
				System.out.println("Press 3 - Deposit Funds");
				System.out.println("Press 4 - Exit");
				System.out.print("Choice:");
				
				int selection = menuInput.nextInt();
				switch(selection) {
				case 1:
					System.out.println("Current Account Balance: " +moneyFormat.format(getCurrentBalance()));
					getAccountType();
					break;
					
				case 2:
					getCurrentWithdrawInput();
					getAccountType();
					break;
					
				case 3:
					getCurrentDepositInput();
					getAccountType();
					break;
				
				case 4:
					System.out.println("Thankyou for using this ATM.\n\n");
					break;
				
				default:
					System.out.println("\n" + "Invalid Choice." + "\n");
					getCurrent();
					
				}
			}
		
			private void getSaving() {
				System.out.println("Saving Account:");
				System.out.println("Press 1 - View Balance");
				System.out.println("Press 2 - Withdraw Funds");
				System.out.println("Press 3 - Deposit Funds");
				System.out.println("Press 4 - Exit");
				System.out.print("Choice:");
				
				int selection = menuInput.nextInt();
				switch(selection) {
				case 1:
					System.out.println("Saving Account Balance: " +moneyFormat.format(getSavingBalance()));
					getAccountType();
					break;
					
				case 2:
					getSavingWithdrawInput();
					getAccountType();
					break;
					
				case 3:
					getSavingDepositInput();
					getAccountType();
					break;
				
				case 4:
					System.out.println("Thankyou for using this ATM.\n\n");
					break;
				
				default:
					System.out.println("\n" + "Invalid Choice." + "\n");
					getCurrent();
					
				}
				
				
			}
		
		
	

	


	

				
				

}
