package com.cocoa.bean.obj;

import java.util.List;
import java.util.Optional;

public class User {

    private int id;

    private String name;

    private int age;

    private int gender;

    private String phone;

    private List<Integer> interests;

    private List<Company> companies;

    private Organization organization;

    private Company company;

    public User() {
    }

    public User(int id, String name, int age, int gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getInterests() {
        return interests;
    }

    public void setInterests(List<Integer> interests) {
        this.interests = interests;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Optional<Organization> getOrganization() {
        return Optional.ofNullable(organization);
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
