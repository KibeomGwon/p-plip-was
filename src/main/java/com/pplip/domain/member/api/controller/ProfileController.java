package com.pplip.domain.member.api.controller;

import com.pplip.domain.member.api.request.ProfileRequest;
import com.pplip.domain.member.api.response.MemberResponse;
import com.pplip.domain.member.api.response.ProfileResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/profile")
@RequiredArgsConstructor
public class ProfileController {

    /**
     * @Param nickname 변경할 닉네임
     * @return 변경된 닉네임
     */
    @PatchMapping("/nickname")
    public CommonResponse<ProfileResponse.ModifyNickName> modifyNickname(@RequestParam String nickname,
                                                                         @AuthenticationPrincipal UserDetails principal){
        return CommonResponse.success(SuccessCode.UPDATED, null);
    }

    /**
     * 프로파일 이미지 수정 완료 시 success code 응답. 실패시 error code. 실패 경우 : 이미지 업로드 실패
     *
     * @param image
     * @param principal
     * @return 이미지 파일 경로.
     */
    @PatchMapping("/image")
    public CommonResponse<ProfileResponse.ImageUrl> modifyProfileImage(@RequestBody ProfileRequest.Image image,
                                                                   @AuthenticationPrincipal UserDetails principal) {
        return CommonResponse.success(SuccessCode.UPDATED, null);
    }
}
