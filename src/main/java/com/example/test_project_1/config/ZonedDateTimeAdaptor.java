package com.example.test_project_1.config;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;

@Component
public class ZonedDateTimeAdaptor extends XmlAdapter<String, ZonedDateTime> {

    @Override
    public ZonedDateTime unmarshal(String source) throws Exception {
        return ZonedDateTime.parse(source);
    }

    @Override
    public String marshal(ZonedDateTime zonedDateTime) throws Exception {
        return zonedDateTime.toString();
    }
}
