public class RedBlackTree {
    private Node root;

    public boolean Add(int value){
        if (root != null){
            boolean result = AddNode(root, value);
            root = Rebalance(root);
            root.color =Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    public boolean AddNode(Node node, int value){
        if (node.value == value){
            return false;
        } else {
            if (node.value > value){
                if (node.leftChild != null){
                    boolean result = AddNode(node.leftChild, value);
                    node.leftChild = Rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null){
                    boolean result = AddNode(node.rightChild, value);
                    node.rightChild = Rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    public void PrintRedBlackTree(RedBlackTree redBlackTree){
        if (redBlackTree.root != null){
            PrintNode(redBlackTree.root, 0);
        }
    }

    private void PrintNode(Node node, int lvl){
        System.out.print(node.value + "-" + node.color + "(" + lvl + ") ");
        if (node.leftChild != null ){
            PrintNode(node.leftChild, lvl + 1);
        }
        if (node.rightChild != null ){
            PrintNode(node.rightChild, lvl + 1);
        }
    }

    private void ColorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node LeftSwap(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node RightSwap(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node Rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if(result.rightChild != null && result.rightChild.color == Color.RED &&
                (result.leftChild == null || result.leftChild.color == Color.BLACK)){
                    needRebalance = true;
                    result = RightSwap(result);
                }
            if(result.leftChild != null && result.leftChild.color == Color.RED &&
                result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED){
                    needRebalance = true;
                    result = LeftSwap(result);
                }
            if(result.leftChild != null && result.leftChild.color == Color.RED &&
                result.rightChild != null && result.rightChild.color == Color.RED){
                    needRebalance = true;
                    ColorSwap(result);
                }
        }
        while (needRebalance);
        return result;
    }

    private class Node{
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;
    }

    private enum Color{
        RED, BLACK
    }
}