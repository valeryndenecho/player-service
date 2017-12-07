package com.team.playerservice.Controller;

import com.team.playerservice.Domain.Player;
import com.team.playerservice.Domain.PlayerSpecifications;
import com.team.playerservice.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping(value ="/")
public class PlayerRestController {

    @Autowired
    private PlayerRepository playerRepository;

    // Test
    @RequestMapping(value = "/playerss/{searchParam}", method = RequestMethod.GET)
    public Page<Player> getPlayersByFirstNameOrLastName(@PathVariable("searchParam") String searchParam, Pageable pageable){
        Page<Player> players = this.playerRepository.findAllByVornameContainingOrNameContaining(searchParam, searchParam, pageable);
        System.out.println(players);
        return players;
    }
    // Actual
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public Page<Player> getAllPlayers(Pageable pageable, @RequestParam(required = false) String q){
        if (q != null) {
            return this.playerRepository.findAll(PlayerSpecifications.containsTextInName(q), pageable);
        } else {
            return this.playerRepository.findAll(pageable);
        }
    }

    @RequestMapping(value= "/player/{id}", method = RequestMethod.GET)
    public ResponseEntity getPlayerById(@PathVariable("id") Long id){
        System.out.println(this.playerRepository.findPlayerById(id));
        return new ResponseEntity<Player>(this.playerRepository.findPlayerById(id), HttpStatus.OK);
    }

    @RequestMapping(value ="/players/{vorname}", method = RequestMethod.GET )
    public ResponseEntity getPlayerByFirstname(@PathVariable String vorname){
        System.out.println(this.playerRepository.findPlayersByVorname(vorname));
        return new ResponseEntity<List<Player>>(this.playerRepository.findPlayersByVorname(vorname), HttpStatus.OK);
    }

    @RequestMapping(value= "/players", method = RequestMethod.POST)
    public ResponseEntity addPlayer(@RequestBody Player player){

        Player playerInstance = new Player();

        playerInstance.setVorname(player.getVorname());
        playerInstance.setName(player.getName());

        return new ResponseEntity<Player>(this.playerRepository.save(playerInstance), HttpStatus.CREATED);
    }

    @RequestMapping(value= "/players/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePlayer(@PathVariable Long id, @RequestBody Player player){

        Player playerInstance = playerRepository.findOne(id);
        playerInstance.setVorname(player.getVorname());
        playerInstance.setName(player.getName());

        return new ResponseEntity<Player>(this.playerRepository.save(playerInstance), HttpStatus.OK);
    }

    @RequestMapping(value= "/player/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePlayer(@PathVariable Long id){
        this.playerRepository.delete(id);
        return new ResponseEntity<Player>(HttpStatus.OK);
    }
}
