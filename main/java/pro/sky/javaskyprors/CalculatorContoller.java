package pro.sky.javaskyprors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorContoller {

    private final CalculatorServiceInterface calculatorService;

    public CalculatorContoller(CalculatorServiceInterface calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String helloCalculator() {
        return "Добро пожаловать в калькулятор";

    }
    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int a, @RequestParam("num2")int b) {
        int result = calculatorService.plus(a, b);
        return String.format("%s + %s = %s", a, b, result);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int a, @RequestParam("num2")int b) {
        int result = calculatorService.minus(a, b);
        return String.format("%s - %s = %s", a, b, result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2")int b) {
        int result = calculatorService.multiply(a, b);
        return String.format("%s * %s = %s", a, b, result);
    }@GetMapping("/divide")
    public String divide(@RequestParam("num1") int a, @RequestParam("num2")int b) {
        if (b == 0) {
            return "На ноль делить нельзя";
        }

        int result = calculatorService.divide(a, b);
        return String.format("%s / %s = %s", a, b, result);
}




}
