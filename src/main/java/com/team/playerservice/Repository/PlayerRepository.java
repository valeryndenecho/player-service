package com.team.playerservice.Repository;

import com.team.playerservice.Domain.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findPlayersByVorname (String vorname);
    Page<Player> findAllByVornameContainingOrNameContaining (String text1, String text2, Pageable pageable);
    Page<Player> findAll(Specification<Player> spec, Pageable pageable);

    // merge to DTO -> PlayerDTO
    // List<Player> findPlayersByIdOrVornameOrName(String query)
    // entity "trainer_id" (long) -> trainerService.findById(trainer_id)
    // playerDTO.setTrainer()

    Player findPlayerById(Long id);
}









// List<Profile> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrMidNameIgnoreCaseContaining(String firstName, String lastName, String midName);