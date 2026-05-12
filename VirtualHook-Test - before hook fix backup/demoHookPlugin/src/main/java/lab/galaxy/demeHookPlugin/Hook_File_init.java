package lab.galaxy.demeHookPlugin;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;


/**
 * Created by liuruikai756 on 31/03/2017.
 */

public class Hook_File_init {
    public static String className = "java.io.File";
    public static String methodName = "<init>";
    public static String methodSig = "(Ljava/lang/String;)V";
    public static void hook(File thiz, String fileName) {
//        Log.e("YAHFA", "open file "+fileName);
//        backup(thiz, fileName);
//            Log.e("YAHFA", "original path: " + fileName);
//
//            String redirected =
//                    "/storage/emulated/0/Android/data/io.virtualhook/vs/"
//                            + fileName;
//
//            Log.e("YAHFA", "redirected path: " + redirected);
//
//            // IMPORTANT: pass through original behavior
//            backup(thiz, redirected);
        Log.e("YAHFA", "open file " + fileName);

//// IMPORTANT: prevent re-virtualization
//        if (fileName.startsWith("/storage/emulated/0/Android/data/io.virtualhook/vs/")) {
//            backup(thiz, fileName);
//            return;
//        }
//
//// only redirect external storage
//        if (fileName.startsWith("/storage/emulated/0/")) {
//
//            String redirected =
//                    "/storage/emulated/0/Android/data/io.virtualhook/vs/"
//                            + fileName.substring("/storage/emulated/0/".length());
//
//            Log.e("YAHFA", "redirected path: " + redirected);
//        String base = "/storage/emulated/0/Android/data/io.virtualhook/vs/";
//
//        String relative;
//
//        if (fileName.startsWith("/storage/emulated/0/Android/data/")) {
//            relative = fileName.substring(
//                    "/storage/emulated/0/Android/data/".length()
//            );
//
//        } else if (fileName.startsWith("/storage/emulated/0/")) {
//            relative = fileName.substring(
//                    "/storage/emulated/0/".length()
//            );
//
//        } else {
//            relative = fileName;
//        }
//
//        String redirected = base + relative;
        // ONLY external storage
        if (!fileName.startsWith("/storage/emulated/0/")) {
            backup(thiz, fileName);
            return;
        }

        String base =
                "/storage/emulated/0/Android/data/io.virtualhook/vs/";

        String relative = fileName.substring(
                "/storage/emulated/0/".length()
        );

        String redirected = base + relative;

        Log.e("YAHFA", "redirected path: " + redirected);
            backup(thiz, redirected);
            return;
        }

// fallback
        //backup(thiz, fileName);



    public static void backup(File thiz, String fileName) {
        Log.e("YAHFA", "should not be here");
        throw new UnsupportedOperationException("Stub!");
    }

}
