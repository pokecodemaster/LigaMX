/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligamx;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author gxcxr01
 */
public class Tournament {
	List<Jornada> jornada;
	List<Jornada> liguilla;
	String name;
	String champions;
        List<Match> allMatches;
        List<Stadium> allStadiums;
        
        HashMap<String,Team> teams;
        
        //The constructor should set all players, teams, jornadas, etc.
        
        
        
        public Tournament(String Name) throws Exception{
            this.name = Name;
            teams = new HashMap<String,Team>();
            allMatches = new ArrayList<Match>();
            
            File teamsFile = new File("C:\\Users\\gxcxr01\\Documents\\NetBeansProjects\\LigaMX\\src\\ligamx\\allTeams.txt");
            Scanner teamSC = new Scanner(teamsFile); 
            
            File jornadasFile = new File("C:\\Users\\gxcxr01\\Documents\\NetBeansProjects\\LigaMX\\src\\ligamx\\allJornadas.csv");
            Scanner jornadasSC = new Scanner(jornadasFile);

            while (teamSC.hasNextLine()){
                String currentTeam = teamSC.nextLine();
                Team team = new Team(currentTeam);
                teams.put(team.name, team);
                System.out.println(currentTeam.toUpperCase() + ":");
                getPlayersByTeam(currentTeam);
            }
            
            while (jornadasSC.hasNextLine()){
                /*
                J1,Puebla,1,3,Tijuana,7/19/2019,Christian Tabo,"Washington Camacho,Ariel Nahuelpan,Angel Sepulveda"
                */
                String currentJornada = jornadasSC.nextLine();
                
                String [] inputs = currentJornada.split(",");
                
                Team homeTeam = teams.get(inputs[1]);
                Team awayTeam = teams.get(inputs[4]);
                //System.out.println(inputs[2]+"-"+inputs[3]);
                Match currentMatch = new Match(inputs[0], homeTeam, awayTeam, Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]), inputs[5]);
                allMatches.add(currentMatch);
                //Update team stats based on results.
                int htg = currentMatch.homeTeamGoals;
                int atg = currentMatch.awayTeamGoals;
                if(htg > atg) {
                    homeTeam.updateTeamStats(1, 0, 0, htg, atg);
                    awayTeam.updateTeamStats(0, 0, 1, atg, htg);
                }
                else if(htg < atg){
                    homeTeam.updateTeamStats(0, 0, 1, htg, atg);
                    awayTeam.updateTeamStats(1, 0, 0, atg, htg);
                }
                else if(htg == atg){
                    homeTeam.updateTeamStats(0, 1, 0, htg, atg);
                    awayTeam.updateTeamStats(0, 1, 0, atg, htg);
                }
                //update players stats based on results.
                //System.out.println(currentMatch.toString());
                
            }
            showStandings();
            
        }
        
        //Get that lambdfa expression to sort based on points, then goal difference
        public void showStandings(){
            System.out.println("Team\t\tMP\tWins\tDraws\tLoss\tPTS\tGF\tGA\tGD");
            for(Entry ee : teams.entrySet()) {
                System.out.println(ee.getValue());
            }
        }
        
        public List<Player> getPlayersByTeam(String teamName){
            for(Player p : teams.get(teamName).getRoster()){
                System.out.println(p.toString());
            }
            return teams.get(teamName).getRoster();
        }
        
        public List<Match> getJornadasByWeek(String jWeek){
            List<Match> matchesByWeek = new ArrayList<>();
            for(Match m: allMatches){
                if(m.week.toLowerCase().equals(jWeek.toLowerCase())){
                    matchesByWeek.add(m);
                }
            }
            return matchesByWeek;
        }
        
        public List<Stadium> getAllStadiums(){
            return allStadiums;
        }

}
