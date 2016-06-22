import java.util.Scanner;

/**
 * @(#)assignment.java
 *
 * assignment application
 *
 * @author 
 * @version 1.00 2016/6/20
 */
 import java.util.*;
public class SampleProblem {
    
    static abstract class Employee{
    	
    	public String name;
		public String social_security_number;
		public Integer birthday_month;
		public Integer birthday_week;
		
		// three-argument constructor
     public Employee( String n, String ssn, Integer m, Integer w )
     {
        name = n;
        social_security_number = ssn;
        birthday_month = m;
        birthday_week = w;
     }		
		
		abstract Double getEarnings();
		
		public String toString(){
			String value = String.format("employee: %s\nsocial security number: %s", name, social_security_number);
			return value;
		}
		
		Double finalPaycheck(Double d){
			if(d > 1000.0)
				return 1000.0;
			else
				return d;
		}

    }
    
    public static class Salaried extends Employee{
    	Double weekly_salary;
    	public void loadSalary(){
    		Scanner scn = new Scanner(System.in);
			
    	}
    	
    	public Salaried(String a, String b, Integer c, Integer d, Double e){
			super(a,b,c,d);
			weekly_salary = e;
		}
    	
    	Double getEarnings(){
    		return weekly_salary;
    	}
    	
    	public String toString(){
			String value = String.format("%s\nPaycheck: $ %f\n", super.toString(), finalPaycheck(getEarnings()));
			return value;
		}
    }
    
    public static class Hourly extends Employee{
    	Double hourly_pay;
		Double hours_worked_during_the_past_week;
		
		public Hourly(String a, String b, Integer c, Integer d, Double e, Double f){
			super(a,b,c,d);
			hourly_pay = e;
			hours_worked_during_the_past_week = f;
		}
		public void loadHour(){
			Scanner scn = new Scanner(System.in);
			
		}
		
		Double getEarnings(){
			Double extra = (hours_worked_during_the_past_week>40)?hours_worked_during_the_past_week-40:0;
			Double normal = (hours_worked_during_the_past_week>40)?40:hours_worked_during_the_past_week;
			return (normal*hourly_pay) + (hourly_pay*1.5*extra);
		}
		
		public String toString(){
			String value = String.format("%s\nPaycheck: $ %f\n", super.toString(), finalPaycheck(getEarnings()));
			//String value = super.toString();
			return value;
		}		
			
    }
    
    
    
    public static class SalariedPlusCommission extends Salaried{
    	Double sales;
		Double rate;
		
		public SalariedPlusCommission(String a, String b, Integer c, Integer d, Double e, Double f, Double g){
			super(a,b,c,d,e);
			sales = f;
			rate = g;
		}
		public void loadCommission(){
			Scanner scn = new Scanner(System.in);
		}
		
		Double getEarnings(){
			return weekly_salary + (sales*rate);
		}
		
		public String toString(){
			String value = String.format("%s\nPaycheck: $ %f\n", super.toString(), finalPaycheck(getEarnings()));
			return value;
		}

    }
    public static void main(String[] args) {
    	// TODO, add your application code
    	String name;
		String social_security_number;
		Integer birthday_month;
		Integer birthday_week;
		
		Double hourly_pay;
		Double hours_worked_during_the_past_week;
		
		Double weekly_salary;
		
		Double sales;
		Double rate;
		
    	Scanner scn = new Scanner(System.in);
    	Integer numberOfEmployees;
    	System.out.println("Number of Employees: ");
    	numberOfEmployees = scn.nextInt();
    	Integer cnt=1;
    	Employee employees[] = new Employee[ numberOfEmployees];
    	while(numberOfEmployees>0){
    		System.out.println("PROFILE FOR EMPLOYEE #" + cnt + ":");
    		System.out.println("type Hourly(1), Salaried(2), Salaried plus Commission(3)");
    		System.out.println("Enter 1, 2, or 3 ==>");
    		Integer type = scn.nextInt();
    		
			System.out.println("Name ==>");
			name = scn.next();
			System.out.println("Social security number ==>");
			social_security_number = scn.next();
			System.out.println("Birthday month (1-12) ==>");
			birthday_month = scn.nextInt();
			System.out.println("Birthday bonus week (1-4) ==>");
			birthday_week = scn.nextInt();
			
    		if(type == 1){
    			System.out.println("Hourly pay ==>");
				hourly_pay = scn.nextDouble();
				System.out.println("Hours worked this past week ==>");
				hours_worked_during_the_past_week = scn.nextDouble();
				
				try {
					Hourly hourlyEmployee = new Hourly(name, social_security_number, birthday_month, birthday_week, hourly_pay, hours_worked_during_the_past_week);
					employees[cnt-1] = hourlyEmployee;
				}
				catch (Exception ex) {
				}
				
    		}else if(type == 2){
    			System.out.println("Salary ==>");
				weekly_salary = scn.nextDouble();
				
				Salaried salariedEmployee = new Salaried(name, social_security_number, birthday_month, birthday_week, weekly_salary);
				employees[cnt-1] = salariedEmployee;
    		}else{
    			
    			System.out.println("Salary ==>");
				weekly_salary = scn.nextDouble();
				
    			System.out.println("Sales for this past week ==>");
				sales = scn.nextDouble();
				System.out.println("Sales commission rate (fraction paid to employee) ==>");
				rate = scn.nextDouble();
				SalariedPlusCommission salariedPlusCommissionEmployee = new SalariedPlusCommission(name, social_security_number, birthday_month, birthday_week, weekly_salary, sales, rate);
				employees[cnt-1] = salariedPlusCommissionEmployee;
    		}
    		
    		cnt++;
    		numberOfEmployees--;
    	}
    	
    	for(Employee curr: employees){
    		System.out.println(curr);
    	}
    }
}

