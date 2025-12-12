package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor //기본생성자 자동생성
//@AllArgsConstructor //필드를 모두 매개변수로하는 생성자 생성
@ToString
public class MemberDTO {
    private Long Id;
    private String memberEmail;
    private String memberName;
    private String memberPassword;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        return memberDTO;
    }
}
