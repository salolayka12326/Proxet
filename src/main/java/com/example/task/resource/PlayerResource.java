package com.example.task.resource;

import com.example.task.domain.Player;
import com.example.task.repository.PlayerRepository;
import com.example.task.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerResource {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;
    private final Logger log = LoggerFactory.getLogger(PlayerResource.class);

    public PlayerResource(PlayerService playerService, PlayerRepository playerRepository) {
        this.playerService = playerService;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/players")
    public Player savePlayer(@RequestParam int time,@RequestParam int type,@RequestParam String name) throws IOException {
        log.debug("Request to save Player");

        return playerService.savePlayer(new Player(name,type,time));
    }
    /**
     * {@code GET  /Players} : get all the players.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of products in body.
     */
    @GetMapping("/players")
    public List<Player> getAllPlayers(Pageable pageable) {
        log.debug("REST request to get all Players");
        List<Player> playerList = playerService.findAll(pageable);

        return playerList;
    }
}
