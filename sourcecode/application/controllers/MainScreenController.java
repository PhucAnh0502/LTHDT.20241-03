
public class MainScreenController {

    // Selection Sort
    public static void selectionSort(int[] array) {
      
        }
    }

    // Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        


    }

    private static void merge(int[] array, int left, int mid, int right) {
       
    }

    // Shell Sort
    public static void shellSort(int[] array) {

	    
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Selection Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Shell Sort");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                selectionSort(array);
                System.out.println("Array sorted using Selection Sort:");
                break;
            case 2:
                mergeSort(array, 0, array.length - 1);
                System.out.println("Array sorted using Merge Sort:");
                break;
            case 3:
                shellSort(array);
                System.out.println("Array sorted using Shell Sort:");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println(Arrays.toString(array));
        scanner.close();
    }
}
