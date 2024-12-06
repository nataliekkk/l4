package com.yutube;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
//Абстрактный класс булка
abstract class Bulka {
    protected double price;
    protected List<String> ingredients;
    protected LocalDateTime creationDate;

    public Bulka(double price) {
        this.price = price;
        this.ingredients = new ArrayList<>();
        this.creationDate = LocalDateTime.now();
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (Цена: " + price + ", Ингредиенты: " + ingredients + ")";
    }
}

class WhiteBulka extends Bulka {
    public WhiteBulka(double price) {
        super(price);
    }
}

class RyeBulka extends Bulka {
    public RyeBulka(double price) {
        super(price);
    }
}

class WholeGrainBulka extends Bulka {
    public WholeGrainBulka(double price) {
        super(price);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Bulka> bulkas = new ArrayList<>();
        
        // Создание объектов булок
        WhiteBulka whiteBulka = new WhiteBulka(2.5);
        whiteBulka.addIngredient("Мука");
        whiteBulka.addIngredient("Соль");
        whiteBulka.creationDate = LocalDateTime.now().minusMinutes(2);
        bulkas.add(whiteBulka);
        
        RyeBulka ryeBulka = new RyeBulka(3.0);
        ryeBulka.addIngredient("Ржаная мука");
        ryeBulka.addIngredient("Сахар");
        ryeBulka.creationDate = LocalDateTime.now().minusMinutes(7);
        bulkas.add(ryeBulka);
        
        WholeGrainBulka wholeGrainBulka = new WholeGrainBulka(3.5);
        wholeGrainBulka.addIngredient("Цельнозерновая мука");
        wholeGrainBulka.addIngredient("Перец");
        wholeGrainBulka.creationDate = LocalDateTime.now().minusMinutes(4);
        bulkas.add(wholeGrainBulka);
        
        // Создание дополнительных булок
        String[] ingr = new  String[]{"Перец", "Цельнозерновая мука", "Дрожжи", "Мак", "Перец", "Яйцо", "Сахар"};
        for (int i = 0; i < 7; i++) {
            WhiteBulka tempBulka = new WhiteBulka(2.5 + i);
            tempBulka.addIngredient("Ингредиент " + ingr[i]);
            tempBulka.creationDate = LocalDateTime.now().minusMinutes(3+i);
            bulkas.add(tempBulka);
            //System.out.println(tempBulka);
            //System.out.println("");
        }
        WhiteBulka oldBulka = new WhiteBulka(2.5);
        oldBulka.addIngredient("Дрожжи");
        oldBulka.creationDate = LocalDateTime.now().minusMinutes(6);
        bulkas.add(oldBulka);

        RyeBulka ryeBulka2 = new RyeBulka(3.0);
        ryeBulka2.addIngredient("Мак");
        ryeBulka2.addIngredient("Яйцо");
        oldBulka.creationDate = LocalDateTime.now().minusMinutes(10);
        bulkas.add(ryeBulka2);

        // Вывод булок, созданных 5 мин. назад
        System.out.println("Булки, созданные 5 минут назад:");
        for (Bulka bulka : bulkas) {
            if (ChronoUnit.MINUTES.between(bulka.getCreationDate(), LocalDateTime.now()) >= 5) {
                System.out.println(bulka);
            }
        }
        
        // Вывод булок с перцем
        System.out.println("\nБулки, содержащие перец:");
        for (Bulka bulka : bulkas) {
            if (bulka.toString().contains("Перец")) {
                System.out.println(bulka);
            }
        }
    }
}