package com.example.jobPortal.Config;

import com.example.jobPortal.utils.CompanyType;
import com.example.jobPortal.utils.Education;
import com.example.jobPortal.utils.Industry;
import com.example.jobPortal.utils.WorkMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, WorkMode>() {
            @Override
            public WorkMode convert(String source) {
                if(source == null) {
                return null;
                }
                for(WorkMode v : WorkMode.values()) {
                    if(source.equals(v.getLabel())) {
                        return v;
                    }
                }
                throw new RuntimeException("Enum value misMatch");
            }
        });

        registry.addConverter(new Converter<String, CompanyType>() {
            @Override
            public CompanyType convert(String source) {
                if(source == null) {
                    return null;
                }
                for(CompanyType v : CompanyType.values()) {
                    if(source.equals(v.getLabel())) {
                        return v;
                    }
                }
                throw new RuntimeException("Enum value misMatch");
            }
        });

        registry.addConverter(new Converter<String, Education>() {
            @Override
            public Education convert(String source) {
                if(source == null) {
                    return null;
                }
                for(Education v : Education.values()) {
                    if(source.equals(v.getLabel())) {
                        return v;
                    }
                }
                throw new RuntimeException("Enum value misMatch");
            }
        });

        registry.addConverter(new Converter<String, Industry>() {
            @Override
            public Industry convert(String source) {
                if(source == null) {
                    return null;
                }
                for(Industry v : Industry.values()) {
                    if(source.equals(v.getLabel())) {
                        return v;
                    }
                }
                throw new RuntimeException("Enum value misMatch");
            }
        });


    }
}
