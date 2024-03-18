package com.systeminfos.job.joinbrix;

import java.util.Objects;

/**
 * 2 * @Author: LJJ
 * 3 * @Date: 2023/8/18 13:32
 * 4
 */
public class ValidateBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 主函数，判断给定二叉树是否为有效二叉搜索树
    public boolean isValidBST(TreeNode root) {
        // 调用递归函数，初始值不限定上界和下界
        return isValidBST(root, null, null);
    }

    // 递归函数，判断以当前节点为根的子树是否为有效的二叉搜索树
    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        System.out.println(Objects.isNull(node) ? -1 : node.val);

        // 递归终止条件，如果当前节点为空，说明子树是一个有效的二叉搜索树
        if (node == null) {
            return true;
        }
        int val = node.val;

        // 检查当前结点的是否在合适的范围内
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        // 递归判断左子树和右子树是否是有效的二叉搜索树
        // 对于左子树，当前节点的值成为上界；对于右子树，当前节点的值成为下界
        return isValidBST(node.left, lower, val) && isValidBST(node.right, val, upper);
    }

    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();

        // 创建示例二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);


        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(7);
        root2.right.right = new TreeNode(9);

        // 调用验证函数并输出结果
//        boolean isValid = validateBST.isValidBST(root);
        boolean isValid2 = validateBST.isValidBST(root2);
        System.out.println("是否为二叉搜索树? " + isValid2); // 输出 true
//        System.out.println("是否为二叉搜索树? " + isValid); // 输出 true
    }
}

