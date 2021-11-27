package com.example.task.domain;

import java.util.List;

public class Lobby {

    private final List<Player> firstTeam;
    private final List<Player> secondTeam;

    public Lobby(List<Player> firstTeam, List<Player> secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public Lobby addToLobby(Player player,int numberOfTeam)
    {
        Lobby res = new Lobby(firstTeam,secondTeam);
        if(numberOfTeam==1)res.addToFirstTeam(player);
        if(numberOfTeam==2)res.addToSecondTeam(player);
        else System.out.println("Ошибка");
        return res;
    }

    public void deleteFromLobby(String name)
    {

        Lobby res=new Lobby(firstTeam,secondTeam);
        for (int i = 0; i < getFirstTeam().size(); i++) {
            if(firstTeam.get(i).getNickname().equals(name)){res.deleteFromFirstTeam(i);
                System.out.println("нашел "+name+"  в 1");}
        }
        for (int i = 0; i < getSecondTeam().size(); i++) {
            if (secondTeam.get(i).getNickname().equals(name)) {
                res.deleteFromSecondTeam(i);
                System.out.println("нашел " + name + "  в 2");
            }

        }
    }
    public List<Player> getFirstTeam() {
        return firstTeam;
    }

    public List<Player> getSecondTeam() {
        return secondTeam;
    }
    public void deleteFromSecondTeam(int i){
        secondTeam.remove(i);
    }
    public void deleteFromFirstTeam(int i){
        firstTeam.remove(i);
    }
    public void addToFirstTeam(Player player){
        firstTeam.add(player);
    }
    public void addToSecondTeam(Player player){
        secondTeam.add(player);
    }
}