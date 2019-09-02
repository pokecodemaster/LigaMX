/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligamx;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author gxcxr01
 */
public class Team {
	String name;
	HashMap<String, Player> roster;
	Stadium home;
        
        //these will need mutators (Setter methods). 
	int MP, W, L, D, PTS, GF, GA, GD = 0;
        
        public Team(String Name) {
            name = Name;
            try{
                populateRoster();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        public void updateTeamStats(int win, int draw, int loss, int gf, int ga){
            W += win;
            D += draw;
            L += loss;
            MP = (W + D + L);
            PTS = (W * 3) + D;
            GF += gf;
            GA += ga;
            GD = (GF-GA);
        }
        
        private void populateRoster() throws Exception{
            File playersFile = new File("C:\\Users\\gxcxr01\\Documents\\NetBeansProjects\\LigaMX\\src\\ligamx\\allPlayers.csv");
            Scanner playersSC = new Scanner(playersFile);
            roster = new HashMap<String, Player>();
            
            while (playersSC.hasNextLine()){
                String currentPlayer = playersSC.nextLine();
                String inputs [] = currentPlayer.split(",");
                if(inputs[3].toLowerCase().equals(name.toLowerCase())){
                    Player player = new Player(currentPlayer);
                    roster.put(player.getName(), player);
                }
            }
        }
        
        public HashMap<String, Player> getRoster() {
            return roster;
        }
	
	public void showRoster(){
		for(Player p : roster.values()) {
                    System.out.println(p.toString());
		}
	}
        
        public Integer getPoints(){
            return PTS;
        }
        
        private String parseGoalDifference(){
            String GDStr = GD + "";
            if(GD > 0){
                GDStr = "+" + GD;
            }
            return GDStr;
        }
        
        @Override
        public String toString() {
            String teamStr = "";
            String GDStr = parseGoalDifference();
            if(name.length() <= 7){
                teamStr = name + "\t\t" + MP + "\t" + W + "\t" + D + "\t" + L + "\t" + PTS + "\t" + GF + "\t" + GA + "\t" + GDStr; 
            }
            else if(name.length() > 7){
                teamStr = name + "\t" + MP + "\t" + W + "\t" + D + "\t" + L + "\t" + PTS + "\t" + GF + "\t" + GA + "\t" + GDStr;
            }
            return teamStr;
        }

}