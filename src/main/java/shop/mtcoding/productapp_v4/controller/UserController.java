package shop.mtcoding.productapp_v4.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.productapp_v4.dto.user.AdminLoginDto;
import shop.mtcoding.productapp_v4.dto.user.LoginDto;
import shop.mtcoding.productapp_v4.model.user.User;
import shop.mtcoding.productapp_v4.model.user.UserRepository;

@Controller
public class UserController {
    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository userRepository;
    
    //관리자 로그인
    @GetMapping("/adminLoginForm")
    public String adminLoginForm() {
        return "user/adminLoginForm";
    }

    @PostMapping("/adminLogin")
    public String adminLogin(AdminLoginDto adminLoginDto) {
  
        User userPS = userRepository.adminLogin(adminLoginDto);

        if (userPS != null && userPS.getRole().equals("ADMIN")) {

            session.setAttribute("principal", userPS);

            System.out.println("adminName : " + userPS.getUserName());
            System.out.println("adminPassword : " + userPS.getUserPassword());
            System.out.println("admin 로그인 성공");

            return "redirect:/product";
        }
        // 로그인 실패 시
        return "redirect:/adminLoginForm";

    }

    
    //로그아웃
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/product";
	}

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    // 구매자 로그인
    @PostMapping("/login")
    public String login(LoginDto loginDto) {
        User userPS = userRepository.login(loginDto);
        if (userPS != null ) {
            session.setAttribute("principal", userPS);
            System.out.println(loginDto.getUserName());
            return "redirect:/";
        } else {

            System.out.println("user 로그인 실패");
            return "redirect:/loginForm";
        }
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }
}