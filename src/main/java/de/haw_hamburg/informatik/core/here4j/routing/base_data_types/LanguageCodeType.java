package de.haw_hamburg.informatik.core.here4j.routing.base_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * This type is used whenever a language of a value needs to be referenced.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageCodeType {

    private String code;

    public LanguageCodeType() {
    }

    public LanguageCodeType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LanguageCodeType{" +
                "code='" + code + '\'' +
                '}';
    }
}
