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
public class Method {

    @XmlElement(name = "Name")
    @JsonProperty("Name")
    private String name;

    @XmlElement(name = "Type")
    @JsonProperty("Type")
    private String type;
    @XmlElement(name = "Assembly")
    @JsonProperty("Assembly")
    private String assembly;
}
