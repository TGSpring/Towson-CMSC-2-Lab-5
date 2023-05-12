import java.util.*;

public class Problem51
{
  static private int bComparisons = 0;
  static private int sComparisons = 0;
  
  static Scanner console = new Scanner(System.in);
  
  final static int SIZE = 2500;
  
  public static void main(String[] args)
  {
    int item;
    System.out.println("Enter a target number.");
    item = console.nextInt();
    
    Random rand = new Random();
    int[] intList = new int[SIZE];
    
    for(int i = 0; i < SIZE; i++)
    {
      intList[i] = rand.nextInt(2500)+1;
    }
    
    bubbleSort(intList, SIZE);
    
    System.out.println("The target number was found in binary search at: " + (binarySearch(intList, intList[0], SIZE, item)));
    System.out.println("The number of comparisons to find it was: " + bComparisons);
    System.out.println("The target number was found in sequential search at: " + (seqSearch(intList, intList[0], SIZE, item)));
    System.out.println("The number of comparisons to find it was: " + sComparisons);
  }
  
  
  //Bubble sorting method
  public static void bubbleSort(int[]list, int length)
  {
    for (int iteration = 1; iteration < length; iteration++)
    {
      for (int index = 0; index < length - iteration;
           index++)
      {
        Comparable compElem =
          (Comparable) list[index];
        
        if (compElem.compareTo(list[index + 1]) > 0)
        {
          int temp = list[index];
          list[index] = list[index + 1];
          list[index + 1] = temp;
        }
      }
    }
  }
  
  //Binary Search method
  public static int binarySearch(int[] list, int start, int length, int searchItem)
  {
    int first = start;
    int last = length - 1;
    int mid = -1;
    
    boolean found = false;
    
    while (first <= last && !found)
    {
      mid = (first + last) / 2;
      
      Comparable compElem = (Comparable) list[mid];
      
      if (compElem.compareTo(searchItem) == 0)
      {
        found = true;
        bComparisons++;
      }
      else if(!found) 
      {
        if (compElem.compareTo(searchItem) > 0)
        {
          last = mid - 1;
          bComparisons++;
        }
        else
        {
          first = mid + 1;
          bComparisons++;
        } 
      }
    }
    if (found)
    {
      return mid;
    }
    else
    {
      return -1;
    }
  }
  
  //Sequential Search Method
  public static int seqSearch(int[] list, int start, int length, int searchItem)
  {
    int loc;
    boolean found = false;
    
    for (loc = start; loc < length; loc++)
    {
      if (list[loc] == (searchItem))
      {
        found = true;
        break;
      }
      sComparisons++;
    }
    
    if (found)
      return loc;
    else
      return -1;
  }
}


