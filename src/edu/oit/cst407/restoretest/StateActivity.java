package edu.oit.cst407.restoretest;


import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StateActivity extends Activity{
	
	long seed = (R.integer.random_seed);
	
	private static final String RANDOM_NUMBER = null;
	
	// For some reason, this always produced the same random number(string)
	// no matter what number I put in my "numbers.xml" file.  The default
	// function seems to pull seed from current time and always gives me 
	// something unique, given enough range for my number of few test attempts.
	
	// Random randomNumber = new Random(seed);
	
	Random randomNumber = new Random();
	
	int randomInteger = randomNumber.nextInt(1000);
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_state);
		
		TextView stateMessage = (TextView) findViewById(R.id.state_message);
		
		stateMessage.setText(Integer.toString(randomInteger));
		
		Toast.makeText(StateActivity.this,"ON CREATE", Toast.LENGTH_SHORT).show();
	
	}
	
	 @Override
	    protected void onResume() {
	       // TODO Auto-generated method stub
	       super.onResume(); 
	        Toast.makeText(StateActivity.this,"ON RESUME", Toast.LENGTH_SHORT).show(); 
	    } 
	    @Override
	    protected void onPause() {
	       // TODO Auto-generated method stub
	       super.onPause(); 
	        Toast.makeText(StateActivity.this,"ON PAUSE", Toast.LENGTH_SHORT).show(); 
	    } 
	    @Override
	    protected void onRestart() {
	       // TODO Auto-generated method stub
	       super.onRestart(); 
	        Toast.makeText(StateActivity.this,"ON RESTART", Toast.LENGTH_SHORT).show(); 
	    } 
	    @Override
	    protected void onStop() {
	       // TODO Auto-generated method stub
	       super.onStop(); 
	        Toast.makeText(StateActivity.this,"ON STOP", Toast.LENGTH_SHORT).show(); 
	    } 
	    
	    @Override
	    protected void onSaveInstanceState(Bundle outState){
	    	super.onSaveInstanceState(outState);
	    	outState.putInt(RANDOM_NUMBER, randomInteger);
	    	Toast.makeText(StateActivity.this,"ON SAVE INSTANCE STATE", Toast.LENGTH_SHORT).show();
	    }
	    
	    @Override
	    protected void onRestoreInstanceState(Bundle savedInstanceState){
	    	super.onRestoreInstanceState(savedInstanceState);
	    	randomInteger = savedInstanceState.getInt(RANDOM_NUMBER);
	    	TextView stateMessage = (TextView) findViewById(R.id.state_message);
	    	stateMessage.setText(Integer.toString(randomInteger));
	    	Toast.makeText(StateActivity.this,"ON RESTORE INSTANCE STATE", Toast.LENGTH_SHORT).show();
	    }
	    	    
	    @Override
	    protected void onDestroy() {
	       // TODO Auto-generated method stub
	       super.onDestroy(); 
	        Toast.makeText(StateActivity.this,"ON DESTROY", Toast.LENGTH_SHORT).show();
	    } 
}
