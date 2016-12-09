package com.example.terryma.hello;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.terryma.hello.common.fastjson.FastJsonConverterFactory;
import com.example.terryma.hello.requests.EmployeeListRequest;
import com.example.terryma.hello.response.base.Page;
import com.example.terryma.hello.response.employee.EmployeeBiz;
import com.example.terryma.hello.services.employee.EmployeeService;
import com.socks.library.KLog;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initActionBarHeaderInfo(navigationView);
    }

    /**
     * 初始化ActionBar 头部信息
     */
    private void initActionBarHeaderInfo(final NavigationView navigationView) {
        final HelloApplication application = (HelloApplication) getApplication();

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //httpClient.addInterceptor(logInterceptor);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("User-Agent", "HelloApk")
                        //.header("Accept", "application/vnd.yourapi.v1.full+json")
                        .header("Authorization","APP_KEYS " + application.getLastAppkey())
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.8.201:8080/")
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(client)
                .build();


        EmployeeListRequest employeeListRequest = new EmployeeListRequest();
        employeeListRequest.setLastAppKey(application.getLastAppkey());

        EmployeeService employeeService = retrofit.create(EmployeeService.class);
        Call<Page<EmployeeBiz>> empList = employeeService.list(employeeListRequest);

        empList.enqueue(new Callback<Page<EmployeeBiz>>() {
            @Override
            public void onResponse(Call<Page<EmployeeBiz>> call, Response<Page<EmployeeBiz>> response) {
                if (response.code() == 200) {
                    List<EmployeeBiz> data = response.body().getData();
                    if (data != null && !data.isEmpty()) {
                        EmployeeBiz employeeBiz = data.get(0);

                        //获取抽屉里面的控件
                        LinearLayout headerLayout = (LinearLayout) navigationView.getHeaderView(0);

                        TextView navUserCodeTextView = (TextView) headerLayout.findViewById(R.id.nav_user_code);
                        navUserCodeTextView.setText(employeeBiz.getCode());

                        TextView navUserNameView = (TextView) headerLayout.findViewById(R.id.nav_user_name);
                        navUserNameView.setText(employeeBiz.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Page<EmployeeBiz>> call, Throwable t) {
                String stackTraceString = Log.getStackTraceString(t);
                KLog.e(stackTraceString);
            }
        });


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
