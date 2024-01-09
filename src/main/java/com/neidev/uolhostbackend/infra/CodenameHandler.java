package com.neidev.uolhostbackend.infra;

import com.neidev.uolhostbackend.domain.enums.GroupType;
import com.neidev.uolhostbackend.service.CodenameService;
import org.springframework.stereotype.Component;

@Component
public class CodenameHandler {

    private final CodenameService codenameService;

    public CodenameHandler(CodenameService codenameService) {
        this.codenameService = codenameService;
    }

    public String findCodename(GroupType groupType) {
        if(groupType == GroupType.AVENGERS) {
            String firstMatch = codenameService
                    .getAvengersCodenameList()
                    .stream().findFirst().orElseThrow();
            // removing first codename (codename rep no allowed)
            this.codenameService.getAvengersCodenameList().remove(firstMatch);
            return firstMatch;
        }
        String firstMatch = codenameService.getJusticeLeagueCodenameList()
                .stream().findFirst().orElseThrow();
        this.codenameService.getJusticeLeagueCodenameList().remove(firstMatch);
        return firstMatch;
    }

}
