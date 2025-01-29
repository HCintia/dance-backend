package hu.me.iit.dance.mappers;

import hu.me.iit.dance.dtos.BoyDto;
import hu.me.iit.dance.entities.Boy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoysMapper {
    Boy toBoy(BoyDto boyDto);
    BoyDto toBoyDto(Boy boy);
    List<BoyDto> toBoyDtos(List<Boy> boys);
}
