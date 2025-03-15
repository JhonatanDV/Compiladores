import java.util.HashMap;
import java.util.Map;

public class CalculatorEvaluator extends CalculatorBaseListener {
    private Map<String, Integer> memory = new HashMap<>();
    private Map<String, Integer> results = new HashMap<>();

    @Override
    public void exitAssignment(CalculatorParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        int value = evaluateExpression(ctx.expr());
        memory.put(id, value);
        results.put(id, value);
    }

    private int evaluateExpression(CalculatorParser.ExprContext ctx) {
        if (ctx instanceof CalculatorParser.LiteralContext) {
            return Integer.parseInt(ctx.getText());
        } else if (ctx instanceof CalculatorParser.VariableContext) {
            String id = ctx.getText();
            if (!memory.containsKey(id)) {
                throw new RuntimeException("Variable not defined: " + id);
            }
            return memory.get(id);
        } else if (ctx instanceof CalculatorParser.ParensContext) {
            return evaluateExpression(((CalculatorParser.ParensContext) ctx).expr());
        } else if (ctx instanceof CalculatorParser.AddSubContext) {
            CalculatorParser.AddSubContext addSubContext = (CalculatorParser.AddSubContext) ctx;
            int left = evaluateExpression(addSubContext.expr(0));
            int right = evaluateExpression(addSubContext.expr(1));
            
            if (addSubContext.ADD() != null) {
                return left + right;
            } else {
                return left - right;
            }
        } else if (ctx instanceof CalculatorParser.MulDivContext) {
            CalculatorParser.MulDivContext mulDivContext = (CalculatorParser.MulDivContext) ctx;
            int left = evaluateExpression(mulDivContext.expr(0));
            int right = evaluateExpression(mulDivContext.expr(1));
            
            if (mulDivContext.MUL() != null) {
                return left * right;
            } else {
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left / right;
            }
        }
        
        throw new RuntimeException("Unknown expression type: " + ctx.getClass().getName());
    }

    public Map<String, Integer> getResults() {
        return results;
    }
}