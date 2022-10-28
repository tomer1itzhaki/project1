
package com.example.project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1to10;
    Button btn1o50;
    Button btn1to100;
    private int Random;
    Button button;
    Button buttonminus;
    Button buttonplus;
    Button buttonenter;
    private int guess=1;
    TextView numbertext;
    private int counter=0;
    TextView response;
    TextView countertext;
    Button buttonrestart;
    SharedPreferences sp;
    Button btnSave;
    String strfname,strlname;
    EditText etFname,etLname;
    TextView name;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);



        if(item.getItemId()==R.id.action_first)
        {
            Toast.makeText(MainActivity.this,"you have selected 1-10",Toast.LENGTH_LONG).show();
            Random = (int)(Math.random()*10)+1;
            return true;

        }
        if(item.getItemId()==R.id.action_second)
        {
            Toast.makeText(MainActivity.this,"you have selected 1-50",Toast.LENGTH_LONG).show();
            Random = (int)(Math.random()*50)+1;
            return true;
        }
        if(item.getItemId()==R.id.action_third)
        {
            Toast.makeText(MainActivity.this,"you have selected 1-100",Toast.LENGTH_LONG).show();
            Random = (int)(Math.random()*100)+1;
            return true;
        }
        return false;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        buttonminus=findViewById(R.id.button2);
        buttonplus=findViewById(R.id.button3);
        buttonenter=findViewById(R.id.button4);
        numbertext=findViewById(R.id.textView);
        response=findViewById(R.id.textView2);
        countertext=findViewById(R.id.textView3);
        buttonrestart=findViewById(R.id.button5);
        btnSave=findViewById(R.id.button6);
        etFname=findViewById(R.id.etFname);
        etLname=findViewById(R.id.etLname);
        name=findViewById(R.id.textView4);


        sp = getSharedPreferences("details1",0);
        strfname = sp.getString("fname",null);
        strlname = sp.getString("lname",null);
        if(strfname!=null&&strlname!=null)
        {

        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnSave==v)
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("fname",etFname.getText().toString());
                    editor.putString("lname",etLname.getText().toString());
                    editor.commit();

                    View a=findViewById(R.id.button6);
                    a.setVisibility(View.GONE);
                    View b=findViewById(R.id.etLname);
                    b.setVisibility(View.GONE);
                    View c=findViewById(R.id.etFname);
                    c.setVisibility(View.GONE);
                    View e=findViewById(R.id.textView4);
                    e.setVisibility(View.VISIBLE);
                    View d=findViewById(R.id.button);
                    d.setVisibility(View.VISIBLE);
                    strfname=sp.getString("fname",null);
                    strlname=sp.getString("lname",null);
                    name.setText("hello:"+strfname+" "+strlname);


                }
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View a = findViewById(R.id.button);
                a.setVisibility(View.GONE);
                View b =findViewById(R.id.button2);
                b.setVisibility(View.VISIBLE);
                View c =findViewById(R.id.button3);
                c.setVisibility(View.VISIBLE);
                View d =findViewById(R.id.button4);
                d.setVisibility(View.VISIBLE);


                numbertext.setText(""+guess);


            }

        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess--;
                numbertext.setText(""+guess);

            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess++;
                numbertext.setText(""+guess);

            }
        });
        buttonenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("guess");
                alert.setMessage("are you sure you want to send your guess");
                alert.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counter++;
                        if(guess>Random)
                        {
                            response.setText("Too High");


                        }
                        if(guess<Random)
                        {
                            response.setText("Too Low");

                        }
                        if (guess==Random)
                        {
                            View b =findViewById(R.id.button2);
                            b.setVisibility(View.GONE);
                            View c =findViewById(R.id.button3);
                            c.setVisibility(View.GONE);
                            View d =findViewById(R.id.button4);
                            d.setVisibility(View.GONE);
                            guess=1;
                            countertext.setText(counter+" Tries");
                            counter=0;
                            response.setText("");
                            numbertext.setText("");
                            View e =findViewById(R.id.button5);
                            e.setVisibility(View.VISIBLE);


                        }

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.create().show();
            }
        });


        buttonrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View b =findViewById(R.id.button2);
                b.setVisibility(View.VISIBLE);
                View c =findViewById(R.id.button3);
                c.setVisibility(View.VISIBLE);
                View d =findViewById(R.id.button4);
                d.setVisibility(View.VISIBLE);
                View e =findViewById(R.id.button5);
                e.setVisibility(View.GONE);
                numbertext.setText(""+guess);
                countertext.setText("");
            }
        });




    }
}