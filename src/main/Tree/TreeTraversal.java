import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class TreeTraversal {

    // Inorder traversal: phải, giữa, trái
    void printInOrder(TreeNode node) {
        if (node == null)
            return;

        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    // Using stack
    void inorder(TreeNode root)
    {
        if (root == null)
            return;


        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;

        // Traverse the tree
        while (curr != null || s.size() > 0)
        {

            // Reach the left most Node of the
            // curr Node
            while (curr !=  null)
            {
                // Place pointer to a tree node on
                // the stack before traversing
                // the node's left subtree
                s.push(curr);
                curr = curr.left;
            }

            // Current must be NULL at this point
            curr = s.pop();

            System.out.print(curr.value + " ");

            curr = curr.right;
        }
    }

    // Preorder traversal: giữa, trái, phải
    void printPreOrder(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Postorder traversal: trái, phải, giữa
    void printPostOrder(TreeNode node) {
        if (node == null)
            return;

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.value + " ");
    }

    void printLevelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top == null)
                return;
            System.out.print(top.value + " ");
            queue.add(top.left);
            queue.add(top.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeTraversal  traversal = new TreeTraversal();

        // Thêm các khóa vào cây
        tree.root = new TreeNode(99);
        tree.root.left = new TreeNode(63);
        tree.root.right = new TreeNode(98);
        tree.root.left.left = new TreeNode(60);
        tree.root.left.right = new TreeNode(62);
        tree.root.right.left = new TreeNode(90);
        tree.root.right.right = new TreeNode(59);
        tree.root.left.left.left = new TreeNode(2);
        tree.root.left.left.right = new TreeNode(20);
        tree.root.left.right.right = new TreeNode(61);
        tree.root.left.right.left = new TreeNode(30);

        traversal.printLevelOrder(tree.root);
    }
}
