package academy.dd.fibonacci.json;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonUtilsTests {

    private String expectedResult;

    @Before
    public void setUp() throws IOException {
        InputStream fixtureStream = JsonUtilsTests.class.getClassLoader().getResourceAsStream("fixtures/sample-json.json");
        StringWriter writer = new StringWriter();
        IOUtils.copy(fixtureStream , writer, "UTF-8");
        expectedResult = writer.toString();
    }

    @Test
    public void testThatCanConvertObjectToJsonString() throws IOException {
        Map<String, String> sampleObject  = new HashMap();
        sampleObject.put("id", "9a4b170d-9445-448d-bd20-7f741ddea957");
        sampleObject.put("name", "Steve Walton");
        String actualResult = JsonUtils.toString(sampleObject);
        assertThat("Can't convert an object to a json", actualResult, is(expectedResult));
    }
}
