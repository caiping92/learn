package pers.cabin.learn.chaptor01;

/**
 * 搜索二叉树
 * <p>
 * http://blog.csdn.net/u012124438/article/details/77987391
 * <p>
 * Created by caiping on 2017/9/20.
 */
public class BinarySearchTree<Item extends Comparable<? super Item>> {

    private BinaryNode<Item> root;

    /**
     * 清空二叉树
     */
    public void makEmpty() {
        this.root = null;
    }

    /**
     * 二叉树是否为null
     *
     * @return
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * 二叉树中是否包含元素 item
     *
     * @param item
     * @return
     */
    public boolean contains(Item item) {
        return contains(item, this.root);
    }

    /**
     * root 二叉树 ，是否包含item元素
     *
     * @param item
     * @param root
     * @return
     */
    public boolean contains(Item item, BinaryNode<Item> root) {

        if (item == null) {
            return false;
        }
        int result = item.compareTo(root.item); //当前值和当前根节点进行比较
        if (result < 0) {   //左节点递归
            return contains(item, root.left);
        } else if (result > 0) {
            return contains(item, root.right);
        } else {    // item 就是 root 的值
            return true;
        }
    }

    /**
     * 获取最大值
     *
     * @return
     */
    public Item findMax() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return findMax(root).item;

    }

    /**
     * 查找树中最小元素
     *
     * @param node
     * @return
     */
    private BinaryNode<Item> findMin(BinaryNode<Item> node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    /**
     * 查找节点 node 中的最大值
     *
     * @param node
     * @return
     */
    public BinaryNode<Item> findMax(BinaryNode<Item> node) {
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }
        return node;
    }

    /**
     * 添加一个子节点
     *
     * @param item
     */
    public void insert(Item item) {
        root = insert(item, root);
    }

    /**
     * 在node节点上 添加一个 元素
     *
     * @param t
     * @param node
     * @return
     */
    public BinaryNode<Item> insert(Item t, BinaryNode<Item> node) {
        if (node == null) { // 该树为null（最终挂载树枝上）
            return new BinaryNode<Item>(t, null, null);
        }
        int compareResult = t.compareTo(node.item);
        if (compareResult > 0) {
            node.right = insert(t, node.right);
        } else if (compareResult <= 0) {
            node.left = insert(t, node.left);
        }
        return node;
    }

    /**
     * 移除元素
     *
     * @param t
     */
    public void remove(Item t) {
        root = remove(t, root);
    }

    /**
     * 在节点 树 node 中 移除tem 的 节点
     *
     * @param t
     * @param node
     * @return
     */
    public BinaryNode<Item> remove(Item t, BinaryNode<Item> node) {
        if (node == null) {
            return node;
        }
        int compareResult = t.compareTo(node.item);
        if (compareResult > 0) {    //比当前元素大
            node.right = remove(t, node.right);
        } else if (compareResult < 0) { //比当前元素小
            node.left = remove(t, node.left);
        } else {    //就是当前元素，
            if (node.left != null && node.right != null) {  // 左右节点不为null
                node.item = findMin(node.right).item;
                node.right = remove(node.item, node.right);
            } else {    //但是只有 子节点有一个为null
                node = (node.left != null) ? node.left : node.right;
            }
        }
        return node;
    }
    /**
     * 前序遍历
     *
     * 若二叉树非空，则执行以下操作：
     *
     * (1) 访问根结点；
     * (2) 先序遍历左子树；
     * (3) 先序遍历右子树。
     *
     * @param tree
     */
    private void preOrder(BinaryNode<Item> tree) {
        if (tree != null) {
            System.out.print(tree.item + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     *
     * 若二叉树非空，则执行以下操作：
     *(1) 中序遍历左子树；
     *(2) 访问根结点；
     *(3) 中序遍历右子树。
     *
     * @param tree
     */
    private void inOrder(BinaryNode<Item> tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.item+" ");
            inOrder(tree.right);
        }
    }

    /**
     * 中序遍历 本tree
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     *
     *若二叉树非空，则执行以下操作：
     *(1) 后序遍历左子树；
     *(2) 后序遍历右子树；
     *(3) 访问根结点。
     *
     * @param tree
     */
    private void postOrder(BinaryNode<Item> tree) {
        if(tree != null)
        {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.item+" ");
        }
    }

    /**
     * 后序遍历 本tree
     */
    public void postOrder() {
        postOrder(root);
    }



    private class BinaryNode<Item> {
        /**
         * 节点的值
         */
        Item item;
        /**
         * 左节点
         */
        BinaryNode<Item> left;
        /**
         * 右节点
         */
        BinaryNode<Item> right;

        public BinaryNode(Item item) {
            this(item, null, null);
        }

        public BinaryNode(Item item, BinaryNode<Item> left, BinaryNode<Item> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}
