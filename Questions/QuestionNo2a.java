

import java.util.*;


/* Call the dfs method with arguments (nums, tree, 0, 0, visited, ans, map, poss), where visited is a boolean array of size n indicating whether each node has been visited in the DFS traversal.
The dfs method performs a DFS traversal of the tree, starting at node 0. For each node node visited, it first checks if there is a previously visited node with a coprime value to nums[node]. If there is, it chooses the node with the smallest depth as the ancestor of node. Otherwise, it sets the ancestor of node to -1.
It then updates the map with the current node node and its depth.
Finally, it recursively visits all the children of node, passing in the updated map and visited arrays.
After visiting all the children, it removes the current node from the map and restores any previously stored value for nums[node].
The getCoprimes method returns the ans array as the result of the algorithm. */




class ListOfAncestors {
    public int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    public void dfs(int[] nums, LinkedList<Integer>[] tree, int depth, int node, boolean[] visited, int[] ans, Map<Integer,int[]> map, boolean[][] poss) {
        if(visited[node]) return;
        visited[node] = true;
        int ancestor = -1;
        int d = Integer.MAX_VALUE;
        for(int i = 1; i < 51; i++) {
            if(poss[nums[node]][i] && map.containsKey(i)) {
                if(depth - map.get(i)[0] <= d) {
                    d = depth - map.get(i)[0];
                    ancestor = map.get(i)[1];
                }
            }
        }
        ans[node] = ancestor;
        int[] exist = (map.containsKey(nums[node])) ? map.get(nums[node]) :  new int[]{-1,-1};
        map.put(nums[node],new int[]{depth,node});
        for(int child : tree[node]) {
            if(visited[child]) continue;
            dfs(nums, tree, depth+1, child, visited, ans, map, poss);
        }
        if(exist[0] != -1) map.put(nums[node], exist);
        else map.remove(nums[node]);

        return;
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        boolean[][] poss = new boolean[51][51];
        for(int i = 1; i < 51; i++) {
            for(int j = 1; j < 51; j++) {
                if(gcd(i,j) == 1) {
                    poss[i][j] = true;
                    poss[j][i] = true;
                }
            }
        }
        int n = nums.length;
        LinkedList<Integer>[] tree = new LinkedList[n];

        for(int i =0 ; i < tree.length; i++) tree[i] = new LinkedList<>();
        for(int edge[] : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = -1;
        Map<Integer,int[]> map = new HashMap<>();

        boolean[] visited = new boolean[n];
        dfs(nums, tree, 0, 0, visited, ans, map, poss);

        return ans;
    }

    public static void main(String[] args) {
        int[][] edges =  {{0,1}, {0,2}, {1,3}, {1,4}, {2,5}, {2,6}};
        int [] values = {3,2,6,6,4,7,12};
        ListOfAncestors listOfAncestors = new ListOfAncestors();
        int[] ans = listOfAncestors.getCoprimes(values,edges);
        List<Integer> answer= new ArrayList<Integer>();
        for (int i = 0;i<ans.length;i++) {
            answer.add(ans[i]);
        }
        System.out.println(answer);
    }


}
