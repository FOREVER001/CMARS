package com.zxh.common.app

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import java.lang.Exception


class ManifestParser constructor(private val context:Context?) {
    companion object{
        val MODULE_NAME:String="IModuleConfig"
    }
    /**
     * 解析AndroidManifest
     */
     fun parse():ArrayList<IApplife>?{
        val modules = ArrayList<IApplife>()
        try {
            val appInfo: ApplicationInfo =  context?.packageManager!!.getApplicationInfo(context!!.packageName,
                    PackageManager.GET_META_DATA)
            var metaData = appInfo.metaData
            if(metaData!=null){
                for (key in metaData.keySet()) {
                    if(MODULE_NAME.equals(metaData.get(key))){
                        modules.add(parseModule(key))
                    }
                }
            }
        }catch ( e:Exception){
            e.printStackTrace()
        }

        return modules
    }

    private fun parseModule(key: String?): IApplife {
        var newInstance:Any?=null
        try {
            var clazz = Class.forName(key)
             newInstance = clazz.newInstance()
        }catch (e:Exception){
            e.printStackTrace()
        }
       return newInstance as IApplife
    }
}