package hu.me.iit.dance.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class DanceGroupDto {
    private Long id;
    @NotNull
    private String name;

    private List<GirlDto> girls;
    private List<BoyDto> boys;
}
