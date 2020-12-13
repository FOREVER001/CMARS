package com.zxh.common.http.core

/**
 * 网络请求结果回调接口
 */
interface HttpReslutCallback<T> {
    /**
     * 请求成功的结果
     */
    fun onResponse(data: String)

    /**
     * 请求失败的结果
     */
    fun onFailure(errMsg:String);
}