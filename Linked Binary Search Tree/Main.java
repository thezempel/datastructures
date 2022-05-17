class Main {
  public static void main(String[] args) {
    LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree();
    /*tree.add(1);
    tree.add(5);
    tree.add(6);
    tree.add(3);
    System.out.println(tree.findMax());
    System.out.println(tree.findMin());
    System.out.println(tree.removeMax());
    System.out.println(tree.findMax());
    */
    System.out.println(tree.removeMin());
  }
}