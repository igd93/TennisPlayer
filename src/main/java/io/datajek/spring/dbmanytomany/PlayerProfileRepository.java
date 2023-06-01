package io.datajek.spring.dbmanytomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerProfileRepository extends JpaRepository <PlayerProfile, Integer> {
}
