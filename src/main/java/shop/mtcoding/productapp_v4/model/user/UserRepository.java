package shop.mtcoding.productapp_v4.model.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.mtcoding.productapp_v4.dto.user.JoinDto;
import shop.mtcoding.productapp_v4.dto.user.LoginDto;

@Mapper
public interface UserRepository {

    public void insert(JoinDto joinDto);

    public User findById(Integer userId);

    public User findByUsername(String userName);

    public User findByUsernameAndPassword(LoginDto loginDto);

    public List<User> findAll();

    public void update(User user);

    public void delete(Integer userId);
}