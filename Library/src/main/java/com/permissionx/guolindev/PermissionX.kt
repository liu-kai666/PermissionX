package com.permissionx.guolindev

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object PermissionX {
    private const val TAG = "InvisibleFragment"

    fun request(activity:FragmentActivity,vararg permissions: String,callback:PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val exiistedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(exiistedFragment!=null){
            exiistedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,* permissions )
    }
}