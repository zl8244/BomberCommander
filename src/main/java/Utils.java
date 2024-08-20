import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
    public static double round(double value, int places) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double nearestDivisibleByFive(double value) {
        if(value % 5 == 0) return value;

        int countUp = 0;
        double valueUp = value;
        int countDown = 0;
        double valueDown = value;

        do{
            valueUp++;
            countUp++;
        } while(valueUp % 5 != 0);

        do {
            valueDown--;
            countDown++;
        } while(valueDown % 5 != 0);

        if(countUp <= countDown) return valueUp;

        return valueDown;
    }
}
