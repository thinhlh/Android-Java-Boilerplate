package com.thinhlh.domain.api.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thinhlh on 3/1/2022.
 * Copyright 2022 (c)
 */
public abstract class BaseResponse<T> {


    @SerializedName("success")
    boolean success;

    @SerializedName("message")
    String message;

    @SerializedName("data")
    T data;
}
