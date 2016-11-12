package com.guyj.permissions;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

/**
 * 检查权限的工具类
 * ......................我佛慈悲......................
 * 　　　　　　　　　　　　　　　_oo0oo_
 * 　　　　　　　　　　　　　　o8888888o
 * 　　　　　　　　　　　　　　88" . "88
 * 　　　　　　　　　　　　　　(| -_- |)
 * 　　　　　　　　　　　　　　0\  =  /0
 * 　　　　　　　　　　　　　___/`---'\___
 * 　　　　　　　　　　　.' \\|     |// '.
 * 　　　　　　　　　　　/ \\|||  :  |||// \
 * 　　　　　　　　　　/ _||||| -卍-|||||- \
 * 　　　　　　　　　　|   | \\\  -  /// |   |
 * 　　　　　　　　　　| \_|  ''\---/''  |_/ |
 * 　　　　　　　　　　\  .-\__  '-'  ___/-. /
 * 　　　　　　　　___'. .'  /--.--\  `. .'___
 * 　　　　　　."" '<  `.___\_<|>_/___.' >' "".
 * 　　　　　　| | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * 　　　　　　\  \ `_.   \_ __\ /__ _/   .-` /  /
 * 　　　=====`-.____`.___ \_____/___.-`___.-'=====
 * 　　　　　　　　　　　　　　　`=---='
 * ..................佛祖开光 ,永无BUG...................
 */
public class PermissionsChecker {
    private final Context mContext;

    public PermissionsChecker(Context context) {
        mContext = context.getApplicationContext();
    }

    // 判断权限集合,快速判断是否授予权限
    public boolean lacksPermissions(String... permissions) {
        for (String permission : permissions) {
            if (lacksPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    // 判断权限集合，返回未授权的权限集合
    public List<String> lacksPermissions2(String... permissions) {
        ArrayList<String> deniedList = new ArrayList<>();
        for (String permission : permissions) {
            if (lacksPermission(permission)) {
                deniedList.add(permission);
            }
        }
        return deniedList;
    }

    // 判断是否缺少权限
    private boolean lacksPermission(String permission) {
        return ContextCompat.checkSelfPermission(mContext, permission) ==
                PackageManager.PERMISSION_DENIED;
    }
}
