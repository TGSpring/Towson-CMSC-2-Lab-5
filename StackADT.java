
public interface StackADT<T>
{
    public void initializeStack();
       //Method to initialize the stack to an empty state.

    public boolean isEmptyStack();
       //Method to determine whether the stack is empty.
       //Postcondition: Returns true if the stack is empty;
       //               otherwise, returns false.

    public boolean isFullStack();
       //Method to determine whether the stack is full.
       //Postcondition: Returns true if the stack is full;
       //               otherwise, returns false.

    public void push(T newItem) throws StackOverflowException;
       //Method to add newItem to the stack.
       //Precondition: The stack exists and is not full.
       //Postcondition: The stack is changed and newItem
       //               is added to the top of stack.
       //               If the stack is full, the method
       //               throws StackOverflowException.

    public T peek() throws StackUnderflowException;
       //Method to return a reference to the top element of
       //the stack.
       //Precondition: The stack exists and is not empty.
       //Postcondition: If the stack is empty, the method
       //               throws StackUnderflowException;
       //               otherwise, a reference to the top
       //               element of the stack is returned.

    public void pop() throws StackUnderflowException;
       //Method to remove the top element of the stack.
       //Precondition: The stack exists and is not empty.
       //Postcondition: The stack is changed and the top
       //               element is removed from the stack.
       //               If the stack is empty, the method
       //               throws StackUnderflowException.
}

