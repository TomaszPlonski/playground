package com.tplonski.repository;

import com.tplonski.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {
    long countByFirstPlayerAndIsFirstPlayerAWinnerTrueOrSecondPlayerAndIsFirstPlayerAWinnerFalse(String firstPlayer, String secondPlayer);

    @Query(value = "select distinct first_player as players from games union distinct select second_player as player from games",
            nativeQuery = true)
    List<String> findAllDistinctPlayers();

}
