public class StackOverflowException extends StackException
{
    public StackOverflowException()
    {
         super("Stack Overflow");
    }

    public StackOverflowException(String msg)
    {
        super(msg);
    }
}

