package hu.me.iit.dance.mappers;

import hu.me.iit.dance.dtos.DanceGroupDto;
import hu.me.iit.dance.entities.DanceGroup;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface DanceGroupMapper {
    DanceGroup toDanceGroup(DanceGroupDto danceGroupDto);
    DanceGroupDto toDanceGroupDto(DanceGroup danceGroup);
    List<DanceGroupDto> toDanceGroupDtos(List<DanceGroup> danceGroups);
}
