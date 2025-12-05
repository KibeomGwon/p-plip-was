package com.pplip.domain.trip.attraction.persistence.dao;

import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("SidoGugunDao 테스트")
class SidoGugunDaoTest {

    @Autowired
    private SidoGugunDao sidoGugunDao;

    @Test
    @DisplayName("성공: 모든 지역 정보 조회")
    void findAllRegion_Success() {
        // Given & When
        List<AttractionResponse.Region> regions = assertDoesNotThrow(() -> sidoGugunDao.findAllRegion());

        // Then
        assertNotNull(regions);
    }

    @Test
    @DisplayName("성공: 모든 시도 정보 조회")
    void findAllSido_Success() {
        // Given & When
        List<AttractionResponse.Sido> sidos = assertDoesNotThrow(() -> sidoGugunDao.findAllSido());

        // Then
        assertNotNull(sidos);
    }

    @Test
    @DisplayName("성공: 모든 구군 정보 조회")
    void findAllGugun_Success() {
        // Given & When
        List<AttractionResponse.Gugun> guguns = assertDoesNotThrow(() -> sidoGugunDao.findAllGugun());

        // Then
        assertNotNull(guguns);
    }

    @Test
    @DisplayName("성공: 특정 시도의 구군 정보 조회")
    void findAllGugunInSido_Success() {
        // Given
        Long sidoCode = 1L; // Assuming 1 is a valid sido_code (e.g., 서울)

        // When
        List<AttractionResponse.Gugun> guguns = assertDoesNotThrow(() -> sidoGugunDao.findAllGugunInSido(sidoCode));

        // Then
        assertNotNull(guguns);
    }

    @Test
    @DisplayName("엣지 케이스: 존재하지 않는 시도 코드로 구군 정보 조회")
    void findAllGugunInSido_Fail_WhenSidoCodeNotFound() {
        // Given
        Long nonExistentSidoCode = 9999L;

        // When
        List<AttractionResponse.Gugun> guguns = assertDoesNotThrow(() -> sidoGugunDao.findAllGugunInSido(nonExistentSidoCode));

        // Then
        assertNotNull(guguns);
        assertThat(guguns).isEmpty();
    }
}
