import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {

    void askStatus() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter HTTP status code");
        try {
            int userCode = Integer.parseInt(bufferedReader.readLine());
            Document document = Jsoup.connect("https://http.cat").get();
            if(document.text().contains(String.valueOf(userCode))) {
                HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
                httpStatusImageDownloader.downloadStatusImage(userCode);
            }else {
                System.out.println("There is not image for HTTP status " + userCode);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
