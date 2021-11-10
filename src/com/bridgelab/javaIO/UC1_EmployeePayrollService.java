package com.bridgelab.javaIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UC1_EmployeePayrollService {
	public List<EmployeePayrollData> employeePayrollList;
	public enum IOService{
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}
	public UC1_EmployeePayrollService() {

	}
	public UC1_EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {

	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		UC1_EmployeePayrollService employeePayrollService = new UC1_EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData();
	}

	public void readEmployeePayrollData(Scanner input) {
		System.out.println("Enter Employee Id: ");
		int id = input.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = input.next();
		System.out.println("Enter Employee Salary: ");
		double salary = input.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}
	public void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll Roster to Console\n" + employeePayrollList);
	}
}