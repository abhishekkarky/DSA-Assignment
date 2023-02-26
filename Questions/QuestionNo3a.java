//Define a function product(subarray) that takes an input subarray and returns its product.
//Define a function findminimumdifference(array) that takes an input array and returns the minimum difference between the product of any two subarrays of the input array.
//Initialize a variable mindiff to the maximum integer value.
//Iterate over all possible combinations of subarrays of length n/2, where n is the length of the input array.
//For each combination, split the input array into two subarrays of length n/2.
//Calculate the product of each subarray using the product() function.
//Find the absolute difference between the product of the two subarrays.
//If the difference is less than mindiff, update mindiff to the difference.
//Return mindiff.
public class QuestionNo3a {
    public static int product(int[] subaaray){
        if (subaaray.length == 0){
            return 0;
        }
        int res = 1;
        for (int i = 0;i<subaaray.length;i++){
            res = res*subaaray[i];
        }
        return res;
    }

    public static int findminimumdifference(int[] array){
        int mindiff = Integer.MAX_VALUE;
        int n = array.length;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == n / 2) {
                int[] subarray1 = new int[n / 2];
                int[] subarray2 = new int[n / 2];
                int index1 = 0;
                int index2 = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        subarray1[index1++] = array[j];
                    } else {
                        subarray2[index2++] = array[j];
                    }
                }
                int subarray1product = product(subarray1);
                int subarray2product = product(subarray2);
                int curr_min_diff = 0;
                if (subarray2product>subarray1product){
                    curr_min_diff = subarray2product-subarray1product;
                }else{
                    curr_min_diff = subarray1product-subarray2product;
                }
                if (curr_min_diff<mindiff){
                    mindiff = curr_min_diff;
                }

            }
        }
        return mindiff;


    }


    public static void main(String[] args) {
        int[] array = {5, 2, 4, 11};
        int answer = findminimumdifference(array);
        System.out.println(answer);

    }
}
