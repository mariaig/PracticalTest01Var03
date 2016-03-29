package ro.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends Activity {
	 EditText riddleText = null;
     EditText answer = null;
     Button check = null;
     Button back = null;
     private ButtonClickListener buttonClickListener = new ButtonClickListener();
     String riddleString ="";
     String answerString="";
     
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_play);
		
		riddleText = (EditText) findViewById(R.id.riddleText);
        answer = (EditText) findViewById(R.id.answer);
        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(buttonClickListener);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(buttonClickListener);
        
        EditText riddle = (EditText) findViewById(R.id.riddle);
        
        
        Intent intent = getIntent();
        

        if (intent != null) {
            riddleString = intent.getStringExtra("riddle");
            answerString = intent.getStringExtra("goodAnswer");
            riddleText.setText(riddleString);
        }
	}
	
	
	public class ButtonClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
		
			 switch(view.getId()) {
		        case R.id.check:
	                if (answerString.equals(answer.getText().toString())) {
	                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
	                } else {
	                    Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT).show();
	                }
		          break;
		        case R.id.back:
	                finish();
		          break;
		      }
			
		}

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_play, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
