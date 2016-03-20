package com.epam.mentoring.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import eu.dataaccess.footballpool.ArrayOftPlayersWithCards;
import eu.dataaccess.footballpool.Info;
import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.TPlayersWithCards;

@WebService
public class MegaWebService {

	@WebMethod(operationName="getMessage")
	public String getMessage(String name) {
		
		Info footballService = new Info();
		InfoSoapType footballSoap = footballService.getInfoSoap();
		
		GlobalWeather weatherService = new GlobalWeather();
		GlobalWeatherSoap weatherSoap = weatherService.getGlobalWeatherSoap();
		
		ArrayOftPlayersWithCards allPlayers = footballSoap.allPlayersWithYellowOrRedCards(false, false, false);
		for (TPlayersWithCards player : allPlayers.getTPlayersWithCards()) {
			if (player.getSTeamName().equals(name)) {
				System.out.println("Team: " + player.getSTeamName() + "| Player: " + player.getSName()  + "| Yellow: " + player.getIYellowCards() + "| Red: " + player.getIRedCards());
			}
		}

		for (String city : footballSoap.cities().getString()) {
			System.out.println("Weather for: " + city + " -> " + weatherSoap.getWeather(city, ""));
		} 
		return "MegaWebService perfomded for team:" + name;
	}
}
