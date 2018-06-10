package pers.cabin.jichu.a3_typeofstru.tree4_binaryTree;

import org.junit.Test;

import java.util.Stack;

public class Test1 {

    @Test
    public void testBinaryTree() {

        BinaryTree t = new BinaryTree();
        t.insert(new Data((int) (Math.random() * 10)));
        t.insert(new Data((int) (Math.random() * 10)));
        t.insert(new Data((int) (Math.random() * 10)));
        t.insert(new Data((int) (Math.random() * 10)));

        t.showTree();
    }

}

/**
 * 二叉树 的深度 最大为5，实际的树中不会出现这样的问题
 *
 * @author caiping
 */
class BinaryTree {

    private class Node {
        Data data;
        Node leftChild;
        Node rightChild;

        //		-------------------
        public Node(Data data) {
            this.data = data;
        }

        public void displayNode() {
            System.out.print(data.getI());
        }
    }

    //	---------------------
    private Node root;
//	------------------

    public BinaryTree() {
        super();
    }

    //	----------------------
    public Data find(Data key) {
        Node current = root;
        while (key.compareTo(current.data) != 0) {
            if (key.compareTo(current.data) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current.data;
    }

    //	------------
    public void insert(Data data) {
        Node newNode = new Node(data);
        if (data == null) {
            return;
        }
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (newNode.data.compareTo(current.data) < 0) {    //向左 树走
                current = current.leftChild;
                if (current == null) {    //最后一层
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }

            }
        }

    }

    //	----------
    public boolean delete(Data key) {
        Node current = this.root;
        Node parent = root;
        boolean isLeftChild = true;

        while (key.compareTo(current.data) != 0) {
            parent = current;
            if (key.compareTo(current.data) < 0) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) { //没有找到
                return false;
            }
        }
        //删除节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == this.root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }

        //如果没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else { //有两个节点
            Node successor = getSucesessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }

        return true;
    }

    private Node getSucesessor(Node delNode) {
        // TODO Auto-generated method stub
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    //	----------------
    public void showTree() {

        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("........................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    temp.displayNode();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    } else {
                        System.out.print("..");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j < nBlanks * 2.2; j++) {
                        System.out.print(' ');
                    }
                }
            }//End while
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
            System.out.println("........................");
        }
    }

    private void showLeftNode(Node parent) {
        parent.leftChild.displayNode();
    }

    private void showRightNode(Node parent) {
        parent.rightChild.displayNode();
    }
}

class Data implements Comparable<Data> {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Data(int i) {
        super();
        this.i = i;
    }

    //----------------
    public int compareTo(Data o) {
        return this.getI() - o.getI();
    }

}