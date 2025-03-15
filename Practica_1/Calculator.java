import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Calculator {
    public static void main(String[] args) throws IOException {
        // Si se proporciona un archivo, léelo; de lo contrario, usa un ejemplo
        CharStream input;
        if (args.length > 0) {
            input = CharStreams.fromFileName(args[0]);
        } else {
            // Ejemplo predeterminado
            input = CharStreams.fromString(
                "a = 10;\n" +
                "b = 5 + a * 2;\n" +
                "c = (b - 3) / 2;"
            );
        }

        // Crear lexer
        CalculatorLexer lexer = new CalculatorLexer(input);
        
        // Obtener tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Mostrar tokens generados
        System.out.println("TOKENS GENERADOS:");
        tokens.fill();
        for (Token token : tokens.getTokens()) {
            System.out.println(token.getType() + " : " + token.getText());
        }
        tokens.seek(0); // Reset the token stream
        
        // Crear parser
        CalculatorParser parser = new CalculatorParser(tokens);
        
        // Construir árbol de análisis sintáctico
        ParseTree tree = parser.program();
        
        // Mostrar el árbol
        System.out.println("\nÁRBOL DE ANÁLISIS SINTÁCTICO:");
        System.out.println(tree.toStringTree(parser));
        
        // Evaluar las expresiones
        ParseTreeWalker walker = new ParseTreeWalker();
        CalculatorEvaluator evaluator = new CalculatorEvaluator();
        walker.walk(evaluator, tree);
        
        // Mostrar resultados
        System.out.println("\nRESULTADOS:");
        evaluator.getResults().forEach((key, value) -> 
            System.out.println(key + " = " + value));
    }
}