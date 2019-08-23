/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligamx;

/**
 *
 * @author gxcxr01
 */
public class Stadium {
	String location;
	String name;
	int capacity;
        
        public Stadium(String stadiumInfo){
            String[] inputs = stadiumInfo.split(",");
            location = inputs[1];
            name = inputs[2];
            capacity = Integer.parseInt(inputs[3]);
        }
        
        @Override
        public String toString(){
            return name;
        }
}