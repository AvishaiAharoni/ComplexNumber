package Complex;

import java.util.regex.Pattern;

public class Complex implements Comparable<Complex> {
	public int real;
	public int imaginary;
	
	Complex() { }
	
	public boolean isReal() {
		return (imaginary == 0);
	}
	
	public boolean isImaginary() {
		return (real == 0);	
	}
	
	public Complex add(Complex num) {
		Complex newComp = new Complex();
		
		newComp.real = Math.addExact(this.real, num.real);
		newComp.imaginary = Math.addExact(this.imaginary, num.imaginary);
		
		return newComp;
	}
	
	public Complex substract(Complex num) {
		Complex newComp = new Complex();
		
		newComp.real = Math.subtractExact(this.real, num.real);
		newComp.imaginary = Math.subtractExact(this.imaginary, num.imaginary);
		
		return newComp;
	}
	
	public static Complex setComplex(String str, Complex myComp) {
		// to remove the last char from the number (i \ j)
		str = str.replaceFirst(".$","");
		
		// to find the index of the + or - in the complex number
		int idx = str.indexOf('+');
		if (idx != -1) {
			// to skip the + sign
			myComp.imaginary = Integer.parseInt(str.substring(idx + 1));			
		}
		else {
			idx = str.indexOf('-', 1);
			myComp.imaginary = Integer.parseInt(str.substring(idx));			
		}
		
		myComp.real = Integer.parseInt(str.substring(0, idx));
		
		return myComp;
	}
	
	public static Complex parse(String str) {
		// to remove all the spaces
		str = str.replaceAll("\\s+","");
		
		// to create all the patterns of the string
		final String[] pattern = { ("^(-?\\d+)([-|+])(\\d+)(i|j)$"),		// x + xi
							 ("^(-?\\d+)$"),						// x
						 	 ("^(-?\\d+)(i|j)$") };					// xi

		Complex myComp = new Complex();

		if (Pattern.matches(pattern[0], str)) {						// a complex number
			myComp = setComplex(str, myComp);
		}
		else if (Pattern.matches(pattern[1], str)) {				// a real number
			myComp.real = Integer.parseInt(str);
		}
		else if (Pattern.matches(pattern[2], str)) {				// an imaginary number
			myComp.imaginary = Integer.parseInt(str.replaceFirst(".$",""));
		}
		else {
			throw new IllegalArgumentException("the pattern does not fit!");
		}
		
		return myComp;
	}
	
	public int getReal() {
		return this.real;
	}
	
	public int getImaginary() {
		return this.imaginary;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Complex) {
			return ((this.real == ((Complex)(obj)).real) &&
					(this.imaginary == ((Complex)(obj)).imaginary));
		}
		
		return false; 
	}
	
	@Override
	public int hashCode() {
		return Math.addExact((real + 17 * 31),(imaginary + 17 * 31));
	}

	@Override
	public String toString() {
		String str = Integer.toString(real);
		
		int sign = Integer.signum(imaginary); 
		if (sign == 0) {							// there isn't imaginary number
			return str;
		}
		else if (sign == 1) {						// the imaginary number is positive
			str = str + "+";
		}
		
		return (str + imaginary + "i");
	}
	
	@Override
	public int compareTo(Complex o) {
		final double sqr1 = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
		final double sqr2 = Math.sqrt(Math.pow(o.real, 2) + Math.pow(o.imaginary, 2));
		
		return (int)(sqr1 - sqr2);
	}
}