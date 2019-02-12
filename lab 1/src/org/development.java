package org;

public class development extends employee {
    protected String teamName;
    protected String project;

    public development(String name,int salary, String dob, String teamName,String project)
    {
        this.teamName=teamName;
        this.project=project;
        this.name=name;
        this.salary=salary;
        this.dob=dob;
    }

    @Override
    public void information() {
        System.out.println("Name: " + name+", salary: "+salary+", date of birth: "+ dob + ", team name: "+ teamName+ ", current project: "+ project);
    }
}
