package com.example.hindedfr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements TabListener {
	ViewPager viewPager;
ActionBar actionBar;


//Muutujad sessiooni salvestamiseks
	private static final String HINNE= "HINNE";
	private static final String PUNNE= "PUNNE";
	private static final String MPUNNE= "MPUNNE";
	private static final String PROTSENT= "PROTSENT";
	private static final String HINDED = "HINDED";
	private static final String KESKMINE = "KESKMINE";


	
	// Väärtuste muutujad
	private int punne;
	private int maxpunne;
	private double protsent;
	private String hinne;
	private String hinded;
	private String keskmine;
	


//---------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(savedInstanceState == null)
		{
			punne = 0;
			maxpunne =0;
			protsent =0.0;
			hinne="";
			hinded = "";
			keskmine ="";
		}
		else
		{
			punne = savedInstanceState.getInt(PUNNE);
			maxpunne =savedInstanceState.getInt(MPUNNE);
			protsent =savedInstanceState.getDouble(PROTSENT);
			hinne=savedInstanceState.getString(HINNE);
			hinded = savedInstanceState.getString(HINDED);
			keskmine =savedInstanceState.getString(KESKMINE);
		}

		
		viewPager= (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
		
		
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	ActionBar.Tab hindedTab= actionBar.newTab();
	hindedTab.setText(getString(R.string.Hinded));
	hindedTab.setTabListener(this);
	ActionBar.Tab keskmineTab= actionBar.newTab();
	keskmineTab.setText(getString(R.string.Hinne));
	keskmineTab.setTabListener(this);
	actionBar.addTab(hindedTab);
	actionBar.addTab(keskmineTab);
//	Log.d("omalog"," lehe id" + viewPager.getCurrentItem());
	
	}
	
	
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
//		Log.d("TV", "OnSelect " + tab.getPosition()+ " nimi " + tab.getText());
//		Log.d("omalog"," lehe id" + viewPager.getCurrentItem());
		viewPager.setCurrentItem(tab.getPosition());
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	
	}

    // Actionbar menyy


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
class MyAdapter extends FragmentPagerAdapter
{

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		if (arg0 == 0)
		{	fragment = new FrHinded();
		}
		if (arg0 == 1)
		{	fragment = new FrKeskmine();}
		
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	
	
	}
