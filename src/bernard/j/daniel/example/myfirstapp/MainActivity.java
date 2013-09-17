package bernard.j.daniel.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "daniel.j.bernard.example.myfirstapp.MESSAGE";
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
			case R.id.action_settings:
				updateApp();
				return true;
			case R.id.action_update:
				updateApp();
				return true;
			default:
	            return super.onOptionsItemSelected(item);
		}
		
	}
	
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	public void updateApp() {
		UpdateApp upApp = new UpdateApp();
		upApp.setContext(getApplicationContext());
		upApp.execute("http://www.d.umn.edu/~berna228/MyFirstApp/bin/MyFirstApp.apk");
	}
}
