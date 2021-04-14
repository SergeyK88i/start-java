package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Person
{
    protected String surName;
    protected String givenName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Ardess adress;

    public String getPersonString() {
        return surName + " "+ givenName;
    }

    public Ardess getAdress() {
        return adress;
    }

    public void setAdress(Ardess adress) {
        this.adress = adress;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
