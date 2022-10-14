package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CalculatorController {

    @GetMapping
    public String showForm() {
        return "calculator";
    }

    @RequestMapping("calculate")
    public String calculate(@RequestParam(required = false) String number1, @RequestParam(required = false) String number2, String operation, Model model) {
        String result = "";
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            switch (operation) {
                case "add":
                    result += num1 + " + " + num2 + " = " + (num1 + num2);
                    break;
                case "sub":
                    result += num1 + " - " + num2 + " = " + (num1 - num2);
                    break;
                case "mul":
                    result += num1 + " * " + num2 + " = " + (num1 * num2);
                    break;
                case "div":
                    if (num2 == 0) {
                        result = "Can't divide by zero";
                        break;
                    } else {
                        result += num1 + " / " + num2 + " = " + (num1 / num2);
                        break;
                    }
            }
        } catch (NumberFormatException e) {
            result = "Empty input";
        }
        model.addAttribute("result", result);
        return "calculator";
    }
}
