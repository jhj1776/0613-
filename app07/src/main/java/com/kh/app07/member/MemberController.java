package com.kh.app07.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 회원가입
     */
    @GetMapping("join")
    public void join() {
    }

    /**
     * 마이페이지
     */

    @GetMapping("mypage")
    public String mypage(HttpSession session) {
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        if (loginMember != null) {
            return "member/mypage";
        } else {
            return "member/login";
        }

    }

    /**
     * 로그인 화면
     */
    @GetMapping("login")
    public void login() {
    }

    /**
     * 회원가입 기능
     */
    @PostMapping("join")
    public String join(MemberVo vo) {
        int result = memberService.join(vo);
        System.out.println(result);
        if (result != 1) {
            throw new IllegalStateException("[Member-001] 회원가입 문제");
        }

        return "redirect:/member/login";
    }

    /**
     * 로그인 기능
     */


    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session) {
        MemberVo loginMember = memberService.login(vo);
        if(loginMember == null){
            session.setAttribute("alertMsg","logun fail ...");
        }else{
        session.setAttribute("loginMember", loginMember);
        }
        return "redirect:/home";
    }

    /**
     * 로그아웃
     */

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    @GetMapping("quit")
    public String quit(HttpSession session) {
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        int result = memberService.quit(loginMember);
        session.invalidate();
        if (result != 1) {
            throw new IllegalStateException("[MEMBER-002] QUIT ERROR");
        }
        return "redirect:/home";
    }

    @GetMapping("update")
    public void update(MemberVo vo) {
        int result = memberService.update(vo);

    }


}
