package testAPI;

import com.fasterxml.jackson.core.JsonParser;
import com.squareup.okhttp.Request;
import io.restassured.RestAssured;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class testAPI {


    @Test
    public void  firtsTest() throws IOException {

        HttpUriRequest request = new HttpGet( "http://KWW8SVJ68F72JYU2JHS9ELTL6BNI2K98@my-prestashop/api/?output_format=JSON");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        //System.out.println(httpResponse);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    public  void getShopingGroup() throws IOException {

    }

}
