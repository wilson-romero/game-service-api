package com.wilsonromero.game_service_api.repositories;

import com.wilsonromero.game_service_api.commons.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>{
}
