public class FinancialForecasting {

    public static double forecast(double currentValue,
                                  double growthRate,
                                  int years) {

        if (years == 0) {
            return currentValue;
        }

        double newValue = currentValue * (1 + growthRate / 100);

        return forecast(newValue, growthRate, years - 1);
    }

    public static void main(String[] args) {

        double result = forecast(1000, 10, 3);

        System.out.println("Future Value = " + result);
    }
}