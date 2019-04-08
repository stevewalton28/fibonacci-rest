package academy.dd.fibonacci.contracttests;

import academy.dd.fibonacci.jetty.EmbeddedJetty;
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
            Runnable runnable = () -> {
                try {
                    new EmbeddedJetty(7003).start();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Couldn't start embedded jetty server for test");
                }
            };

            new Thread(runnable).start();
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
