

public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State lessMoneyState;
    State enoughMoneyState;
    State soldState;
    State state = soldOutState;
    int count = 0; 
    int numberOfGumballOut = 0;
    int totalInsertedMoney=0;
    int changeToReturn = 0;
    boolean gumballPresentinSlot= false;
    
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        enoughMoneyState = new EnoughMoneyState(this);
        lessMoneyState = new LessMoneyState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = lessMoneyState;
        } 
    }
 
    public void insertQuarter() {
        state.insertQuarter();
    }
    public void insertDime() {
        state.insertDime();
    }
    
    public void insertNickle(){
        state.insertNickle();
    }
    
    public  boolean isGumballInSlot() {
    
        return getGumballPresentinSlot();
        
    }
    
    public void takeGumballFromSlot() {
         //System.out.println("take the gumballs from the slot");
         //setGumballPresentinSlot(false);
         
         state.takeGumballFromSlot();
         
     }
     
    public void ejectMoney() {
        state.ejectMoney();
    }
 
    public void turnCrank() {
        state.turnCrank();
       // state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        System.out.println("Gumballs are coming out of machine ... ");
        System.out.println(" " + getNumberOfGumballOut() + " Gumballs rolled out . Take them from slot ");
        if(getChangeToReturn()>0){
		    System.out.println("Dont forget to collect change of   "+ getChangeToReturn());
		    setChangeToReturn(0);
		}
        if (count != 0) {
            count = count - 1;
        }
    }
        
    // getters and setters 
 
    public boolean getGumballPresentinSlot(){
         return gumballPresentinSlot;
     }
     
    public  void setGumballPresentinSlot(boolean gumballPresentinSlot){
         this.gumballPresentinSlot=gumballPresentinSlot;
     }
     
    public int getTotalInsertedMoney(){
        return totalInsertedMoney;
    }
    
    public void setTotalInsertedMoney(int totalInsertedMoney){
        this.totalInsertedMoney=totalInsertedMoney;
    }
    
    public int getChangeToReturn(){
        return changeToReturn;
    }
    
    public void setChangeToReturn(int changeToReturn){
        this.changeToReturn=changeToReturn;
    }
    
    public int getNumberOfGumballOut(){
       return numberOfGumballOut;
    }
    
    public void setNumberOfGumballOut(int numberOfGumballOut){
      this.numberOfGumballOut=numberOfGumballOut;
    }
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = lessMoneyState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getLessMoneyState() {
        return lessMoneyState;
    }

    public State getEnoughMoneyState() {
        return enoughMoneyState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
