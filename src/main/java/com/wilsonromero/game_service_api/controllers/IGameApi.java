package com.wilsonromero.game_service_api.controllers;

import com.wilsonromero.game_service_api.commons.constans.ApiPathVariables;
import com.wilsonromero.game_service_api.commons.entities.Game;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAMES_ROUTE)
public interface IGameApi {
    @PostMapping
    ResponseEntity<Game> createGame(@RequestBody Game game);

    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Page<Game>> getGames(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size,
            @Parameter(description = "Sorting criteria in the format: property:(asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")
            @RequestParam(name = "sort", required = false) String[] sort
    );
}
