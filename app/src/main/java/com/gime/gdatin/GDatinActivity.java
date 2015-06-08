package com.gime.gdatin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GDatinActivity extends Activity {
	@Override
	public void onBackPressed() {
		//super.onBackPressed();
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdatin);
        
        /*Button btLogin = new Button(this);
		btLogin.setText("Đăng nhập");
		btLogin.setWidth(400);
		btLogin.setHeight(100);
		btLogin.setX(0);
		btLogin.setY(0);
		btLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(GDatinActivity.this, GCenterActivity.class);
				GDatinActivity.this.startActivity(intent);
			}
		});
		WindowManager.LayoutParams params = new WindowManager.LayoutParams(
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_PHONE,
				WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT);
		params.gravity = Gravity.TOP | Gravity.LEFT;
		params.x = 0;
		params.y = 0;
		this.addContentView(btLogin, params);//*/
    }
}