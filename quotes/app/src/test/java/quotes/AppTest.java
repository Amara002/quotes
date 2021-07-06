/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    public void contructorQuote (){
        Quotes quote = new Quotes(null,"Author","likes","text");
        assertEquals(null, quote.getTags());
        assertEquals("Author", quote.getAuthor());
        assertEquals("likes", quote.getLikes());
        assertEquals("text", quote.getText());
    }
    @Test
    public void testJsonReader() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\LTUC\\Desktop\\401asac\\quotes\\quotes\\app\\src\\main\\java\\quotes\\recentquotes.json"));
        assertNotNull(
                " Reader return: ",
                String.valueOf(reader)
        );
    }

    @RepeatedTest(100)
    public void testFunctionality() throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\LTUC\\Desktop\\401asac\\quotes\\quotes\\app\\src\\main\\java\\quotes\\recentquotes.json"));
        List<Quotes> quotes = gson.fromJson(reader, new TypeToken<List<Quotes>>() {}.getType());
        int min =0;
        int max = 137;
         Quotes quote = quotes.get((int) (Math.random()*(max-min+1)+min));
        int index = 0;
        for (int i = 0; i < quotes.size() ; i++) {
            if(quotes.get(i).getText().equals(quote.getText())){
                index = i;
            }
        }
    assertTrue(index >= 0 && index < 138 , "return true if got a random quote from the json file ");    }
}