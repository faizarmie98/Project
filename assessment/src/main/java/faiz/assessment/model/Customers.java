package faiz.assessment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "phone_num", nullable = false)
    private long phoneNum;
    @Column(name = "personal_email", nullable = false)
    private String personalEmailId;
    @Column(name = "office_email", nullable = false)
    private String officeEmailId;
    @Column(name = "family_members", nullable = false)
    private String familyMembers;

    public Customers() {

    }

    public Customers(String firstName, String lastName, String gender, int age, long phoneNum,
    String personalEmailId, String officeEmailId, String familyMembers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phoneNum = phoneNum;
        this.personalEmailId = personalEmailId;
        this.officeEmailId = officeEmailId;
        this.familyMembers = familyMembers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPersonalEmailId() {
        return personalEmailId;
    }

    public void setPersonalEmailId(String personalEmailId) {
        this.personalEmailId = personalEmailId;
    }

    public String getOfficeEmailId() {
        return officeEmailId;
    }

    public void setOfficeEmailId(String officeEmailId) {
        this.officeEmailId = officeEmailId;
    }

    public String getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(String familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public String toString() {
        return "Customer [id= " + id + 
            ", firstName= " + firstName + 
            ", lastName= " + lastName + 
            ", gender= " + gender + 
            ", age= " + age +
            ", phoneNum= " + phoneNum + 
            ", personalEmail= " + personalEmailId + 
            ", officeEmail= " + officeEmailId + 
            ", familyMembers= " + familyMembers +  
            "]";
    }

}