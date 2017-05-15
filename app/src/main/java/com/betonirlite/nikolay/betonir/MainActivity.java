package com.betonirlite.nikolay.betonir;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    AlertDialog.Builder ad;
    AlertDialog.Builder ad2;
    AlertDialog.Builder ad3;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        int icon = (R.drawable.ic_info);

        /*int title = (R.string.moget_plata);
        int button1String = (R.string.soglasen);
        int button2String = (R.string.otmena);
        //String message = "Выбери пищу";
        //String button1String = "Ок";
        //String button2String = "No   ";

        ad = new AlertDialog.Builder(context);
        ad.setTitle(title);  // заголовок
        ad.setIcon(icon);  // заголовок
        //ad.setMessage(message); // сообщение
        ad.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {

                Intent a = new Intent(MainActivity.this,WebArmaturaActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 startActivity(a);
            }
        });
        ad.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                //Toast.makeText(context, "Возможно вы правы", Toast.LENGTH_LONG)
                        //.show();
            }
        });
        ad.setCancelable(true);
        ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                //Toast.makeText(context, "Вы ничего не выбрали",
                        //Toast.LENGTH_LONG).show();
            }
        });

        ad2 = new AlertDialog.Builder(context);
        ad2.setTitle(title);  // заголовок
        ad2.setIcon(icon);  // заголовок
        //ad.setMessage(message); // сообщение
        ad2.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {

                Uri address = Uri.parse("https://www.google.com.ua/maps/search/бетон по близости");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openlinkIntent);
            }
        });
        ad2.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                //Toast.makeText(context, "Возможно вы правы", Toast.LENGTH_LONG)
                //.show();
            }
        });
        ad2.setCancelable(true);
        ad2.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                //Toast.makeText(context, "Вы ничего не выбрали",
                //Toast.LENGTH_LONG).show();
            }
        });

        ad3 = new AlertDialog.Builder(context);
        ad3.setTitle(title);  // заголовок
        ad3.setIcon(icon);  // заголовок
        //ad.setMessage(message); // сообщение
        ad3.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {

                Uri address = Uri.parse("https://www.google.com.ua/maps/search/металобаза по близости");
                Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openlinkIntent);
            }
        });
        ad3.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                //Toast.makeText(context, "Возможно вы правы", Toast.LENGTH_LONG)
                //.show();
            }
        });
        ad3.setCancelable(true);
        ad3.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                //Toast.makeText(context, "Вы ничего не выбрали",
                //Toast.LENGTH_LONG).show();
            }
        });*/

        /*FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this,PlusActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);

            }
        });*/
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long mills = 40L;
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(mills);
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String textToSend="https://play.google.com/store/apps/details?id=com.betonirlite.nikolay.betonir";
                intent.putExtra(Intent.EXTRA_TEXT, textToSend);
                try
                {
                    startActivity(Intent.createChooser(intent, "Поделится приложением"));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(getApplicationContext(), "Some error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
       //         WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.info_beton) {

            Intent a = new Intent(this,WebArmaturaActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);

        } else if (id == R.id.info_hellp) {

            Intent a = new Intent(this,HellpActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(a);


    }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.navi_beton) {

           Uri address = Uri.parse("https://www.google.com.ua/maps/search/бетон по близости");
           Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
           startActivity(openlinkIntent);

        } else if (id == R.id.navi_armatura) {

           Uri address = Uri.parse("https://www.google.com.ua/maps/search/металобаза по близости");
           Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
           startActivity(openlinkIntent);


       } else if (id == R.id.versia_pro) {

           Intent intent = new Intent(Intent.ACTION_VIEW);
           intent.setData(Uri.parse("market://details?id=com.betonir.nikolay.betonir"));
           startActivity(intent);



    } else if (id == R.id.market) {



        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Dastory+Studio"));
        startActivity(intent);

    } else if (id == R.id.pod) {


        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String textToSend="https://play.google.com/store/apps/details?id=com.lite.my.masterok";
        intent.putExtra(Intent.EXTRA_TEXT, textToSend);
        try
        {
            startActivity(Intent.createChooser(intent, "Поделится приложением"));
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(getApplicationContext(), "Some error", Toast.LENGTH_SHORT).show();
        }}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        String rString = getString(R.string.fundament_menu);
        String rString2 = getString(R.string.dastroyka_menu);
        String rString3 = getString(R.string.plita_menu);
        String rString4 = getString(R.string.kolonna_menu);

        adapter.addFrag(new FunFragment(), rString);
        adapter.addFrag(new PristFragment(), rString2);
        adapter.addFrag(new PlitaFragment(), rString3);
        adapter.addFrag(new KolonaFragment(), rString4);


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    /*public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            Toast.makeText(context, "Вы выбрали Wi Fi",
                    Toast.LENGTH_LONG).show();

            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {

            Toast.makeText(context, "Вы выбрали Data",
                    Toast.LENGTH_LONG).show();
            //return false;
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }*/


}
