package org;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        employee[] Employee = new employee[4];
        Employee[0] = new managers("Jerry", 4000,"24/4/09", "Team A", 4);
        Employee[1] = new sales("Merry", 4000,"13/6/01", 20, 4,6);
        Employee[2] = new development("Sam", 4000,"14/4/98", "Team A", "apple");
        Employee[3] = new development("Dav", 6000,"8/2/98", "Team B", "pears");
        for(employee employee:Employee){employee.information();}

    }
    @Override
    public String toString(){
        return "";
    }
}
