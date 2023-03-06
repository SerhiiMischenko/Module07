import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        try {
            String fileName = String.format("%s.jpg", code);
            String website = httpStatusChecker.getStatusImage(code);

            System.out.println("Downloading File From: " + website);

            URL url = new URL(website);
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(fileName);
            byte[] buffer = new byte[2048];

            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                System.out.println("Buffer Read of length: " + length);
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}