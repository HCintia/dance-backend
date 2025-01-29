package hu.me.iit.dance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class DanceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "danceGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Boy> boys;

    @OneToMany(mappedBy = "danceGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Girl> girls;

}
