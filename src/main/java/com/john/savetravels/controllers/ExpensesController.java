package com.john.savetravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.john.savetravels.models.Expense;
import com.john.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpensesController {
	
	private final ExpenseService expenseService;
	
	public ExpensesController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String expense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute(expense);
		return "Show.jsp";
	}
	
	@PostMapping("/expenses/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "Edit.jsp";
	}
	
	@PatchMapping("/expenses/edit/update/{id}")
	public String update (@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "Edit.jsp";
		} else {
			expenseService.editOne(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}

}
