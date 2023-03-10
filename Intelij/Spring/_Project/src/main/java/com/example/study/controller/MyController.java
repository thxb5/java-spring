package com.example.study.controller;

import com.example.study.entity.User;
import com.example.study.entity.UserImg;
import com.example.study.repository.UserRepository;
import com.example.study.service.UserImgService;
import com.example.study.service.UserImgServiceImpl;
import com.example.study.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MyController {

    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;
    private final UserImgServiceImpl userImgServiceImpl;

    //채널 메인
    @GetMapping("/")
    public String header(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "view/main";
    }

    //로그인 처리
    @PostMapping("logincheck.do")
    @ResponseBody
    public User logincheck(@RequestParam("userId")String userId, @RequestParam("userPw")String userPw, HttpSession session) {
        User user = userServiceImpl.loginCheck2(userId,userPw);
        if(user!=null) {
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60 * 10);
        }
        return user;
    }

    //로그아웃 처리
    @RequestMapping("logout.do")
    public String logout(HttpSession session) {
        session.setAttribute("user",null);
        return "redirect:/";
    }

    //회원가입 페이지
    @GetMapping("/join")
    public String joinPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "view/join";
    }

    //회원가입
    @PostMapping("/joinUser")
        public String join(@RequestParam(value = "userNickname") String userNickname, @RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw, @RequestParam(value = "userEmail") String userEmail, HttpSession session, Model model){
            User user = (User) session.getAttribute("user");
            model.addAttribute("user",user);

            userRepository.save(User.builder().userId(userId).userPw(userPw).userNickname(userNickname).userEmail(userEmail).build());
        return "redirect:/";
    }

    //가입시 아이디 중복체크
    @PostMapping("joincheck.do")
    public @ResponseBody int joincheck3(@RequestParam("userid")String userid) {
        int result = userServiceImpl.joinCheck2(userid);
        return result;
    }

    //마이페이지
    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "view/mypage";
    }

    //개인정보 수정페이지
    @GetMapping("/myAccount")
    public String myAccount(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "view/myAccount";
    }

    //개인정보 수정
    @PostMapping("userUpdate.do")
    public String userUpdate(User user, HttpSession session) {
        userServiceImpl.userModify(user);
        User user2 = userServiceImpl.userInfo(user);
        session.setAttribute("user",user2);
        return "redirect:/myAccount";
    }

    //프로필 이미지 수정페이지
    @GetMapping("/userImage")
    public String userImage() {
        return "view/imageUpload";
    }

    //프로필 이미지 수정
    @PostMapping("/userImg")
    public String imgUpload(HttpSession session, MultipartFile[] imgs) throws IOException {
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        int resultImg = userImgServiceImpl.userImg(imgs, userId);
        String result;

        if(resultImg == 1) {
            result = "성공";
        } else {
            result = "실패";
        }

        System.out.println("result = " + result);
        
//        String ogUserFileName = file.getOriginalFilename();
//        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/upload";
//        User user = (User) session.getAttribute("user");
//        String user_id = user.getUserId();
//        String random = ""+Math.random();
//
//        String lastName = projectPath + "/" + random + file.getOriginalFilename();
//        String imgPath = "./upload/";
//        String realName = imgPath + random + ogUserFileName;
//
//        File dest = new File(lastName);
//        System.out.println("dest = " + dest);
//        file.transferTo(dest);
//
//        user.setUserProfimg();

        return result;
    }


} // Class
