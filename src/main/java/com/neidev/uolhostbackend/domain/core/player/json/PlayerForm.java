package com.neidev.uolhostbackend.domain.core.player.json;

import com.neidev.uolhostbackend.domain.enums.GroupType;

public record PlayerForm(

        String name,
        String email,
        String phoneNumber,
        GroupType groupType
) {

}
