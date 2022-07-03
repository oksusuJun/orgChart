package com.daou.orgChart.entity;

import com.daou.orgChart.fixture.OrgChartFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
public class ChartRepositoryTests {
    @Autowired
    private ChartRepository chartRepository;

    @BeforeEach
    void setUp() {
        chartRepository.saveAll(
                Arrays.asList(OrgChartFixture.CHART1, OrgChartFixture.CHART2, OrgChartFixture.CHART3)
        );
    }

    @Test
    @DisplayName("OrganizationChart를 저장하면 저장된다.")
    void save() {
        final OrganizationChart chart = chartRepository.save(new OrganizationChart(  "dev", "abc"));
        assertAll(() -> {
            assertThat(chart.getDep_nm()).isEqualTo("dev");
            assertThat(chart.getUpp_dep()).isEqualTo("abc");
        });
    }

    @Test
    @DisplayName("3개가 등록된 OrganizationChart 조회하면 3개가 조회된다.")
    void list() {
        List<OrganizationChart> organizationCharts = chartRepository.findAll();
        assertThat(organizationCharts.size()).isEqualTo(3);
    }
}