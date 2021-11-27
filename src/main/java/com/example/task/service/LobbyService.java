package com.example.task.service;

import com.example.task.domain.Lobby;
import com.example.task.domain.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class LobbyService {
    public LobbyService() {
    }

    public Lobby generateTeams(List<Player> playerList) {
        List<Player> firstTeam = new ArrayList<>();
        List<Player> secondTeam = new ArrayList<>();
        List<Player> res = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            res.add(new Player("1", 1,1));

        }
        int[] max1 = new int[]{0, 0, 0, 0, 0, 0};
        int[] max2 = new int[]{0, 0, 0, 0, 0, 0};
        int[] max3 = new int[]{0, 0, 0, 0, 0, 0};
        int[] minPos = new int[]{0, 0, 0};
        playerList.forEach(player -> {
            switch (player.getVehicleType()) {
                case 1: {
                    int current = player.getWaitingTime();
                    int min = max1[0];
                    for (int j = 0; j < 6; j++) {
                        if (max1[j] <= min) {
                            min = max1[j];
                            minPos[0] = j;
                        }
                    }
                    if (current > min) {
                        max1[minPos[0]] = current;
                        res.set(minPos[0], player);
                    }
                }
                break;
                case 2: {
                    int current = player.getWaitingTime();
                    int min = max2[0];
                    for (int j = 0; j < 6; j++) {
                        if (max2[j] <= min) {
                            min = max2[j];
                            minPos[1] = 6 + j;
                        }
                    }
                    if (current > min) {
                        max2[minPos[1] - 6] = current;
                        res.set(minPos[1], player);
                    }
                }
                break;
                case 3: {
                    int current = player.getWaitingTime();
                    int min = max3[0];
                    for (int j = 0; j < 6; j++) {
                        if (max3[j] <= min) {
                            min = max3[j];
                            minPos[2] = 12 + j;
                        }
                    }
                    if (current > min) {
                        max3[minPos[2] - 12] = current;
                        res.set(minPos[2], player);
                    }
                }
                break;

            }

        });


        for (int i = 0; i < 18; ) {
            firstTeam.add(res.get(i));
            i++;
            secondTeam.add(res.get(i));
            i++;
        }

        return new Lobby(
                firstTeam, secondTeam
        );
    }

}
