class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] days = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
        };

        int[] monthDays = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int totalDays = 0;

        // Count days from 1971 to year - 1
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Count days in previous months
        for (int m = 1; m < month; m++) {
            totalDays += monthDays[m - 1];

            if (m == 2 && isLeapYear(year)) {
                totalDays++;
            }
        }

        // Days before the given day
        totalDays += day - 1;

        // Jan 1, 1971 was Friday (index 5)
        return days[(totalDays + 5) % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}