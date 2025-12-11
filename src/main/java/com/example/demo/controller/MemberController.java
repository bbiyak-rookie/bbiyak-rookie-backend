package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;

    @GetMapping("/member/create")
    public String createForm(){
        return "create";
    }

    @PostMapping("/member/create")  //@ModelAttribute HTML에서 입력한 데이터를 DTO에 넣어준다
    public String create(@ModelAttribute MemberDTO memberDTO)                   //Requestparam사용시
                                                                                 /*(@RequestParam("memberEmail")String memberEmail,
                                                                                    @RequestParam("memberPassword")String memberPassword,
                                                                                    @RequestParam("memberName")String memberName)
                                                                                    System.out.println("memberEmail = " + memberEmail + ", memberPassword = " + memberPassword + ", memberName = " + memberName);
                                                                                    */
    {
        System.out.println("memberCOntrollor.create");
        System.out.println("memberDTO:"+memberDTO);
        memberService.save(memberDTO);
        return "index";
    }

    @GetMapping("/member/login")
    public String login(){
        return "login";
    }

    @PostMapping("member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult!=null){
            //login 성공\
            session.setAttribute("loginEmail",loginResult.getMemberEmail());
            return "main";
        }else {
            //login 실패
            return " login";


        }
    }
}

