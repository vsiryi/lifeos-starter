package com.willbe.lifeos.controller;

import com.willbe.lifeos.TestWebServer;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Creation date: 10/14/15
 *
 * @author Vitalii Siryi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestWebServer.class)
@WebIntegrationTest({"server.port=8080", "management.port=0"})
public class ThirdPartyControllerTest {

    public static final int FIVE_MINUTE = 5 * 60 * 1000;
    public static final String OS_X_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) " +
            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.104 Safari/537.36";

    protected boolean doCall(String url) throws IOException {

        Connection connection = Jsoup.connect(url)
                .userAgent(OS_X_USER_AGENT)
                .ignoreContentType(true)
                .timeout(FIVE_MINUTE)
                .followRedirects(false);

        Connection.Response response = connection.execute();
        assertThat(response.statusCode(), is(equalTo(200)));
        return true;
    }

    @Test
    public void testThirdPartyCall() throws Exception {
        doCall("http://localhost:8080/api/fake");
    }

    @Test(expected = HttpStatusException.class)
    public void testNotExistingThirdPartyCall() throws Exception {
        doCall("http://localhost:8080/api/notexisting");
    }

}
