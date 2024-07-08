package com.wilsonromero.game_service_api.services;

import com.wilsonromero.game_service_api.entities.Game;
import com.wilsonromero.game_service_api.repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }
}
