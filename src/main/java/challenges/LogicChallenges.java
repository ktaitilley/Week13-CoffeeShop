package challenges;

// SECTION A: Logic. if, else if, && and ||, and a little math.
// The test is src/test/java/challenges/LogicChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 06 (if and switch), Part 07 (logical operators), Part 13 (methods).

public class LogicChallenges {

    // How much extra a drink size costs.
    //   'S' or 's' -> 0.0     'M' or 'm' -> 0.50     'L' or 'l' -> 1.00
    //   anything else -> -1.0 (that size does not exist)
    //   sizeUpcharge('M') -> 0.5     sizeUpcharge('l') -> 1.0     sizeUpcharge('X') -> -1.0
    public static double sizeUpcharge(char size) {
        if (size == 's'|| size == 'S') {
            return 0.0;
        } else if (size == 'm'||size == 'M') {
            return 0.50;
        }else if (size == 'l'||size == 'L') {
            return 1.0;
        } else {
            return -1.0;
        }
    }

    // Happy hour on a weekday is from hour 14 to hour 16 (2 PM to 4 PM), both included.
    // On the weekend it is longer: hour 12 to hour 17, both included.
    // hour is on a 24-hour clock (0 to 23). Any other hour is never happy hour.
    //   isHappyHour(15, false) -> true     isHappyHour(12, false) -> false
    //   isHappyHour(12, true)  -> true     isHappyHour(25, true)  -> false
    public static boolean isHappyHour(int hour, boolean weekend) {
        if (weekend == false) {
            switch (hour) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    return false;
                case 14:
                    return true;
                case 15:
                    return true;
                case 16:
                    return true;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    return false;
                default:
                    return false;
            }
        } else {
            switch (hour) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    return false;
                case 12:
                    return true;
                case 13:
                    return true;
                case 14:
                    return true;
                case 15:
                    return true;
                case 16:
                    return true;
                case 17:
                    return true;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    return false;
                default:
                    return false;
            }
        }
    }

    // A loyalty card gets one stamp per drink. Every 10 stamps is one free drink.
    // The card already has stamps, and the customer buys more drinks.
    // Give back how many free drinks they have earned in total.
    // If stamps or bought is below 0, give back 0.
    //   freeDrinks(8, 3)  -> 1     freeDrinks(0, 25) -> 2
    //   freeDrinks(4, 5)  -> 0     freeDrinks(-1, 30) -> 0
    public static int freeDrinks(int stamps, int bought) {
        if (stamps < 0 || bought < 0) {
            return 0;
        }
        return (stamps + bought) / 10;
    }

    // The fewest coins that make the change. Coins are 25, 10, 5 and 1 cents.
    // Use as many quarters as you can, then dimes, then nickels, then pennies.
    // If cents is 0 or less, give back 0.
    //   coinsForChange(30) -> 2  (25 + 5)
    //   coinsForChange(41) -> 4  (25 + 10 + 5 + 1)
    //   coinsForChange(99) -> 9  (3 quarters, 2 dimes, 4 pennies)
    public static int coinsForChange(int cents) {
        if (cents <= 0) {
            return 0;
        }
        int coins = cents / 25;
        cents = cents % 25;
        coins += cents / 10;
        cents = cents % 10;
        coins += cents / 5;
        cents = cents % 5;
        coins += cents;
        return coins;
    }
}
