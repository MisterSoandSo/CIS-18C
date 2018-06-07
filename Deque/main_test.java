package deque;

public class main_test
{
    public static void main(String[] args) 
    {
        Deque<Integer> dequeofInt = new Deque<Integer>();
        
        System.out.print("enqueue_front(insertfront): \n");
        dequeofInt.enqueue_front(4);
        dequeofInt.display();   //4 1 8 2 3 6 0
        System.out.print("Size: " + dequeofInt.size()+"\n");
        System.out.print("Front: " + dequeofInt.front()+"\n");
        System.out.print("Back: " +  dequeofInt.back() +"\n");;        
        
        //test push back
        System.out.print("enqueue_back(pushback): \n");
        dequeofInt.enqueue_back(1);
        dequeofInt.enqueue_back(8);
        dequeofInt.enqueue_back(2);
        dequeofInt.enqueue_back(3);
        dequeofInt.enqueue_back(6);
        dequeofInt.enqueue_back(0);
        
        dequeofInt.display();   //4 1 8 2 3 6 0
        System.out.print("Size: " + dequeofInt.size()+"\n");
        System.out.print("Front: " + dequeofInt.front()+"\n");
        System.out.print("Back: " +  dequeofInt.back() +"\n");
         
        
        System.out.print("enqueue_front(insertfront): \n");
        dequeofInt.enqueue_front(12);
        dequeofInt.display();   //12 4 1 8 2 3 6 0
         System.out.print("Size: " + dequeofInt.size()+"\n");
        System.out.print("Front: " + dequeofInt.front()+"\n");
        System.out.print("Back: " +  dequeofInt.back() +"\n");
        
                      
        System.out.print("dequeue_front(popfront): \n");  
        dequeofInt.dequeue_front();
        dequeofInt.display();    // 3 2 1 8 5
        System.out.print("Size: " + dequeofInt.size()+"\n");
        System.out.print("Front: " + dequeofInt.front()+"\n");
        System.out.print("Back: " +  dequeofInt.back() +"\n");
        
        System.out.print("dequeue_back(popback): \n");
        dequeofInt.dequeue_back();
        dequeofInt.display();    // 3 2 1 8
        System.out.print("Size: " + dequeofInt.size()+"\n");
        System.out.print("Front: " + dequeofInt.front()+"\n");
        System.out.print("Back: " +  dequeofInt.back() +"\n");
        
        System.out.print("dequeue_front(popfront): \n");  
        dequeofInt.dequeue_front();
        dequeofInt.display();    // 3 2 1 8 5
        System.out.print("Size: " + dequeofInt.size()+"\n");
        System.out.print("Front: " + dequeofInt.front()+"\n");
        System.out.print("Back: " +  dequeofInt.back() +"\n");
        
        System.exit(0);
    }
}