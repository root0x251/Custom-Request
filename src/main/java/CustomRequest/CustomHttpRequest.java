package CustomRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Vyacheslav Alekseevich
 * 06/12/2019
 */

public abstract class CustomHttpRequest {

    private StringBuilder urlString = new StringBuilder();
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    protected abstract void postRequest();

    public void getRequest(String URL, Map<String, String> keyValueRequestParam) throws IOException {
        urlString.append(URL).append("?");

        keyValueRequestParam.forEach((key, value) -> {
            String newValue;
            if (value.contains(" ")) {
                newValue = value.replace(" ", "+");
            } else {
                newValue = value;
            }
            urlString.append(key).append("=").append(newValue).append("&");

        });

        if (urlString.toString().charAt(urlString.length() - 1) == '&') {
            urlString.replace(urlString.length() - 1, urlString.length(), "");
        }

        try {
            HttpGet request = new HttpGet(String.valueOf(urlString));
            System.out.println(request.toString());
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println(EntityUtils.toString(entity));
                }
            }
        } finally {
            urlString.replace(0, urlString.length(), "");
            keyValueRequestParam.clear();
            httpClient.close();
        }

    }


}
