import java.util.*;
///////////




class Task2
{
    
    static int findMinDiff(int[] arr, int n)
    {
        int diff = Integer.MAX_VALUE;
     
        for (int i=0; i<n-1; i++)
            for (int j=i+1; j<n; j++)
                if (Math.abs((arr[i] - arr[j]) )< diff)
                    diff = Math.abs((arr[i] - arr[j])); 
        return diff;
    }
 
   
    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 5, 3, 19, 18, 25};
        System.out.println("Minimum difference is "+
                              findMinDiff(arr, arr.length));
     
    }
}


///////////////////////////




public class Task2 {
    public static void main(String[] args) {
        int k = 3;
        List<Integer> integers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.print("Input count integers: ");
        int countInt = in.nextInt();
        System.out.print("Input integers : ");


        for (int i = 0; i < countInt; i++) {
            int integer = in.nextInt();
            integers.add(integer);
        }

        integers.stream().forEach(a -> System.out.print(a + " "));
        in.close();

        int[] arr =integers.stream().mapToInt(i -> i).toArray();

        System.out.println(minValue(arr,integers.size(),k));

    }

    static int countPairs(int[] a, int n, int mid)
    {
        int res = 0, value;
        for(int i = 0; i < n; i++)
        {
            int ub = upperbound(a, n, a[i]+mid);
            res += (ub- (i-1));
        }
        return res;
    }

    static int upperbound(int a[], int n, int value)
    {
        int low = 0;
        int high = n;
        while(low < high)
        {
            final int mid = (low + high)/2;
            if(value >= a[mid])
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
    static int minValue(int a[], int n, int k) {

        Arrays.sort(a);
        int low = a[1] - a[0];
        for (int i = 1; i <= n - 2; ++i)
            low = Math.min(low, a[i + 1] - a[i]);

        int high = a[n - 1] - a[0];
        while (low < high) {
            int mid = (low + high) >> 1;
            if (countPairs(a, n, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}


