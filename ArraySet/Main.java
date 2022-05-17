class Main {
  public static void main(String[] args) {
    ArraySet set = new ArraySet();
    set.add(5);
    set.add(6);
    set.add(3);
    System.out.println(set.toString());
    ArraySet second = new ArraySet();
    second.add(4);
    second.add(5);
    second.add(6);
    System.out.println(set.intersection(second));
  }
}