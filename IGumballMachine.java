
/**
 * Write a description of interface IGumballMachine here.
 * 
 * @author Lakshmi Bharatula 
 * @version (a version number or a date)
 */
public interface IGumballMachine
{
     void insertQuarter();
     void insertDime();
     void insertNickle();   
     void turnCrank();   
     boolean isGumballInSlot();  
     void takeGumballFromSlot();
 }