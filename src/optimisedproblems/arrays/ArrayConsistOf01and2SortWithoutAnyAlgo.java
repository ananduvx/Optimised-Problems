package optimisedproblems.arrays;

//Dutch National Flag algorithm
//by count and then just put in array by using switch.
public class ArrayConsistOf01and2SortWithoutAnyAlgo {
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else { // nums[mid] == 1
                mid++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0,2, 0, 2, 1, 1, 0 };
        sortColors(nums);

        System.out.println("Sorted Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}