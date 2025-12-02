package com.pplip.domain.user.cache;

/**
 * 이메일 유효성 검사를 위한 계약을 정의하는 인터페이스
 */
public interface EmailValidator {
    /**
     * 주어진 이메일 주소의 유효성을 검사합니다.
     *
     * @param email 검사할 이메일 주소
     * @return 이메일이 유효하면 true, 그렇지 않으면 false
     */
    boolean valid (String email);
}
