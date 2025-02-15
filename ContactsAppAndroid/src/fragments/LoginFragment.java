package fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.starter.R;

public class LoginFragment extends Fragment {
	EditText username;
	EditText password;
	Button loginButton;
	Button signupButton;
	String usernameEntered = "";
	String passwordEntered = "";
	TextView skipView;
	String TAG = "Login Fragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_login, container, false);
		
		username = (EditText) view.findViewById(R.id.usernameText);
		password = (EditText) view.findViewById(R.id.passwordText);
		loginButton = (Button) view.findViewById(R.id.loginButton);
		signupButton = (Button) view.findViewById(R.id.signupButton);
		skipView = (TextView) view.findViewById(R.id.skipLink);
		
		loginButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				usernameEntered = username.getText().toString();
				passwordEntered = password.getText().toString();
				Log.i(TAG, "Username: " +usernameEntered+ " Password: " +passwordEntered);
				 
			}
			
		}); 
		
		signupButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//FragmentManager manager = getFragmentManager();
				//SignUpFragment fragment = (SignUpFragment) manager.findFragmentById(R.id.signup_fragment);
				//manager.beginTransaction().replace(0, fragment).commit();
				
				//SignUpFragment newFragment = new SignUpFragment();
				//FragmentTransaction transaction = getFragmentManager().beginTransaction();

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack
				//transaction.add(R.id.signup_fragment_id, newFragment);
				//transaction.replace(R.id.signup_fragment, newFragment);
				//transaction.addToBackStack(null);   

				// Commit the transaction
				//transaction.commit();
				FragmentManager manager = getFragmentManager();
				SignUpFragment fragment = new SignUpFragment();
				//fragment.setArguments(bundle);
				//manager.beginTransaction().replace(R.id.container, fragment).commit();
			}
			
		});
		
		skipView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(TAG, "Clicked Skip");
			}
			
		});
		
		return view;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}

}
