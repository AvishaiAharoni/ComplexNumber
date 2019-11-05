package Test;
import Complex.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComplexJUnitTest {

	@Test
	void test() {
		ComplexJUnitTest test = new ComplexJUnitTest();
		
		Complex c = Complex.parse("1");
		System.out.println(c);
		c = Complex.parse("   1");
		System.out.println(c);
		c = Complex.parse("   1   ");
		System.out.println(c);
		c = Complex.parse("-1");
		System.out.println(c);
		c = Complex.parse("  -1");
		System.out.println(c);
		c = Complex.parse("   1");
		System.out.println(c);

		System.out.println("");

		c = Complex.parse("1i");
		System.out.println(c.imaginary);
		System.out.println(c);
		c = Complex.parse("1 i");
		System.out.println(c.imaginary);
		System.out.println(c);
		c = Complex.parse("   1i");
		System.out.println(c.imaginary);
		System.out.println(c);
		c = Complex.parse("-1i");
		System.out.println(c.imaginary);
		c = Complex.parse("   -1  i");
		System.out.println(c);
		System.out.println(c.imaginary);
		System.out.println(c);
		c = Complex.parse("  - 1  i");
		System.out.println(c.imaginary);
		System.out.println(c);
		
		System.out.println("");

		c = Complex.parse("1 + 1i");
		System.out.println("real: " + c.real + "\timaginary: " + c.imaginary);
		System.out.println(c);
		Complex c1 = Complex.parse("-1 + 1i");
		System.out.println("real: " + c1.real + "\timaginary: " + c1.imaginary);
		System.out.println(c1);
		System.out.println(c1.add(c));
		System.out.println(c1.substract(c));
		c = Complex.parse("1 - 1i");
		System.out.println("real: " + c.real + "\timaginary: " + c.imaginary);
		System.out.println(c);
		c = Complex.parse("-1 - 1i");
		System.out.println("real: " + c.real + "\timaginary: " + c.imaginary);
		System.out.println(c);
		c = Complex.parse("-1 - 1   i");
		System.out.println("real: " + c.real + "\timaginary: " + c.imaginary);
		System.out.println(c);
		c = Complex.parse("-  1 - 1  i");
		System.out.println("real: " + c.real + "\timaginary: " + c.imaginary);
		System.out.println(c);
		c = Complex.parse("1 + 1j");
		System.out.println("real: " + c.real + "\timaginary: " + c.imaginary);
		System.out.println(c);
	}

}
