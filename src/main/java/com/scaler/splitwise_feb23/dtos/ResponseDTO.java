package com.scaler.splitwise_feb23.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {
    private ResponseStatus status;
    private T data;
}

// {
//   status: SUCCESS,
//   data: {
//
//   }
// }
// ResponseDTO<Integer>
//
// class ArrayList<T>
