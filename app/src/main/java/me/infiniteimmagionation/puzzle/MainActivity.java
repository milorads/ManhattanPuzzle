package me.infiniteimmagionation.puzzle;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if (savedInstanceState != null){
        //    ((WebView)findViewById(R.id.wv)).restoreState(savedInstanceState);}
        //else
        //{

        v = (WebView) findViewById(R.id.wv);
        v.getSettings().setJavaScriptEnabled(true);
        v.loadUrl("file:///android_asset/website/manhattanPuzzle.html");
        v.setBackgroundColor(Color.TRANSPARENT);
        v.setPadding(0, 0, 0, 0);
        //v.setInitialScale(130);
        v.getSettings().setLoadWithOverviewMode(true);
        v.getSettings().setUseWideViewPort(true);
        v.getSettings().setBuiltInZoomControls(true);

        //}
    }
    private int getScale(){
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(200);
        val = val * 100d;
        return val.intValue();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    boolean fscr = false;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.fscr:
                //action
                FullScreen();
                return true;
            case R.id.cont:
                //action
                Contact();
                return true;
            case R.id.about:
                //action
                About();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void Contact(){
        Toast.makeText(this, "milorad.sekulovic@gmail.com\nCredits go to original prject\nCheck it at: http://198.46.157.26/", Toast.LENGTH_LONG).show();
    }

    private void About(){
        Toast.makeText(this, "This is port of website project(using A* Algorithm with Manhattan Distance Heuristic) developed at University Singidunum.", Toast.LENGTH_LONG).show();
    }

    private void FullScreen() {
        if(!fscr){
//            getWindow().getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            fscr = true;
        }
        else{
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            fscr = false;
        }
    }
}
