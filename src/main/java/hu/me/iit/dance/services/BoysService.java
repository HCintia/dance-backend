package hu.me.iit.dance.services;

import hu.me.iit.dance.dtos.BoyDto;
import hu.me.iit.dance.entities.Boy;
import hu.me.iit.dance.exceptions.AppException;
import hu.me.iit.dance.mappers.BoysMapper;
import hu.me.iit.dance.repositories.BoysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoysService {

    private final BoysRepository boysRepository;
    private final BoysMapper mapper;

    public List<BoyDto> allBoys() {
        List<Boy> all = boysRepository.findAll();
        return mapper.toBoyDtos(all);
    }

    public BoyDto getBoy(Long id) {
        Boy boy = boysRepository.findById(id)
                .orElseThrow(() -> new AppException("Boy not found", HttpStatus.NOT_FOUND));
        return mapper.toBoyDto(boy);
    }

    public BoyDto createBoy(BoyDto boyDto) {
        Boy boy = mapper.toBoy(boyDto);
        Boy createdBoy = boysRepository.save(boy);
        return mapper.toBoyDto(createdBoy);
    }

    public BoyDto updateBoy(Long id, BoyDto boyDto) {
        Boy boy = mapper.toBoy(boyDto);
        Boy storedBoy = boysRepository.findById(id).orElseThrow( () -> new AppException("Boy not found", HttpStatus.NOT_FOUND));
        boy.setId(storedBoy.getId());
        Boy updatedBoy = boysRepository.save(boy);
        return mapper.toBoyDto(updatedBoy);
    }

    public void deleteBoy(Long id) {
        boysRepository.deleteById(id);
    }

    public void deleteAll() {
        boysRepository.deleteAll();
    }
}
