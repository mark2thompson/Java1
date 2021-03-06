/*
 * project		week1
 * 
 * package		com.example.week1
 * 
 * @author		Mark Thompson
 * 
 * date			Aug 8, 2013
 */
package com.example.week1;

import android.app.Activity;
import android.database.CursorJoiner.Result;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	EditText et;
	TextView result;
	TextView ifTv;
	int spendQ;
	boolean boolCheck = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout of application allows for each item to be placed near each other without overlapping
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
    	lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    	ll.setLayoutParams(lp);
    	
    	// text view that contains the strings for the amount of money after calculated
    	TextView tv = new TextView(this);
        tv.setText(getString(R.string.quarter)+"," +getString(R.string.dime)+ "," +getString(R.string.nickel)+ "," +getString(R.string.penny ));
        final TextView ifTv = new TextView(this);
        final TextView spentQuarters = new TextView(this);
        
        //text field
        et = new EditText(this);
        et.setHint("Convert dollars");
        
        //calculate button and click listener function
        Button b = new Button(this);
        b.setText("Convert");
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			//when button is clicked
			public void onClick(View v) {
				int quarter = getResources().getInteger(R.integer.quarter);
				int dime = getResources().getInteger(R.integer.dime);
				int nickel = getResources().getInteger(R.integer.nickel);
				int penny = getResources().getInteger(R.integer.penny);
				
				int entry = Integer.parseInt(et.getText().toString());
				//calculation for how much money is entered into textfield
				int numQ = (100/quarter)*entry;
				int numD = (100/dime)*entry;
				int numN = (100/nickel)*entry;
				int numP = (100/penny)*entry;
				
				//conditional statement, this condition just checks to see if the quarters are more then 2500
				if (numQ>2500){
					ifTv.setText("Thats a lot of quarters!!");
					int i = numQ;
					//simple while loop - only loops once in this case - would be considered a switch because of the contained boolean.
					while (boolCheck == false){		
						spendQ = (numQ - i);
						i = spendQ;
						spentQuarters.setText("ive spent all my quarters, I have " + i + " quarters left!");
						boolCheck = true;
					}
				}else{
					ifTv.setText("That is not a lot of quarters");
				};
				//sets text for amount of change after calculation
				result.setText("Quarter: " + numQ + "\r\n" + 
						"Dime: " + numD + "\r\n" + 
						"Nickel: " + numN + "\r\n" + 
						"Penny: " + numP + "\r\n");
			}
		});
        //adds items to the view... 
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.HORIZONTAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        form.setLayoutParams(lp);
        
        form.addView(et);
        form.addView(b);
        
        ll.addView(form);
        result = new TextView(this);          
        setContentView(ll);
        ll.addView(result);
        ll.addView(ifTv);
        ll.addView(spentQuarters);
    }


    /* (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
