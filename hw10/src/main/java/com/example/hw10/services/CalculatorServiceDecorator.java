package com.example.hw10.services;

import com.example.hw10.models.Cache;
import com.example.hw10.repositories.CalculatorRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceDecorator implements Calculator {
    private final Calculator calculator;
    private final CalculatorRepository calculatorRepository;

    public CalculatorServiceDecorator(Calculator calculator, CalculatorRepository calculatorRepository) {
        this.calculator = calculator;
        this.calculatorRepository = calculatorRepository;
    }

    @Override
    public String calculate(String a, String op, String b) {
        Cache cache = calculatorRepository.findByAAndOperatorAndB(a, op, b);
        if (cache != null) return cache.getResult() + " (from cache)";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = calculator.calculate(a, op, b);
        Cache newCache = new Cache(null, a, b, op, result);
        calculatorRepository.save(newCache);
        return result;
    }
}
