package com.zxh.common.http.okhttpImpl

import android.os.Handler
import android.os.Looper
import com.zxh.common.http.core.HttpReslutCallback
import com.zxh.common.http.core.Ihttp
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Ihttp实现类---基于Okhttp
 */
class OkHttpImpl : Ihttp {
     private val mHandler:Handler= Handler(Looper.getMainLooper())
    private val mOkHttpClient:OkHttpClient=OkHttpClient
            .Builder()
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .build()
    override fun <T> doGetAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
        val request=Request.Builder().url(url).build()
        val call=mOkHttpClient.newCall(request)
        call.enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                mHandler.post(object :Runnable{
                    override fun run() {
                        callback.onFailure(e.message.toString())
                    }
                })
            }

            override fun onResponse(call: Call, response: Response) {
                mHandler.post {
                    callback.onResponse(response.body!!.string())
                }
            }
        })
    }

    override fun <T> doPostAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
        val builder=FormBody.Builder()
        if(null!=params && params.isNotEmpty()){
            var entries = params.entries
            params.forEach {
                builder.add(it.key,it.value.toString())
            }
            val formBody = builder.build()
            val request=Request.Builder().url(url).post(body =formBody).build()
            val call=mOkHttpClient.newCall(request)
            call.enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    mHandler.post { callback.onFailure(e.message.toString())
                    }
                }

                override fun onResponse(call: Call, response: Response) {
                    mHandler.post {
                        callback.onResponse(response.body!!.string())
                    }
                }
            })
        }
    }
}