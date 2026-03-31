package employee_wage;

import employee_wage.EmployeeWageService;

public class EmployeeWageController {
	
	public static void main(String[] args) {

        int EMP_RATE_PER_HOUR = 20;
        final int FULL_TIME = 1; //case constant used in switch case
        final int PART_TIME = 2;
        int empCheck = (int) (Math.random() * 3);
        int empHours = 0;
        switch (empCheck) {
            case FULL_TIME:
                empHours = 8;
                break;
            case PART_TIME:
                empHours = 4;
                break;
            default:
                empHours = 0;
        }
        int dailyWage = empHours * EMP_RATE_PER_HOUR;
        System.out.println("Daily Wage: " + dailyWage);
        
        EmployeeWageService service = new EmployeeWageService();
        System.out.println("Monthly Wage: " + service.computeMonthlyWage());
        
        service.addCompany("TCS", 20, 20, 100);
        service.addCompany("Infosys", 25, 22, 120);

        service.computeAllWages();

        System.out.println("Total Wage for TCS: " + service.getTotalWageByCompany("TCS"));
    }
   }
