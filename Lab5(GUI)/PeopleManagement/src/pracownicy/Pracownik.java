package pracownicy;

import javafx.scene.image.Image;

public class Pracownik {
    private Image img;
    private String name;
    private String surname;
    private String fullname;
    private String town;
    private String adress;
    private String phoneNumber;
    private Integer age;
    private Double salary;
    public Pracownik(Image img_toSet,String name_toSet, String surname_toSet, String town_toSet, String adress_toSet, String phoneNumber_toSet, Integer age_toSet, Double salary_toSet){
        img= img_toSet;
        name= name_toSet;
        surname= surname_toSet;
        fullname = name +" "+ surname;
        town = town_toSet;
        adress = adress_toSet;
        phoneNumber= phoneNumber_toSet;
        age = age_toSet;
        salary = salary_toSet;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary){
        this.salary = salary;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
