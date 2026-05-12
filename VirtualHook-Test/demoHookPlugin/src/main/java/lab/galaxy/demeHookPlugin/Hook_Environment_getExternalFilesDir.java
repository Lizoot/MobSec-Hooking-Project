package lab.galaxy.demeHookPlugin;

import android.util.Log;

import java.io.File;


/**
 * Created by liuruikai756 on 31/03/2017.
 */

public class Hook_Environment_getExternalFilesDir {
    public static String className = "android.content.ContextWrapper";
    public static String methodName = "getExternalFilesDir";
    public static String methodSig = "(Ljava/lang/String;)Ljava/io/File;";
    public static File hook(Object thiz, String type) {

        Log.d("YAHFA", "HOOKED: Environment getExternalFilesDir: ");
        //String res = backup(thiz);
        Log.d("YAHFA", "Changing file path to /storage/emulated/0/Android/data/io.virtualhook/vs/storage/emulated/0/Android/data/com.example.proofofconcept_hextree/files/");
        File returnval = new File("/storage/emulated/0/Android/data/io.virtualhook/vs/storage/emulated/0/Android/data/com.example.proofofconcept_hextree/files/");
        returnval.mkdirs();
        return returnval;//"1234567890"+res;
    }


    //public static String backup(Object thiz) {
    //    Log.e("YAHFA", "should not be here");
    //    return "";
    //}

}
