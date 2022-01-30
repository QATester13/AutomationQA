package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class SampleTest1 {
  @Test(timeOut=2000,priority=0,description="I'm test Method")
  public void f() {
	  System.out.println("Hello");
  }
  @Test(timeOut=2000,priority=1,description="I'm after test method")
  public void afterTest() {
	  System.out.println("Hi good morning");
  }

}
