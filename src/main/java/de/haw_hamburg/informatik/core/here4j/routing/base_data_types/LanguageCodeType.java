package de.haw_hamburg.informatik.core.here4j.routing.base_data_types;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * This type is used whenever a language of a value needs to be referenced.
 */
public enum LanguageCodeType {
    english_uk("en-gb"),
    english_us("en-us"),
    german_ger("de-de");

    private String code;

    LanguageCodeType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
