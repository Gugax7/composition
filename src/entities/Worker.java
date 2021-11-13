package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContracts> contract = new ArrayList<>();
	
	public Worker() {
		
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContracts> getContracts() {
		return contract;
	}
	public void addContracts(HourContracts contracts) {
		contract.add(contracts);
		
	}
	public void RemoveContracts(HourContracts contracts) {
		contract.remove(contracts);
	}
	public double income(int year, int month) {
		
		double som = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContracts x : contract) {
			int x_year = cal.get(Calendar.YEAR);
			int x_month = cal.get(Calendar.MONTH);
			if(year == x_year && month == x_month) {
			som+= x.totalValue();
			}
		}
		return som;
	}

}
