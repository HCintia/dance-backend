package hu.me.iit.dance.services;

import hu.me.iit.dance.dtos.DanceGroupDto;
import hu.me.iit.dance.entities.DanceGroup;
import hu.me.iit.dance.exceptions.AppException;
import hu.me.iit.dance.mappers.DanceGroupMapper;
import hu.me.iit.dance.repositories.DanceGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DanceGroupService {
    private final DanceGroupRepository danceGroupRepository;
    private final DanceGroupMapper danceGroupMapper;

    public List<DanceGroupDto> getAllDanceGroups() {
        List<DanceGroup> danceGroups = danceGroupRepository.findAll();
        return danceGroupMapper.toDanceGroupDtos(danceGroups);
    }

    public DanceGroupDto getDanceGroup(Long id) {
        DanceGroup danceGroup = danceGroupRepository.findById(id)
                .orElseThrow(() -> new AppException("Dance Group not found", HttpStatus.NOT_FOUND));
        return danceGroupMapper.toDanceGroupDto(danceGroup);
    }

    public DanceGroupDto createDanceGroup(DanceGroupDto danceGroupDto) {
        DanceGroup danceGroup = danceGroupMapper.toDanceGroup(danceGroupDto);
        DanceGroup createDanceGroup = danceGroupRepository.save(danceGroup);
        return danceGroupMapper.toDanceGroupDto(createDanceGroup);
    }

    public DanceGroupDto updateDanceGroup(Long id, DanceGroupDto danceGroupDto) {
        DanceGroup danceGroup = danceGroupMapper.toDanceGroup(danceGroupDto);
        DanceGroup storedDanceGroup = danceGroupRepository.findById(id).orElseThrow(() -> new AppException("Dance Group not found", HttpStatus.NOT_FOUND));
        danceGroup.setId(storedDanceGroup.getId());
        DanceGroup updatedDanceGroup = danceGroupRepository.save(danceGroup);
        return danceGroupMapper.toDanceGroupDto(updatedDanceGroup);
    }

    public void deleteDanceGroup(Long id) {
        danceGroupRepository.deleteById(id);
    }

    public void deleteAll() {
        danceGroupRepository.deleteAll();
    }
}
