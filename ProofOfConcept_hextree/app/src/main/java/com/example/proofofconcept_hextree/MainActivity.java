package com.example.proofofconcept_hextree;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView homeText = findViewById(R.id.home_text);
        homeText.setText("Welcome from BEEEEEEs");

        Button homeButton = findViewById(R.id.home_button);

        homeButton.setOnClickListener(v -> {

            try {
                File dir = getExternalFilesDir(null);
                File file = new File(dir, "example.txt");
                //File file =  new File(
                       // "/storage/emulated/0/example.txt"); //getExternalFilesDir(null);

                //file.mkdirs();
                //file.createNewFile();

                //File file = new File(directory, "example.txt");

                FileWriter writer = new FileWriter(file);

                writer.write("Welcome from BEEEEEEs");

                writer.close();

                Log.i("HexBee", "Saved file to: " + file.getAbsolutePath());

            } catch (IOException e) {

                e.printStackTrace();

            }

        });
    }
//        super.onCreate(savedInstanceState);
//        //EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        TextView homeText = findViewById(R.id.home_text);
//        homeText.setText("Welcome from BEEEEEEs");
//
//        Button homeButton = findViewById(R.id.home_button);
//        homeButton.setOnClickListener(new View.OnClickListener(){
//           @Override
//           public void onClick(View v) {
//               try {
//                   File directory = getExternalFilesDir(null);
//
//                   File file = new File(directory, "example.txt");
//
//                   FileWriter writer = new FileWriter(file);
//
//                   writer.write("Hello from BEEEEEEs");
//
//                   writer.close();
//
//                   Log.i("HexBee", "Saved file!");
//
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//               //Log.i("HexBee", "Welcome to beeland");
//
//               // Source - https://stackoverflow.com/a/30827530
//// Posted by Yash Sampat, modified by community. See post 'Timeline' for change history
//// Retrieved 2026-05-09, License - CC BY-SA 4.0
//
//              //Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT); //we want an explicit intent (initiated and limited in the application)
//               //chooseFile.setType("*/*");
//               //Log.i("HexBee", "made it this far");
//               //chooseFile = Intent.createChooser(chooseFile, "Choose a file");
//               //startActivityForResult(i, LAUNCH_SECOND_ACTIVITY);
//               Log.i("HexBee", "Welcome to beeland YAAAY");
//               //startActivityForResult(chooseFile, 1); //deprecated + pickfileresultcode squiggly?
//
//
//
//
//           }
//        });
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
////            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
////            return insets;
////        });
//    }
//
//
//    // Source - https://stackoverflow.com/a/30827530
//// Posted by Yash Sampat, modified by community. See post 'Timeline' for change history
//// Retrieved 2026-05-09, License - CC BY-SA 4.0
//
////    public String getPath(Uri uri) {
////
////        String path = null;
////        String[] projection = { MediaStore.Files.FileColumns.DATA };
////        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
////
////        if(cursor == null){
////            path = uri.getPath();
////        }
////        else{
////            cursor.moveToFirst();
////            int column_index = cursor.getColumnIndexOrThrow(projection[0]);
////            path = cursor.getString(column_index);
////            cursor.close();
////        }
////
////        return ((path == null || path.isEmpty()) ? (uri.getPath()) : path);
////    }


}