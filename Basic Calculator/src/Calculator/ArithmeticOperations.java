package Calculator;

public class ArithmeticOperations {
	
	
	public static double addition(double valOne, double valTwo) {
		return valOne + valTwo;
	}
	
	public static double subtraction(double valOne, double valTwo) {
		return valOne - valTwo;
	}
	
	public static double multiplication(double valOne, double valTwo) {
		return valOne * valTwo;
	}
	
	public static double division(double valOne, double valTwo) {
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
			result = addition(values[0], values[1]);
		} else if (valOne.contains("-")) {
			double[] values = convertValuesToDoubles(valOne, valTwo);
			result = subtraction(values[0], values[1]);
		} else if (valOne.contains("*")) {
			double[] values = convertValuesToDoubles(valOne, valTwo);
			result = multiplication(values[0], values[1]);
		} else if (valOne.contains("/")) {
			double[] values = convertValuesToDoubles(valOne, valTwo);
			result = division(values[0], values[1]);
		}
		
		return result;
	}
}
