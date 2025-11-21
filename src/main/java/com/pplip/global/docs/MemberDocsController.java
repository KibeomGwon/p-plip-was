package com.pplip.global.docs;


import com.pplip.domain.member.api.request.MemberRequest;
import com.pplip.domain.member.api.response.MemberResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User API", description = "사용자 API, 마이페이지, 회원가입 등")
public interface MemberDocsController {


    CommonResponse<MemberResponse.DupCheck> emailDupCheck(String nickname);

    public CommonResponse<Void> join(MemberRequest.Join join);

    public CommonResponse<Void> sendVerificationEmail(MemberRequest.Email email);

    public CommonResponse<MemberResponse.EmailCheck> verificationEmail(MemberRequest.Email email);

}
