public  class LongestStabilityPeriod {


    public int count(int[] gdp) {

        int counter = 0;

        if (gdp.length == 1) {
            return 1;
        }

        for (int i = 0; i < gdp.length; i++) {

            int firstMonth = gdp[i];
            int nextMonth = 0;

            if (i + 1 < gdp.length) {
                nextMonth = gdp[i + 1];
            }

            if (Math.abs(firstMonth - nextMonth) <= 1) {

                counter++;

            }

        }

        return counter;
    }
}