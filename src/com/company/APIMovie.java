package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class APIMovie {
    // 네이버 API 키값
    String clientId = "API ID";
    String clientSecret = "API PW";

    URL url;
    String apiURL;
    String title;
    String inputLine;


    public String getinfo(String title, String type) {
        StringBuffer response = new StringBuffer();

        try {
            // 영화 제목을 UTF-8형식으로 인코딩
            String text = URLEncoder.encode(title, "UTF-8");

            // 오픈API를 이용하기 위한 URL
            apiURL = "https://openapi.naver.com/v1/search/movie?query=" + text + "&yearfrom=1950&yearto=2017";
            url = new URL(apiURL);

            // URL연결
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // 정보를 얻어올 수 있는 GET메소드
            con.setRequestMethod("GET");

            // 연결을 위한 키 아이디와 비밀번호
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            BufferedReader br;

            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            // 원하는 정보를 모두 받아온다. 하지만 가장 최신의 하나것만 사용하기 때문에 break;를 사용
            while ((inputLine = br.readLine()) != null) {
                if (inputLine.contains(type)) {
                    String arr[] = new String[5];
                    arr = inputLine.split("\"", 5);
                    response.append(arr[3] + "\n");
                    break;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return response.toString();
    }
}

