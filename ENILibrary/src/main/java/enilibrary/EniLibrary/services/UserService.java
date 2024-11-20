package enilibrary.EniLibrary.services;


import enilibrary.EniLibrary.entities.User;
import enilibrary.EniLibrary.repositories.RoleRepository;
import enilibrary.EniLibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class    UserService  {


    @Autowired
    UserRepository userRep;

    @Autowired
    RoleRepository roleRep;







    public User addUser(User user) {
        // TODO Auto-generated method stub
        return userRep.save(user);
    }


    public List<User> addListUser(List<User> listuser) {
        // TODO Auto-generated method stub
        return userRep.saveAll(listuser);
    }



    public User updateUser(User user, Long iduser) {
        // TODO Auto-generated method stub

        User usr = userRep.findById(iduser).get();

        usr.setFname(user.getFname());
        usr.setLname(user.getLname());

        return userRep.save(usr);
    }


    public String deleteuser(Long iduser) {
        // TODO Auto-generated method stub

        String ch = "";

        userRep.deleteById(iduser);
        ch = "user successfuly deleted !!";
        return ch;
    }



    public List<User> getAllUsers() {
        List<User> users = userRep.findAll();
        return users;
    }


    public List<User> getListUsersStartWSC(String ch) {
        // TODO Auto-generated method stub
        return userRep.getUsersStartWSC(ch);
    }


    public User findByUsername(String username) {


// Utilisation de findByUsername qui renvoie un Optional<User>
        Optional<User> userOptional = userRep.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return userOptional.get();

            // Faire quelque chose avec l'utilisateur trouvé
        } else {
            return null;
        }


    }


    public User adduserRole(Long iduser, Long idrole) {
        // TODO Auto-generated method stub

        User user = userRep.findById(iduser).get();
            /*
        Role role = roleRep.findById(idrole).get();



        user.addRole(role);

             */
        return userRep.save(user);
    }


    public List<Long> listiduserfromidrole() {
        // TODO Auto-generated method stub
        return userRep.listiduserfromidrole();
    }


    public List<Long> listiduserfromidrole(Long idrole) {
        // TODO Auto-generated method stub
        return userRep.listiduserfromidrole(idrole);
    }


    public List<User> listuserfromidrole(Long idrole) {
        // TODO Auto-generated method stub
        return userRep.listuserfromidrole(idrole);
    }











    public long countUsers() {
        return userRep.count();
    }









}