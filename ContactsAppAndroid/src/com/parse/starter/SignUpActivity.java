package com.parse.starter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arianaantonio.networkconnection.NetworkConnect;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity {

	EditText username;
	EditText password;
	Button signupButton;
	String passwordCreated;
	String usernameCreated;
	NetworkConnect networkConnection;
	Boolean networkConn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i("Sign Up Activity", "Test");  
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_layout); 
		final Context context = this;
		
		username = (EditText) findViewById(R.id.newUsername);
		password = (EditText) findViewById(R.id.newPassword);
		signupButton = (Button) findViewById(R.id.newSignUp);
		
		networkConnection = new NetworkConnect();
		networkConn = networkConnection.connectionStatus(context);
		if (!networkConn) {
			Toast.makeText(context, "Please connect to a network", Toast.LENGTH_LONG).show();
		}
		
		signupButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				usernameCreated = username.getText().toString();
				passwordCreated = password.getText().toString();
				networkConn = networkConnection.connectionStatus(context);
				if (networkConn) {
					ParseUser user = new ParseUser();
					user.setUsername(usernameCreated);
					user.setPassword(passwordCreated);

					user.signUpInBackground(new SignUpCallback() {
						public void done(ParseException e) {
							if (e == null) {
								Intent intent = new Intent(getBaseContext(), ContactsActivity.class);
								startActivity(intent);
							} else {
								Log.e("SignUp", "Error: " +e.getCode());
								if (e.getCode() == 202) {
									Toast.makeText(context, "Username already taken", Toast.LENGTH_LONG).show();
								}
							} 
						}
					});
				} else {
					Toast.makeText(context, "Please connect to a network", Toast.LENGTH_LONG).show();
				}
			}
		});
		new CountDownTimer(20000, 1000) {
		     public void onTick(long millisUntilFinished) {
		    	 
		     }

		     public void onFinish() {
		    	 networkConn = networkConnection.connectionStatus(context);
		    	 if (networkConn) { 
		    		 //Log.i("Main", "Connected");
		    		 //Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
		    	 } else {
		    		 //Log.i("Main", "Not connected");
		    		 //Toast.makeText(context, "Not connected", Toast.LENGTH_SHORT).show();
		    	 }
		    	 start();
		     }
		}.start();
	}
}
