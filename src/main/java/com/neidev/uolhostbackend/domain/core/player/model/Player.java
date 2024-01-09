package com.neidev.uolhostbackend.domain.core.player.model;

import com.neidev.uolhostbackend.domain.core.player.json.PlayerForm;
import com.neidev.uolhostbackend.enums.GroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "PLAYER")
@Table(name = "TB_PLAYER")
@EqualsAndHashCode(of = "id")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String phoneNumber;
    private String codename;
    private GroupType groupType;

    public Player(PlayerForm form) {
        this.name = form.name();
        this.email = form.email();
        this.phoneNumber = form.phoneNumber();
        this.groupType = form.groupType();
    }
}
