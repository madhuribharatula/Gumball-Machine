

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
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
		
	    System.out.println("You can not get all the money back after turning Crank ...please take gumball instead");
		
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setChangeToReturn(gumballMachine.getTotalInsertedMoney() - 50);
		
		gumballMachine.setTotalInsertedMoney(0);
		gumballMachine.setNumberOfGumballOut(gumballMachine.getNumberOfGumballOut()+1);
		gumballMachine.setGumballPresentinSlot(true);
		//gumballMachine.setState(gumballMachine.getSoldState());
	}
 
    public void takeGumballFromSlot() {
         if(gumballMachine.getGumballPresentinSlot() ){     
            
             gumballMachine.releaseBall();
            
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getLessMoneyState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
            gumballMachine.setGumballPresentinSlot(false);
            gumballMachine.setNumberOfGumballOut(0);
          
        }
    }
 
    public String toString() {
        return "dispensing a gumball";
    }
}


