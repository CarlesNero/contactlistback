package com.todo.contactlist.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {

    String column;
    String value;
    @NonNull
    Operation operation;
    String joinTable;

    public enum Operation {
        EQUAL, LIKE,IN,GREATER_THAN,LESS_THAN,BETWEEN,JOIN;
    }
}
