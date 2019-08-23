/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligamx;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gxcxr01
 */
public class Jornada {
	List<Match> matches;
	Date startDate;
	Date endDate;
        
        public void showJornada(String currJor){
            for(Match m: matches){
                if(m.week.equals(currJor)){
                    System.out.println(m.toString());
                }
            }
            
        }
}
