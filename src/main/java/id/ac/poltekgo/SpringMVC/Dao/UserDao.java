package id.ac.poltekgo.SpringMVC.Dao;

// import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.poltekgo.SpringMVC.Entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
