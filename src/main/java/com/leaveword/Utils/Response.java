package com.leaveword.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/7/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private  String status;
    private Object content;
}
