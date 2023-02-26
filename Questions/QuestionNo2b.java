
import java.util.LinkedList;
import java.util.Queue;

/* In the "dfs" function, if the node is null, return 2.
Otherwise, recursively call the "dfs" function on the left and right children of the node and store the result in variables "left" and "right".
If either "left" or "right" is 0, it means that the node needs to be covered by a camera, so increment "res" and return 1.
If either "left" or "right" is 1, it means that the node is already covered by a camera, so return 2.
Otherwise, return 0.
In the "minCameraCover" function, call the "dfs" function on the root node, and if the result is less than 1, it means that the root node needs to be covered by a camera, so add 1 to "res".
Return the value of "res" as the final result. */


class TreeNode{
    TreeNode left;
    TreeNode right;
        int data;

    TreeNode(int data){
            this.data=data;
            this.left=this.right=null;
    }
    TreeNode(){

    }

    public TreeNode addToTree(Object[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode((int) input[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < input.length; i += 2) {
            TreeNode curr = queue.poll();
            if (input[i] != null) {
                curr.left = new TreeNode((int) input[i]);
                queue.offer(curr.left);
            }
            if (i+1 < input.length && input[i+1] != null) {
                curr.right = new TreeNode((int) input[i+1]);
                queue.offer(curr.right);
            }
        }

        return root;
    }


}



class ConstructionServiceCenter{
    int res = 0;
    public int minCameraCover(TreeNode root) {

        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {

        if (root == null) return 2;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }

    public static void main(String[] args) {
        Object[] tree= {0,0, null, 0, null, 0, null, null, 0 , 0 ,null,0};
        TreeNode root = new TreeNode().addToTree(tree);
        int ans = new ConstructionServiceCenter().minCameraCover(root);
        System.out.println(ans);


    }

}

