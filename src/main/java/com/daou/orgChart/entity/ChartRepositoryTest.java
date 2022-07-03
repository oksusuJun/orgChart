package com.daou.orgChart.entity;

import com.daou.orgChart.OrgChartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrgChartApplication.class)
public class ChartRepositoryTest {

    @Autowired
    ChartRepository chartRepository;

    @Test
    public void postAdd() throws Exception {
        String dep_cd = "NEW_DEP";
        String dep_nm = "신규부서";
        String upp_dep = "";

        chartRepository.save(OrganizationChart.builder().dep_cd(dep_cd).dep_nm(dep_nm).upp_dep(upp_dep).build());

        List<OrganizationChart> list = chartRepository.findAll();
        OrganizationChart org = list.get(0);

        assertThat(org.getDep_cd()).isEqualTo(dep_cd);
        assertThat(org.getDep_nm()).isEqualTo(dep_nm);
        assertThat(org.getUpp_dep()).isEqualTo(upp_dep);
    }
}
