package shop.mtcoding.productapp_v4.dto.user;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.productapp_v4.model.user.User;

@Getter
@Setter
public class JoinDto {
    private String userName;
    private String userPassword;
    private String userEmail;

    public User toEntity() {
        return new User(this.userName, this.userPassword, this.userEmail, "user");
    }
}
