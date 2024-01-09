package com.neidev.uolhostbackend.service;

import com.neidev.uolhostbackend.domain.core.player.json.PlayerForm;
import com.neidev.uolhostbackend.domain.core.player.model.Player;
import com.neidev.uolhostbackend.domain.enums.GroupType;
import com.neidev.uolhostbackend.domain.repository.PlayerRepository;
import com.neidev.uolhostbackend.infra.CodenameHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final CodenameHandler codenameHandler;

    public PlayerService(PlayerRepository playerRepository, CodenameHandler codenameHandler) {
        this.playerRepository = playerRepository;
        this.codenameHandler = codenameHandler;
    }

    @Transactional
    public Player createPlayer(PlayerForm data) {
        var playerToPersist = new Player(data);
        playerToPersist.setCodename(getCodename(data.groupType()));
        return playerRepository.save(playerToPersist);
    }

    @Transactional
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    private String getCodename(GroupType groupType) {
        return codenameHandler.findCodename(groupType);
    }

}
