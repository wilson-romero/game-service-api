package com.wilsonromero.game_service_api.commons.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "games")
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;
}
