package test.iumzium.menu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Transactional
    public String getImageAsBase64(String imageName) throws IOException {
        Resource resource = new ClassPathResource("static/images/" + imageName);
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    }

}
