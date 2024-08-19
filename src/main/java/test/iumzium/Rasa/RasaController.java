package test.iumzium.Rasa;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rasa")
public class RasaController {

    private final RasaService rasaService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String userMessage) {
        try {
            // RasaService를 호출하여 챗봇에 메시지를 전송하고 응답을 받음
            String botResponse = rasaService.sendMessageToRasa(userMessage);
            return ResponseEntity.ok(botResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Failed to connect to the bot.");
        }
    }

}
