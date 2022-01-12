package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Driver {

    String id;
    String name;

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "id:" + id + '\'' +
                "name:" + name + '\'';
    }

    public static void parsing() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\HomeWork1\\autoBase2.json")));
        JSONArray jsonArray = new JSONArray(data);
        System.out.println("--------DRIVER'S INFO----------");

        for (int i = 0; i < jsonArray.length(); i++) {
            String string = jsonArray.get(i).toString();
            JSONObject jsonObject2 = new JSONObject(string);
            String id = jsonObject2.getString("id");
            String driver1 = jsonObject2.getString("name");
            Driver driver = new Driver(id, driver1);
            System.out.print(driver.getId()+" : ");
            System.out.print(driver.getName()+"\n");
        }
    }
}
