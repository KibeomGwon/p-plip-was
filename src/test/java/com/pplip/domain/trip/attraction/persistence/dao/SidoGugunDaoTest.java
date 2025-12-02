package com.pplip.domain.trip.attraction.persistence.dao;

import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SidoGugunDaoTest {

    @Autowired
    SidoGugunDao dao;

    @Test
    @DisplayName("find all sidogungu")
    void findAllSidogungu() {
        // given
        List<AttractionResponse.Gugun> allGugun = dao.findAllGugun();
        // when
        Assertions.assertThat(allGugun.size()).isEqualTo(0);
        // then
    }

    @Test
    @DisplayName("findAllRegion")
    void findAllRegion() {
        // when
        List<AttractionResponse.Region> allRegion = dao.findAllRegion();
        // then
        Assertions.assertThat(allRegion.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("findAllSido")
    void findAllSido() {
        // when
        List<AttractionResponse.Sido> allSido = dao.findAllSido();
        // then
        Assertions.assertThat(allSido.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("findOne")
    void findOne() {
        // when
        List<AttractionResponse.Gugun> allGugunInSido = dao.findAllGugunInSido(1L);
        // then
        Assertions.assertThat(allGugunInSido.size()).isEqualTo(0);
    }
}