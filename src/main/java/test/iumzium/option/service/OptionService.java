package test.iumzium.option.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.iumzium.menu.domain.Menu;
import test.iumzium.option.domain.Option;
import test.iumzium.option.dto.OptionReqDto;
import test.iumzium.option.dto.OptionUpdateReqDto;
import test.iumzium.menu.repository.MenuRepository;
import test.iumzium.option.repository.OptionRepository;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final MenuRepository menuRepository;
    private final OptionRepository optionRepository;

    // Option 생성
    @Transactional
    public Long createOption(Long menuId, OptionReqDto optionDto) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 메뉴가 존재하지 않습니다."));

        Option option = optionDto.toEntity(menu);

        return optionRepository.save(option).getId();
    }

    // Option 업데이트
    @Transactional
    public Long updateOption(Long optionId, OptionUpdateReqDto optionDto) {
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 옵션이 존재하지 않습니다."));
        option.update(optionDto.quantity(), optionDto.isHot(), optionDto.size(), optionDto.syrup(), optionDto.totalOptionPrice());
        return option.getId();
    }

    // Option 삭제
    @Transactional
    public void deleteOption(Long optionId) {
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 옵션이 존재하지 않습니다."));

        optionRepository.deleteById(optionId);
    }


}
