package com.mistersoandso.inBalance;

import java.util.*;

public class Stack_In_Test
{
    public static void main(String[] args) 
    {
        Stack<Character> si = new Stack<Character>();
        
        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter an expression to test if balance:");
        String inputCon = scanner.nextLine();
        
        if(inputCon.length() == 0)
        {
            System.out.println("Empty String ... Invalid Input");
            System.out.println("False");
            System.exit(0);
        }
        
              
        for (int i = 0; i < inputCon.length(); i++) 
	{
            char cInput = inputCon.charAt(i);
            if (cInput == '[' || cInput == '(' || cInput == '{') 
            {
                si.push(cInput);
            } 
            else if ((cInput == ']' || cInput == '}' 
                    || cInput == ')')&& (!si.isEmpty())) 
            {
                if (((char) si.peek() == '(' && cInput == ')')
                || ((char) si.peek() == '{' && cInput == '}')
                || ((char) si.peek() == '[' && cInput == ']')) 
                {
                    si.pop();
                } 
                else 
                {
                    System.out.println("False");
                    System.exit(0);
                }
            }
            else 
            {
                if ((cInput == ']' || cInput == '}' || cInput == ')')) 
                {
                    //if i find this first before anything else
                    System.out.println("False");
                    System.exit(0);
                }
            }

        }
        
        if(si.isEmpty())
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
        
        //System.out.println("Execution Finished");
    }
}