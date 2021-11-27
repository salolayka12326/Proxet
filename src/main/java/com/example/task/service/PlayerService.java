package com.example.task.service;

import com.example.task.domain.Player;
import com.example.task.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    private final Logger log = LoggerFactory.getLogger(PlayerService.class);
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Player savePlayer(Player player) {
        log.debug("Request to save Player");

        return playerRepository.save(player);
    }

    /**
     * Get all the players.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Player> findAll() {
        log.debug("Request to get all Players");
        return playerRepository.findAllPlayersOrderedById();
    }
}
