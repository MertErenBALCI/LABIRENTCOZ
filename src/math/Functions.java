package math;

public class Functions {
	public static double map(double val, double start1, double stop1, double start2, double stop2) {
		double value = val - start1;
		
		double d1 = stop1 - start1;
		double d2 = stop2 - start2;
		
		value /= d1;
		value *= d2;
		
		return value + start2;
	}
}
