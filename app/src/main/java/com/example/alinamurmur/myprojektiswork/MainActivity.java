package com.example.alinamurmur.myprojektiswork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.alinamurmur.myprojektiswork.Fragments.Anketa;
import com.example.alinamurmur.myprojektiswork.Fragments.ArticleFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.CalendarFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.CalendarMonthFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.ContactsFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.DiscountFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.DiscountsFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.FragmentScroll;
import com.example.alinamurmur.myprojektiswork.Fragments.JournalFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.MainFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.NewsFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.NotificationsFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.SectionFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.ServicesFragment;
import com.example.alinamurmur.myprojektiswork.Fragments.TelKniga;
import com.example.alinamurmur.myprojektiswork.Interfaces.eventListener;

//import com.example.alinamurmur.myprojektiswork.Fragments.DataFragment;


public class MainActivity extends AppCompatActivity
        implements eventListener, JournalFragment.ListListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private boolean mToolBarNavigationListenerIsRegistered = false;
    int count1 = 4;
    int count2 = 5;
   // public int selectedItem =0;
    Fragment tempFragment;
    FragmentTransaction tempFragmTran;
    Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        setMenuCounter(R.id.skidki, count1);
        setMenuCounter(R.id.opovech, count2);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Checking if the item is in checked state or not, if not make it in checked state
              //  if (menuItem.isChecked()) menuItem.setChecked(false);
              //  else menuItem.setChecked(true);
                uncheckAllMenuItems(navigationView);
                displaySelectedScreen(menuItem.getItemId());

                if (menuItem.getItemId() == R.id.skidki) {
                    count1 = 0;
                    setMenuCounter(R.id.skidki, count1);
                }
                if (menuItem.getItemId() == R.id.opovech) {
                    count2 = 0;
                    setMenuCounter(R.id.opovech, count2);
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        tempFragment = new MainFragment();
        tempFragmTran = getSupportFragmentManager().beginTransaction();
        tempFragmTran.add(R.id.content_frame, tempFragment).commit();
    }
    //click on drawerlayout
    private void displaySelectedScreen(int itemId) {
       // selectedItem = itemId;

        switch (itemId) {
            case R.id.glav:
                tempFragment = new MainFragment();
              //  navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case R.id.news:
                tempFragment = NewsFragment.newInstance("http://garazh.space/rvt/represent/get_article2.php", 0);
                break;
            case R.id.trud:
                tempFragment = new JournalFragment();
                break;
            case R.id.strelok:
                tempFragment = SectionFragment.newInstance(1);
                break;
            case R.id.rostov:
                tempFragment = SectionFragment.newInstance(2);
                break;
            case R.id.molodeg:
                tempFragment = SectionFragment.newInstance(3);
                break;
            case R.id.skidki:
                tempFragment = new DiscountsFragment();
                break;
            case R.id.opovech:
                tempFragment = new NotificationsFragment();
                break;
            case R.id.tel:
                tempFragment = new TelKniga();
                break;

        }

        if (!(tempFragment == null || itemId == R.id.glav)) {
            tempFragmTran = getSupportFragmentManager().beginTransaction();

            getSupportFragmentManager().popBackStack(null,
                    getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
            tempFragmTran.replace(R.id.content_frame, tempFragment)
                    .addToBackStack(null)
                    .commit();
            enableViews(true);

        } else {
            tempFragmTran = getSupportFragmentManager().beginTransaction();

            getSupportFragmentManager().popBackStack(null,
                    getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
            tempFragmTran.replace(R.id.content_frame, tempFragment)
                    .commit();
            enableViews(false);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            enableViews(false);
        }
        uncheckAllMenuItems(navigationView);
    }

    void setMenuCounter(@IdRes int itemId, int count) {
        TextView view = (TextView) navigationView.getMenu().findItem(itemId).getActionView();
        view.setText(count > 0 ? String.valueOf(count) : null);
    }

    @Override
    public void someEvent(int i) { //6 buttons on main screen
       // selectedItem = i;
        switch (i) {
            case 1:
                tempFragment = NewsFragment.newInstance("http://garazh.space/rvt/represent/get_article2.php", 0);
                break;
            case 2:
                tempFragment = new JournalFragment();
                break;
            case 3:
                tempFragment = SectionFragment.newInstance(1);
                break;
            case 4:
                tempFragment = SectionFragment.newInstance(2);
                break;
            case 5:
                tempFragment = SectionFragment.newInstance(3);
                break;
            case 6:
                tempFragment = new DiscountsFragment();
                break;
        }

        if (tempFragment != null) {
            replaceFragment(tempFragment, tempFragmTran);
            enableViews(true);
            navigationView.getMenu().getItem(i).setChecked(true);
        }

    }


    public void sectionClickListener(int i, int section) {
        switch (i) {
            case 1:
                tempFragment = NewsFragment.newInstance("http://garazh.space/rvt/represent/get_article2.php?section="+section, section);
                replaceFragment(tempFragment, tempFragmTran);
                break;
            case 2:
                tempFragment = new CalendarFragment();
                replaceFragment(tempFragment, tempFragmTran);
                break;
            case 3:
                tempFragment = ContactsFragment.newInstance(section);
                replaceFragment(tempFragment, tempFragmTran);
                break;
            case 4:
                tempFragment = ServicesFragment.newInstance(section);
                replaceFragment(tempFragment, tempFragmTran);
                break;
        }
    }

    public void onMonthSelected (String month) {
        tempFragment = CalendarMonthFragment.newInstance(month);
        replaceFragment(tempFragment, tempFragmTran);
    }

    public void onArticleSelected (String title, int id, int section) {
        tempFragment = ArticleFragment.newInstance(title, id, section);
        replaceFragment(tempFragment, tempFragmTran);
    }

    public void onDiscountSelected (String title) {
        tempFragment = DiscountFragment.newInstance(title);
        replaceFragment(tempFragment, tempFragmTran);
    }

    public void onEventSelected (String title) {
        //tempFragment = DataFragment.newInstance(title);
        replaceFragment(tempFragment, tempFragmTran);
    }

    public void onReturnToSection (int section) {
        tempFragment = NewsFragment.newInstance("http://garazh.space/rvt/represent/get_article2.php?section="+section, section);
        replaceFragment(tempFragment, tempFragmTran);
    }

    private void enableViews(boolean enable) {
        // To keep states of ActionBar and ActionBarDrawerToggle synchronized,
        // when you enable on one, you disable on the other.
        // And as you may notice, the order for this operation is disable first, then enable - VERY VERY IMPORTANT.
        if (enable) {
            // Remove hamburger
            actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
            // Show back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // when DrawerToggle is disabled i.e. setDrawerIndicatorEnabled(false), navigation icon
            // clicks are disabled i.e. the UP button will not work.
            // We need to add a listener, as in below, so DrawerToggle will forward
            // click events to this listener.
            if (!mToolBarNavigationListenerIsRegistered) {
                actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Doesn't have to be onBackPressed
                        onBackPressed();
                        String a = String.valueOf(getSupportFragmentManager().getBackStackEntryCount());
                    }
                });

                mToolBarNavigationListenerIsRegistered = true;
            }
        } else {
            // Remove back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            actionBarDrawerToggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }
    }

    public void onZClick(View view){
        Anketa anketa = new Anketa();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.linearSkidki, anketa)
                .commit();
    }

    public void replaceFragment (Fragment f, FragmentTransaction ft) {
        uncheckAllMenuItems(navigationView);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, f)
                .addToBackStack(null)
                .commit();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

      //  navigationView.getMenu().getItem(selectedItem).setChecked(true);
    }

    private void uncheckAllMenuItems(NavigationView navigationView) {
        final Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            item.setChecked(false);
            }
    }

    @Override
    public void itemClicked(int id) {
        FragmentScroll fragment = new FragmentScroll();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragment.getSelected(id);
        replaceFragment(fragment,fragmentTransaction);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        this.menu = menu;
        setToolbarCounter(Integer.toString(count2));
        return true;
    }

   private void setToolbarCounter(String string) {

       MenuItem item =  menu.findItem(R.id.sobits);
       item.setTitle(string);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        replaceFragment(new NotificationsFragment(),ft);
        setMenuCounter(R.id.opovech,0);
        setToolbarCounter("");
        return super.onOptionsItemSelected(item);
    }
}

