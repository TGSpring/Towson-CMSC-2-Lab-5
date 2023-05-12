public class StackUnderflowException extends StackException
{
    public StackUnderflowException()
    {
         super("Stack Underflow");
    }

    public StackUnderflowException(String msg)
    {
        super(msg);
    }
}