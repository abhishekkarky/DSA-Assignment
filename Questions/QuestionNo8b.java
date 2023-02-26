/*
b)
        Given an array of even numbers sorted in ascending order and an integer k,
        Find the k^th missing even number from provided array
        Input a[] ={0, 2, 6, 18, 22} k=6
        Output: 16 examples:
        Explanation: Missing even numbers on the list are 4, 8, 10, 12, 14, 16, 20 and so on
        and kth missing number is on 6th place of the list i.e. 16
*/


//Initialize a list called missingEvens to store the missing even numbers.
//Initialize two variables, i and j, to the first even number and the index of the first element in the array, respectively.
//While the size of missingEvens is less than k, do the following:
//a. If j is less than the length of array a and a[j] is equal to i, increment j.
//b. Otherwise, add i to the missingEvens list.
//c. Increment i by 2.
//Return the kth element in the missingEvens list.

import java.util.ArrayList;
import java.util.List;

class MissingEven {
    public static int findKthMissingEvenNumber(int[] a, int k) {
        List<Integer> missingEvens = new ArrayList<>();
        int j = 0;
        int i = a[0];
        while (missingEvens.size() < k) {
            if (j < a.length && a[j] == i) {
                j++;
            } else {
                missingEvens.add(i);
            }
            i += 2;
        }
        return missingEvens.get(k - 1);
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 6, 18, 22};
        int k = 6;
        System.out.println(findKthMissingEvenNumber(a, k));
    }
}