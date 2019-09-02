/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligamx;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gxcxr01
 */
public class Player {
	String name;
	String position;
        String number;
	String team;
        //This will need a mutator (setter)
	int goals;
        String playerKey;
        List<Player> allPlayers;
        
        public Player (String playerInfo){
            String[] inputs = playerInfo.split(",");
            name = inputs[0];
            position = inputs[1];
            number = inputs[2];
            team = inputs[3];
            goals = Integer.parseInt(inputs[4]);
            playerKey = (name + number + team).replaceAll(" ", "");
        }
        
        public String getName(){
            return name;
        }
        
        public void setGoals(int ugoals){
            goals += ugoals;
        }
        
        @Override
        public String toString(){
            return "\t" + number + " " + name + " " + position + " " + goals;
        }
}
