import java.util.*;

/*
Question 5.b)
        Assume an electric vehicle must go from source city s to destination city d.
        You can locate many service centers along the journey that allow for the replacement of batteries; however,
        each service center provides batteries with a specific capacity. You are given a 2D array in which
        service center[i]=[xi,yj] indicates that the ith service center is xi miles from the source city and
        offers yj miles after the automobile can travel after replacing batteries at specific service centers.
        Return the number of times the car's batteries need to be replaced before arriving at the destination.
        Input: serviceCenters = [{10,60},{20,30},{30,30},{60,40}], targetMiles= 100, startChargeCapacity = 10
        Output: 2
        Explanation: The car can go 10 miles on its initial capacity; after 10 miles, the car replaces
        batteries with a capacity of 60 miles; and after travelling 50 miles, at position 60 we change batteries
        with a capacity of 40 miles; and ultimately, we may arrive at our destination.
*/


//Initialize count to 0.
//Initialize currentMiles to startChargeCapacity.
//Create two ArrayLists, distances and capacities, to store the distance to each service center and the capacity of each service center, respectively.
//Loop through each service center in the serviceCenters array:
//a. Add the distance of the service center to the distances ArrayList.
//b. Add the capacity of the service center to the capacities ArrayList.
//Loop through each distance in the distances ArrayList:
//a. If the current distance is greater than currentMiles, set currentMiles to the capacity of the previous service center and increment count.
//If currentMiles is less than targetMiles, increment count.
//Return count.

public class Question5b {
    public int numBatteryReplacements(int[][] serviceCenters, int targetMiles, int startChargeCapacity) {
        int count = 0;
        int currentMiles = startChargeCapacity;
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> capacities = new ArrayList<>();

        for (int[] serviceCenter : serviceCenters) {
            distances.add(serviceCenter[0]);
            capacities.add(serviceCenter[1]);
        }

        for (int i = 0; i < distances.size(); i++) {
            if (distances.get(i) > currentMiles) {
                currentMiles = capacities.get(i - 1);
                count++;
            }
        }
        if (currentMiles < targetMiles) {
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int [][] serviceCenterList={{10,60},{20,30},{30,30},{60,40}};
        Question5b question1=new Question5b();
        int finalAnswer=question1.numBatteryReplacements(serviceCenterList,100,10);
        System.out.println("the car's batteries need to be replaced: "+finalAnswer +"times.");
    }
}

