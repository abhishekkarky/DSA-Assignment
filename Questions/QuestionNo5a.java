//Create an array list of integer arrays "heights".
//Call the method "transformBuilding" and pass in the "buildings" and "heights" array lists.
//Sort the "heights" array list using a custom comparator that compares the first element in each array, and if they are the same, compare the second element instead.
//Create a priority queue of integers "pq" and seed it with 0.
//Create an integer variable "prevMax" and set it to 0.
//Loop through each array "height" in the "heights" array list.
//If the second element in the "height" array is negative, add its absolute value to the priority queue "pq".
//Otherwise, remove the second element from the priority queue.
//Get the maximum value in the priority queue "pq" and assign it to the variable "CurrentMax".
//If "CurrentMax" is not equal to "prevMax", create a new array list "subResult", add the first element from the "height" array and "CurrentMax" to it, and add the "subResult" to the "res" list.
//Set "prevMax" to "CurrentMax".
//Return the "res" list.
//Create a method named "transformBuilding" that takes in a 2D integer array "buildings" and an array list of integer arrays "heights".
//Loop through each array "building" in the "buildings" array.
//Add a new array to the "heights" array list with the first element from the "building" array, the negative value of the third element from the "building" array, and repeat this process but with the second element from the "building" array and the third element from the "building" array instead.
import java.util.*;

class QuestionNo5a {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res=new ArrayList<>();

        List<int[]> heights=new ArrayList<>();

        transformBuilding(buildings,heights);

        //if heights of 2 points are same then place the point with smaller height first else place point with smaller starting point

        Collections.sort(heights,(a,b)->(a[0]==b[0]) ? a[1]-b[1] : a[0]-b[0]);// TC->O(nlog n)

        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->(b-a));

        //seeding the Priority Queue
        pq.add(0);
        int prevMax=0;

        for(int[] height:heights){ //O(n)

            if(height[1]<0){
                pq.add(-height[1]);
            }
            else{
                pq.remove(height[1]); //O(log n)
            }

            int CurrentMax=pq.peek();
            if(CurrentMax!=prevMax)
            {
                List<Integer> subResult=new ArrayList<>();
                subResult.add(height[0]);
                subResult.add(CurrentMax);

                res.add(subResult);
                prevMax=CurrentMax;
            }
        }

        return res;
    }
    //this will seperate the values of start point and end point with height
    //example-->[1,2,3]-->[1,-3] & [2,3]-->here -(minus) is just for convention for starting point
    private void transformBuilding(int[][] buildings,List<int[]> heights)
    {
        for(int[] building:buildings)
        {
            heights.add(new int[]{building[0],-building[2]});
            heights.add(new int[]{building[1],building[2]});
        }



    }

    public static void main(String[] args) {
        int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
        QuestionNo5a solution = new QuestionNo5a();





        List<List<Integer>> ans = solution.getSkyline(height);
        System.out.println(ans);

    }



}