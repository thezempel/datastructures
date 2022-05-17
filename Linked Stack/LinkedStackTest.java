public class LinkedStackTest {
  // instantiates a stack
  // tests push, pop, top, and isEmpty methods
  public static void emptyStackTest(){
    System.out.println("------------------------");
    System.out.println("test with a new stack");
    LinkedStack emptyStack = new LinkedStack();
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
    System.out.println("testing top()...");
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

  public static void sizeTest(){
    System.out.println("-----------------------");
    LinkedStack newStack = new LinkedStack();
    System.out.println("beginning size test");
    System.out.println("-----------------------");
    System.out.println();
    System.out.println("pushing two elements into stack...");
    System.out.println();
    try {
      newStack.push(1);
      System.out.println("1 pushed into stack:");
      System.out.println("size of stack is " + newStack.size());
      System.out.println();
      newStack.push(2);
      System.out.println("2 pushed into stack");
    }
    catch (Exception e) {
      System.out.println("push failed");
    }
    System.out.println("size of stack is now " + newStack.size());
  }

  public static void topTest() {
    String top1 = "yabba";
    String top2 = "dabba";
    String top3 = "do";
    System.out.println("----------------------");
    System.out.println("testing top is correct");
    System.out.println("----------------------");
    LinkedStack topStack = new LinkedStack();
    topStack.push(top1);
    if (topStack.top() == top1)
      System.out.println("top is " + topStack.top());
    else {
      System.out.println("expected = " + top1);
      System.out.println("actual = " + topStack.top());
    }
    System.out.println();
    topStack.push(top2);
    if (topStack.top() == top2)
      System.out.println("top is " + topStack.top());
    else {
      System.out.println("expected = " + top2);
      System.out.println("actual = " + topStack.top());
    }
    System.out.println();
    topStack.push(top3);
    if (topStack.top() == top3)
      System.out.println("top is " + topStack.top());
    else 
      System.out.println("expected = " + top3 + "\n actual = " + topStack.top());
      System.out.println();
      System.out.println("top test successful");
  }

}