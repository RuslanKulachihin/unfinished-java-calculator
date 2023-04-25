package Components;

import view.AbstractComponent;
import view.AllCalculations;
import view.ComponentType;

import java.util.Arrays;
import java.util.Scanner;


public class MenuCalculate extends AbstractComponent<Void> {
    public MenuCalculate() {
        super(ComponentType.CALCULATE, null);
    }

    @Override
    public void draw() {
        Scanner reader = new Scanner(System.in);
        System.out.print("\nВведите вырожение для расчета:\t");
        String str = reader.nextLine();
        String calculationStr = str.replaceAll("[^0-9-+*/%][^0-9]","");
        String result = calculationStr;
        result = result.replaceAll ("\s", "");
        String resultString =  Arrays.toString(new double[]{lexicalAnalyzer.eval(result)});
        resultString = resultString.replaceAll ("[^0-9 .]", "");
        result = "\n"+result + " = " + resultString + "\n";
        System.out.println(result);
        AllCalculations.operations.add(result);
        /*MenuHistoryOperations setResults = new MenuHistoryOperations();
        setResults.setResult(result);*/
        Arrays.stream(ComponentType.values())
                .map(v -> v.getType() + " " + v.getComment())
                .forEach(System.out::println);
        System.out.println("9 - Exit\n");
    }
    public static class lexicalAnalyzer {
        public static double eval(final String result) {
            return new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < result.length()) ? result.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < result.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                    return x;
                }

                double parseExpression() {
                    double x = parseTerm();
                    for (;;) {
                        if      (eat('+')) x += parseTerm(); // addition
                        else if (eat('-')) x -= parseTerm(); // subtraction
                        else return x;
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    for (;;) {
                        if      (eat('*')) x *= parseFactor(); // multiplication
                        else if (eat('/')) x /= parseFactor(); // division
                        else return x;
                    }
                }

                double parseFactor() {
                    if (eat('+')) return +parseFactor(); // unary plus
                    if (eat('-')) return -parseFactor(); // unary minus

                    double x;
                    int startPos = this.pos;
                    if (eat('(')) { // parentheses
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')'");
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(result.substring(startPos, this.pos));
                    } else if (ch >= 'a' && ch <= 'z') { // functions
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String func = result.substring(startPos, this.pos);
                        if (eat('(')) {
                            x = parseExpression();
                            if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                        } else {
                            x = parseFactor();
                        }
                        if (func.equals("sqrt")) x = Math.sqrt(x);
                        else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                        else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                        else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                        else throw new RuntimeException("Unknown function: " + func);
                    } else {
                        throw new RuntimeException("Unexpected: " + (char)ch);
                    }

                    if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
                    return x;
                }
            }.parse();
        }
    }
}
