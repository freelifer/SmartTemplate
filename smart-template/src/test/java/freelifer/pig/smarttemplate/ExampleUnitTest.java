package freelifer.pig.smarttemplate;

import org.junit.Test;

import freelifer.pig.smarttemplate.inner.lexer.Lexer;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        int a = 2;
        int b = 3;

        assertEquals(MyClass.add(a, b), a - b);
    }

    @Test
    public void lexer_parse() throws Exception {
        new Lexer.Builder().build().parse("a{{b}}{{d}}e{{}}ggg");
    }
}