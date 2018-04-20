package com.example.borshan.tracker;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class openPDF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_pdf);

        Toast.makeText(this,
                "inside openPDF class",
                Toast.LENGTH_SHORT).show();

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
    try{
        Toast.makeText(this,
                "trying",
                Toast.LENGTH_SHORT).show();
        //File file = new File("/testthreepdf/maven.pdf");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/"+ "maven.pdf");
        pdfView.fromFile(file).load();
    } catch (Exception ex) {
        Log.i(getClass().toString(), ex.toString());
        Toast.makeText(this,
                "Cannot open your selected file, try again later",
                Toast.LENGTH_SHORT).show();
    }
    }
}
