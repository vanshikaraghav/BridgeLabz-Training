package scenario_based;

public class EmployeeWageComputation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");
        int empHours = 0;
        int totalEmpHours = 0;
        int totalWorkingDays = 0;
        int wagesPerHour = 20;
        
     // UC 6: Calculate wages till total hours or days is reached
        int maxWorkingHours = 100;
        int maxWorkingDays = 20;
        while(totalEmpHours<maxWorkingHours && totalWorkingDays<maxWorkingDays) {
            totalWorkingDays++;
            
        // UC1 employee attendance
        int empCheck = (int)(Math.random()*3);
        
        // UC4 switch-case 
        switch(empCheck) {
        case 1:
            empHours = 8;   // UC 3: Part Time Employee
            break;
        case 2:
            empHours = 8;   // Full Time Employee
            break;
        default:
            empHours = 0;   // Employee Absent
        }
        totalEmpHours += empHours;
        
        // UC2 calculate daily wage
        int dailyWage = empHours*wagesPerHour;
        System.out.println("Day "+totalWorkingDays+" | Working Hours: "+empHours+" | Daily Wage: ₹"+dailyWage);
        }
        
        // UC 5: Calculate Monthly Wage
        int totalSalary = totalEmpHours*wagesPerHour;
        System.out.println("\nTotal Working Days: "+totalWorkingDays);
        System.out.println("Total Working Hours: "+totalEmpHours);
        System.out.println("Total Monthly Wage: ₹"+totalSalary);
    }
}
