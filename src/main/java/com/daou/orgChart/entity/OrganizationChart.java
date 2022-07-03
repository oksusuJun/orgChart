package com.daou.orgChart.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity(name="TEST_DEPARTMENT")
@DynamicInsert
public class OrganizationChart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dep_cd;

    @Column(length=100, insertable=true)
    private String dep_nm;

    @Column(length=10, insertable=true)
    private String upp_dep;

    public OrganizationChart(String dep_cd, String dep_nm, String upp_dep) {
        this.dep_cd = dep_cd;
        this.dep_nm = dep_nm;
        this.upp_dep = upp_dep;
    }
}
