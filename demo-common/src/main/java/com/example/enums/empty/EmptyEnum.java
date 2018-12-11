package com.example.enums.empty;

import com.example.enums.EnumMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmptyEnum implements EnumMsg<String> {
    NULL("null", "");

    private String value;
    private String name;

    @Override
    public boolean isEmpty() {
        return true;
    }
}
