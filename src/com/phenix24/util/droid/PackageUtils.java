package com.phenix24.util.droid;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;

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
     * @param pkaName
     *            android package name
     * @return version code
     * @throws NameNotFoundException
     *             if app not installed
     */
    public static int getAppVersionCode(Context context, String pkaName)
            throws NameNotFoundException {
        PackageManager pkgManager = context.getPackageManager();
        PackageInfo pkgInfo = pkgManager.getPackageInfo(pkaName, 0);
        return pkgInfo.versionCode;
    }

    /**
     * Get android app's version name,the version name defined
     * AndroidManifest.xml.
     * 
     * @param context
     * @param pkaName
     *            android package name
     * @return version name
     * @throws NameNotFoundException
     *             if app not installed
     */
    public static String getAppVersionName(Context context, String pkaName)
            throws NameNotFoundException {
        PackageManager pkgManager = context.getPackageManager();
        PackageInfo pkgInfo = pkgManager.getPackageInfo(pkaName, 0);
        return pkgInfo.versionName;
    }

}
