package com.neidev.uolhostbackend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CodenameService {

    ObjectMapper objectMapper = new ObjectMapper();

    private final RestTemplate restTemplate;
    private final Environment environment;

    private List<String> avengersCodenameList = new ArrayList<>();
    private List<String> justiceLeagueCodenameList = new ArrayList<>();

    public CodenameService(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    /**
     * @PostConstruct annotation indicates that loadJsonData()
     * will be initialized every time application runs.
     *
     * loadJsonData() will BOT be called after that.
     */
    @PostConstruct
    public void loadJsonData() {
        try {
            String codenameResponse =
                    restTemplate.getForObject
                            (environment.getProperty("avengers"), String.class);

            // mapping json node and reading codenameResponse
            JsonNode jsonNode = objectMapper.readTree(codenameResponse);
            // initiating one array of nodes containg each node (codinome)
            ArrayNode avengers = (ArrayNode) jsonNode.get("vingadores");
            // mapping each node to String and populating avengersCodenameList
            for(JsonNode node: avengers) {
                this.avengersCodenameList.add(node.get("codinome").asText());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData() {
        try {
            // getting an instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // initialing builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // access the xml
            Document document = builder.parse(environment.getProperty("justice.league"));

            // instance containing each value tagged by "codiname"
            NodeList codenameList = document.getElementsByTagName("codiname");
            // populating list
            for(int i = 0; i < codenameList.getLength(); i++) {
                Element codenameElement = (Element) codenameList.item(i);
                String codename = codenameElement.getTextContent();
                this.justiceLeagueCodenameList.add(codename);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
