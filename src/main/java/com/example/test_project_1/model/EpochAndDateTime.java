package com.example.test_project_1.model;

import com.example.test_project_1.config.ZonedDateTimeAdaptor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class EpochAndDateTime {
    @XmlElement(name = "Epoch")
    @JsonProperty("Epoch")
    private String epoch;

    @XmlElement(name = "Date")
    @JsonProperty("Date")
    @XmlJavaTypeAdapter(ZonedDateTimeAdaptor.class)
    private ZonedDateTime date;
}
