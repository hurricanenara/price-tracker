package com.sparta.week04.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "rY_p3zqWgwMOmMdWudXs");
        headers.add("X-Naver-Client-Secret", "KaN0S_DKb4");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("iMac");
        JSONObject rjson = new JSONObject(result); // use after adding json to dependencies
        JSONArray items = rjson.getJSONArray("items"); // get items out of JS Array
        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
//            System.out.println(itemJson);
            // get info out of json item
            String title = itemJson.getString("title");
            String image = itemJson.getString("image");
            int lprice = itemJson.getInt("lprice");
            String link = itemJson.getString("link");
//            System.out.println(lprice);
        }


    }
}
