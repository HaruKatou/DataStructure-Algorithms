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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.value == val)
            return root;
        if (val < root.value)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.value) {
            TreeNode left = insertIntoBST(root.left, val);
        } else {
            TreeNode right = insertIntoBST(root.right, val);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.value > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.value < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            TreeNode rightMin = root.right;
            while (rightMin.left != null)
                rightMin = rightMin.left;
            root.value = rightMin.value;
            root.right = deleteNode(root.right, root.value);
        }
        return root;
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