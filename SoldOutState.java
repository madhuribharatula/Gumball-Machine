

public class SoldOutState implements State {
    GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertQuarter() {
		System.out.println("You can't insert a Quarter, the machine is sold out");
	}
	public void insertDime() {
	    System.out.println("You can't insert a Dime, the machine is sold out");
	}
	public void insertNickle(){
	   System.out.println("You can't insert a Nickle, the machine is sold out");
	} 
 
	public void ejectMoney() {
		System.out.println("You can't eject, you haven't inserted a Money yet");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}
 
	public void takeGumballFromSlot() {
		System.out.println("No gumball dispensed");
	}
 
	public String toString() {
		return "sold out";
	}
}
