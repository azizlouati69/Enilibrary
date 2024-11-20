package enilibrary.EniLibrary.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
public  class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    private String fname;
    private String lname;
    private String password;
    private String email;
    private String adresse;
    private String username;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username, String email, String password, String adresse, String fname, String lname, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(Long iduser, String fname, String lname, String password, String confirmPassword, String email,
                String adresse, String username  ) {
        super();
        this.iduser = iduser;
        this.fname = fname;
        this.lname = lname;
        this.password = password;

        this.email = email;
        this.adresse = adresse;
        this.username = username;


    }


    public User() {
        super();
        // TODO Auto-generated constructor stub
    }









    @Override
    public String toString() {
        return "User [iduser=" + iduser + ", fname=" + fname + ", lname=" + lname + ", password=" + password
                + ", email=" + email + ", adresse=" + adresse + ", username="
                + username + ", role=" + role  + "]";
    }

}