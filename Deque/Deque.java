package deque;

public class Deque<T> implements DequeInterface<T>
{
	
    // linked list containing the items in the deque
   private Node<T> head=null, tail=null;

    // current number of items in deque
    int numberOfItems;
    
    // Deque constructor that starts with empty queue.
    public Deque()
    {
        numberOfItems=0; // no items yet!
    }

    // returns true if the deque is empty (no items in deque) 
    // false if deque is (has at least one or more items in deque)
    public boolean isEmpty()
    {
        return numberOfItems==0;
    };
	
    // return the number of items currently in the deque
    public int size()
    {
        return numberOfItems;
    };
 
    // returns the value of the item currently at front of deque
    public T front()
    {
        if ( head==null ) return null;
            return head.getValue(); // return item stored at head node
    };
	
    // returns the value of the item currently at the end of the deque
    public T back()
    {
        if ( tail==null ) return null;
            return tail.getValue(); // return item stored at tail node
    };
	
    // places parameter newItem onto the front of the deque
    public void enqueue_front(T newItem)
    {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
            //System.out.print("null front\n");
            head = new Node(newItem);
            tail=head; // when first item is enqueued, head and tail are the same
            numberOfItems++; // increment the number of items in the queue
        }
        else
        {
            head = new Node<T>(newItem,null,head);          
            numberOfItems++;
            //System.out.print("Size after: "+numberOfItems+"\n");
        }
    };

    // places parameter newItem onto the end of the deque
    public void enqueue_back(T newItem)
    {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
            //System.out.print("null head\n");
            head = new Node(newItem);
            tail=head; // when first item is enqueued, head and tail are the same
            numberOfItems++; // increment the number of items in the queue
        }
        else
        {
            
            //System.out.print("push back\n");
            Node<T> newNode = new Node<T>(newItem,tail,null);
            tail.setNext(newNode);
            tail = newNode;
            
            numberOfItems++;
        }
    };

     // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T dequeue_front()
    {
        T headDataValue = null;
        if ( numberOfItems > 0 )
        {
                headDataValue = head.getValue();
                Node<T> oldHead=head;
                head=head.getNext();
                oldHead.setNext(null);
                oldHead.setPrevious(null);

                numberOfItems--;
        }
        return headDataValue;  // returns the data value from the popped head, null if queue empty
    };

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T dequeue_back()
    {
        T tailDataValue = null;
        if ( numberOfItems > 0 )
        {
            tailDataValue = tail.getValue();
            tail = tail.getPrevious();
            //System.out.print("\nNew Tail:"+tail.getValue());
            numberOfItems--;
        }
        return tailDataValue;
    };

    // display all of the contents in the deque from front to back
    public void display()
    {
       Node current=head;
       
       for(int i=0;i<numberOfItems;i++)
       {
           System.out.print(current.getValue()+" ");
           if ( current.getNext()==null ) 
            {
                 System.out.print("\n");
                break;
            }
           current=current.getNext();
       }
       
    };
    // Node Inner Class 
    private class Node<T> 
    {
        private T value;
        private Node _previous, _next;
    
        public Node(T data) {
            value = data;
            _previous = null;
            _next = null;
        }
    
        protected Node(T data, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
            _next = nextNode;
        }
		
        public Node getNext() {
            return _next;
        }
		
        public Node getPrevious() {
            return _previous;
        }
        
        public void setValue(T newValue)
        {
            value=newValue;
        }

        public T getValue() 
        {
            return value;
        }
    
        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }
		
        public void setPrevious(Node newPreviousNode) {
            _next = newPreviousNode;
        }

    }
}

