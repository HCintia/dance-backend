package hu.me.iit.dance.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Boy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "b_name")
    private String b_name;

    @Column(name = "b_b_year")
    private String b_b_year;

    @ManyToOne()
    @JoinColumn(name = "boys")
    private DanceGroup danceGroup;

}
