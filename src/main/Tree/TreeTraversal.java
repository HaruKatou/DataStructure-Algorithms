import java.util.Stack;

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


        Stack<Node> s = new Stack<Node>();
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
        printInOrder(node.left);
        printInOrder(node.right);
    }

    // Postorder traversal: trái, phải, giữa
    void printPostOrder(TreeNode node) {
        if (node == null)
            return;

        printInOrder(node.left);
        printInOrder(node.right);
        System.out.print(node.value + " ");
    }
}
