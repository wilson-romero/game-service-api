package com.wilsonromero.game_service_api.controllers;

import com.wilsonromero.game_service_api.commons.constans.ApiPathVariables;
import com.wilsonromero.game_service_api.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAMES_ROUTE)
public interface IGameApi {
    @PostMapping
    ResponseEntity<Game> createGame(@RequestBody Game game);

    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable Long id);
}
