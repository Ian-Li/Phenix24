package com.phenix24.util.droid;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PackageUtils {

    public static void installAPK(Context context, String path) {
        Uri uri = Uri.fromFile(new File(path));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static void uninstallAPK(Context context, String pkgName) {
        Uri uri = Uri.parse("package:" + pkgName);
        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        context.startActivity(intent);
    }
}
