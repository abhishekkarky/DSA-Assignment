import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Question 6
        a)	Implement Huffman encoding and decoding.
*/

//Create a function called "printCode" which takes a root node and string s as input
//If the current node is a leaf node (i.e. left and right pointers are null and the character is a letter), print the character and its corresponding code (which is the string s passed in)
//Recursively call printCode for the left and right child nodes, adding "0" to the code string for the left child and "1" for the right child
//Create a function called "encode" which takes an array of characters and their frequencies as input
//Create a priority queue of HuffmanNode objects with each character as a leaf node and its frequency as the data
//While there are at least 2 nodes in the queue, remove the 2 nodes with the lowest frequencies and create a new node with a "-" character and a data value equal to the sum of the removed nodes' data values. Set the removed nodes as the left and right children of the new node
//Add the new node to the queue
//Once only one node remains in the queue, it is the root of the Huffman tree
//Call the printCode function on the root node to print out each character and its corresponding Huffman code
//Create a function called "decode" which takes the Huffman tree root and a string of Huffman codes as input
//Initialize an empty array list for characters and another empty array list for their frequencies
//Traverse the Huffman tree using the provided string of Huffman codes and add each character and its frequency to their respective array lists
//Print out the characters and their frequencies using the printDecode function
//Create a custom comparator class called "MyComparator" which compares 2 HuffmanNode objects based on their data values
//In the main function, define an array of characters and their frequencies
//Create a new Huffman object and call the encode function with the character and frequency arrays as input. Store the returned root node of the Huffman tree
//Print out the data value of the root node
//Define a string of Huffman codes to be decoded
//Call the decode function with the root node and Huffman code string as input
//The decoded characters and their frequencies will be printed out
 class Huffman {
     class HuffmanNode{
        int data;
        char c;
        HuffmanNode left;
        HuffmanNode right;
    }

    //prints the encoded huffman code
    public static void printCode(HuffmanNode root, String s){
        if(root.left==null&&root.right==null&&Character.isLetter(root.c)){
            System.out.println(root.c+":"+s);
            return;
        }
        printCode(root.left,s+"0");
        printCode(root.right,s+"1");
    }

    //encoding
    public HuffmanNode encode(char[] charArray, int[] charFreq){
        int n=charArray.length;
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());
        for(int i=0; i<n; i++){
            HuffmanNode hn = new HuffmanNode();
            hn.c=charArray[i];
            hn.data=charFreq[i];

            hn.left=null;
            hn.right=null;
            q.add(hn);
        }
        HuffmanNode root=null;
        while(q.size()>1){
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data+y.data;
            f.c='-';
            f.left=x;
            f.right=y;
            root=f;
            q.add(f);
        }
        printCode(root,"");
        return root;
    }

    //decoding the huffman tree
    public void decode(HuffmanNode root, String str){
        ArrayList characters= new ArrayList<>();
        ArrayList frequency=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            HuffmanNode current = root;
            while (current.c=='-'){
                if(str.charAt(i)=='0'){
                    current=current.left;
                    i++;
                }
                else {
                    current=current.right;
                    i++;
                }
            }
            char c = current.c;
            int f =current.data;
            characters.add(current.c);
            frequency.add(current.data);
        }
        printDecode(characters,frequency);
    }

    public static void printDecode(ArrayList characters, ArrayList frequencies){
        for (int i=0; i<characters.size(); i++){
            System.out.println(characters.get(i)+":"+frequencies.get(i));
        }
    }
    class MyComparator implements Comparator<HuffmanNode> {
        public int compare(Huffman.HuffmanNode x, Huffman.HuffmanNode y)
        {
            //used to sort the character in the sequence of r
            return x.data - y.data;
        }
    }
    //driver method
    public static void main(String[] args) {
        char[] ch={'A','B','C','D','E'};
        int[] fre= {4,7,3,2,7};

        Huffman h = new Huffman();
        HuffmanNode hn= h.encode(ch,fre);
        System.out.println(hn.data);
        String cha = "000100111011";
        h.decode(hn,cha);

    }
}