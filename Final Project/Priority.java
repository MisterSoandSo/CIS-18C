package priorityqueues;
public class Priority<T> implements PriorityInterface<T>
{
    // linked list containing the items in the queue
    private Node<T> head=null;
    private Node<T> sortNode = null;
    // current number of items in queue
    private int numberOfItems;
    
    public boolean isEmpty()
    {
            return numberOfItems==0;
    }
	
    public int size()
    {
            return numberOfItems;
    }
     
    public T front_value()
    {
            if ( head==null ) return null;
            return head.getValue(); // return item stored at head node
    }
    
    public int front_level()
    {
        if ( head==null ) return 0;
            return head.getLevel(); // return item stored at head node
    }

    @Override
    public void insert(T element, int priority) 
    {   
        if ( head == null)
        {
            //System.out.print("null head\n");
            head = new Node(element,priority,null);
            
            numberOfItems++; // increment the number of items in the queue
        }
        else
        {
            Node<T> newNode = new Node<T>(element,priority,null);
            newNode.setNext(head);
            head = newNode;
            
            numberOfItems++;
        }
        //my_sort();
    }

    @Override
    //should assume queue is always sorted
    public void remove_maximum() 
    {
        if ( numberOfItems > 0 )
        {
            
            Node<T> oldHead=head;
            head=head.getNext();
            oldHead.setNext(null);
            numberOfItems--;
        }
       
        
    }
        
    @Override
    public boolean decrease(T element, int new_priority) 
    {
        if(head==null) return false;
        Node<T>temp = head;
        for(int i=0;i<numberOfItems;i++)
        {
            if(temp.getValue()==element)
            {
                
                if((temp.getLevel()-new_priority) <=0)
                    return false;
                temp.setLevel((temp.getLevel()-new_priority));
                
                return true;
            }
            if(temp.getNext()!=null)
            {
                temp=temp.getNext();
            }
        }
        return false;
    }
    
    @Override
    public boolean increase(T element, int new_priority) 
    {
        if(head==null) return false;
        Node<T>temp = head;
        for(int i=0;i<numberOfItems;i++)
        {
            if(temp.getValue()==element)
            {
                temp.setLevel(temp.getLevel()+new_priority);
                
                return true;
            }
            if(temp.getNext()!=null)
            {
                temp=temp.getNext();
            }
        }
        return false;
    }
    
    @Override
    public void display() {
        
        Node current=head;
        if(numberOfItems ==0 || current == null)
        {
            System.out.print("\n");
            return;
        }
        for(int i=0;i<numberOfItems;i++)
        {
            System.out.print(current.getValue()+" - with Priority:" + current.getLevel()+"\n");
            if ( current.getNext()==null ) 
             {
                break;
             }
            current=current.getNext();
        }
    }
     
    public void my_sort()
    {
        Node<T> current = head;
        
        while (current != null) 
        {
            Node<T> next = current.getNext();
            sortedInsert(current);
            current = next;
        }
        head = sortNode;
    }
    public void sortedInsert(Node<T> newNode)
    {
        if (sortNode == null) 
        {
            newNode.setNext(null);
            sortNode = newNode;
            return; // your done here
        }
        else
        {
            Node<T> current = sortNode;
                        
            while (current.getNext() != null && (current.getNext().getLevel() >= newNode.getLevel())) 
            {
               current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }
    
// Node Inner Class - Single Linked list with priority level
    private class Node<T> 
    {
        private T value;
        private int level;
        private Node _next;
    
        public Node(T data, int plevel) 
        {
            value = data;
            level = plevel;
            _next = null;
   
        }
    
        protected Node(T data, int p_level, Node nextNode) 
        {
            value = data;
            level = p_level;
            _next = nextNode;
           
        }
		
        public Node getNext() 
        {
            return _next;
        }
        
		
        public int getLevel() 
        {
            return level;
        }
        
        public void setValue(T newValue)
        {
                value=newValue;
        }

        public T getValue() {
            return value;
        }
    
        public void setNext(Node newNextNode) 
        {
            _next = newNextNode;
        }
        
		
        public void setLevel(int p_level) {
            level = p_level;
        }
        
    }
}