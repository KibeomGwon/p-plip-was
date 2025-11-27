package com.pplip.global.docs;


import com.pplip.domain.member.api.request.MemberRequest;
import com.pplip.domain.member.api.response.MemberResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * 회원 관련 API 명세를 정의하는 인터페이스
 */
@Tag(name = "User API", description = "사용자 API, 마이페이지, 회원가입 등")
public interface MemberDocsController {

    /**
     * 이메일 중복 여부를 확인합니다.
     *
     * @param nickname 확인할 닉네임
     * @return 중복 확인 결과
     */
    CommonResponse<MemberResponse.DupCheck> emailDupCheck(String nickname);

    /**
     * 회원가입을 처리합니다.
     *
     * @param join 회원가입 요청 정보
     * @return 처리 결과
     */
    public CommonResponse<Void> join(MemberRequest.Join join);

    /**
     * 인증 이메일을 발송합니다.
     *
     * @param email 이메일 발송 요청 정보
     * @return 처리 결과
     */
    public CommonResponse<Void> sendVerificationEmail(MemberRequest.Email email);

    /**
     * 이메일 인증을 확인합니다.
     *
     * @param email 이메일 인증 요청 정보
     * @return 인증 확인 결과
     */
    public CommonResponse<MemberResponse.EmailCheck> verificationEmail(MemberRequest.Email email);

}
