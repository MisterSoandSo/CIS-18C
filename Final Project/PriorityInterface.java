package priorityqueues;

public interface PriorityInterface<T>
{

//insert – insert an element into the queue with a given priority 
//(higher priority value, the higher the priority is for the data element).
    public void insert(T element, int priority);
    
//remove_maximum – removes the highest priority element from the priority queue.
//removes the first instance of highest priority
    public void remove_maximum();
    
// decrease – search for element in the priority queue and decrease its 
//priority to the new priority level (priority = priority – priority_delta).
    public boolean decrease(T element, int new_priority);
    
//increase – search for element in the priority queue and increase its 
//priority to the new priority level (priority = priority + priority_delta).
    public boolean increase(T element, int new_priority);
    
//display – display the elements in the priority queue in order from highest
//priority to lowest priority.
    public void display(); 
    
 
    
}