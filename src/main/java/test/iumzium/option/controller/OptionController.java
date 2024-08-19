package test.iumzium.option.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import test.iumzium.option.dto.OptionReqDto;
import test.iumzium.option.dto.OptionUpdateReqDto;
import test.iumzium.option.service.OptionService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/option")
public class OptionController {

    private final OptionService optionService;

    // Option 생성
    @PostMapping("/{menu-id}")
    public ResponseEntity<Long> createOption(
        @PathVariable("menu-id") Long menuId,
        @Validated @RequestBody OptionReqDto optionDto
    ) {
        Long optionId = optionService.createOption(menuId, optionDto);
        return ResponseEntity.ok(optionId);
    }


    // Option 업데이트
    @PutMapping("/{option-id}")
    public ResponseEntity<Long> updateOption(
        @PathVariable("option-id") Long optionId,
        @Validated @RequestBody OptionUpdateReqDto optionDto
    ) {
        Long updatedOptionId = optionService.updateOption(optionId, optionDto);
        return ResponseEntity.ok(updatedOptionId);
    }

    // Option 삭제
    @DeleteMapping("/{option-id}")
    public ResponseEntity<Void> deleteOption(
        @PathVariable("option-id") Long optionId
    ) {
        optionService.deleteOption(optionId);
        return ResponseEntity.ok().build();
    }

}
