package com.neidev.uolhostbackend.service;

import com.neidev.uolhostbackend.domain.core.player.json.PlayerForm;
import com.neidev.uolhostbackend.domain.core.player.model.Player;
import com.neidev.uolhostbackend.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player createPlayer(PlayerForm data) {
        var playerToPersist = new Player(data);
        return playerRepository.save(playerToPersist);

    }

}
