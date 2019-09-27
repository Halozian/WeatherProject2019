// Page Object to Retrieve, Store and Print Weather News 24 Forecast Data

package Expleo.pageObjects;

public class WeatherNews24PageObject {
    private int[] maxTemp = new int[5];
    private int[] minTemp = new int[5];

    public void addMaxTemp(int index, int maxTemp) {
        this.maxTemp[index] = maxTemp;
    }

    public void addMinTemp(int index, int minTemp) {
        this.minTemp[index] = minTemp;
    }

    public int getMaxTemp(int index) {
        return this.maxTemp[index];
    }

    public int getMinTemp(int index) {
        return this.minTemp[index];
    }

    public void printBoth() {
        for (int i = 0; i < 5; i++)
            System.out.println("Day " + (i+1) + "\t\tMax: " + maxTemp[i] + " °C\t\tMin: " + minTemp[i] + " °C");
    }
}