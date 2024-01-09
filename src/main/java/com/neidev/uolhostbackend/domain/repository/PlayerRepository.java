package com.neidev.uolhostbackend.domain.repository;

import com.neidev.uolhostbackend.domain.core.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
}
