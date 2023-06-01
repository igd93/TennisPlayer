package io.datajek.spring.dbmanytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    public List<Player> allPlayers() {
        return repo.findAll();
    }

    public Player getPlayer(int id) {
        Optional<Player> tempPlayer = repo.findById(id);
        if (tempPlayer.isPresent()) {
            return tempPlayer.get();
        }
        else {
            throw new CustomNotFoundException("Player with this id " + id + "does not exist");
        }

    }

    public Player addPlayer(Player player) {
        player.setId(0);
        if(player.getPlayerProfile() != null) {
            player.getPlayerProfile().setPlayer(player);
        }
        return repo.save(player);
    }

    public void deletePlayer(int id) {
        repo.deleteById(id);
    }

    public Player assignProfile(int id, PlayerProfile profile) {
        Optional<Player> tempPlayer = repo.findById(id);
        if (tempPlayer.isPresent()) {
            Player player = tempPlayer.get();
            player.setPlayerProfile(profile);
            player.getPlayerProfile().setPlayer(player);
            return repo.save(player);
        }
        else {
            throw new CustomNotFoundException("Player with this id " + id + " does not exist");
        }
    }

    public Player assignRegistration(int id, Registration registration) {
        Optional<Player> tempPlayer = repo.findById(id);
        if(tempPlayer.isPresent()) {
          Player player = tempPlayer.get();
          player.registerPlayer(registration);
          return repo.save(player);
        }
        else {
            throw new CustomNotFoundException("Player with such id " + " does not exist");
        }
    }

    public Player removeRegistration(int id, Registration registration) {
        Optional<Player> tempPlayer = repo.findById(id);
        if(tempPlayer.isPresent()) {
            Player player = tempPlayer.get();
            player.removeRegistration(registration);
            return repo.save(player);
        }
        else {
            throw new CustomNotFoundException("Player with such id " + "does not exist");
        }
    }
}
