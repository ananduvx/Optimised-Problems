package optimisedproblems.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionAndIntesectionOfTwoSortedArrays {
    /**
     * Method to find union.
     * 
     * @param arr1
     * @param arr2
     * @return List<Integer>
     */
    public static Set<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();
        int i = 0;
        int j = 0;
        for (i = 0; i < arr1.length; i++) {
            union.add(arr1[i]);
        }
        for (j = 0; j < arr2.length; j++) {
            union.add(arr2[j]);
        }
        return union;
    }

    /**
     * Use two pointer approach
     * 
     * @param arr1
     * @param arr2
     * @return List<Integer>
     */
    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 3, 4, 5, 6, 7 };

        Set<Integer> union = findUnion(arr1, arr2);
        System.out.println("Union: " + union);

        List<Integer> intersection = findIntersection(arr1, arr2);
        System.out.println("Intersection: " + intersection);
    }
}