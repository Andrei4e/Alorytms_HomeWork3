public class Main {
    
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.Add(5);
        redBlackTree.Add(7);
        redBlackTree.Add(10);
        redBlackTree.Add(3);
        redBlackTree.Add(6);
        redBlackTree.Add(20);
        redBlackTree.Add(25);
        redBlackTree.Add(35);
        redBlackTree.Add(1);
        
        redBlackTree.PrintRedBlackTree(redBlackTree);
    }
}
