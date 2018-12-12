package expression.parser;

import expression.exceptions.EvaluateException;
import expression.TripleExpression;
import expression.exceptions.ParsingException;

import java.sql.SQLOutput;

/**
 * Created by Nikolay Yarlychenko on 05/12/2018
 */
public class MyTest {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        int x = 5;
        try {
            String s = "log2 1601364467";
            try {
                System.out.println(parser.parse(s).evaluate(5, 1, 1));
            } catch (EvaluateException | ParsingException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            System.out.println("Not integer number");
        }

    }
}

