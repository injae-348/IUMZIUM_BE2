package test.iumzium.Rasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

@Service
public class RasaService {

    @Autowired
    private RestTemplate restTemplate;

    private final String rasaUrl = "https://d83b-124-53-16-60.ngrok-free.app/webhooks/rest/webhook";

    public String sendMessageToRasa(String userMessage) {
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // 요청 본문 설정
        String payload = String.format("{\"sender\":\"user\",\"message\":\"%s\"}", userMessage);

        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        // POST 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(rasaUrl, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody(); // 챗봇의 응답을 반환
        } else {
            throw new RuntimeException("Failed to connect to the bot. Status code: " + response.getStatusCodeValue());
        }
    }
}