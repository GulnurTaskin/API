package pojos;

public class PojoDummyData {

    /* "data":{
           "id":3,
           "employee_name":"Ashton Cox",
           "employee_salary":86000,
           "employee_age":66,
           "profile_image":""
           }       */

    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profil_image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfil_image() {
        return profil_image;
    }

    public void setProfil_image(String profil_image) {
        this.profil_image = profil_image;
    }

    public PojoDummyData(int id, String employee_name, int employee_salary, int employee_age, String profil_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profil_image = profil_image;
    }

    public PojoDummyData() {
    }

    @Override
    public String toString() {
        return "PojoDummyData{" +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_age=" + employee_age +
                ", profil_image='" + profil_image + '\'' +
                '}';
    }
}
