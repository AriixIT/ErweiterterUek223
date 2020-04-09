package ch.noseryoung.ukErweitert.functionalInterfaces;

public class Start {

    public static void main(String[] args){
        CalculaterInterface addition = ((x, y) -> x + y);
        CalculaterInterface multiplication = ((x, y) -> x * y);
        CalculaterInterface subtraction = ((x, y) -> x - y);
        CalculaterInterface division = ((x, y) -> x / y);

        System.out.println(addition.calculate(6, 2));
        System.out.println(multiplication.calculate(6, 2));
        System.out.println(subtraction.calculate(6, 2));
        System.out.println(division.calculate(6, 2));

    }
}
