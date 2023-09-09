package com.lab3.Q1;

import java.util.Stack;

public class BalancingExpression {

	    // function to check if brackets are balanced
	    static boolean checkingBracketsExpression(String expression)
	    {
	        //for this problem stack seems valid to use because it uses FIFO rule
	        Stack<Character> stack = new Stack<Character>();
	 
	        for (int i = 0; i < expression.length(); i++)
	        {
	            char character = expression.charAt(i);
	 
	            if (character == '(' || character == '[' || character == '{')
	            {
	               
	                stack.push(character);
	                continue;
	            }
	 
	          
	            if (stack.isEmpty())
	                return false;
	            
	            char c;
	            
	            switch (character) {
	            
	            case '}':
	            	
	            	c = stack.pop();
	                if (c == '(' || c == '[')
	                    return false;
	                break;
	                
	            case ')':
	            	
	                c = stack.pop();
	                if (c == '{' || c == '[')
	                    return false;
	                break;
	 
	            case ']':
	                c = stack.pop();
	                if (c == '(' || c == '{')
	                    return false;
	                break;
	            }
	        }	       
	        return (stack.isEmpty());
	    }
	 
	    private static void evaluateExpression(String expression) {
		        Boolean result;
		        result = checkingBracketsExpression(expression);
		        if (result)
		             System.out.println("The entered String has Balanced Brackets");
		        else
		             System.out.println("The entered Strings do not contain Balanced Brackets ");
	    }
	    
	    // Driver code
	    public static void main(String[] args)
	    {
	    	 String bracketExpression1 = "([[{}]])";
	    	 String bracketExpression2 = "([[{}]]))";
	    	 evaluateExpression(bracketExpression1);
	    	 evaluateExpression(bracketExpression2);
	    	 
	    	 
	   }
	}

