package com.todo.contactlist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {

    String column;
    String value;
    Operation operation;

    public enum Operation {
        EQUAL, LIKE;
    }
}
