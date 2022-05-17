class Main {
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
}