package hu.me.iit.dance.mappers;

import hu.me.iit.dance.dtos.GirlDto;
import hu.me.iit.dance.entities.Girl;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GirlsMapper {
    Girl toGirl(GirlDto girlDto);
    GirlDto toGirlDto(Girl girl);
    List<GirlDto> toGirlDtos(List<Girl> girls);


}
