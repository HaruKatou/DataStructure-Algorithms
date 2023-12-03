public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // In cây nhị phân theo thứ tự giảm dần
    void printInOrderDecreasing(TreeNode node) {
        if (node == null)
            return;

        // Duyệt cây theo thứ tự: phải, giữa, trái
        printInOrderDecreasing(node.right);
        System.out.print(node.value + " ");
        printInOrderDecreasing(node.left);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Thêm các khóa vào cây
        tree.root = new TreeNode(50);
        tree.root.left = new TreeNode(30);
        tree.root.right = new TreeNode(70);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(40);
        tree.root.right.left = new TreeNode(60);
        tree.root.right.right = new TreeNode(80);

        System.out.println("Duyệt cây theo thứ tự giảm dần:");
        tree.printInOrderDecreasing(tree.root);
    }
}