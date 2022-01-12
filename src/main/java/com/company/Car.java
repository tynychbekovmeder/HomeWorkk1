package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Car {
    private int id;
    private String name;
    private String driver;
    private State state;
    private Driver driverObject;

    public Car(int id, String name, String driver, State state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public Driver getDriverObject() {
        return driverObject;
    }

    public void setDriverObject(Driver driverObject) {
        this.driverObject = driverObject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return
                "id:" + id +
                        "name:" + name + '\'' +
                        "driver:" + driver + '\'' +
                        "state:" + state;
    }

    public static void parsing() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(
                "C:\\Users\\User\\IdeaProjects\\HomeWork1\\autoBase1.json")));
        Scanner scanner = new Scanner(System.in);
        System.out.println("о какой машине хотите получить информацию?");
        int choose = scanner.nextInt();
        JSONArray jsonArray = new JSONArray(data);
        Car []array= new Car[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            String string = jsonArray.get(i).toString();
            JSONObject jsonObject2 = new JSONObject(string);
            int id = jsonObject2.getInt("id");
            String name = jsonObject2.getString("name");
            String driver1 = jsonObject2.getString("driver");
            String state = jsonObject2.getString("state");

            if (choose==id) {
                System.out.println("-----CAR'S INFO-------------");
                System.out.println("ID:" + id);
                System.out.println("NAME:" + name);
                System.out.println("DRIVER:"+driver1);
                System.out.println("STATE:"+ state);
           }
        }
    }
}
