public class test
{
  public static void main (String [] args)
  {
    System.out.println(Method(3));
    System.out.println(Method(4));
  }
  
  
  public static int Method(int x)
  {
    
    if (x <= 0)
      
      return 0;
    else if(x % 2 == 0)
      return x + Method(x-1);
    else
      return x * Method(x-1);    
  }
}
