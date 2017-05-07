package stacksAndQueues;

public class NodeStack<E> implements Stack<E> {
	protected Node<E> top; // reference to the head node
	protected int size; // number of elements in the stack

	public NodeStack() { // constructs an empty stack
		top = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		return false;
	}

	public void push(E elem) {
		Node<E> v = new Node<E>(elem, top); // create and link-in a new node
		top = v;
		size++;
	}

	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return top.getElement();
	}

	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		E temp = top.getElement();
		top = top.getNext(); // link-out the former top node
		size--;
		return temp;
	}
	
	
	// some additional methods added for test purposes
	public String toString() {
		
		Node<E> node = top;
		
		String s;
	    s = "[";
	    if(node != null){
	    	s += node.getElement();
	    	node = node.getNext();
	    }
		
		while(node != null){
		    s += ", " + node.getElement();
			node = node.getNext();
		}
	    
	    return s + "]";
	}
	
	
		//  Prints status information about a recent operation and the stack.
	public void status(String op, Object element) {
	    System.out.print("------> " + op);   // print this operation
	    System.out.println(", returns " + element); // what was returned
	    System.out.print("result: size = " + size() + ", isEmpty = " + isEmpty());
	    System.out.println(", stack: " + this);       // contents of the stack
	}
	
	
	
	
	public static void main(String[] args) {
		
		Object o;
	    NodeStack<Integer> A = new NodeStack<Integer>();
	    A.status("new ArrayStack<Integer> A", null);
	    A.push(7);
	    A.status("A.push(7)", null);
	    o = A.pop();
	    A.status("A.pop()", o);
	    A.push(9);
	    A.status("A.push(9)", null);
	    o = A.pop();
	    A.status("A.pop()", o);
	    
	    NodeStack<String> B = new NodeStack<String>();
	    B.status("new ArrayStack<String> B", null);
	    B.push("Bob");
	    B.status("B.push(\"Bob\")", null);
	    B.push("Alice");
	    B.status("B.push(\"Alice\")", null);
	    o = B.pop();
	    B.status("B.pop()", o);
	    B.push("Eve");
	    B.status("B.push(\"Eve\")", null);
	  }
}
	

