package com.guyj.permissions;

import android.app.Activity;

/**
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
public class CheckPermissionsForAPI23 {
    private PermissionsChecker mPermissionsChecker; // 权限检测器

    public CheckPermissionsForAPI23(Activity mActivity, String... permissions) {
        mPermissionsChecker = new PermissionsChecker(mActivity);
        if (mPermissionsChecker.lacksPermissions(permissions)) {
            PermissionsActivity.startActivityForResult(mActivity, PermissionsActivity.REQUEST_CODE, permissions);
        }
    }
}
