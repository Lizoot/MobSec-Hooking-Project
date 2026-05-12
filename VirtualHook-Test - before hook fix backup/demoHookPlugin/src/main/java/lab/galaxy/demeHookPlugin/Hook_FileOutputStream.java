package lab.galaxy.demeHookPlugin;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

public class Hook_FileOutputStream {
    public static void hook_outputstream(FileOutputStream thiz, String path) {

//        Log.e("YAHFA", "stream open: " + path);
//
//        // FORCE redirect here too
//        String redirected = path;
//
//        if (path.startsWith("/storage/emulated/0/Android/data/com.example.proofofconcept_hextree/")) {
//            redirected = path.replace(
//                    "com.example.proofofconcept_hextree",
//                    "io.virtualhook/vs/com.example.proofofconcept_hextree"
//            );
//        }
//
//        Log.e("YAHFA", "stream redirected: " + redirected);
//
//        backup(thiz, redirected);
        Log.e("YAHFA", "stream open: " + path);

        String base =
                "/storage/emulated/0/Android/data/io.virtualhook/vs/";

        String redirected;

        if (path.startsWith(base)) {
            // already virtualized → DO NOT touch
            redirected = path;

        } else if (path.startsWith("/storage/emulated/0/Android/data/")) {
            redirected = base + path.substring(
                    "/storage/emulated/0/Android/data/".length()
            );

        } else {
            redirected = path;
        }

        Log.e("YAHFA", "stream redirected: " + redirected);

        backup(thiz, redirected);
    }
    public static void backup(FileOutputStream thiz, String fileName) {
        Log.e("YAHFA", "should not be here");
        throw new UnsupportedOperationException("Stub!");
    }
}
