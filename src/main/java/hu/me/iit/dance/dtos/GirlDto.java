package hu.me.iit.dance.dtos;

import hu.me.iit.dance.entities.DanceGroup;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class GirlDto {
    private Long id;
    @NotNull
    private String g_name;
    @NotNull
    private String g_b_year;
    private DanceGroup DanceGroup;

}
