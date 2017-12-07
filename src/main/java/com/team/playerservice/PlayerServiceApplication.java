package com.team.playerservice;

import com.team.playerservice.Domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.team.playerservice.Repository.PlayerRepository;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class PlayerServiceApplication implements CommandLineRunner{

	@Autowired
	private PlayerRepository playerRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlayerServiceApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {

		List<Player> player = new ArrayList<>();
		player.add(new Player("Valery", "Ndenecho"));
		player.add(new Player("Tita", "Edgar"));
		player.add(new Player("Carinton", "Tifor"));
		player.add(new Player("Rodrigue", "Ambassa"));
		player.add(new Player("Jackson", "Panzo"));
		player.add(new Player("Valery2", "Ndenecho"));
		player.add(new Player("Tita2", "Edgar"));
		player.add(new Player("Carinton2", "Tifor"));
		player.add(new Player("Rodrigue2", "Ambassa"));
		player.add(new Player("Jackson2", "Panzo"));
		player.add(new Player("Valery3", "Ndenecho"));
		player.add(new Player("Tita3", "Edgar"));
		player.add(new Player("Carinton3", "Tifor"));
		player.add(new Player("Rodrigue3", "Ambassa"));
		player.add(new Player("Jackson3", "Panzo"));
		player.add(new Player("Valery4", "Ndenecho"));
		player.add(new Player("Tita4", "Edgar"));
		player.add(new Player("Carinton4", "Tifor"));
		player.add(new Player("Rodrigue4", "Ambassa"));
		player.add(new Player("Jackson4", "Panzo"));
		player.add(new Player("Valery5", "Ndenecho"));
		player.add(new Player("Tita5", "Edgar"));
		player.add(new Player("Carinton5", "Tifor"));
		player.add(new Player("Rodrigue5", "Ambassa"));
		player.add(new Player("Jackson5", "Panzo"));
		player.add(new Player("Valery6", "Ndenecho"));
		player.add(new Player("Tita6", "Edgar"));
		player.add(new Player("Carinton6", "Tifor"));
		player.add(new Player("Rodrigue6", "Ambassa"));
		player.add(new Player("Jackson6", "Panzo"));
		player.add(new Player("Valery7", "Ndenecho"));
		player.add(new Player("Tita7", "Edgar"));
		player.add(new Player("Carinton7", "Tifor"));
		player.add(new Player("Rodrigue7", "Ambassa"));
		player.add(new Player("Jackson7", "Panzo"));


		for (Player p :player) {
			this.playerRepository.save(p);
		}
	}
}
