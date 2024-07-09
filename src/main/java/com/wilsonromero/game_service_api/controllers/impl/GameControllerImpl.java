package com.wilsonromero.game_service_api.controllers.impl;

import com.wilsonromero.game_service_api.commons.entities.Game;
import com.wilsonromero.game_service_api.controllers.IGameApi;
import com.wilsonromero.game_service_api.services.IGameService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameControllerImpl implements IGameApi {

    private final IGameService gameService;

    public GameControllerImpl(IGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game newGame = gameService.createGame(game);
        return ResponseEntity.ok(newGame);
    }

    @Override
    public ResponseEntity<Game> getGameById(Long id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Page<Game>> getGames(int page, int size, String[] sort) {
        Page<Game> games = gameService.getGames(page, size, sort);
        return ResponseEntity.ok(games);
    }

    @Override
    public ResponseEntity<Game> updateGame(Long id, Game game) {
        Game updatedGame = gameService.updateGame(id, game);
        return ResponseEntity.ok(updatedGame);
    }
}
