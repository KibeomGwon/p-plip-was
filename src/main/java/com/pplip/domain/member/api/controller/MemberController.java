package com.pplip.domain.member.api.controller;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.member.api.request.MemberRequest;
import com.pplip.domain.member.api.response.MemberResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    /**
     * 성공시 isDuplicated Field가 false로 응답
     * 실패시 isDuplicated Field가 true로 응답
     * 실패 케이스 : 닉네임이 중복된 경우
     * @Param nickname 사용자 닉네임
     * @return 닉네임 중복 여부
     */
    @GetMapping("/join/nickname-dupcheck")
    public CommonResponse<MemberResponse.DupCheck> emailDupCheck(@RequestParam String nickname) {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

    /**
     * 회원가입 성공시 success code 응답
     * 실패시 error code 응답
     * 실패 케이스 : 이메일 인증을 하지 않은 경우, 필수 값을 입력하지 않은 경우
     * @Param join 사용자 정보
     * @return 생성 응답
     */
    @PostMapping("/join")
    public CommonResponse<Void> join(@RequestBody MemberRequest.Join join) {
        return CommonResponse.success(SuccessCode.CREATED, null);
    }

    /**
     * 이메일 인증코드 발송 성공시 success code 응답
     * 실패시 error code 응답
     * 실패 케이스 : 이미 가입된 이메일인 경우
     * @Param email 사용자 이메일
     * @return 생성 응답
     */
    @PostMapping("/join/send-verification-email")
    public CommonResponse<Void> sendVerificationEmail(@RequestBody MemberRequest.Email email) {
        return CommonResponse.success(SuccessCode.CREATED, null);
    }

    /**
     * 실패 케이스 : 이메일 인증코드 발급을 신청하지 않은 경우, 발급된 인증코드와 상이한 경우
     *
     * @Param email 사용자 이메일, 코드
     * @return 성공시 EmailCheck에 성공 메시지와 isSuccess Field가 true로 응답, 실패시 EmailCheck에 실패 메시지와 isSuccess Field가 false로 응답
     */
    @GetMapping("/join/verification-email")
    public CommonResponse<MemberResponse.EmailCheck> verificationEmail(@RequestBody MemberRequest.Email email) {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

    /**
     * @Param nickname 변경할 닉네임
     * @return 변경된 닉네임
     */
    @PatchMapping("/nickname")
    public CommonResponse<MemberResponse.ModifyNickName> modifyNickname(@RequestParam String nickname,
                                                                        @AuthenticationPrincipal UserDetails principal){
        return CommonResponse.success(SuccessCode.UPDATED, null);
    }

}
