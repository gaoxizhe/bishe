package com.example.base;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/19 上午10:50
 */

import lombok.Data;

/**
 * @ClassName LayuiResponse
 * @Author Mr.Gao
 * @Date 2020/3/19 上午10:50
 * @Description
 */
@Data
public class LayuiFileResponse {
    private Integer success;
    private String message;
    private String url;
}
