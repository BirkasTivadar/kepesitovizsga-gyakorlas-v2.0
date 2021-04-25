package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Eggs {


    public Rabbit getRabbitWithMaxEggs() {

        String name = null;
        int max = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Eggs.class.getResourceAsStream("/eggs.csv")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int temp = Integer.parseInt(line.split(";")[1]);
                if (temp > max) {
                    name = line.split(";")[0];
                    max = temp;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return new Rabbit(name, max);
    }
}
