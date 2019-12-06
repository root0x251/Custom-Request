import CustomRequest.CustomHttpRequest;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Vyacheslav Alekseevich
 * 06/12/2019
 */

public class Main extends CustomHttpRequest {

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        Map<String, String> requestMap = new TreeMap<>();

        String url = "https://translate.yandex.net/api/v1.5/tr.json/translate";
        requestMap.put("key", "trnsl.1.1.20191205T080823Z.bb65c6959adee4c4.a52d173186b595d60cb30c4222c79fef09d6c904");
        requestMap.put("lang", "ru");
        requestMap.put("text", "hello world");
        main.getRequest(url, requestMap);

    }

    @Override
    protected void postRequest() {

    }
}
