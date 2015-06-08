package com.gime.gdatin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import org.lucasr.twowayview.TwoWayView;

public class Horizonal_Listview extends Activity {
	   int[] flags = new int[]{
	    		R.drawable.india,
	    		R.drawable.pakistan,
	    		R.drawable.srilanka,
	    		R.drawable.china,
	    		R.drawable.bangladesh,
	    		R.drawable.nepal,
	    		R.drawable.afghanistan,
	    		R.drawable.nkorea,
	    		R.drawable.skorea,
	    		R.drawable.japan
	    };
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_listview);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        
        for(int i=0;i<10;i++){
        	HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("flag", Integer.toString(flags[i]) );            
            aList.add(hm);        
        }
        String[] from = {"flag"};
        int[] to = {R.id.flag};      
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.image_list_item, from, to);
        TwoWayView lvTest = (TwoWayView) findViewById(R.id.lvItems);
        lvTest.setAdapter(adapter);
	};
	
}
