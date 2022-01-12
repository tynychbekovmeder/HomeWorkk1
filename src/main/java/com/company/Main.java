package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH1 = Paths.get("./autoBase1.json");
    public static final Path WRITE_PATH2 = Paths.get("./autoBase2.json");


    public static void main(String[] args) throws IOException {

        Car[] car = {
                new Car(1, "BMW", "", State.BASE),
                new Car(2, "GT-63", "", State.BASE),
                new Car(3, "HURACAN", "", State.BASE)
        };
        Driver[] driver = {
                new Driver("driver-1", "Michael"),
                new Driver("driver-2", "Sucre"),
                new Driver("driver-3", "Abruzzi")
        };
        String gson = GSON.toJson(car);
        writeJson(gson, WRITE_PATH1);
        String gson1 = GSON.toJson(driver);
        writeJson(gson1, WRITE_PATH2);
        Car.parsing();
        Driver.parsing();
    }

    static void writeJson(String object1, Path WRITE_PATH) {
        try {
            Files.writeString(WRITE_PATH, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
