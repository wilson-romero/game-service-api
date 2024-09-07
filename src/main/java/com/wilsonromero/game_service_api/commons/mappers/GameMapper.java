package com.wilsonromero.game_service_api.commons.mappers;

import com.wilsonromero.game_service_api.commons.dto.NewGameDTO;
import com.wilsonromero.game_service_api.commons.entities.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    NewGameDTO toNewGameDTO(Game game);
    Game toGame(NewGameDTO newGameDTO);
}
