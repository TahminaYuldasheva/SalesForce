package dto;

public class Contact {

    private String salutation;
    private String firstName;
    private String lastName;
    private String phone;
    private String homePhone;
    private String title;
    private String department;
    private String mobile;
    private String fax;
    private String email;

    public Contact(String salutation, String firstName, String lastName, String phone, String homePhone, String title,
                   String department, String mobile, String fax,
                   String email) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.homePhone = homePhone;
        this.title = title;
        this.department = department;
        this.mobile = mobile;
        this.fax = fax;
        this.email = email;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
