package com.screens.activity.carousel;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.screens.R;
import com.screens.adapter.AdapterCarousel;
import com.screens.data.DataGenerator;
import com.screens.utils.Tools;

public class CarouselBasicM3 extends AppCompatActivity {
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_carousel_basic_m3);
        ((RecyclerView) findViewById(R.id.recycler)).setAdapter(new AdapterCarousel(this, DataGenerator.getImageDate(this)));
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar((MaterialToolbar) findViewById(R.id.material_toolbar));
        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), menuItem.getTitle(), 0).show();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
