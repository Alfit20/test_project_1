package com.example.test_project_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Process {

    @XmlElement(name = "Name")
    @JsonProperty("Name")
    private String name;
    @XmlElement(name = "Id")
    @JsonProperty("Id")
    private String id;
    @XmlElement(name = "Start")
    @JsonProperty("Start")
    private EpochAndDateTime start;

}
