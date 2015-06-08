package com.gime.lazyloading;

import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class Imageloading {
	private String imgUrl;
	private Bitmap image;
	private ImageAdapter iea;
	public Imageloading(String imgUrl){
		this.imgUrl=imgUrl;
		this.image=null;
	}
	public String getImgUrl() {
        return imgUrl;
    }
 
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
 
    public Bitmap getImage() {
        return image;
    }
    public ImageAdapter getAdapter(){
    	return iea;
    }
    public void setAdapter(ImageAdapter iea){
    	this.iea=iea;
    }
    public void loadImage(ImageAdapter iea){
    	this.iea=iea;
    	if (imgUrl != null && !imgUrl.equals("")) {
            new ImageLoadTask().execute(imgUrl);
        }
    }
 // ASYNC TASK TO AVOID CHOKING UP UI THREAD
    private class ImageLoadTask extends AsyncTask<String, String, Bitmap> {
 
        @Override
        protected void onPreExecute() {
            Log.i("ImageLoadTask", "Loading image...");
        }
 
        // PARAM[0] IS IMG URL
        protected Bitmap doInBackground(String... param) {
            Log.i("ImageLoadTask", "Attempting to load image URL: " + param[0]);
            try {
            	URL url = new URL(param[0]);
            	InputStream is = url.openConnection().getInputStream();
                Bitmap b = BitmapFactory.decodeStream(is);
                return b;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
 
        protected void onProgressUpdate(String... progress) {
            // NO OP
        }
 
        protected void onPostExecute(Bitmap ret) {
            if (ret != null) {
                Log.i("ImageLoadTask", "Successfully loaded "+" image");
                image = ret;
                if (iea != null) {
                    // WHEN IMAGE IS LOADED NOTIFY THE ADAPTER
                    iea.notifyDataSetChanged();
                }
            } else {
                Log.e("ImageLoadTask", "Failed to load "+" image");
            }
        }
    }
    
}
