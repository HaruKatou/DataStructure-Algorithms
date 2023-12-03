public class Graph {
    // Bài toán tìm chu trình
    public boolean hasCycle(Node head) {
        if (head == null)
            return false;
        Node slow = new Node();
        Node fast = new Node();
        slow = head;
        fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
