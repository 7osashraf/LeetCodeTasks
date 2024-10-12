import java.util.Arrays;

public class MedianOfTwoSortedArrayProblem {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] mergedArray = new int[m + n];

        for(int i = 0; i < m; i++){
            mergedArray[i] = nums1[i];
        }

        for(int j = 0; j < n; j++){
            mergedArray[j + m] = nums2[j];
        }

        Arrays.sort(mergedArray);

        int lengthOfMergedArray = mergedArray.length;
        
        int index = lengthOfMergedArray / 2;
        double median = 0;

        if(lengthOfMergedArray % 2 == 0){
            median = (mergedArray[index] + mergedArray[index - 1]) / 2.0;
        }
        else{
            median = mergedArray[index] ;
        }
        
        return median;
    }


    public static void main(String[] args) {
        MedianOfTwoSortedArrayProblem solution = new MedianOfTwoSortedArrayProblem();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}
