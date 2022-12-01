// Java program for implementation of Bubble Sort
class BubbleSort
{
    void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
            for (int j = 1; j < arr.length - i; j++)
                if (arr[j] < arr[j - 1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
    }

    /* Prints the array */
    void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String[] args)
    {
        BubbleSort ob = new BubbleSort();
        int[] arr = { 54, 18, 6, 7, 11 };
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
