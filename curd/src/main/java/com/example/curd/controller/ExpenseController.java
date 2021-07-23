package com.example.curd.controller;

import com.example.curd.model.Expense;
import com.example.curd.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;
    @GetMapping("/expense")
    public ResponseEntity<List<Expense>> get(){
        List<Expense> expenses=expenseService.findAll();
        return new ResponseEntity<List<Expense>>(expenses, HttpStatus.OK);

    }
    @PostMapping("/expense")
    public ResponseEntity<Expense> save(@RequestBody Expense expense){
        Expense expense1=expenseService.save(expense);
        return new ResponseEntity<Expense>(expense1, HttpStatus.OK);
    }
    @GetMapping("/expense/{id}")
    public ResponseEntity<Expense> get(@PathVariable("id") Long id){
       Expense expenses=expenseService.findById(id);
        return new ResponseEntity<Expense>(expenses, HttpStatus.OK);

    }
    @DeleteMapping("/expense/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
       expenseService.delete(id);
        return new ResponseEntity<String>("Delete successfully", HttpStatus.OK);

    }
}
