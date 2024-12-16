package springboot.security.example.helper;

import lombok.Data;

import java.util.List;


@Data
public class ResponseData<T>{

    private T payload;

    private List<String> message;

    private boolean status;
}
