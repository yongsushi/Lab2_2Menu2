package my.edu.tarc.lab2_2menu2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewMessage;
    private float size;
    float screenDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = findViewById(R.id.textViewMessage);
        screenDensity = getResources().getDisplayMetrics().scaledDensity;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_zoom_in){
             increaseTextSize();
        }else if(id == R.id.action_zoom_out){
            decreaseTextSize();
        }else if(id == R.id.action_about_us){
            lauchAboutUs();
        }

        return super.onOptionsItemSelected(item);
    }

    public void increaseTextSize(){
        size = (textViewMessage.getTextSize()/screenDensity)+1;
        textViewMessage.setTextSize(size);
    }

    public void decreaseTextSize(){
        size = (textViewMessage.getTextSize()/screenDensity)-1;
        textViewMessage.setTextSize(size);
    }

    public void lauchAboutUs(){
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }
}
