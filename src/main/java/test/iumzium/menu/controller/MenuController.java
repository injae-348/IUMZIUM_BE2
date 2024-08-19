package test.iumzium.menu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.iumzium.menu.domain.Category;
import test.iumzium.menu.dto.MenuResDto;
import test.iumzium.menu.service.MenuService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping // 메뉴 리스트
    public ResponseEntity<List<MenuResDto>> getMenus(
            @RequestParam(value = "category", required = false) Category category
    ) {
        List<MenuResDto> menus = menuService.getMenusByCategory(category);
        return ResponseEntity.ok(menus);
    }

    // 메뉴 상세
    @GetMapping("/{id}")
    public ResponseEntity<MenuResDto> getMenu(
            @PathVariable Long id
    ) {
        MenuResDto menu = menuService.getMenuById(id);
        return ResponseEntity.ok(menu);
    }



}
