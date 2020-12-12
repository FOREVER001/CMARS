package com.zxh.common.http.core

class HttpManager private constructor(){
    companion object{
        val instance:HttpManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HttpManager()
        }
    }
}