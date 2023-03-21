package com.example.study.controller;

import com.example.study.entity.Board;
import com.example.study.entity.User;
import com.example.study.repository.UserRepository;
import com.example.study.service.BoardImgServiceImpl;
import com.example.study.service.BoardServiceImpl;
import com.example.study.service.UserImgServiceImpl;
import com.example.study.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;

@RequiredArgsConstructor
@Controller
public class MyController {

    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;
    private final UserImgServiceImpl userImgServiceImpl;
    private final BoardServiceImpl boardServiceImpl;
    private final BoardImgServiceImpl boardImgServiceImpl;

    @Value("${file.dir.userImg}")
    private String userImgDir;

    //메인 페이지
    @GetMapping("/")
    public String main(){
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
        session.removeAttribute("user");
        return "redirect:/";
    }

    //회원가입 페이지
    @GetMapping("/join")
    public String joinPage() {
        return "view/join";
    }

    //회원가입
    @PostMapping("/joinUser")
        public String join(@RequestParam(value = "userNickname") String userNickname, @RequestParam(value = "userId") String userId, @RequestParam(value = "userPw") String userPw, @RequestParam(value = "userEmail") String userEmail){
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
    public String mypage() {
        return "view/mypage";
    }

    //개인정보 수정페이지
    @GetMapping("/myAccount")
    public String myAccount(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        String userImg = userImgServiceImpl.userImgSearch(userId);

        model.addAttribute("user",user);
        model.addAttribute("userImg", userImg);
        return "view/myAccount";
    }

    //이미지 수정 적용
    @GetMapping("myAccount.do")
    public String toMyAccount(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        String userImg = userImgServiceImpl.userImgSearch(userId);
        model.addAttribute("userImg", userImg);
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
        return "fragments/imageUpload";
    }

    //프로필 이미지 수정
    @PostMapping("userImg.do")
    @ResponseBody
    public int imgUpload(HttpSession session, MultipartFile[] imgs,Model model) throws IOException {
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        int data = userImgServiceImpl.userImg(imgs, userId);
        if (data == 1)  {
            String userImg = userImgServiceImpl.userImgSearch(userId);
            model.addAttribute("userImg", userImg);
        }
        return data;
    }

    //프로필 이미지 삭제
    @PostMapping("userImgDel.do")
    @ResponseBody
    public void imgDelete(HttpSession session) {
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        userImgServiceImpl.userImgDelete(userId);
    }

    //프로필 이미지 출력
    @GetMapping("/profile/123")
    @ResponseBody
    public Resource viewProfileImg(HttpSession session) throws IOException{
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        String path = userImgServiceImpl.userImgSearch(userId);
        UrlResource urlResource = new UrlResource("file:" + path);
        return urlResource;
    }

    //중고거래 게시판
    @GetMapping("/TdBoard")
    public String tdboard() {
        return "view/TdBoard";
    }

    //물건 등록 페이지
    @GetMapping("/sellItem")
    public String sellitem() {
        return "view/sellItem";
    }

    //물건 등록
    @PostMapping("/sellItem")
    public String sellItem(Board board, MultipartFile[] imgs, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        boardServiceImpl.insertBd(board, userId);

        //boardImgServiceImpl.insertBdImg(imgs, )

        return "";
    }

} // Class
