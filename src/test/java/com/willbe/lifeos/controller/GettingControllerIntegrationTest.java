package com.willbe.lifeos.controller;

import com.willbe.lifeos.LifeOS;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Creation date: 10/14/15
 *
 * @author Vitalii Siryi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LifeOS.class)
@WebIntegrationTest({"server.port=8081", "management.port=0"})
public class GettingControllerIntegrationTest {

    public static final int FIVE_MINUTE = 5 * 60 * 1000;
    public static final String OS_X_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) " +
            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.104 Safari/537.36";

    protected String doCall(String url) throws IOException {

        Connection connection = Jsoup.connect(url)
                .userAgent(OS_X_USER_AGENT)
                .ignoreContentType(true)
                .timeout(FIVE_MINUTE)
                .followRedirects(false);

        Connection.Response response = connection.execute();
        assertThat(response.statusCode(), is(equalTo(200)));
        return response.body();
    }

    @Test
    public void testHello() throws Exception {
        String responce = doCall("http://localhost:8081/rest/darling");
        assertThat(responce, containsString("Hello, darling!"));
    }

}
