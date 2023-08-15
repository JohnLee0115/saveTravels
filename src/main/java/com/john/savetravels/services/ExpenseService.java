package com.john.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.john.savetravels.models.Expense;
import com.john.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExpense(Long id, String name, String vendor, double amount, String description) {
		Expense update=this.findExpense(id);
		update.setName(name);
		update.setVendor(vendor);
		update.setAmount(amount);
		update.setDescription(description);
		
		return expenseRepository.save(update);
	}
	
	public Expense editOne(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

}
