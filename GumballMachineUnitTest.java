

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineUnitTest.
 *
 * @author  Lakshmi Bharatula
 * @version (a version number or a date)
 */
public class GumballMachineUnitTest
{
    GumballMachine  gumballMachine;
    /**
     * Default constructor for test class GumballMachineUnitTest
     */
    public GumballMachineUnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
         gumballMachine = new GumballMachine(5);

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void GettingGumballFlowTest(){
        
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.insertDime();
        gumballMachine.insertNickle();
        gumballMachine.turnCrank();
        assertEquals(true, gumballMachine.isGumballInSlot()); // did not took gumball from slot so isGumballInSlot should return true.
        gumballMachine.takeGumballFromSlot();
        assertEquals(false, gumballMachine.isGumballInSlot()); // took ball out in the above step so isGumballInSlot should return false.
                
    }
    
    @Test
    public void lessmoneyinsertTest(){
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.turnCrank();
        gumballMachine.takeGumballFromSlot();
        //assertEquals(35, gumballMachine.getTotalInsertedMoney()); 
        assertEquals(false, gumballMachine.isGumballInSlot());    
         
    }
    
     @Test
    public void moremoneyinsertTest(){
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.insertDime();
        gumballMachine.insertNickle();
        gumballMachine.insertDime();
        gumballMachine.insertNickle();
        gumballMachine.turnCrank();
        assertEquals(true, gumballMachine.isGumballInSlot()); 
        //assertEquals(15, gumballMachine.getChangeToReturn());   
        gumballMachine.takeGumballFromSlot();
        assertEquals(false, gumballMachine.isGumballInSlot()); 
             
    }
    
   @Test
   public void lessMoneyandAddingMoreTest(){
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.turnCrank();
        gumballMachine.takeGumballFromSlot();
       // assertEquals(35, gumballMachine.getTotalInsertedMoney()); 
        assertEquals(false, gumballMachine.isGumballInSlot());    
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        assertEquals(true, gumballMachine.isGumballInSlot()); 
       // assertEquals(10, gumballMachine.getChangeToReturn()); 
        gumballMachine.takeGumballFromSlot();
        assertEquals(false, gumballMachine.isGumballInSlot());
      //  assertEquals(0, gumballMachine.getChangeToReturn());  // change should be zero after taking gumball as it is returned with gumball
         
    }
    
    @Test
    public void turningCrankTwiceTest(){
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.insertDime();
        gumballMachine.insertNickle();
        gumballMachine.turnCrank();
        assertEquals(true, gumballMachine.isGumballInSlot());
        //second time adding money with out tking gumball
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.insertDime();
        gumballMachine.insertNickle();
        gumballMachine.turnCrank();
        assertEquals(true, gumballMachine.isGumballInSlot());
        //System.out.println("no of gumballout" + gumballMachine.getNumberOfGumballOut());
       // assertEquals(2,gumballMachine.getNumberOfGumballOut());
        gumballMachine.takeGumballFromSlot();
        assertEquals(false, gumballMachine.isGumballInSlot());
    }
    
    @Test
    public void ejectMoneyBeforeTurnCrankTest(){
        
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.insertDime();
        gumballMachine.insertNickle();
        gumballMachine.ejectMoney();
       // assertEquals(0, gumballMachine.getTotalInsertedMoney());
        assertEquals(false, gumballMachine.isGumballInSlot());
    }
    
    @Test
    public void ejectMoneyafterTurnCrankTest(){
        
        gumballMachine.insertQuarter();
        gumballMachine.insertDime();
        gumballMachine.insertDime();
        gumballMachine.insertNickle();
        gumballMachine.turnCrank();
        gumballMachine.ejectMoney();
        assertEquals(true, gumballMachine.isGumballInSlot()); // have a gumball ,can not eject after crank 
    }
    
    @Test
    public void Addingmoremoneybutlessthan50centsTest(){
        gumballMachine.insertDime();
        gumballMachine.turnCrank();
        gumballMachine.insertDime();
        gumballMachine.turnCrank();
        gumballMachine.takeGumballFromSlot();
       // assertEquals(20, gumballMachine.getTotalInsertedMoney());
        assertEquals(false, gumballMachine.isGumballInSlot());
    }
        
        
}
