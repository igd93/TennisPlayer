package io.datajek.spring.dbmanytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerProfileService {


    @Autowired
    PlayerProfileRepository repo;


    public List<PlayerProfile> allPlayersProfiles() {
        return repo.findAll();
    }

    public PlayerProfile getPlayerProfile(int id) {
        Optional<PlayerProfile> tempPlayerProfile = repo.findById(id);
        if (tempPlayerProfile.isPresent()) {
            return tempPlayerProfile.get();
        }
        else {
            throw new CustomNotFoundException("The playerProfile with the requested id " + id + " does not exist");
        }
    }

    public PlayerProfile addPlayerProfile(PlayerProfile profile) {
        profile.setId(0);
        return repo.save(profile);
    }

    public void deletePlayerProfile(int id) {
        repo.deleteById(id);
    }


}
