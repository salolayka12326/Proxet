package com.example.task.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class LobbyResourceTest {


    @Autowired
    private MockMvc restGeometryMockMvc;

    @Test
    public void createLobby() throws Exception {
        restGeometryMockMvc.perform(get("/api/lobby").param("page", "0"))
                .andExpect(content().json("{\"firstTeam\":[{\"id\":8,\"nickname\":\"Oleg2\",\"vehicleType\":1,\"waitingTime\":123},{\"id\":10,\"nickname\":\"Oleg4\",\"vehicleType\":1,\"waitingTime\":125},{\"id\":12,\"nickname\":\"Oleg6\",\"vehicleType\":1,\"waitingTime\":54},{\"id\":15,\"nickname\":\"Oleg9\",\"vehicleType\":2,\"waitingTime\":32},{\"id\":17,\"nickname\":\"Oleg11\",\"vehicleType\":2,\"waitingTime\":155},{\"id\":19,\"nickname\":\"Oleg13\",\"vehicleType\":2,\"waitingTime\":11},{\"id\":22,\"nickname\":\"Oleg16\",\"vehicleType\":3,\"waitingTime\":123},{\"id\":24,\"nickname\":\"Oleg18\",\"vehicleType\":3,\"waitingTime\":1225},{\"id\":26,\"nickname\":\"Oleg20\",\"vehicleType\":3,\"waitingTime\":15}],\"secondTeam\":[{\"id\":9,\"nickname\":\"Oleg3\",\"vehicleType\":1,\"waitingTime\":124},{\"id\":11,\"nickname\":\"Oleg5\",\"vehicleType\":1,\"waitingTime\":23},{\"id\":13,\"nickname\":\"Oleg7\",\"vehicleType\":1,\"waitingTime\":222},{\"id\":16,\"nickname\":\"Oleg10\",\"vehicleType\":2,\"waitingTime\":123},{\"id\":18,\"nickname\":\"Oleg12\",\"vehicleType\":2,\"waitingTime\":152},{\"id\":14,\"nickname\":\"Oleg8\",\"vehicleType\":2,\"waitingTime\":222},{\"id\":23,\"nickname\":\"Oleg17\",\"vehicleType\":3,\"waitingTime\":122},{\"id\":25,\"nickname\":\"Oleg19\",\"vehicleType\":3,\"waitingTime\":155},{\"id\":27,\"nickname\":\"Oleg21\",\"vehicleType\":3,\"waitingTime\":15}]}"));
    }


    @Test
    void deleteFromLobby() throws Exception {
        restGeometryMockMvc.perform(get("/api/delete_from_lobby").param("page", "0").param("name", "Oleg4"))
                .andExpect(content().json("{\"firstTeam\":[{\"id\":8,\"nickname\":\"Oleg2\",\"vehicleType\":1,\"waitingTime\":123},{\"id\":12,\"nickname\":\"Oleg6\",\"vehicleType\":1,\"waitingTime\":54},{\"id\":15,\"nickname\":\"Oleg9\",\"vehicleType\":2,\"waitingTime\":32},{\"id\":17,\"nickname\":\"Oleg11\",\"vehicleType\":2,\"waitingTime\":155},{\"id\":19,\"nickname\":\"Oleg13\",\"vehicleType\":2,\"waitingTime\":11},{\"id\":22,\"nickname\":\"Oleg16\",\"vehicleType\":3,\"waitingTime\":123},{\"id\":24,\"nickname\":\"Oleg18\",\"vehicleType\":3,\"waitingTime\":1225},{\"id\":26,\"nickname\":\"Oleg20\",\"vehicleType\":3,\"waitingTime\":15}],\"secondTeam\":[{\"id\":9,\"nickname\":\"Oleg3\",\"vehicleType\":1,\"waitingTime\":124},{\"id\":11,\"nickname\":\"Oleg5\",\"vehicleType\":1,\"waitingTime\":23},{\"id\":13,\"nickname\":\"Oleg7\",\"vehicleType\":1,\"waitingTime\":222},{\"id\":16,\"nickname\":\"Oleg10\",\"vehicleType\":2,\"waitingTime\":123},{\"id\":18,\"nickname\":\"Oleg12\",\"vehicleType\":2,\"waitingTime\":152},{\"id\":14,\"nickname\":\"Oleg8\",\"vehicleType\":2,\"waitingTime\":222},{\"id\":23,\"nickname\":\"Oleg17\",\"vehicleType\":3,\"waitingTime\":122},{\"id\":25,\"nickname\":\"Oleg19\",\"vehicleType\":3,\"waitingTime\":155},{\"id\":27,\"nickname\":\"Oleg21\",\"vehicleType\":3,\"waitingTime\":15}]}"));
    }


    @Test
    void addToLobby() throws Exception {
        restGeometryMockMvc.perform(get("/api/add_to_lobby").param("page", "0").param("name", "OlegCOON").param("time", "1111").param("type", "3").param("num", "2").param("id", "777"))
                .andExpect(content().json("{\"firstTeam\":[{\"id\":8,\"nickname\":\"Oleg2\",\"vehicleType\":1,\"waitingTime\":123},{\"id\":10,\"nickname\":\"Oleg4\",\"vehicleType\":1,\"waitingTime\":125},{\"id\":12,\"nickname\":\"Oleg6\",\"vehicleType\":1,\"waitingTime\":54},{\"id\":15,\"nickname\":\"Oleg9\",\"vehicleType\":2,\"waitingTime\":32},{\"id\":17,\"nickname\":\"Oleg11\",\"vehicleType\":2,\"waitingTime\":155},{\"id\":19,\"nickname\":\"Oleg13\",\"vehicleType\":2,\"waitingTime\":11},{\"id\":22,\"nickname\":\"Oleg16\",\"vehicleType\":3,\"waitingTime\":123},{\"id\":24,\"nickname\":\"Oleg18\",\"vehicleType\":3,\"waitingTime\":1225},{\"id\":26,\"nickname\":\"Oleg20\",\"vehicleType\":3,\"waitingTime\":15}],\"secondTeam\":[{\"id\":9,\"nickname\":\"Oleg3\",\"vehicleType\":1,\"waitingTime\":124},{\"id\":11,\"nickname\":\"Oleg5\",\"vehicleType\":1,\"waitingTime\":23},{\"id\":13,\"nickname\":\"Oleg7\",\"vehicleType\":1,\"waitingTime\":222},{\"id\":16,\"nickname\":\"Oleg10\",\"vehicleType\":2,\"waitingTime\":123},{\"id\":18,\"nickname\":\"Oleg12\",\"vehicleType\":2,\"waitingTime\":152},{\"id\":14,\"nickname\":\"Oleg8\",\"vehicleType\":2,\"waitingTime\":222},{\"id\":23,\"nickname\":\"Oleg17\",\"vehicleType\":3,\"waitingTime\":122},{\"id\":25,\"nickname\":\"Oleg19\",\"vehicleType\":3,\"waitingTime\":155},{\"id\":27,\"nickname\":\"Oleg21\",\"vehicleType\":3,\"waitingTime\":15},{\"id\":777,\"nickname\":\"OlegCOON\",\"vehicleType\":3,\"waitingTime\":1111}]}"));

    }
}