package com.elon.model;

/**
 * 用户对象模型
 *
 * @author elon
 * @since 2021-11-14
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    /**
     * 用户名
     */
    private String name = "";

    /**
     * e-mail地址
     */
    private String email = "";
}
