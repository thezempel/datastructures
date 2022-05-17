/**
 * ExpressionTree provides methods to parse a prefix expression, infix expresseion, or postfix expression.
 *    In addition, there are methods for returning a parsed expression as a prefix expression, infix expresseion, or postfix expression.
 * Assumptions:
 *     - Expressions consist of single character variable names and the operators +, -, *, /, and %.
 *     - Expressions do not contain parentheses.
 *     - Expressions do not contain whitespace.
 * @author Jonathon Zempel
 * @version 2021-08-04
 */
import java.util.Scanner;
import java.util.Stack; // Needed for parseInfix and parsePostfix

public class ExpressionTree {
    public class Node {
        char element;
        Node left, right;
        
        public Node(char element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
        
        public Node(char element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    
    private Node root;
    
    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree();
        String expression = "*-ab+cd";
        if (args.length != 0) {
            expression = args[0];
        }
        System.out.println("  input = " + expression);
        expressionTree.parsePrefix(expression);
        System.out.println(" prefix = " + expressionTree.toStringPrefix());
        System.out.println("  infix = " + expressionTree.toStringInfix());
        System.out.println("postfix = " + expressionTree.toStringPostfix());
    }
    
    /**
     * Sets root to the root of the expression tree.
     * @param string is a prefix expression to be parsed.
     */
    public void parsePrefix(String string) {
        Scanner input = new Scanner(string);
        input.useDelimiter(""); // Each token returned is a single character string
        
        root = parsePrefix(input);
    }

    /**
     * @param input is the sequence of single character strings (a prefix expression) to be parsed.
     * @return the root node of the expression tree for the input
     */
    private Node parsePrefix(Scanner input) {
        // Implement this recursive method
        


          
          
        









        /*char c = input.next().charAt(0);
        root = new Node(c);
        while (input.hasNext()) {
          c = input.next().charAt(0);
          if(isOperator(c) && (root.left == null)) {
            root.left = new Node(c);
          c = input.next().charAt(0);
          
            if(!isOperator(c) &&(root.left.left == null))
              root.left.left = new Node(c);
            else if(!isOperator(c)&&(root.left.left!=null))
              root.left.right = new Node(c);

          }
          else if (isOperator(c) && (root.left != null)) {
            root.right = new Node(c);
          c = input.next().charAt(0);
            
            if(!isOperator(c) &&(root.right.left == null))
              root.right.left = new Node(c);
            else if(!isOperator(c)&&(root.right.left!=null))
              root.right.right = new Node(c);
          }
        }
        */  

            
         
    
        




       
        Stack<Node> expressionTree = new Stack<>();
        Stack <Character>operator = new Stack<>();
        //char r = input.next().charAt(0);
        
        while (input.hasNext()) {
          char c = input.next().charAt(0);
          if (isOperator(c)){
             operator.push(c);
          }
          else {
            Node node = new Node(c);
            expressionTree.push(node);
          }
        }
        while (!operator.empty()) {
          char o = operator.pop();
          Node r = expressionTree.pop();
          Node l = expressionTree.pop();
          
          root = new Node(o, l, r);
          expressionTree.push(root);
        }
        
         
        /*char var[] = new char[100];
        Node operand[] = new Node[100];
        
        int i = 0;
        int j = 0;
        while (input.hasNext()) {
          char c = input.next().charAt(0);
          if (isOperator(c)) {
            var[i] = c;
            i++;
          }
          else
            root = new Node(c);
            operand[j] = root;
            j++;
        } 
        
        for (int q = var.length-1; q <= 0; q--) {
          int z = 0;
          Node r = operand[j];
          j--;
          Node l = operand[j];
          j--;
          root = new Node(var[i], l, r);
          operand[j]=root;
          j++;
        } 
        */
        
          
        return root;
  
        }

        
    
    
    /**
     * Sets root to the root of the expression tree.
     * @param string is an infix expression to be parsed.
     */
    public void parseInfix(String string) {
        // Optional implementation. Note: Use the Java Stack class.
    }
    
    /**
     * Sets root to the root of the expression tree.
     * @param string is a postfix expression to be parsed.
     */
    public void parsePostfix(String string) {
        // Optional implementation. Note: Use the Java Stack class. 
        Stack<Node> expressionTree = new Stack<>();
        Stack <Character>operator = new Stack<>();

        for (char element: string.toCharArray()) {
          
          if (isOperator(element)){
             operator.push(element);
          }
          else {
            root = new Node(element);
            expressionTree.push(root);
          }
        }
        while (!operator.empty()) {
          Node r = expressionTree.pop();
          Node l = expressionTree.pop();
          char c = operator.pop();
          root = new Node(c, l, r);
          expressionTree.push(root);
        }
          
           
          

        
          
        
    }
    
    private Boolean isOperator(char aChar) {
        return "+-*/^%".contains(Character.toString(aChar));
    }
    
    public String toStringPrefix() {
        return toStringPrefix(root);
    }
    
    private String toStringPrefix(Node node) {
        String result = "";
        if (node == null) {
            return result;
        }
        result += String.valueOf(node.element);
        result += toStringPrefix(node.left);
        result += toStringPrefix(node.right);
        
        return result;    
    }
    
    public String toStringInfix() {
        return toStringInfix(root);
    }
    
    private String toStringInfix(Node node) {
        String result = "";
        if (node == null) {
            return result;
        }
        result += toStringInfix(node.left);
        result += String.valueOf(node.element);
        result += toStringInfix(node.right);
        
        return result;    
    }
    
    public String toStringPostfix() {
        return toStringPostfix(root);
    }
    
    private String toStringPostfix(Node node) {
        String result = "";
        if (node == null) {
            return result;
        }
        result += toStringPostfix(node.left);
        result += toStringPostfix(node.right);
        result += String.valueOf(node.element);
        
        return result;    
    }
}
