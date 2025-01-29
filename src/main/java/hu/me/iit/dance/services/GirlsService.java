package hu.me.iit.dance.services;

import hu.me.iit.dance.dtos.GirlDto;
import hu.me.iit.dance.entities.Girl;
import hu.me.iit.dance.exceptions.AppException;
import hu.me.iit.dance.mappers.GirlsMapper;
import hu.me.iit.dance.repositories.GirlsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GirlsService {

    private final GirlsRepository girlsRepository;
    private final GirlsMapper mapper;

    public List<GirlDto> allGirls() {
        List<Girl> all = girlsRepository.findAll();
        return mapper.toGirlDtos(all);
    }

    public GirlDto getGirl(Long id) {

        Girl girl = girlsRepository.findById(id)
                .orElseThrow(() -> new AppException("Girl not found", HttpStatus.NOT_FOUND));
        return mapper.toGirlDto(girl);
    }

    public GirlDto createGirl(GirlDto girlDto) {
        Girl girl = mapper.toGirl(girlDto);
        Girl createdGirl = girlsRepository.save(girl);
        return mapper.toGirlDto(createdGirl);
    }

    public GirlDto updateGirl(Long id, GirlDto girlDto) {
        Girl girl = mapper.toGirl(girlDto);
        Girl storedGirl = girlsRepository.findById(id).orElseThrow( () -> new AppException("Girl not found", HttpStatus.NOT_FOUND));
        girl.setId(storedGirl.getId());
        Girl updatedGirl = girlsRepository.save(girl);
        return mapper.toGirlDto(updatedGirl);
    }


    public void deleteGirl(Long id) {
        girlsRepository.deleteById(id);
    }

    public void deleteAll() {
        girlsRepository.deleteAll();
    }
}
