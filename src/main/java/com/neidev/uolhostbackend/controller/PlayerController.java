package com.neidev.uolhostbackend.controller;

import com.neidev.uolhostbackend.domain.core.player.json.PlayerForm;
import com.neidev.uolhostbackend.domain.core.player.model.Player;
import com.neidev.uolhostbackend.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerForm data) {
        Player newPlayer = playerService.createPlayer(data);
        return ResponseEntity.ok(newPlayer);
    }
}
