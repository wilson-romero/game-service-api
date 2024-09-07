package com.wilsonromero.game_service_api.services.impl;

import com.wilsonromero.game_service_api.commons.dto.NewGameDTO;
import com.wilsonromero.game_service_api.commons.entities.Game;
import com.wilsonromero.game_service_api.commons.exceptions.GameException;
import com.wilsonromero.game_service_api.commons.mappers.GameMapper;
import com.wilsonromero.game_service_api.commons.utils.SortUtils;
import com.wilsonromero.game_service_api.repositories.GameRepository;
import com.wilsonromero.game_service_api.services.IGameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameServiceImpl implements IGameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameServiceImpl(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    @Override
    public Game createGame(NewGameDTO newGameDTO) {
        Game game = gameMapper.toGame(newGameDTO);
        return gameRepository.save(game);
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND,"Game not found"));
    }

    @Override
    public Page<Game> getGames(int page, int size, String[] sortCriteria) {
        try {
            List<Sort.Order> orders = SortUtils.createSortOrdersFromCriteria(sortCriteria);
            return gameRepository.findAll(PageRequest.of(page, size, Sort.by(orders)));
        } catch (PropertyReferenceException e) {
            throw new GameException(HttpStatus.BAD_REQUEST, "Invalid sort criteria: " + e.getMessage());
        }
    }

    @Override
    public Game updateGame(Long id, NewGameDTO newGameDTO) {
        Game existingGame = getGameById(id);
        existingGame.setName(newGameDTO.getName());
        return gameRepository.save(existingGame);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
