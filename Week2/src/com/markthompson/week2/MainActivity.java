/*
 * project		Week2
 * 
 * package		com.markthompson.week2
 * 
 * @author		Mark Thompson
 * 
 * date			Sep 12, 2013
 */
package com.markthompson.week2;

import java.util.ArrayList;

import com.markthompson.fishThings.Fish;
import com.markthompson.fishThings.FishType;
import com.markthompson.lib.FormThings;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class MainActivity extends Activity {

	RadioGroup typeOptions;
	ArrayList<FishType> fishTypes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
		LinearLayout ll = new LinearLayout(this);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		ll.setLayoutParams(lp);
		ll.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout entryBox = FormThings.singleEntryWithButton(this, "Size of fish?", "Calculate");
		Button fishButton = (Button) entryBox.findViewById(2);
		
		fishButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				int selectedRadioId = typeOptions.getCheckedRadioButtonId();
				RadioButton selectedRadio = (RadioButton)typeOptions.findViewById(selectedRadioId);
				String radioText = (String)selectedRadio.getText();
				
				
				for(int i=0; i<fishTypes.size(); i++){
					if(radioText.compareTo(fishTypes.get(i).getName()) == 0 ){
						double length = fishTypes.get(i).getLength();
					}
				}
				
				EditText fishLength = (EditText) v.getTag(); 
				Log.i("Button ", fishLength.getText().toString());
				
			}
		});
		
		fishTypes = new ArrayList<FishType>();
		fishTypes.add(new Fish("Redfish",27));
		fishTypes.add(new Fish("Black Drum",24));
		fishTypes.add(new Fish("Snook",28));
		fishTypes.add(new Fish("Sea Trout",20));
		fishTypes.add(new Fish("Flounder",12));
		fishTypes.add(new Fish("Spanish Mackerel",12));
		fishTypes.add(new Fish("Bluefish",12));

		String[] fishNames = new String[fishTypes.size()];
		for(int i=0; i<fishTypes.size(); i++){
			fishNames[i] = fishTypes.get(i).getName();
					
		}
		
		typeOptions = FormThings.getOptions(this, fishNames);
		
		ll.addView(typeOptions);
		
		ll.addView(entryBox);
		
		setContentView(ll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
