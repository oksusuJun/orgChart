package com.daou.orgChart.controller;

import com.daou.orgChart.entity.ChartRepository;
import com.daou.orgChart.entity.OrganizationChart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chart")
public class orgChartController {

    private final ChartRepository chartRepository;

    @GetMapping("list")
    public List<OrganizationChart> findAllDept() {
        return chartRepository.findAll();
    }

    @PostMapping("new")
    public OrganizationChart newContent() {
        final OrganizationChart org = OrganizationChart.builder()
                                        .dep_cd("TEST_01")
                                        .dep_nm("테스트01")
                                        .upp_dep("")
                                        .build();
        return chartRepository.save(org);
    }
}
