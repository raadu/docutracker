package com.example.borshan.tracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.borshan.tracker.ListItem;
//import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    public String pdf_link;
    public String pdf_name;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ListItem listItem = listItems.get(position);

        holder.pdf_name.setText(listItem.getPdf_name());
        //holder.pdf_link.setText(listItem.getPdf_link());
        holder.teacher_id.setText(listItem.getTeacher_id());
        holder.course_name.setText(listItem.getCourse_name());

        pdf_name= listItem.getPdf_name();
        pdf_link= listItem.getPdf_link();


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked on "+ listItem.getPdf_name(), Toast.LENGTH_LONG).show();


                new DownloadFile().execute(pdf_link, pdf_name +".pdf");
                //new DownloadFile().execute("http://maven.apache.org/maven-1.x/maven.pdf", "maven.pdf");


            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView pdf_name;
       // public TextView pdf_link;
        public TextView teacher_id;
        public TextView course_name;


        //public ImageView imageView;

        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            pdf_name = (TextView) itemView.findViewById(R.id.pdf_name);
           // pdf_link = (TextView) itemView.findViewById(R.id.pdf_link);
            teacher_id = (TextView) itemView.findViewById(R.id.teacher_id);
            course_name = (TextView) itemView.findViewById(R.id.course_name);


            //imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }



//    private class DownloadFile extends AsyncTask<String, Void, Void>{
//
//
//
//        @Override
//        protected Void doInBackground(String... strings) {
//
//            //Toast.makeText(context, "inside download file", Toast.LENGTH_LONG).show();
//
//            String fileUrl = strings[0];
//            String fileName = strings[1];
//            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
//            File folder = new File(extStorageDirectory, "docutracker");
//            folder.mkdir();
//
//            File pdfFile = new File(folder, fileName);
//
//            try{
//               // Toast.makeText(context, "trying ", Toast.LENGTH_LONG).show();
//                pdfFile.createNewFile();
//            }catch (IOException e){
//               // Toast.makeText(context, "catched ", Toast.LENGTH_LONG).show();
//                e.printStackTrace();
//
//            }
//            FileDownloader.downloadFile(fileUrl, pdfFile);
//            return null;
//        }
//    }

    private class DownloadFile extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];
            String fileName = strings[1];
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "docutracker");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;
        }
    }

}
