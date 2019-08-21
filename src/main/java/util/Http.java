package util;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class Http {
    public static void main(String[] args) throws Exception {
        Http http = new Http();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc65254be8b92d145&secret=8800d9da40266baa0c70f3b5de62ad9a&js_code=021ZdA4Z0DbXIU14JG3Z0JmI4Z0ZdA44&grant_type=authorization_code";
//        String url = "http://106.52.174.160:9090/comment/";
        String res = http.get(url);
        JSONObject b = new JSONObject(res);
        Object errcode = b.get("errcode");
        System.out.println(errcode);

    }

    public static String get(String url) {

        final HttpClientResponseHandler<String> responseHandler = new HttpClientResponseHandler<String>() {
            @Override
            public String handleResponse(
                    final ClassicHttpResponse response) throws IOException, ParseException {
                final int status = response.getCode();
                if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION) {
                    final HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String response1 = null;
        try {
            response1 = httpclient.execute(httpGet, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------");
        System.out.println(response1);
        return response1;
    }

}
