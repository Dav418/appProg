package org;

public class sales extends employee{
    protected int noOfSales;
    protected int currNoOfSales;
    protected int targetSales;

    public sales(String name,int salary, String dob, int noOfSales,int currNoOfSales,int targetSales)

    {
        this.noOfSales=noOfSales;
        this.currNoOfSales=currNoOfSales;
        this.targetSales=targetSales;
        this.name=name;
        this.salary=salary;
        this.dob=dob;
    }

    @Override
    public void information() {
        System.out.println("Name: " + name+", salary: "+salary+", date of birth: "+ dob + ", number of sales: "+ noOfSales+ ", target sales: "+ targetSales);
    }
}
