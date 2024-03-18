package com.systeminfos.job.joinbrix;

import java.util.Objects;
import java.util.Optional;

/**
 * 请编写一个函数来检查是否
 * 给定的树是有效的二叉搜索树。
 */
public class ShowMeBugTree {

    public class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * 判断是否有效的二叉搜索树
         *
         * @param root
         * @return
         */
        public boolean solution(Node root) {
            boolean validTree = false;
            // Write your code here

            int superValue = root.value;
            Node childLeftNode = root.left;
            Node childRightNode = root.right;

            if (Objects.isNull(root)) {
                return !validTree;
            }

            if (superValue <= childLeftNode.value && superValue >= childRightNode.value) {
                return validTree;
            }
            boolean hasChildLeft = Objects.nonNull(childLeftNode) ? true : false;
            boolean hasChildRight = Objects.nonNull(childRightNode) ? true : false;

            while (hasChildLeft) {
                return false;
            }
            while (hasChildRight) {
            }
            if (hasChildLeft || hasChildRight) {
                int childLeftValue = childLeftNode.value;
            }
            if (hasChildLeft || hasChildRight) {
                return solution(childLeftNode);
            }
            return validTree;
        }

        public boolean solution2(Node root) {
            return isValidBst(root, null, null);
        }

        public boolean solution3(Node root) {
            return isValidBst3(root, null, null);
        }

        public boolean solution4(Node root) {
            return isValidBst4(root, null, null);
        }

        /**
         * @param node  比较节点
         * @param lower 左边值
         * @param upper 右边值
         * @return
         */
        public boolean isValidBst(Node node, Integer lower, Integer upper) {
            if (Objects.isNull(node)) {
                return true;
            }
            int nodeValue = node.value;

            if (Objects.nonNull(node.left) && Objects.nonNull(lower) && lower >= upper) {
                return false;
            }

            if (Objects.nonNull(node.right) && Objects.nonNull(upper) && nodeValue >= upper) {
                return false;
            }

            if (Objects.isNull(node.left) && Objects.nonNull(lower) && lower < upper) {
                return true;
            }
            if (Objects.isNull(node.right) && Objects.nonNull(upper) && nodeValue < upper) {
                return true;
            }
//            return isValidBst(node.left, node.left.value, nodeValue) && isValidBst(node.right, nodeValue, node.right.value);
            return isValidBst(node.right, nodeValue, node.right.value);
        }

        /**
         * @param node  比较节点
         * @param lower 左边值
         * @param upper 右边值
         * @return
         */
        public boolean isValidBst3(Node node, Integer lower, Integer upper) {
            // 递归终止条件，如果当前节点为空，说明子树是一个有效的二叉搜索树
            if (Objects.isNull(node)) {
                return true;
            }
            int val = node.value;

            // 检查当前结点的是否在合适的范围内
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            // 递归判断左子树和右子树是否是有效的二叉搜索树
            // 对于左子树，当前节点的值成为上界；对于右子树，当前节点的值成为下界
            return isValidBst3(node.left, lower, val) && isValidBst3(node.right, val, upper);
        }

        // 递归函数，判断以当前节点为根的子树是否为有效的二叉搜索树
        private boolean isValidBst4(Node node, Integer lower, Integer upper) {

            System.out.println("node:" + (Objects.isNull(node) ? -1 : node.value) + ":lower:" + lower + ":uppper:" + upper);

            // 递归终止条件，如果当前节点为空，说明子树是一个有效的二叉搜索树
            if (Objects.isNull(node)) {
                return true;
            }
            int value = node.value;

            // 检查当前结点的是否在合适的范围内
            if (Objects.nonNull(lower) && value <= lower) {
                return false;
            }
            if (Objects.nonNull(upper) && value >= upper) {
                return false;
            }

            // 递归判断左子树和右子树是否是有效的二叉搜索树
            // 对于左子树，当前节点的值成为上界；对于右子树，当前节点的值成为下界
            return isValidBst4(node.left, lower, value) && isValidBst4(node.right, value, upper);
        }
    }

    public static void main(String[] args) {

        ShowMeBugTree leftTree1 = new ShowMeBugTree();
        Node node1 = leftTree1.new Node(1, null, null);
        ShowMeBugTree leftTree2 = new ShowMeBugTree();
        Node node2 = leftTree2.new Node(4, null, null);
        ShowMeBugTree leftTree = new ShowMeBugTree();
        Node leftNode = leftTree.new Node(3, node1, node2);


        ShowMeBugTree rightTree1 = new ShowMeBugTree();
        Node rightTreeNode1 = rightTree1.new Node(7, null, null);
        ShowMeBugTree rightTree2 = new ShowMeBugTree();
        Node rightTreeNode2 = rightTree2.new Node(9, null, null);
        ShowMeBugTree rightTree = new ShowMeBugTree();
        Node rightNode = rightTree.new Node(8, rightTreeNode1, rightTreeNode2);

        ShowMeBugTree rootTree = new ShowMeBugTree();
        Node root = rootTree.new Node(5, leftNode, rightNode);
//        System.out.println(root.solution2(root));
//        System.out.println(root.solution3(root));
        System.out.println(root.solution4(root));
    }

}