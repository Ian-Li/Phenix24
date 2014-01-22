package com.phenix24.util.droid;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;

public class PackageUtils {

    /**
     * Install android package
     * 
     * @param context
     * @param path
     *            ".apk" file path
     */
    public static void installAPK(Context context, String path) {
        Uri uri = Uri.fromFile(new File(path));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * Uninstall android package
     * 
     * @param context
     * @param pkgName
     *            package name,e.g"com.phenix24"
     * 
     */
    public static void uninstallAPK(Context context, String pkgName) {
        Uri uri = Uri.parse("package:" + pkgName);
        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * Get android app's version code,the version code defined
     * AndroidManifest.xml
     * 
     * @param context
     * @param pkgName
     *            application package name
     * @return version code
     * @throws NameNotFoundException
     *             if app not installed
     */
    public static int getAppVersionCode(Context context, String pkgName)
            throws NameNotFoundException {
        PackageManager pkgManager = context.getPackageManager();
        PackageInfo pkgInfo = pkgManager.getPackageInfo(pkgName, 0);
        return pkgInfo.versionCode;
    }

    /**
     * Get android app's version name,the version name defined
     * AndroidManifest.xml.
     * 
     * @param context
     * @param pkgName
     *            application package name
     * @return version name
     * @throws NameNotFoundException
     *             if app not installed
     */
    public static String getAppVersionName(Context context, String pkgName)
            throws NameNotFoundException {
        PackageManager pkgManager = context.getPackageManager();
        PackageInfo pkgInfo = pkgManager.getPackageInfo(pkgName, 0);
        return pkgInfo.versionName;
    }

    /**
     * Return the name of this application's package.
     * 
     * @param context
     * @return The package name.
     */
    public static String getAppPackageName(Context context) {
        return context.getPackageName();
    }

    /**
     * Check whether the application package is uninstalled
     * 
     * @param context
     * @param pkgName
     *            application package name
     * @return false if the application uninstalled,otherwise return true
     */
    public static boolean isPackageExist(Context context, String pkgName) {
        if (TextUtils.isEmpty(pkgName))
            return false;

        boolean isExist = true;
        try {
            PackageManager pkgManager = context.getPackageManager();
            pkgManager.getPackageInfo(pkgName, 0);
        } catch (NameNotFoundException e) {
            isExist = false;
        }
        return isExist;
    }
}
