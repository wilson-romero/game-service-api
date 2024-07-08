package com.wilsonromero.game_service_api.services.impl;

import com.wilsonromero.game_service_api.commons.entities.Game;
import com.wilsonromero.game_service_api.repositories.GameRepository;
import com.wilsonromero.game_service_api.services.IGameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements IGameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }
}
