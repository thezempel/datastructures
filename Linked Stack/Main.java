public class Main {
  public static void main(String[] args) {
  LinkedStack myStack = new LinkedStack();
   myStack.push(8);
   System.out.println(myStack.toString());
	myStack.push(6);
  System.out.println(myStack.toString());
	myStack.pop();
  System.out.println(myStack.toString());
	myStack.push(3);
  System.out.println(myStack.toString());
	myStack.push(4);
  System.out.println(myStack.toString());
	myStack.push(15);
  System.out.println(myStack.toString());
	myStack.push(12);
  System.out.println(myStack.toString());
	myStack.push(9);
  System.out.println(myStack.toString());
	myStack.pop();
  System.out.println(myStack.toString());
	myStack.pop();
  System.out.println(myStack.toString());
	myStack.pop();
  System.out.println(myStack.toString());
	myStack.push(19);
  System.out.println(myStack.toString());
   
  }
}