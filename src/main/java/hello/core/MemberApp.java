package hello.core;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import springbasic.core.member.Grade;
//import springbasic.core.member.Member;
//import springbasic.core.member.MemberService;
//import springbasic.core.member.MemberServiceImpl;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        MemberService memberService = ac.getBean("memberService", MemberService.class);

        MemberService memberService = new MemberServiceImpl();

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(memberA.getId());

        System.out.println("memberA = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
