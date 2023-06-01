package io.datajek.spring.dbmanytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    @Autowired
    TournamentRepository repo;

    public List<Tournament> allTournaments() {
        return repo.findAll();
    }

    public Tournament getTournament(int id) {
        Optional<Tournament> tempTournament = repo.findById(id);
        if (tempTournament.isPresent()) {
            return tempTournament.get();
        }
        else {
            throw new CustomNotFoundException("Tournament with this id " + id + "does not exist");
        }
    }

    public Tournament addTournament(Tournament tournament) {
        tournament.setId(0);
        return repo.save(tournament);
    }

    public void deleteTournament(int id) {
        repo.deleteById(id);
    }

    public Tournament addRegistration(int id, Registration registration) {
        Optional<Tournament> tempTournament = repo.findById(id);
        if (tempTournament.isPresent()) {
            Tournament tournament = tempTournament.get();
            tournament.addRegistration(registration);
            return repo.save(tournament);
        }
        else {
            throw new CustomNotFoundException("The tournament with this id " + id + "dos not exist");
        }
    }

    public Tournament removeRegistration(int id, Registration registration) {
        Optional<Tournament> tempTournament = repo.findById(id);
        if (tempTournament.isPresent()) {
            Tournament tournament = tempTournament.get();
            tournament.removeRegistration(registration);
            return repo.save(tournament);
        }
        else {
            throw new CustomNotFoundException("Tournament wih this id " + id + "does not exist");
        }
    }

    public Tournament addCategory(int id, Category category) {
        Optional<Tournament> tempTournament = repo.findById(id);
        if (tempTournament.isPresent()) {
            Tournament tournament = tempTournament.get();
            tournament.addCategory(category);
            return repo.save(tournament);
        }
        else {
            throw new CustomNotFoundException("Tournament with id " + id + " does not exist");
        }
    }

    public Tournament removeCategory(int id, Category category) {
        Optional<Tournament> tempTournament = repo.findById(id);
        if (tempTournament.isPresent()) {
            Tournament tournament = tempTournament.get();
            tournament.removeCategory(category);
            return repo.save(tournament);
        }
        else {
            throw new CustomNotFoundException("Tournament with id " + id + " does not exist");
        }

    }

}
