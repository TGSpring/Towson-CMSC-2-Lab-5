import java.util.*;
import java.io.*;
public class q2
{
  
  public static void main (String [] args) throws IOException
  {
    Scanner sc = new Scanner(System.in);
    
    File file = new File("names.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bR = new BufferedReader(fileReader);
    StringBuffer sB = new StringBuffer();
    
    ArrayList<String> lines = new ArrayList<String>();
    String line;
   
    while((line = bR.readLine()) != null)
    {
      sB.append(line);
      sB.append("\n");
      lines.add(line);
    }
    fileReader.close();
    System.out.println("names before sorting: ");
    System.out.println(sB.toString());
    
    String[] lines2 = lines.toArray(new String[lines.size()]);
    
    sort(lines2);
    
    System.out.println("Names after sorting:");
    for(int i = 0; i < lines2.length; i++)
    {
      System.out.println(lines2[i]);
    }
    
  }
  
  public static void sort(String [] words)
  {
    if(words.length > 1)
    {
      String[] left = Arrays.copyOfRange(words, 0, words.length / 2);
      String[] right = Arrays.copyOfRange(words, words.length / 2, words.length);
      
      sort(left);
      sort(right);
      
      merge(words, left, right);
    }
  }
  public static void merge(String[] results, String[] left, String[] right)
  {
    int i = 0;
    int h = 0;
    int k = 0;
    
    while(left.length != h && right.length != k)
    {
      if(left[h].compareTo(right[k]) < 0)
      {
        results[i] = left[h];
        i = i + 1;
        h = h + 1;
      }
      else
      {
        results[i] = right[k];
        i = i + 1;
        k = k + 1;
      }
    }
    while(left.length != h)
    {
      results[i] = left[h];
      i = i + 1;
      h = h + 1;
    }
    
    while(right.length != k)
    {
     results[i] = right[k];
     i = i + 1;
     k = k + 1;
    }
  }
  
}