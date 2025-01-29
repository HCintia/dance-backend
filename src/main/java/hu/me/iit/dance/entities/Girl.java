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
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "g_name")
    private String g_name;

    @Column(name = "g_b_year")
    private String g_b_year;

    @ManyToOne()
    @JoinColumn(name = "girls")
    private DanceGroup danceGroup;

}

