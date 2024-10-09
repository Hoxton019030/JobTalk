package org.hoxton.chat.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hoxton.chat.entity.Message;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private int code;
    private T data;

    public static<T> Response<T> success(T t) {
        return Response.<T>builder().code(200).data(t).build();
    }
}
