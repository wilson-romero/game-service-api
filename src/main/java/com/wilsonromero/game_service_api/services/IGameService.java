package com.wilsonromero.game_service_api.services;

import com.wilsonromero.game_service_api.commons.entities.Game;
import org.springframework.data.domain.Page;


public interface IGameService {
    Game createGame(Game game);
    Game getGameById(Long id);
    Page<Game> getGames(int page, int size, String[] sort);
    Game updateGame(Long id, Game game);
}
