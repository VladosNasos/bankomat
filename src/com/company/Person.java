package com.company;

import java.util.Scanner;

public class Person {
    private String fullName;
    private String birthDate;
    private String phoneNumber;
    private String city;
    private String country;
    private String homeAddress;

    // Метод для ввода данных
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО: ");
        this.fullName = scanner.nextLine();

        System.out.print("Введите дату рождения (dd/mm/yyyy): ");
        this.birthDate = scanner.nextLine();

        System.out.print("Введите контактный телефон: ");
        this.phoneNumber = scanner.nextLine();

        System.out.print("Введите город: ");
        this.city = scanner.nextLine();

        System.out.print("Введите страну: ");
        this.country = scanner.nextLine();

        System.out.print("Введите домашний адрес: ");
        this.homeAddress = scanner.nextLine();
    }

    // Метод для вывода данных
    public void printData() {
        System.out.println("ФИО: " + this.fullName);
        System.out.println("Дата рождения: " + this.birthDate);
        System.out.println("Контактный телефон: " + this.phoneNumber);
        System.out.println("Город: " + this.city);
        System.out.println("Страна: " + this.country);
        System.out.println("Домашний адрес: " + this.homeAddress);
    }

    // Методы доступа к отдельным полям

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
