//Generic interface that describes various searching and sorting
//algorithms. Note that the type parameter is unbounded. However,
//for these algorithms to work correctly, the data objects must
//be compared using the method compareTo and equals.
//In other words, the classes implementing the list objects
//must implement the interface Comparable. The type parameter T
//is unbounded because we would like to use these algorithms to
//work on an array of objects as well as on objects of the classes
//UnorderedArrayList and OrderedArrayList.

public interface SearchSortADT<T>
{
    public int seqSearch(T[] list, int start, int length, T searchItem);
       //Sequantial search algorithm.
       //Postcondition: If searchItem is found in the list,
       //               it returns the location of searchItem;
       //               otherwise it returns -1.

    public int binarySearch(T[] list, int start, int length, T searchItem);
       //Binary search algorithm.
       //Precondition: The list must be sorted.
       //Postcondition: If searchItem is found in the list,
       //               it returns the location of searchItem;
       //               otherwise it returns -1.

    public void bubbleSort(T list[], int length);
       //Bubble sort algorithm.
       //Postcondition: list objects are in ascending order.

    public void selectionSort(T[] list, int length);
       //Selection sort algorithm.
       //Postcondition: list objects are in ascending order.

    public void insertionSort(T[] list, int length);
       //Insertion sort algorithm.
       //Postcondition: list objects are in ascending order.

    public void quickSort(T[] list, int length);
       //Quick sort algorithm.
       //Postcondition: list objects are in ascending order.

    public void heapSort(T[] list, int length);
       //Heap sort algorithm.
       //Postcondition: list objects are in ascending order.
}


