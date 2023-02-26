//Define a ListNode class with two properties: val (integer value) and next (reference to next node).
//Define a sortList method that takes a ListNode head as input and returns an integer value.
//Initialize a count variable to 0 and a current variable to head.
//Traverse the linked list while the current node's next property is not null.
//If the current node's value is greater than the next node's value, remove the next node by updating the current node's next property to point to the node after the next node and increment the count variable by 1.
//If the current node's value is less than or equal to the next node's value, set the current node to be the next node and continue traversing.
//Return the count variable, which represents the number of steps required to sort the linked list.
class Question4B {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int sortList(ListNode head) {
        if (head == null || head.next == null)
            return 0;

        int count = 0;
        ListNode current = head;
        while (current.next != null) {
            if (current.val > current.next.val) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Question4B obj = new Question4B();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next = new ListNode(7);

        System.out.println("Number of steps required to sort the linked list: " + obj.sortList(head));
    }
}