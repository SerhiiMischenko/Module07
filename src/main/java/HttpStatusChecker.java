import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class HttpStatusChecker {

    String getStatusImage(int code) {
        String absolutePath = String.format("https://http.cat/%s.jpg", code);
        try {
            Document document = Jsoup.connect("https://http.cat").get();
            if(document.text().contains(String.valueOf(code))) {
                return absolutePath;
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}