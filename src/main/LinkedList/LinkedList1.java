public class LinkedList1 {
    Node head;

    public LinkedList1() {
        this.head = null;
    }

    // Hàm chèn phần tử giá trị x vào vị trí p
    public void insert(int p, int x) {
        Node newNode = new Node(x);
        if (p == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < p - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    // Hàm xoá phần tử giá trị x
    public void delete(int x) {
        Node current = head;
        Node prev = null;

        // Kiểm tra nếu node cần xoá là head
        if (current != null && current.data == x) {
            head = current.next;
            return;
        }

        // Tìm node cần xoá và lưu lại node trước nó
        while (current != null && current.data != x) {
            prev = current;
            current = current.next;
        }

        // Nếu không tìm thấy node cần xoá
        if (current == null) {
            return;
        }

        // Xoá node
        prev.next = current.next;
    }

    // Hàm hiển thị linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();

        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);

        System.out.println("Linked List after insert:");
        list.display();

        list.delete(2);

        System.out.println("Linked List after delete:");
        list.display();
    }
}
