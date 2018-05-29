package sieves;

import java.util.*;

public class main_test
{
    public static void main(String[] args) 
    {
        Queue<Integer> queueOfIntegers = new Queue<Integer>();
        Queue<Integer> queueOfPrimes = new Queue<Integer>();
        
        Scanner scanner = new Scanner( System.in );
        System.out.printf("Enter an integer N:");
        int inputCon = Integer.valueOf(scanner.nextLine());
        if(inputCon == 0)
        {
            System.out.println("0 is an Invalid Input");
            System.exit(0);
        }
        for (int i = 2; i <=inputCon; i++)  // populate queueofInt
        {
            queueOfIntegers.enqueue(i);
        }
        
        int curr_mod = 0; //temp value
        int temp_mem =0;
        
        while(!(queueOfIntegers.isEmpty()))
        {
            System.out.printf("\nContent of: queueOfIntegers: ");
            queueOfIntegers.display();
            
            
            System.out.printf("%n%s %d %n" ,"Dequeuing a prime number:", queueOfIntegers.front());
            queueOfPrimes.enqueue(queueOfIntegers.front()); //push onto Prime
            queueOfIntegers.dequeue();  //pop off QoInt
                            
            System.out.printf("Content of: queueOfPrimes: ");
            queueOfPrimes.display();    //print prime queue
           
            //modulous
            temp_mem = queueOfIntegers.front();
            curr_mod = queueOfIntegers.front();
            
            
                queueOfIntegers.pop_front();    //temp pop off QoInt 
            
            
            if((queueOfIntegers.isEmpty())) //if last queue value
            {
                System.out.printf("%n%s %d %n" ,"Content of: queueOfIntegers:", curr_mod);
                System.out.printf("%s %d %n" ,"Dequeuing a prime number:", curr_mod);
                queueOfPrimes.push_back(curr_mod);
                System.out.printf("Content of: queueOfPrimes: ");
                queueOfPrimes.display();
                
                System.out.printf("\nContent of: queueOfIntegers: ");
                queueOfIntegers.display();
                System.out.printf("\nContent of: queueOfPrimes: ");
                queueOfPrimes.display();
                System.out.printf("\n");
                System.exit(0);
            }
            if(!(curr_mod%(queueOfPrimes.back()) ==0) && !(queueOfIntegers.isEmpty()))
            {
                queueOfIntegers.push_back(curr_mod);
            }
            if(!(curr_mod%(queueOfPrimes.back()) ==0) && (queueOfIntegers.isEmpty()))
            {
                queueOfIntegers.push_back(curr_mod);
            }
             
            //else ... dont push it back

            while(queueOfIntegers.size()!=0)
            {
                if(queueOfIntegers.front()== temp_mem) {
                    if (queueOfIntegers.isEmpty()) 
                    {
                        queueOfIntegers.push_back(curr_mod);
                    }
                    break;
                }
                curr_mod = queueOfIntegers.front();
                queueOfIntegers.pop_front();

                if(!(curr_mod%(queueOfPrimes.back()) ==0))
                {
                    queueOfIntegers.push_back(curr_mod);
                }      
            }
            
            
        }
            
            
        
        //after done
        System.out.printf("\nContent of: queueOfIntegers: ");
        queueOfIntegers.display();
        System.out.printf("Content of: queueOfPrimes: ");
        queueOfPrimes.display();
    }
}