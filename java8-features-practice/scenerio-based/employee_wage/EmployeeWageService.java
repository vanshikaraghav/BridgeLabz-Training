package employee_wage;

import employee_wage.CompanyEmployeeWage;
import employee_wage.CompanyRepository;

public class EmployeeWageService implements EmployeeWageServiceInterface {

    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    
    
    private CompanyRepository repository = new CompanyRepository();
    
    public void addCompany(String name, int wagePerHour,int maxDays, int maxHours) {	
    	repository.addCompany(new CompanyEmployeeWage(name, wagePerHour, maxDays, maxHours));
    }

    public int computeMonthlyWage() {

        int totalWorkingHours = 0;
        int totalWorkingDays = 0;
        int wagePerHour = 20;
        int maxDays = 20;
        int maxHours = 100;

        while(totalWorkingHours <= maxHours && totalWorkingDays < maxDays) {
            totalWorkingDays++;
            int empCheck = (int) (Math.random() * 3);
            int empHours = 0;
            switch (empCheck) {
                case FULL_TIME:
                    empHours = 8;
                    break;
                case PART_TIME:
                    empHours = 4;
                    break;
            }
            totalWorkingHours += empHours;
        }
        return totalWorkingHours * wagePerHour;
    }

	@Override
	public void computeWage(CompanyEmployeeWage company) {
		// TODO Auto-generated method stub
		 int totalHours = 0;
	     int totalDays = 0;
	     while(totalHours <= company.getMaxWorkingHours() && totalDays < company.getMaxWorkingDays()) {
	            totalDays++;
	            int empCheck = (int) (Math.random() * 3);
	            int empHours = 0;
	            switch (empCheck) {
	                case FULL_TIME: empHours = 8; break;
	                case PART_TIME: empHours = 4; break;
	            }
	            totalHours += empHours;
	            company.addDailyWage(empHours * company.getWagePerHour());
	        }
	        company.setTotalWage(totalHours * company.getWagePerHour());
	    }
	
	
	 public void computeAllWages() {
	        for(CompanyEmployeeWage company : repository.getAllCompanies()) {
	            computeWage(company);
	            System.out.println(company);
	        }
	    }
	 
	 public int getTotalWageByCompany(String name) {
	        CompanyEmployeeWage company = repository.getCompanyByName(name);
	        return (company != null) ? company.getTotalWage() : 0;
	    }	
}