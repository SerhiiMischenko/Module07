import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HttpStatusChecker {

    String getStatusImage(int code) {
        String absolutePath = String.format("https://http.cat/%s.jpg", code);
        try {
            Document document = Jsoup.connect("https://http.cat").get();
            if(document.text().contains(new String(String.valueOf(code)))) {
                return absolutePath;
            }else {
                throw new Exception();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}