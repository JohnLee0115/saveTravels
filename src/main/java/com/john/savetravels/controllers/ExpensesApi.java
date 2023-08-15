package com.john.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.savetravels.models.Expense;
import com.john.savetravels.services.ExpenseService;

@RestController
public class ExpensesApi {
	
	private final ExpenseService expenseService;
	
	public ExpensesApi(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("/api/expenses")
	public List<Expense> index() {
		return expenseService.allExpenses();
	}
	
	@PostMapping("/api/burgers")
	public Expense create(  @RequestParam(value="name") String name, 
							@RequestParam(value="vendor") String vendor,
							@RequestParam(value="amount") double amount,
							@RequestParam(value="description") String description) {
		Expense expense = new Expense(name, vendor, amount, description);
		
		return expenseService.createExpense(expense);
	}
	
	@RequestMapping("/api/expenses/{id}")
	public Expense show(@PathVariable("id") Long id) {
		Expense expense = expenseService.findExpense(id);
		return expense;
	}
	
	@PatchMapping("/api/expenses/{id}")
	public Expense update(  @PathVariable("id") Long id,
							@RequestParam(value="name") String name,
							@RequestParam(value="vendor") String vendor,
							@RequestParam(value="amount") double amount,
							@RequestParam(value="description") String description) {
		Expense expense = expenseService.updateExpense(id, name, vendor, amount, description);
		
		return expense;
	}
	
	@DeleteMapping("/api/expenses/{id}")
	public void destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
	}
	
	
}
