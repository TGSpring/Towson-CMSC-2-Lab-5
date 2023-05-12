//Generic interface that describes various searching and sorting
//algorithms. Note that the type parameter is unbounded. However,
//for these algorithms to work correctly, the data objects must
//be compared using the method compareTo and equals.
//In other words, the classes implementing the list objects
//must implement the interface Comparable. The type parameter T
//is unbounded because we would like to use these algorithms to
//work on an array of objects as well as on objects of the classes
//UnorderedArrayList and OrderedArrayList.

public class SearchSortAlgorithms<T> implements SearchSortADT<T>
{
  private int comparisons;
  
  public int noOfComparisons()
  {
    return comparisons;
//Dr. Yu - finish this method
  }

    public void initializeNoOfComparisons()
    {
      comparisons = 0; 
        //Dr. Yu 
    }

       //Sequantial search algorithm.
       //Postcondition: If searchItem is found in the list,
       //               it returns the location of searchItem;
       //               otherwise it returns -1.
    public int seqSearch(T[] list, int start, int length, T searchItem)
    {
        int loc;
        boolean found = false;

        for (loc = start; loc < length; loc++)
        {
             if (list[loc].equals(searchItem))
            {
                found = true;
                break;
            }
        }

        if (found)
            return loc;
        else
            return -1;
    } //end seqSearch

       //Binary search algorithm.
       //Precondition: The list must be sorted.
       //Postcondition: If searchItem is found in the list,
       //               it returns the location of searchItem;
       //               otherwise it returns -1.
    public int binarySearch(T[] list, int start, int length, T searchItem)
    {
        int first = start;
        int last = length - 1;
        int mid = -1;

        boolean found = false;

        while (first <= last && !found)
        {
            mid = (first + last) / 2;

            Comparable<T> compElem = (Comparable<T>) list[mid];

            if (compElem.compareTo(searchItem) == 0)
                found = true;
            else
            {
                   if (compElem.compareTo(searchItem) > 0)
                    last = mid - 1;
                else
                    first = mid + 1;
            }
            comparisons++;
        }

        if (found)
            return mid;
        else
            return -1;
    }//end binarySearch

   public int binSeqSearch15(T[] list, int start, int length, T searchItem)
   {
       int first = 0;
       int last = length - 1;
       int mid = -1;

       boolean found = false;

       while (last - first > 15 && !found)
       {
           mid = (first + last) / 2;

           Comparable<T> compElem = (Comparable<T>) list[mid];

           comparisons++;

           if (compElem.compareTo(searchItem) ==0)
               found = true;
           else
           {
               if (compElem.compareTo(searchItem) > 0)
                   last = mid - 1;
               else
                   first = mid + 1;
           }
       }

       if (found)
           return mid;
       else
           return seqSearch(list, first, last, searchItem);
   }

       //Bubble sort algorithm.
       //Postcondition: list objects are in ascending order.
    public void bubbleSort(T list[], int length)
 {
     for (int iteration = 1; iteration < length; iteration++)
     {
         for (int index = 0; index < length - iteration;
                             index++)
         {
             Comparable<T> compElem =
                           (Comparable<T>) list[index];

             if (compElem.compareTo(list[index + 1]) > 0)
             {
                 T temp = list[index];
                 list[index] = list[index + 1];
                 list[index + 1] = temp;
             }
         }
     }
 }//end bubble sort

       //Selection sort algorithm.
       //Postcondition: list objects are in ascending order.
    public void selectionSort(T[] list, int length)
    {
        for (int index = 0; index < length - 1; index++)
        {
            int minIndex = minLocation(list, index, length - 1);

            swap(list, index, minIndex);
        }
    }//end selectionSort

       //Method to determine the index of the smallest item in
       //list between the indices first and last..
       //This method is used by the selection sort algorithm.
       //Postcondition: Returns the position of the smallest
       //               item.in the list.
    private int minLocation(T[] list, int first, int last)
    {
        int minIndex = first;

        for (int loc = first + 1; loc <= last; loc++)
        {
            Comparable<T> compElem = (Comparable<T>) list[loc];

            if (compElem.compareTo(list[minIndex]) < 0)
                minIndex = loc;
        }

        return minIndex;
    }//end minLocation

       //Method to swap the elements of the list speified by
       //the parameters first and last..
       //This method is used by the algorithms selection sort
       //and quick sort..
       //Postcondition: list[first] and list[second are
       //swapped..
    private void swap(T[] list, int first, int second)
    {
         T temp;

         temp = list[first];
         list[first] = list[second];
         list[second] = temp;
    }//end swap

       //Insertion sort algorithm.
       //Postcondition: list objects are in ascending order.
    public void insertionSort(T[] list, int length)
 {
     for (int firstOutOfOrder = 1; firstOutOfOrder < length;
                                   firstOutOfOrder ++)
     {
         Comparable<T> compElem =
                   (Comparable<T>) list[firstOutOfOrder];

         if (compElem.compareTo(list[firstOutOfOrder - 1]) < 0)
         {
             Comparable<T> temp =
                         (Comparable<T>) list[firstOutOfOrder];

             int location = firstOutOfOrder;

             do
             {
                 list[location] = list[location - 1];
                 location--;
             }
             while (location > 0 &&
                    temp.compareTo(list[location - 1]) < 0);

             list[location] = (T) temp;
         }
     }
 }//end insertionSort

       //Quick sort algorithm.
       //Postcondition: list objects are in ascending order.
    public void quickSort(T[] list, int length)
    {
        recQuickSort(list, 0, length - 1);
    }//end quickSort

       //Method to partition the list between first and last.
       //The pivot is choosen as the middle element of the list.
       //This method is used by the recQuickSort method.
       //Postcondition: After rearranging the elements,
       //               according to the pivot, list elements
       //               between first and pivot location - 1,
       //               are smaller the the pivot and list
       //               elements between pivot location + 1 and
       //               last are greater than or equal to pivot.
       //               The position of the pivot is also
       //               returned.
    private int partition(T[] list, int first, int last)
    {
        T pivot;

        int smallIndex;

        swap(list, first, (first + last) / 2);

        pivot = list[first];
        smallIndex = first;

        for (int index = first + 1; index <= last; index++)
        {
            Comparable<T> compElem = (Comparable<T>) list[index];

            if (compElem.compareTo(pivot) < 0)
            {
                smallIndex++;
                swap(list, smallIndex, index);
            }
        }

        swap(list, first, smallIndex);

        return smallIndex;
    }//end partition

       //Method to sort the elements of list between first
       //and last using quick sort algorithm,
       //Postcondition: list elements between first and last
       //               are in ascending order.
    private void recQuickSort(T[] list, int first, int last)
    {
        if (first < last)
        {
            int pivotLocation = partition(list, first, last);
            recQuickSort(list, first, pivotLocation - 1);
            recQuickSort(list, pivotLocation + 1, last);
        }
    }//end recQuickSort

       //Heap sort algorithm.
       //Postcondition: list objects are in ascending order.
    public void heapSort(T[] list, int length)
    {
        buildHeap(list, length);

        for (int lastOutOfOrder = length - 1; lastOutOfOrder >= 0;
                                  lastOutOfOrder--)
        {
            T temp = list[lastOutOfOrder];
            list[lastOutOfOrder] = list[0];
            list[0] = temp;
            heapify(list, 0, lastOutOfOrder - 1);
        }//end for
    }//end heapSort

       //Method to the restore the heap in the list between
       //low and high.
       //This method is used by the heap sort algorithm and
       //the method buildHeap.
       //Postcondition: list elemets between low and high are
       //               in a heap.
    private void heapify(T[] list, int low, int high)
    {
        int largeIndex;

        Comparable<T> temp =
                 (Comparable<T>) list[low];  //copy the root
                                             //node of
                                             //the subtree

        largeIndex = 2 * low + 1;  //index of the left child

        while (largeIndex <= high)
        {
            if (largeIndex < high)
            {
                Comparable<T> compElem =
                         (Comparable<T>) list[largeIndex];

                if (compElem.compareTo(list[largeIndex + 1]) < 0)
                    largeIndex = largeIndex + 1; //index of the
                                               //largest child
            }

            if (temp.compareTo(list[largeIndex]) > 0) //subtree
                                         //is already in a heap
                break;
            else
            {
                list[low] = list[largeIndex]; //move the larger
                                             //child to the root
                low = largeIndex;    //go to the subtree to
                                     //restore the heap
                largeIndex = 2 * low + 1;
            }
        }//end while

        list[low] = (T) temp; //insert temp into the tree,
                              //that is, list
    }//end heapify


       //Method to convert an array into a heap.
       //This method is used by the heap sort algorithm
       //Postcondition: list elements are in a heap.
    private void buildHeap(T[] list, int length)
    {
        for (int index = length / 2 - 1; index >= 0; index--)
            heapify(list, index, length - 1);
    }//end buildHeap
}
