package com.wangwei.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpCheckUtility {
    public static String sendGetRequest(String url, String queryString) throws IOException {
        URL urlObj = new URL(url + "?" + queryString);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Host", "zhxy.xhe.cn");
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("userId", "0");
        connection.setRequestProperty("time","1690857320330"); // Setting fixed value for time
        connection.setRequestProperty("digest", "fa0ba21f652ea3adf546307ee37aa17c");
        connection.setRequestProperty("random", "724726"); // Setting fixed value for random
        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.5563.65 Safari/537.36");
        connection.setRequestProperty("Referer", "http://zhxy.xhe.cn/static/pc/login.html");
        connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
        connection.setRequestProperty("Connection", "close");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } else {
            return "Request failed with HTTP error code: " + responseCode;
        }
    }
}
