package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContracts;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
		
		System.out.print("Enter the department name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base Salary: ");
		Double salary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), salary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println();
			System.out.println("Enter contract number #" + i + " data ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractData = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int hours = sc.nextInt();
			
			HourContracts contract = new HourContracts(contractData, valuePerHour, hours);
			worker.addContracts(contract);
			
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		Date monthAndYear = sdf1.parse(sc.next());
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + sdf1.format(monthAndYear) + ": " + String.format("%.2f", worker.income(monthAndYear)));
		
		
		sc.close();

	}

}
