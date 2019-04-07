package academy.dd.fibonacci.contracttests;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContractTests {

    @Before
    public void setUp() {
        if(null == System.getenv("serviceUrl")) {
            RestAssured.baseURI = "http://localhost:7003";
        } else {
            RestAssured.baseURI = System.getenv("serviceUrl");
        }
    }

    @Test
    public void testServiceAvailable() {
        String responseBody = get("/fib").getBody().print();
        assertThat("Response was unexpected", responseBody,
                is("[\"0\",\"1\",\"1\",\"2\",\"3\",\"5\",\"8\",\"13\",\"21\",\"34\"]"));
    }
}
