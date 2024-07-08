package com.wilsonromero.game_service_api.services;

import com.wilsonromero.game_service_api.commons.entities.Game;

public interface IGameService {
    Game createGame(Game game);
    Game getGameById(Long id);
}
