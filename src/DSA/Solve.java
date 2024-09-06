package DSA;

import java.util.HashSet;

public class Solve {
    public static int lengthOfCycle(int[] arr, int startIndex) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        Integer cycleStart = null;
        int i=startIndex;
        while (i<n){
            count++;
            if(set.contains(arr[i])){
                if (cycleStart == null) {
                    cycleStart = i;
                    count = 0;  // reset count to start counting the cycle length
                } else if (i == cycleStart) {
                    // When we revisit the cycle start, the cycle length is determined
                    return count;
                }
            }
            set.add(arr[i]);
            i = arr[i];

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(lengthOfCycle(arr,0));
    }
}
