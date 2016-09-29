
package org.egov.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stack{
	
	ArrayList<Object> stackObj=new ArrayList<Object>();
		
	final String INPUT_ARITHMETIC_EXP="^\\s*(\\d+)+\\s*((?>([\\+\\-\\*\\/])+\\s*(\\d+))?)\\s*$";
		
	private final static HashMap<String, DoubleBinaryOperator> operationSet=new HashMap<String, DoubleBinaryOperator>(){{
	   put("+", Operator.add);
	   put("-", Operator.minus);
	   put("*", Operator.multiple);
	   put("/", Operator.division);
    }};
	
	public void push(Object value) throws Exception
	{
		if(value==null){ throw new NullPointerException("Null is not allowed to push!"); }		
		stackObj.add(getArithmeticExpResult(value));
	}
	
	public Object pop()
	{
		Object popObj=(stackObj.size()==0?null:stackObj.get(stackObj.size()-1));
		stackObj.remove(popObj);
		return popObj;
	}
	
	public Object[] toArray(){
		return stackObj.toArray(new Object[stackObj.size()]);
	}
	
	public int size()
	{
		return stackObj.size();
	}
	
	public boolean isEmpty()
	{
		return (stackObj.size()==0);
	}
	
	public boolean contains(Object value) throws Exception
	{
		if(value==null){ throw new NullPointerException(); }
		return stackObj.contains(value);
	}
	
	Object getArithmeticExpResult(Object exp)
	{
		if(exp instanceof String){
			Pattern pattern = Pattern.compile(INPUT_ARITHMETIC_EXP);
			Matcher matcher = pattern.matcher(exp.toString());
			if(matcher.matches())
			{
				if(matcher.group(2).equals("")){
					return Double.valueOf(matcher.group(1).trim());
				}
				DoubleBinaryOperator operation=operationSet.get(matcher.group(3).trim());
				return operation.applyAsDouble(Double.valueOf(matcher.group(1).trim()), Double.valueOf(matcher.group(4).trim()));
			}
		}
		return exp;
	}
	
}