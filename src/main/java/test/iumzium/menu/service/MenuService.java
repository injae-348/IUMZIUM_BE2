package test.iumzium.menu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.iumzium.menu.domain.Category;
import test.iumzium.menu.domain.Menu;
import test.iumzium.menu.dto.MenuResDto;
import test.iumzium.menu.repository.MenuRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final ImageService imageService;

    @Transactional(readOnly = true)
    public List<MenuResDto> getMenusByCategory(Category category) {
        return menuRepository.findAll().stream()
                .filter(menu -> menu.getCategory().equals(category))
                .map(menu -> {
                    try {
                        String imageData = imageService.getImageAsBase64(menu.getImageName());
                        return MenuResDto.of(menu.getName(), menu.getPrice(), menu.getCategory(), imageData);
                    } catch (IOException e) {
                        throw new RuntimeException("이미지를 불러오는데 실패했습니다.", e);
                    }
                })
                .toList(); // 불변
    }

    @Transactional(readOnly = true)
    public MenuResDto getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 메뉴가 존재하지 않습니다."));
        try {
            String imageData = imageService.getImageAsBase64(menu.getImageName());
            return MenuResDto.of(menu.getName(), menu.getPrice(), menu.getCategory(), imageData);
        } catch (IOException e) {
            throw new RuntimeException("이미지를 불러오는데 실패했습니다.", e);
        }
    }

}
