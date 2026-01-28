package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InsufficientLeaveBalanceException extends Exception {
    public InsufficientLeaveBalanceException(String message) {
        super(message);
    }
}

class Employee{
	String name;
	int id;
	int leaveBalance;
	
	 Employee(String name, int id, int leaveBalance){
		 this.name=name;
		 this.id=id;
		 this.leaveBalance=leaveBalance;
	 }
}
class LeaveRequest{
	int days;
	LeaveRequest(int days){
		this.days=days;
	}
}

public class EmployeeLeaveSystem {
	static Map<Integer, Employee> employeeMap = new HashMap<>();
    static List<LeaveRequest> leaveRequests = new ArrayList<>();
     
    public static void applyLeave(int empID, int days) throws InsufficientLeaveBalanceException {
    	Employee emp=employeeMap.get(empID);
    	if(emp.leaveBalance<days) {
    		throw new InsufficientLeaveBalanceException(" insufficient days");
    	}
    	emp.leaveBalance-=days;
    	leaveRequests.add(new LeaveRequest(days));
    	System.out.println(" Leave Approved for "+ emp.name);
    	
    }
    public static void main(String[] args) {
    	employeeMap.put(1,new Employee("vanshika",001,6));
    	try{
    		applyLeave(1,5);
    	}
    	catch(InsufficientLeaveBalanceException e) {
    		System.out.println(e.getMessage());
    	}
    }

}
