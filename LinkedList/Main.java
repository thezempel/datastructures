class Main {
  public static void main(String[] args) {
    LinkedOrderedList list = new LinkedOrderedList();
    list.add(2);
    list.add(6);
    list.add(1);
    list.add(4);
    list.add(10);
    list.add(5);
    list.add(3);
    list.add(7);
    list.add(9);
    list.add(8);
    System.out.println(list.last());
    System.out.println(list.toString());
    System.out.println(list.contains(4));
    System.out.println(list.contains(11));
    list.removeFirst();
    list.removeLast();
    System.out.println(list.last());
    System.out.println(list.toString());
  
    System.out.println(list.first());
    System.out.println(list.remove(4));
    System.out.println(list.toString());
    
  }
}