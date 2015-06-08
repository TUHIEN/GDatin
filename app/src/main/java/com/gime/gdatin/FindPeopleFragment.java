package com.gime.gdatin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class FindPeopleFragment extends Fragment {
	
	public FindPeopleFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);
		/*Button btLogin = new Button(rootView.getContext());
		btLogin.setText("Đăng nhập");
		btLogin.setWidth(400);
		btLogin.setHeight(100);
		btLogin.setX(0);
		btLogin.setY(0);
		btLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Fragment fragment = new HomeFragment();
	            FragmentManager fragmentManager = getChildFragmentManager();
	            android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
	            transaction.replace(R.id.child_fragment, fragment);
	            transaction.addToBackStack(null);
	            transaction.commit();
	 
	            // update selected item and title, then close the drawer
//	            mDrawerList.setItemChecked(position, true);
//	            mDrawerList.setSelection(position);
//	            setTitle(navMenuTitles[position]);
//	            mDrawerLayout.closeDrawer(mDrawerList);
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
		container.addView(btLogin, params);//*/
        return rootView;
    }

//    public interface OnFragmentInteractionListener {
//        public void showDrawerToggle(boolean showDrawerToggle);
//    }

    private GCenterActivity mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (GCenterActivity) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mListener.showDrawerToggle(false);
    }
}
