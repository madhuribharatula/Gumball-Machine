

import java.util.Random;

public class EnoughMoneyState implements State {
	GumballMachine gumballMachine;
 
	public EnoughMoneyState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		 gumballMachine.setTotalInsertedMoney(gumballMachine.getTotalInsertedMoney()+25);
        
    }
    
    public void insertDime(){
        System.out.println("You have Inserted Dime");
        gumballMachine.setTotalInsertedMoney(gumballMachine.getTotalInsertedMoney()+10);
         
    }
    
    public void insertNickle(){
        System.out.println("You have Inserted Nickle");
        gumballMachine.setTotalInsertedMoney(gumballMachine.getTotalInsertedMoney()+5);
        
    }
    
 
	public void ejectMoney() {
		System.out.println(gumballMachine.getTotalInsertedMoney() +" Money returned");
		gumballMachine.setTotalInsertedMoney(0);
		gumballMachine.setState(gumballMachine.getLessMoneyState());
		
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setChangeToReturn(gumballMachine.getTotalInsertedMoney() - 50);
		
		gumballMachine.setTotalInsertedMoney(0);
		gumballMachine.setNumberOfGumballOut(gumballMachine.getNumberOfGumballOut()+1);
		gumballMachine.setGumballPresentinSlot(true);
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void takeGumballFromSlot() {
        System.out.println("No gumball to take out");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
}
