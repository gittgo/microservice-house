package com.ruanmou.house.houseserver.Controller;

import com.ruanmou.house.housecommon.common.ApiResponse;
import com.ruanmou.house.houseserver.domain.User;
import com.ruanmou.house.houseserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: user-service
 * @Auther: GERRY
 * @Date: 2018/11/13 16:14
 * @Description:
 */
@Controller
@RequestMapping("accounts")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 到登录页面
     */
    @GetMapping("signin")
    public String signin() {
        return "accounts/signin";
    }

    /**
     * 注解界面
     */
    @GetMapping("register")
    public String register() {
        return "accounts/register";
    }

    /**
     * 记住密码
     */
    @GetMapping("remember")
    public String remember() {
        return "accounts/remember";
    }


    /**
     * 登录方法
     */
    @PostMapping("login")
    @ResponseBody
    public ApiResponse login(@RequestBody User user) {
        User loginUser = userService.login(user.getEmail(), user.getPassword());
        return ApiResponse.ofSuccess(loginUser);
    }

    /**
     * 鉴权
     */
    @GetMapping("get")
    @ResponseBody
    public ApiResponse get(String token) {
        User user = userService.getLoginUserByToken(token);
        return ApiResponse.ofSuccess(user);
    }

    @GetMapping("logout")
    @ResponseBody
    public ApiResponse logout(String token) {
        userService.logout(token);
        return ApiResponse.ofSuccess(null);
    }
}
