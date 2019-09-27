// Page Object to Store and Print Accuweather Forecast

package Expleo.pageObjects;

public class AccuweatherPageObject {
    private int[] maxTemp = new int[5];
    private int[] minTemp = new int[5];

    public void addMaxTemp(int index, int maxTemp) {
        this.maxTemp[index] = maxTemp;
    }

    public void addMinTemp(int index, int minTemp) {
        this.minTemp[index] = minTemp;
    }

    public void printBoth() {
        for (int i = 0; i < 5; i++)
            System.out.println("Accuweather Day " + (i+1) + " Max: " + maxTemp[i] + " °C\t\tMin: " + minTemp[i] + " °C");
    }
}
