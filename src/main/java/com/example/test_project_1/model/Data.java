package com.example.test_project_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Getter
@Setter
@NoArgsConstructor
@XmlType
@XmlRootElement(name = "Data")
@JsonTypeName("Data")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class Data {

    private Method method;
    private Process process;
    private String layer;
    private EpochAndDateTime creation;
    private String type;

    @XmlElement(name = "Method")
    @JsonProperty("Method")
    public Method getMethod() {
        return method;
    }

    @XmlElement(name = "Process")
    @JsonProperty("Process")
    public Process getProcess() {
        return process;
    }

    @XmlElement(name = "Layer")
    @JsonProperty("Layer")
    public String getLayer() {
        return layer;
    }

    @XmlElement(name = "Creation")
    @JsonProperty("Creation")
    public EpochAndDateTime getCreation() {
        return creation;
    }

    @XmlElement(name = "Type")
    @JsonProperty("Type")
    public String getType() {
        return type;
    }
}
