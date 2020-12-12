package com.zxh.common.http.okhttpImpl

import com.zxh.common.http.core.HttpReslutCallback
import com.zxh.common.http.core.Ihttp

/**
 * Ihttp实现类---基于Okhttp
 */
class OkHttpImpl : Ihttp {

    override fun <T> doGetAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
        TODO("Not yet implemented")
    }

    override fun <T> doPostAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
        TODO("Not yet implemented")
    }
}