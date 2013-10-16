import static org.junit.Assert.*;

import org.junit.Test;

/*Since the formulas to convert between Kelvin, Farhenheit and Celsius 
are not exact, we will consider the result given correct if the 
result given and the actual result do not diverge by more than than 1^(-6)*/


public class TemperatureTest {

	@Test
	public void testGetUnits (){//Check that the getUnits() returns the correct Unit every time
		   System.out.println("Test if getUnits() returns FAHRENHEIT ...");
		   Temperature t1 = new Temperature(0, Temperature.Units.FAHRENHEIT);
		   assertTrue (t1.getUnits() == Temperature.Units.FAHRENHEIT);
		   System.out.println("Test if getUnits() returns CELSIUS...");
		   Temperature t2 = new Temperature(0, Temperature.Units.CELSIUS);
		   assertTrue (t2.getUnits() == Temperature.Units.CELSIUS);
		   System.out.println("Test if getUnits() returns KELVIN...");
		   Temperature t3 = new Temperature(0, Temperature.Units.KELVIN);
		   assertTrue (t3.getUnits() == Temperature.Units.KELVIN);
		  

	}
	
	@Test
	public void testGetValueFarenheit(){
	
		//boundary testing for Fahrenheit values with -1, 0, 1 to check sign handling
		
		System.out.println("Test for -1 F if getValue() returns -1 ...");
		Temperature t1 = new Temperature(-1, Temperature.Units.FAHRENHEIT);
		double outputValue1 = t1.getValue(); 
		assertTrue (Math.abs(outputValue1 + 1) <= Math.pow(1, -6));
		System.out.println("Test for 0 F if getValue() returns 0 ...");
		Temperature t2 = new Temperature(0, Temperature.Units.FAHRENHEIT);
		double outputValue2 = t2.getValue(); 
		assertTrue (Math.abs(outputValue2) <= Math.pow(1, -6));
		System.out.println("Test for 1 F if getValue() returns 1 ...");
		Temperature t3 = new Temperature(1, Temperature.Units.FAHRENHEIT);
		double outputValue3 = t3.getValue(); 
		assertTrue (Math.abs(outputValue3 - 1) <= Math.pow(1, -6));

		//good data for Farhenheit values with 15.5
		
		System.out.println("Test for 15.5 F if getValue() returns 15.5 ...");
		Temperature t4 = new Temperature(15.5, Temperature.Units.FAHRENHEIT);
		double outputValue4 = t4.getValue(); 
		assertTrue (Math.abs(outputValue4 - 15.5) <= Math.pow(1, -6));
	
		
	}
	
	@Test
	public void testGetValueCelsius(){
		
		//boundary testing for Celsius values with -1, 0, 1 to check sign handling
		
		System.out.println("Test for -1 C if getValue() returns -1 ...");
		Temperature t1 = new Temperature(-1, Temperature.Units.CELSIUS);
		assertTrue (t1.getValue() == -1.0);
		System.out.println("Test for 0 C if getValue() returns 0 ...");
		Temperature t2 = new Temperature(0, Temperature.Units.CELSIUS);
		assertTrue (t2.getValue() == 0.0);
		System.out.println("Test for 1 C if getValue() returns 1 ...");
		Temperature t3 = new Temperature(1, Temperature.Units.CELSIUS);
		assertTrue (t3.getValue() == 1.0);
		
		//good data for Celsius values with 15.5
		
		System.out.println("Test for 15.5 C if getValue() returns 15.5 ...");
		Temperature t4 = new Temperature(15.5, Temperature.Units.CELSIUS);
		assertTrue (t4.getValue() == 15.5);
		
	}
	
	@Test
	public void testGetValueKelvin(){
		
		//boundary testing for Kelvin values 0, 1
		/* -1 is not defined in Kelvin, it is bad data so it should display an error message,
		therefore I modified the Temperature class so that the convertToKelvin function throws 
		an IllegalArgumentException() if the value passed as input is in Kelvin and is inferior to 0.
		It can be handled to print an error message. The same is true if the temperature in C is inferior 
		to -273.15 and in F if the temperature is inferior to -459.67. 
		 */
		
		System.out.println("Test for 0 K if getValue() returns 0 ...");
		Temperature t2 = new Temperature(0, Temperature.Units.KELVIN);
		assertTrue (t2.getValue() == 0.0);
		System.out.println("Test for 1 K if getValue() returns 1 ...");
		Temperature t3 = new Temperature(1, Temperature.Units.KELVIN);
		assertTrue (t3.getValue() == 1.0);
		
		//good data for Kelvin values with 15.5
		
		System.out.println("Test for 15.5 K if getValue() returns 15.5 ...");
		Temperature t4 = new Temperature(15.5, Temperature.Units.KELVIN);
		assertTrue (t4.getValue() == 15.5);
		
	}
	
	@Test
	public void testChangeUnitsKelvinToCelsius(){
	
		//boundary testing with 0, 1
		
		System.out.println("Test for 0 K if changeUnits gives -273.15 C ...");
		Temperature t1 =new Temperature( 0, Temperature.Units.KELVIN);
		t1.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(t1.getUnits() == Temperature.Units.CELSIUS);
		double outputValue1 =  t1.getValue();
		assertTrue(Math.abs(outputValue1 + 273.15) < Math.pow(1, -6));
	
		System.out.println("Test for 1 K if changeUnits gives -272.15 C ...");
		Temperature t2 =new Temperature( 1, Temperature.Units.KELVIN);
		t2.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(t2.getUnits() == Temperature.Units.CELSIUS);
		double outputValue2 =  t2.getValue();
		assertTrue(Math.abs(outputValue2 + 272.15) < Math.pow(1, -6));
	
		//good data with value 293.8
	
		System.out.println("Test for 293.8 K if changeUnits gives 20.65 C ...");
		Temperature t3 =new Temperature(293.8, Temperature.Units.KELVIN);
		t3.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(t3.getUnits() == Temperature.Units.CELSIUS);
		double outputValue3 =  t3.getValue();
		assertTrue(Math.abs(outputValue3 - 20.65) < Math.pow(1, -6));
	
	}
	
	@Test
	public void testChangeUnitsKelvinToFahrenheit(){
	 
		//boundary testing with 0, 1
		
		System.out.println("Test for 0 K if changeUnits gives -459.67 F ...");
		Temperature t1 =new Temperature(0, Temperature.Units.KELVIN);
		t1.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(t1.getUnits() == Temperature.Units.FAHRENHEIT);
		double outputValue1 =  t1.getValue();
		assertTrue(Math.abs(outputValue1 + 459.67) < Math.pow(1, -6));
	
	
		System.out.println("Test for 1 K if changeUnits gives -457.87 F ...");
		Temperature t2 =new Temperature(1, Temperature.Units.KELVIN);
		t2.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(t2.getUnits() == Temperature.Units.FAHRENHEIT);
		double outputValue2 =  t2.getValue();
		assertTrue(Math.abs(outputValue2 + 457.87) < Math.pow(1, -6));

		//good data with value 293.8
	
		System.out.println("Test for 293.8 K if changeUnits gives 69.17 F ...");
		Temperature t3 =new Temperature(293.8, Temperature.Units.KELVIN);
		t3.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(t3.getUnits() == Temperature.Units.FAHRENHEIT);
		double outputValue3 =  t3.getValue();
		assertTrue(Math.abs(outputValue3 - 69.17) < Math.pow(1, -6));
	

	}
	
	@Test
	public void testChangeUnitsCelsiusToKelvin(){
		
		//We check that when the temperature in Celsius changes sign the result in Kelvin is consistent
		//boundary testing with values -0.15, 0, 0.85 
		
		System.out.println("Test for -0.15 C if changeUnits gives 273 K ...");
		Temperature t1 =new Temperature(-0.15, Temperature.Units.CELSIUS);
		t1.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t1.getUnits() == Temperature.Units.KELVIN);
		double outputValue1 =  t1.getValue();
		assertTrue(Math.abs(outputValue1 -273) < Math.pow(1, -6));
	
		System.out.println("Test for 0 C if changeUnits gives 273.15 K ...");
		Temperature t2 =new Temperature(0, Temperature.Units.CELSIUS);
		t2.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t2.getUnits() == Temperature.Units.KELVIN);
		double outputValue2 =  t2.getValue();
		assertTrue(Math.abs(outputValue2 -273.15) < Math.pow(1, -6));
	
		
		System.out.println("Test for 0.85 C if changeUnits gives 274 K ...");
		Temperature t3 =new Temperature(0.85, Temperature.Units.CELSIUS);
		t3.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t3.getUnits() == Temperature.Units.KELVIN);
		double outputValue3 =  t3.getValue();
		assertTrue(Math.abs(outputValue3 -274) < Math.pow(1, -6));
		
		//good data with value 20.65
		
		System.out.println("Test for 20.65 C if changeUnits gives 293.8 K ...");
		Temperature t4 =new Temperature(20.65, Temperature.Units.CELSIUS);
		t4.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t4.getUnits() == Temperature.Units.KELVIN);
		double outputValue4 =  t4.getValue();
		assertTrue(Math.abs(outputValue4 - 293.8) < Math.pow(1, -6));
		
	
	
	}
	
	@Test
	public void testChangeUnitsCelsiusToFahrenheit(){
		
		//We check that when the temperature in Celsius changes sign the result in Farhenheit is consistent
		//boundary testing with values -0.15, 0, 0.85 
		
		System.out.println("Test for -0.15 C if changeUnits gives 31.73 F ...");
		Temperature t1 =new Temperature(-0.15, Temperature.Units.CELSIUS);
		t1.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(t1.getUnits() == Temperature.Units.FAHRENHEIT);
		double outputValue1 =  t1.getValue();
		assertTrue(Math.abs(outputValue1 - 31.73) < Math.pow(1, -6));
	
		System.out.println("Test for 0 C if changeUnits gives 32 F ...");
		Temperature t2 =new Temperature(0, Temperature.Units.CELSIUS);
		t2.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(t2.getUnits() == Temperature.Units.FAHRENHEIT);
		double outputValue2 =  t2.getValue();
		assertTrue(Math.abs(outputValue2 -32) < Math.pow(1, -6));
	
		
		System.out.println("Test for 0.85 C if changeUnits gives 33.53 F ...");
		Temperature t3 =new Temperature(0.85, Temperature.Units.CELSIUS);
		t3.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(t3.getUnits() == Temperature.Units.FAHRENHEIT);
		double outputValue3 =  t3.getValue();
		assertTrue(Math.abs(outputValue3 -33.53) < Math.pow(1, -6));
		
		//good data with value 20.65
		
		System.out.println("Test for 20.65 C if changeUnits gives 69.17 F ...");
		Temperature t4 =new Temperature(20.65, Temperature.Units.CELSIUS);
		t4.changeUnits(Temperature.Units.FAHRENHEIT);
		assertTrue(t4.getUnits() == Temperature.Units.FAHRENHEIT);
		double outputValue4 =  t4.getValue();
		assertTrue(Math.abs(outputValue4 -69.17) < Math.pow(1, -6));
	}
	
	@Test
	public void testChangeUnitsFahrenheitToKelvin(){
		
		//We check that when the temperature in Fahrenheit changes sign, the result in Kelvin is consistent
		// boundary testing with values -0.67, 0, 1.13
		
		System.out.println("Test for -0.67 F if changeUnits gives 255 K ...");
		Temperature t1 =new Temperature(-0.67, Temperature.Units.FAHRENHEIT);
		t1.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t1.getUnits() == Temperature.Units.KELVIN);
		double outputValue1 =  t1.getValue();
		assertTrue(Math.abs(outputValue1 -255) < Math.pow(1, -6));
		
		System.out.println("Test for 0 F if changeUnits gives 255.22222 K ...");
		Temperature t2 =new Temperature( 0, Temperature.Units.FAHRENHEIT);
		t2.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t2.getUnits() == Temperature.Units.KELVIN);
		double outputValue2 =  t2.getValue();
		assertTrue(Math.abs(outputValue2 -255.22222) < Math.pow(1, -6));
		
		System.out.println("Test for 1.13 F if changeUnits gives 256 K ...");
		Temperature t3 =new Temperature( 1.13, Temperature.Units.FAHRENHEIT);
		t3.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t3.getUnits() == Temperature.Units.KELVIN);
		double outputValue3 =  t3.getValue();
		assertTrue(Math.abs(outputValue3 -256) < Math.pow(1, -6));
		
		//good data with value 69.17
		
		System.out.println("Test for 69.17 F if changeUnits gives 293.8 K ...");
		Temperature t4 =new Temperature( 69.17, Temperature.Units.FAHRENHEIT);
		t4.changeUnits(Temperature.Units.KELVIN);
		assertTrue(t4.getUnits() == Temperature.Units.KELVIN);
		double outputValue4 =  t4.getValue();
		assertTrue(Math.abs(outputValue4 -293.8) < Math.pow(1, -6));
		
		
	}
	
	@Test
	public void testChangeUnitsFahrenheitToCelsius(){
		
		//We check that when the temperature in Fahrenheit changes sign, the result in Kelvin is consistent
		// boundary testing with values -0.67, 0, 1.13
		
		System.out.println("Test for -0.67 F if changeUnits gives -18.15 C ...");
		Temperature t1 =new Temperature( -0.67, Temperature.Units.FAHRENHEIT);
		t1.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(t1.getUnits() == Temperature.Units.CELSIUS);
		double outputValue1 =  t1.getValue();
		assertTrue(Math.abs(outputValue1 + 18.15) < Math.pow(1, -6));
		
		System.out.println("Test for 0 F if changeUnits gives -17.778 ...");
		Temperature t2 =new Temperature( 0, Temperature.Units.FAHRENHEIT);
		t2.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(t2.getUnits() == Temperature.Units.CELSIUS);
		double outputValue2 =  t2.getValue();
		assertTrue(Math.abs(outputValue2 + 17.778) < Math.pow(1, -6));
		
		System.out.println("Test for 1.13 F if changeUnits gives -17.15 C ...");
		Temperature t3 =new Temperature( 1.13, Temperature.Units.FAHRENHEIT);
		t3.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(t3.getUnits() == Temperature.Units.CELSIUS);
		double outputValue3 =  t3.getValue();
		assertTrue(Math.abs(outputValue3 + 17.15) < Math.pow(1, -6));
		
		//good data with value 69.17
		
		System.out.println("Test for 69.17 F if changeUnits gives 20.65 C ...");
		Temperature t4 =new Temperature( 69.17, Temperature.Units.FAHRENHEIT);
		t4.changeUnits(Temperature.Units.CELSIUS);
		assertTrue(t4.getUnits() == Temperature.Units.CELSIUS);
		double outputValue4 =  t4.getValue();
		assertTrue(Math.abs(outputValue4 - 20.65) < Math.pow(1, -6));
		
	}
	
}
