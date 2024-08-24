class TreeNode {
    BankAccount account;
    TreeNode left, right;

    public TreeNode(BankAccount account) {
        this.account = account;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(BankAccount account) {
        root = insertRec(root, account);
    }

    private TreeNode insertRec(TreeNode root, BankAccount account) {
        if (root == null) {
            root = new TreeNode(account);
            return root;
        }

        if (account.getAccountNumber() < root.account.getAccountNumber()) {
            root.left = insertRec(root.left, account);
        } else if (account.getAccountNumber() > root.account.getAccountNumber()) {
            root.right = insertRec(root.right, account);
        }

        return root;
    }

    public BankAccount search(int accountNumber) {
        return searchRec(root, accountNumber);
    }

    private BankAccount searchRec(TreeNode root, int accountNumber) {
        if (root == null || root.account.getAccountNumber() == accountNumber) {
            return (root != null) ? root.account : null;
        }

        if (accountNumber < root.account.getAccountNumber()) {
            return searchRec(root.left, accountNumber);
        }

        return searchRec(root.right, accountNumber);
    }
}
