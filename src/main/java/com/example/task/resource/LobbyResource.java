package com.example.task.resource;

import com.example.task.domain.Lobby;
import com.example.task.domain.Player;
import com.example.task.service.LobbyService;
import com.example.task.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LobbyResource {

    private final PlayerResource playerResource;
    private final PlayerService playerService;
    private final LobbyService lobbyService = new LobbyService();
    private final Logger log = LoggerFactory.getLogger(PlayerResource.class);

    public LobbyResource(PlayerResource playerResource, PlayerService playerService) {
        this.playerResource = playerResource;
        this.playerService = playerService;
    }

    @GetMapping("/lobby")
    public Lobby createLobby(Pageable pageable) {
        log.debug("REST request to show lobby");
        Lobby lobby=lobbyService.generateTeams(playerResource.getAllPlayers(pageable));
        return lobby;
    }

    @GetMapping("/delete_from_lobby")
    public Lobby deleteFromLobby(Lobby lobby, @RequestParam String name,Pageable pageable)
    {
        Lobby res=lobbyService.generateTeams(playerResource.getAllPlayers(pageable));
        res.deleteFromLobby(name);


        return res;
    }

    @GetMapping("/add_to_lobby")
    public Lobby addToLobby(Lobby lobby, @RequestParam String name,@RequestParam int id,@RequestParam int time,@RequestParam int type,@RequestParam int num,Pageable pageable)
    {
        Lobby res=lobbyService.generateTeams(playerResource.getAllPlayers(pageable));
        Player player=new Player(name,type,time);
        player.setId(777L);
        res.addToLobby(player,num);


        return res;
    }
}
