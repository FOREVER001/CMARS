package com.zxh.common.http.core

import java.lang.NullPointerException


class HttpImpl : Ihttp {
    private var mIhttp: Ihttp? = null
    override fun <T> doGetAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
        mIhttp?.doGetAsync(url, params, callback) ?: throw NullPointerException("mIhttp不能为空")
    }

    override fun <T> doPostAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
        mIhttp?.doPostAsync(url, params, callback) ?: throw NullPointerException("mIhttp不能为空")
    }

}