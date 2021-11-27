package com.example.task.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {




    @Query("SELECT p FROM Player p ORDER BY p.id DESC")
    Page<Player> findAllPlayersOrderedById(Pageable pageable);
}
