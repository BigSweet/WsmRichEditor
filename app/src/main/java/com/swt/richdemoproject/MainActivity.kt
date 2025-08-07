package com.swt.richdemoproject

import android.Manifest.permission
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.PermissionUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickTest(view: View) {
        PermissionUtils.permission(*getStoragePermission())
            .callback(object : PermissionUtils.FullCallback {
                override fun onGranted(permissionsGranted: List<String>) {
                    DemoActivity.start(this@MainActivity)
                }

                override fun onDenied(
                    permissionsDeniedForever: List<String>,
                    permissionsDenied: List<String>,
                ) {
                    //拒绝权限
                    PermissionUtils.launchAppDetailsSettings()
                }
            })
            .request()


    }

    val READ_MEDIA_VISUAL_USER_SELECTED = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"

    fun getStoragePermission(): Array<String> {
        val target = AppUtils.getAppTargetSdkVersion()
        if (isUPSIDE_DOWN_CAKE()) {
            return if (target >= 34) {
                arrayOf<String>(READ_MEDIA_VISUAL_USER_SELECTED, permission.READ_MEDIA_IMAGES, permission.READ_MEDIA_VIDEO)
            } else if (target == Build.VERSION_CODES.TIRAMISU) {
                arrayOf<String>(permission.READ_MEDIA_IMAGES, permission.READ_MEDIA_VIDEO)
            } else {
                arrayOf<String>(permission.READ_EXTERNAL_STORAGE)
            }
        } else if (isTIRAMISU()) {
            return if (target >= Build.VERSION_CODES.TIRAMISU) arrayOf(permission.READ_MEDIA_IMAGES, permission.READ_MEDIA_VIDEO) else arrayOf(permission.READ_EXTERNAL_STORAGE)
        }
        return arrayOf(permission.READ_EXTERNAL_STORAGE, permission.WRITE_EXTERNAL_STORAGE)
    }

    fun isTIRAMISU(): Boolean {
        return Build.VERSION.SDK_INT >= 33
    }

    fun isUPSIDE_DOWN_CAKE(): Boolean {
        return Build.VERSION.SDK_INT >= 34
    }
}
