public class LongestStabilityPeriod {


    public int count(int[] gdp) {

        int maxPeriod = 0;

        for (int i = 0; i < gdp.length; i++) {

            int counter = 0;
            int minGdp = gdp[i];
            int maxGdp = gdp[i];

            for (int j = i; j < gdp.length; j++) {

                if (gdp[j] < minGdp) { minGdp = gdp[j]; }
                if (gdp[j] > maxGdp) { maxGdp = gdp[j]; }

                int diff = Math.abs(gdp[i] - gdp[j]);
                int diffMin = Math.abs(minGdp - gdp[j]);
                int diffMax = Math.abs(maxGdp - gdp[j]);

                if (diff <= 1 && diffMin <= 1 && diffMax <= 1) {

                    counter++;

                } else {

                    break;

                }

                if (counter > maxPeriod) { maxPeriod = counter; }

            }


        }

        return maxPeriod;
    }
}