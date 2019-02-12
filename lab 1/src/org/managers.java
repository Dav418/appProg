package org;

public class managers extends employee{
    protected String team;
    protected int noOfPpl;


    public managers(String name,int salary, String dob, String team,int noOfPpl)
    {
        this.team=team;
        this.noOfPpl=noOfPpl;
        this.name=name;
        this.salary=salary;
        this.dob=dob;
    }

    @Override
    public void information() {
        System.out.println("Name: " + name+", salary: "+salary+", date of birth: "+ dob + ", managing team: "+ team+ ", number of people: "+ noOfPpl);
    }

}
