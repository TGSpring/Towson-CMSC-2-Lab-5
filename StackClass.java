
public class StackClass<T> implements StackADT<T>
{
  
  public static void main(String [] args) throws RuntimeException
    {
    StackClass<Integer> stack = new StackClass<Integer>(); 
    System.out.println(stack.equalStack(stack));
    }
  
    private int maxStackSize;  //variable to store the
                               //maximum stack size
    private int stackTop;      //variable to point to
                               //the top of the stack
    private T[] list;  //array of reference variables
   
    
       //Default constructor
       //Create an array of size 100 to implement the stack.
       //Postcondition: The variable list contains the base
       //               address of the array, stackTop = 0,
       //               and maxStackSize = 100.
    public StackClass()
    {
        maxStackSize = 100;
        stackTop = 0;         //set stackTop to 0
        list = (T[]) new Object[maxStackSize]; //create the array
    }//end default constructor

       //Constructor with a parameter
       //Create an array of size stackSize to implement the
       //stack.
       //Postcondition: The variable list contains the base
       //               address of the array, stackTop = 0,
       //               and maxStackSize = stackSize.
    public StackClass(int stackSize)
    {
        if (stackSize <= 0)
        {
            System.err.println("The size of the array to "
                             + "implement the stack must be "
                             + "positive.");
            System.err.println("Creating an array of size 100.");

            maxStackSize = 100;
        }
        else
            maxStackSize = stackSize; //set the stack size to
                                      //the value specified by
                                      //the parameter stackSize
        stackTop = 0;    //set stackTop to 0
        list = (T[]) new Object[maxStackSize]; //create the array
    }//end constructor

       //Method to initialize the stack to an empty state.
       //Postcondition: stackTop = 0
    public void initializeStack()
    {
        for (int i = 0; i < stackTop; i++)
            list[i] = null;

        stackTop = 0;
    }//end initializeStack

       //Method to determine whether the stack is empty.
       //Postcondition: Returns true if the stack is empty;
       //               otherwise, returns false.
    public boolean isEmptyStack()
    {
        return (stackTop == 0);
    }//end isEmptyStack

       //Method to determine whether the stack is full.
       //Postcondition: Returns true if the stack is full;
       //               otherwise, returns false.
    public boolean isFullStack()
    {
        return (stackTop == maxStackSize);
    }//end isFullStack

       //Method to add newItem to the stack.
       //Precondition: The stack exists and is not full.
       //Postcondition: The stack is changed and newItem
       //               is added to the top of stack.
       //               If the stack is full, the method
       //               throws StackOverflowException
    public void push(T newItem) throws StackOverflowException
    {
        if (isFullStack())
            throw new StackOverflowException();

        list[stackTop] = newItem; //add newItem at the
                                  //top of the stack
        stackTop++;               //increment stackTop
    }//end push

       //Method to return a reference to the top element of
       //the stack.
       //Precondition: The stack exists and is not empty.
       //Postcondition: If the stack is empty, the method
       //               throws StackUnderflowException;
       //               otherwise, a reference to the top
       //               element of the stack is returned.
    public T peek() throws StackUnderflowException
    {
        if (isEmptyStack())
            throw new StackUnderflowException();

        return (T) list[stackTop - 1];
    }//end peek

       //Method to remove the top element of the stack.
       //Precondition: The stack exists and is not empty.
       //Postcondition: The stack is changed and the top
       //               element is removed from the stack.
       //               If the stack is empty, the method
       //               throws StackUnderflowException
    public void pop() throws StackUnderflowException
    {
        if (isEmptyStack())
           throw new StackUnderflowException();

        stackTop--;       //decrement stackTop
        list[stackTop] = null;
    }//end pop

    public boolean equalStack(StackClass<T> otherStack)
    {
        boolean isEqual = true;
        
        //Dr. Wei Yu: add you code here!!!
        if(otherStack.list == null && this.list == null)
          return isEqual;
        if(otherStack.list.length != this.list.length)
          return isEqual = false;
         
        int i = 0;
        while(i < otherStack.stackTop)
        {
          if(this.list[i] != otherStack.list[i])
            return isEqual = false;
          i++;
        }
         
        return isEqual;
    } //end equalStack
}


