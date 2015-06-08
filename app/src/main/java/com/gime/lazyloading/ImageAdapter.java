package com.gime.lazyloading;

import java.util.ArrayList;
import java.util.List;

import com.gime.gdatin.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
private LayoutInflater mInflater;
private List items=new ArrayList();
public ImageAdapter(Context context,List items){
	mInflater=LayoutInflater.from(context);
	this.items=items;
}
public int getCount(){
	return items.size();
}
public Imageloading getItem(int position){
	return (Imageloading) items.get(position);
} 
public long getItemId(int position) {
    return position;
}
public View getView(int position, View convertView,ViewGroup parent){
	ViewHolder holder;
	Imageloading s= (Imageloading) items.get(position);
	if(convertView==null){
		convertView=mInflater.inflate(R.layout.image_list_item, null);
		holder=new ViewHolder();
		holder.pic=(ImageView)convertView.findViewById(R.id.flag);
		convertView.setTag(holder);
	}else{
		holder=(ViewHolder)convertView.getTag();
	}if (s.getImage()!=null){
		holder.pic.setImageBitmap(s.getImage());
	}else{
		holder.pic.setImageResource(R.drawable.ic_home);
	}
	return convertView;
}
static class ViewHolder {
    ImageView pic;
}
}