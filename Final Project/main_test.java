package priorityqueues;

public class main_test
{
    public static void main(String[] args) 
    {
         Priority<Integer> priorqueue = new Priority<Integer>();
         
///insert random test
         System.out.print("insert random test\n");
         priorqueue.insert(99, 125);
         priorqueue.insert(21, 99);
         priorqueue.insert(23, 23);
         priorqueue.insert(5, 104);
         priorqueue.insert(671, 77);
         priorqueue.insert(213, 66);
         priorqueue.insert(909, 125);
         priorqueue.insert(87, 65);
         priorqueue.insert(234, 8);
         priorqueue.insert(1, 666);
         priorqueue.my_sort();
         priorqueue.display();
         System.out.print("queue size:" + priorqueue.size()+"\n");
         
//remove_maximum test
         System.out.print("\nremove_maximum test\n");
         priorqueue.remove_maximum(); 
         priorqueue.display();
         System.out.print("queue size:" + priorqueue.size()+"\n");
         
//increase and decrease test
         System.out.print("\nincrease and decrease test\n");
         priorqueue.increase(23,6);
         priorqueue.decrease(99, 15);
         priorqueue.increase(87,6);
         priorqueue.my_sort();
         priorqueue.display();
         System.out.print("queue size:" + priorqueue.size()+"\n");
         
         
         //remove_maximum test
         System.out.print("\nremove_maximum test\n");
         priorqueue.remove_maximum(); 
         priorqueue.display();
         System.out.print("queue size:" + priorqueue.size()+"\n");
      System.exit(0);
         
         
         
         
    }
}