package org.egov.stack;

import java.util.function.DoubleBinaryOperator;

public class Operator {
	
	public static DoubleBinaryOperator add=new DoubleBinaryOperator() {

		@Override
		public double applyAsDouble(double input1, double input2) {
			// TODO Auto-generated method stub
			return input1+input2;
		}
	
   };
   
   public static DoubleBinaryOperator minus=new DoubleBinaryOperator() {

		@Override
		public double applyAsDouble(double input1, double input2) {
			// TODO Auto-generated method stub
			return input1-input2;
		}
	
   };
   
   public static DoubleBinaryOperator multiple=new DoubleBinaryOperator() {

		@Override
		public double applyAsDouble(double input1, double input2) {
			// TODO Auto-generated method stub
			return input1*input2;
		}
   };
   
   public static DoubleBinaryOperator division=new DoubleBinaryOperator() {

		@Override
		public double applyAsDouble(double input1, double input2) {
			// TODO Auto-generated method stub
			return input1/input2;
		}
   };

}
