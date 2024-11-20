
package enilibrary.EniLibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@Entity
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrole;


    private String  roletype;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();




    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }











    public Role(Long idrole, String roletype, Set<User> listusers) {
        super();
        this.idrole = idrole;
        this.roletype = roletype;

    }



    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }

    public String  getRolename() {
        return roletype;
    }

    public void setRolename(String rolename) {
        this.roletype = rolename;
    }

    @Override
    public String toString() {
        return "Role [idrole=" + idrole + ", rolename=" + roletype +   "]";
    }

    public String getName() {
        return roletype;
    }
    public void setName(String  rolename) {
        this.roletype = rolename;
    }


}



