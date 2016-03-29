package ro.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var03MainActivity extends Activity {

	  private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	 EditText riddle = null;
	 EditText goodAnswer = null;
	 Button play = null;
	 private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
        
        riddle = (EditText) findViewById(R.id.riddle);
        goodAnswer = (EditText) findViewById(R.id.goodAnswer);
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(buttonClickListener);
      
    }


    public class ButtonClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			
			 switch(view.getId()) {
		        case R.id.play:
		        	 
		        	if("".equals(riddle.getText().toString()) || "".equals(goodAnswer.getText().toString())){ 
		        		return;
		        	}
			          Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
			          intent.putExtra("riddle", riddle.getText().toString());
			          intent.putExtra("goodAnswer", goodAnswer.getText().toString());
			          startActivity(intent);
		          break;
		      }
			
		}

		
	}
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var03_main, menu);
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

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("riddle", riddle.getText().toString());
		outState.putString("goodAnswer", goodAnswer.getText().toString());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		if(savedInstanceState.getString("riddle") != null) {
            riddle.setText(savedInstanceState.getString("riddle"));
		}
		if (savedInstanceState.getString("goodAnswer")!=null) {
			goodAnswer.setText(savedInstanceState.getString("goodAnswer"));
		}
		
	}
    
    
}
