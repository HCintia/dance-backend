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
public class BoyDto {
    private Long id;
    @NotNull
    private String b_name;
    @NotNull
    private String b_b_year;
    private DanceGroup danceGroup;
}
