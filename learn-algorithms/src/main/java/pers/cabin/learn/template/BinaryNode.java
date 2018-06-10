package pers.cabin.learn.template;

/**
 * Created by caiping on 2017/9/20.
 */
class BinaryNode<Item> {
    /**
     * 节点的值
     */
    Item item;
    /**
     * 左节点
     */
    BinaryNode left;
    /**
     * 右节点
     */
    BinaryNode right;

    public BinaryNode(Item item) {
        this(item,null,null);
    }

    public BinaryNode(Item item, BinaryNode left, BinaryNode right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }
}
