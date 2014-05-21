package calculator.model;

public class Calculator {
	public double Calculate(double arg1, double arg2, CalculateType calType){
		if(calType == CalculateType.Add){
			return arg1 + arg2;
		}
		if(calType == CalculateType.Sub){
			return arg1 - arg2;
		}
		if(calType == CalculateType.Mul){
			return arg1 * arg2;
		}
		if(calType == CalculateType.Div){
			return arg1 / arg2;
		}
		else
		{
			return arg2;
		}
	}
}
