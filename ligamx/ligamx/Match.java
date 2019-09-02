/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligamx;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author gxcxr01
 */
public class Match {
	Date date;
	Stadium venue;
	Team homeTeam;
	Team awayTeam;
        int homeTeamGoals;
        int awayTeamGoals;
	String score;
	String result;
        String week;
        
        public Match(String Week, Team home, Team away, int htg, int atg, String Date){
            week = Week;
            //date = inputs[0];
            //venue = inputs[1].toString();
            homeTeam = home;
            awayTeam = away;
            homeTeamGoals = htg;
            awayTeamGoals = atg;
            score = homeTeamGoals + "-" + awayTeamGoals;
            try {
                date = parseDate(Date);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            
        }
        
        /*public void updatePlayersGoals(String playerName, ArrayList<Team> TL){
            for(Team tt : TL){
                tt.getRoster().get(tt)
            }
        }*/
        
        
        private Date parseDate(String Date)throws Exception{
            return new SimpleDateFormat("m/d/yy").parse(Date);
        }
        
        @Override
        public String toString(){
            String matchString = "";
            if(score.contains("-")){
                String [] scores = score.split("-");
                matchString =  homeTeam.name + " " + homeTeamGoals + " vs " + awayTeamGoals + " " + awayTeam.name +  " on " + date;
            }
            else {
                matchString = homeTeam.name + " vs " + awayTeam.name + " on " + date;
            }
            return matchString;
        }
}
