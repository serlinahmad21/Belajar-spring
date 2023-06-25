package id.ac.poltekgo.SpringMVC.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.poltekgo.SpringMVC.Dao.UserDao;
import id.ac.poltekgo.SpringMVC.Entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/daftar")
    User Register(@RequestBody User serlin) {
        return userDao.save(serlin);
    }

    @GetMapping("/lin")
    List<User> Getdata() {
        return userDao.findAll();
    }

    @GetMapping("/nan/{id}")
    Optional<User> Getid(@PathVariable Integer id) {
        return userDao.findById(id);
    }

    @DeleteMapping("/hapus/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id) {
        userDao.deleteById(id);
        Map<String, Boolean> respone = new HashMap<>();
        respone.put("delete", Boolean.TRUE);
        return respone;
    }

    @PutMapping("/edit/{id}")
    Optional<Object> editUser(@RequestBody User newUser, @PathVariable Integer id) {
        return userDao.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            return userDao.save(user);
        });
    }

}
