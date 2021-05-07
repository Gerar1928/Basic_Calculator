package Calculator;

public class ArithmeticOperations {
	
	
	public static double add(double valOne, double valTwo) {
		return valOne + valTwo;
	}
	
	public static double subtract(double valOne, double valTwo) {
		return valOne - valTwo;
	}
	
	public static double multiply(double valOne, double valTwo) {
		return valOne * valTwo;
	}
	
	public static double divide(double valOne, double valTwo) {
		return valOne / valTwo;
	}
	
	public static double[] convertValuesToDoubles(String valOne, String valTwo) {
		StringBuilder valOneStrB = new StringBuilder(valOne);
		valOneStrB.deleteCharAt((valOne.length() - 1));
		double valOneDouble = Double.parseDouble(valOneStrB.toString());
		double valTwoDouble = Double.parseDouble(valTwo);
		double[] valuesConverted = {valOneDouble, valTwoDouble};
		
		return valuesConverted;
		
	}
	
	public static double getResult(String valOne, String valTwo) {
		
		double result = 0;
		
		if (valOne.contains("+")) {
			double[] values = convertValuesToDoubles(valOne, valTwo);
			result = add(values[0], values[1]);
		} else if (valOne.contains("-")) {
			double[] values = convertValuesToDoubles(valOne, valTwo);
			result = subtract(values[0], values[1]);
		} else if (valOne.contains("*")) {
			double[] values = convertValuesToDoubles(valOne, valTwo);
			result = multiply(values[0], values[1]);
		} else if (valOne.contains("/")) {
			double[] values = convertValuesToDoubles(valOne, valTwo);
			result = divide(values[0], values[1]);
		}
		
		return result;
	}
}
