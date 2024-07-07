package tcss143.clientProgram;

import tcss143.entity.Employee;

import tcss143.service.EmployeeDBService;


public class EmployeeDBController {
    public static void main(String[] args) throws Exception {
        /*Employee Tiger = new Employee(1221,"Tiger", "Smith", 47, 100000, "Golfer", 20);
        Employee Fitz = new Employee(1112,"Fitz", "Gerald", 22, 125000, "Hacker", 2);
        Employee Moby = new Employee(1332,"Moby", "Dick", 56, 25000, "Cab Driver", 32);
        Employee Hugh = new Employee(67332,"Hugh", "Jackman", 44, 500000, "Actor", 22);
        Employee[] list1 = {Tiger, Fitz, Moby, Hugh};

        Employee Gerald = new Employee(010001, "Gerald", "Smith", 32, 45000, "Welder", 3);*/

        EmployeeDBService service1 = new EmployeeDBService();
        /*service1.addEmployee(010011, "Ben", "Johnson", 26, 60000, "Chemist", 6);

        service1.addEmployees(list1);
        service1.deleteEmployee(010001);
        service1.deleteAllEmployees();

        service1.addEmployee(010222, "Ronald", "Rogers", 32, 45000, "Welder", 3);
        service1.addEmployee(34532,"Tony", "Manner", 60, 1000000, "Philanthropist", 40);
        service1.addEmployee(555534,"Ben", "Con", 38, 225000, "CEO", 8);
        service1.searchEmployee("Manner");


        service1.getListOfAllEmployees();
        service1.searchEmployees(8);
        service1.updateEmployee(010222, 60000);
        service1.searchEmployee("Rogers");*/

        service1.employeeAdder();
        System.out.println(service1);
        Employee John = new Employee(57111901,"John", "Doe", 35, 50000, "Manager", 10);
        service1.checkEmployeeExists(John);

        System.out.println(service1.getOddNumberedEmployee());
        System.out.println(service1.pickEmployeeForLottery());
        System.out.println(service1.getEmployeesWithGivenExperience(3));

    }
}
