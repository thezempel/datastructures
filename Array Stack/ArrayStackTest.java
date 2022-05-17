public class ArrayStackTest{
  // instantiates a stack, with arbirary capacity of 3,
  // tests push, pop, top, and isEmpty methods
  public static void emptyStackTest(){
    System.out.println("------------------------");
    System.out.println("test with an empty stack");
    ArrayStack emptyStack = new ArrayStack(3);
    System.out.println("------------------------");
    System.out.println();
    System.out.println("testing push()...");
    try {
      emptyStack.push(1);

      System.out.println("test successul");
    }
    catch (Exception e) {
      System.out.println("push test failed");
    }
    System.out.println();
    System.out.println("testing pop()...");
    try {
      emptyStack.pop();
       System.out.println("popped");
    }
    catch(Exception e) {
      System.out.println("pop test failed");
    }
    System.out.println();
    System.out.println("test top()...");
    try{
      System.out.println("the top is " + emptyStack.top());
    }
    catch(Exception e) {
      System.out.println("there are no elements on top");
    }
    System.out.println();
    System.out.println("testing isEmpty()...");
    if (emptyStack.isEmpty())
      System.out.println("the stack is empty");
    else
      System.out.println("the stack is not empty");
  }

  public static void capacityTest(){
    System.out.println("-----------------------");
    ArrayStack stackOf1 = new ArrayStack(1);
    System.out.println("beginning capacity test");
    System.out.println("-----------------------");
    System.out.println();
    System.out.println("pushing two elements into stack...");
    try {
      stackOf1.push(1);
      System.out.println("1 pushed into stack");
      stackOf1.push(2);
      System.out.println("2 pushed into stack");
    }
    catch (Exception e) {
      System.out.println("push failed");
    }
    System.out.println();
    System.out.println("new capacity " + stackOf1.capacity());
  }

  public static void topTest() {
    int top1 = 1;
    int top2 = 2;
    int top3 = 3;
    System.out.println("----------------------");
    System.out.println("testing top is correct");
    System.out.println("----------------------");
    ArrayStack topStack = new ArrayStack(3);
    topStack.push(top1);
    if ((int)topStack.top() == top1)
      System.out.println("top is " + topStack.top());
    else {
      System.out.println("expected = " + top1);
      System.out.println("actual = " + topStack.top());
    }
    System.out.println();
    topStack.push(top2);
    if ((int)topStack.top() == top2)
      System.out.println("top is " + topStack.top());
    else {
      System.out.println("expected = " + top2);
      System.out.println("actual = " + topStack.top());
    }
    System.out.println();
    topStack.push(top3);
    if ((int)topStack.top() == top3)
      System.out.println("top is " + topStack.top());
    else 
      System.out.println("expected = " + top3 + "\n actual = " + topStack.top());
      System.out.println();
      System.out.println("top test successful");
  }
}
