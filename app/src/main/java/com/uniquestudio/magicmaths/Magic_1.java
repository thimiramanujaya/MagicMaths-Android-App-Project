package com.uniquestudio.magicmaths;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Magic_1 extends AppCompatActivity {

    Button bM, reset;
    private EditText n1,n2;
    TextView Myage, nM, warn;

    int num_1, num_2, ag, numM, sb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bM=findViewById(R.id.btn_magic);
        n1=findViewById(R.id.num1);
        n2=findViewById(R.id.num2);
        Myage=findViewById(R.id.age);
        nM=findViewById(R.id.num_mind);
        warn=findViewById(R.id.warning);
        reset=findViewById(R.id.button2);

        n1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                n1.setHint("");
            }
        });

        n2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                n2.setHint("");
            }
        });

     /*   n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n2.setEnabled(true);
            }
        });  */


        bM.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

         if ((n1.getText().toString().length() == 0) || (n2.getText().toString().length() == 0))   {
             finish();
             startActivity(getIntent());
             Toast.makeText(getApplicationContext(),"Oops!, ඔබ මායාව සදහා නිවැරදි ව දායක නොවේ !", Toast.LENGTH_LONG).show();
         }
         else {

             num_1 = Integer.parseInt(n1.getText().toString());
             num_2 = Integer.parseInt(n2.getText().toString());

            /*Myage.setText("");
            nM.setText("");
            warn.setText("");*/

        /*if(((num_1<=2) && (num_2 <=28))) {
            warn.setText("!?? Oops..Wrong Input !");
        }
        else if(((num_1>=92) && (num_2>=28)))  {
            warn.setText("!?? Oops..Wrong Input !");
        }
        else if(((num_1 <2) || (num_1>92))) {
            warn.setText("!?? Oops..Wrong Input !");
        }*/

             if (num_1 < 2) {
                 warn.setVisibility(View.VISIBLE);
                 warn.setText("!?? Oops..Wrong Input !");
                 Myage.setText("-");
                 nM.setText("-");

             } else if ((num_1 == 2) && (num_2 < 29)) {
                 warn.setVisibility(View.VISIBLE);
                 warn.setText("!?? Oops..Wrong Input !");
                 Myage.setText("-");
                 nM.setText("-");

             } else if ((num_1 == 2) && (num_2 > 28)) {
                 if (((num_2 >= 0) && (num_2 < 28)) && ((num_1 >= 0) && (num_1 < 93))) {
                     numM = num_2 + 72;
                     ag = num_1 + 7;

                     Myage.setText(String.valueOf(ag));
                     nM.setText(String.valueOf(numM));
                     warn.setVisibility(View.INVISIBLE);

                 } else if (((num_2 >= 28) && (num_2 < 100)) && ((num_1 >= 0 && num_1 < 92))) {
                     sb2 = num_2 + 72;
                     numM = sb2 - 100;

                     ag = num_1 + 8;

                     Myage.setText(String.valueOf(ag));
                     nM.setText(String.valueOf(numM));
                     warn.setVisibility(View.INVISIBLE);
                 }
             } else if (((num_1 > 2) && (num_1 < 92)) && ((num_2 >= 0) && (num_2 < 99))) {

                 if (((num_2 >= 0) && (num_2 < 28)) && ((num_1 >= 0) && (num_1 < 93))) {
                     numM = num_2 + 72;
                     ag = num_1 + 7;

                     Myage.setText(String.valueOf(ag));
                     nM.setText(String.valueOf(numM));
                     warn.setVisibility(View.INVISIBLE);

                 } else if (((num_2 >= 28) && (num_2 < 100)) && ((num_1 >= 0 && num_1 < 92))) {
                     sb2 = num_2 + 72;
                     numM = sb2 - 100;

                     ag = num_1 + 8;

                     Myage.setText(String.valueOf(ag));
                     nM.setText(String.valueOf(numM));
                     warn.setVisibility(View.INVISIBLE);
                 }
             } else if ((num_1 == 92) && (num_2 < 28)) {
                 if (((num_2 >= 0) && (num_2 < 28)) && ((num_1 >= 0) && (num_1 < 93))) {
                     numM = num_2 + 72;
                     ag = num_1 + 7;

                     Myage.setText(String.valueOf(ag));
                     nM.setText(String.valueOf(numM));
                     warn.setVisibility(View.INVISIBLE);

                 } else if (((num_2 >= 28) && (num_2 < 100)) && ((num_1 >= 0 && num_1 < 92))) {
                     sb2 = num_2 + 72;
                     numM = sb2 - 100;

                     ag = num_1 + 8;

                     Myage.setText(String.valueOf(ag));
                     nM.setText(String.valueOf(numM));
                     warn.setVisibility(View.INVISIBLE);
                 }
             } else if ((num_1 == 92) && (num_2 > 27)) {
                 warn.setVisibility(View.VISIBLE);
                 warn.setText("!?? Oops..Wrong Input !");
                 Myage.setText("-");
                 nM.setText("-");

             } else if (num_1 > 92) {
                 warn.setVisibility(View.VISIBLE);
                 warn.setText("!?? Oops..Wrong Input !");
                 Myage.setText("-");
                 nM.setText("-");

             } else if (num_2 > 99) {
                 warn.setVisibility(View.VISIBLE);
                 warn.setText("!?? Oops..Wrong Input !");
                 Myage.setText("-");
                 nM.setText("-");
             }

         }










        /*else if (getString(R.string.number1).equals(n1.getText().toString())) {
            warn.setText("!? Please input values?");
        }
        else if (getString(R.string.number2).equals(n2.getText().toString())) {
            warn.setText("!? Please input values?");
        }
        else if (getString(R.string.number3).equals(n1.getText().toString())) {
            warn.setText("!? Please input values?");
        }
        else if (getString(R.string.number4).equals(n2.getText().toString())) {
            warn.setText("!? Please input values?");
        }

        else if ((n1.equals("") || (n2.equals("")))) {
            warn.setText("!? Please input values?");
        }
        else if ((n1.equals("මෙහි ඇතුල් කරන්න.") || (n2.equals("මෙහි ඇතුල් කරන්න.")))) {
            warn.setText("!?? Oops..Wrong Input !");
        }


         else {
            if (((num_2 >= 0) && (num_2 < 28)) && ((num_1 >= 0) && (num_1 < 93))) {
                    numM = num_2 + 72;
                    ag = num_1 + 7;

                    Myage.setText(String.valueOf(ag));
                    nM.setText(String.valueOf(numM));

                } else if (((num_2 >= 28) && (num_2 < 100)) && ((num_1 >= 0 && num_1 < 92))) {
                    sb2 = num_2 + 72;
                    numM = sb2 - 100;

                    ag = num_1 + 8;

                    Myage.setText(String.valueOf(ag));
                    nM.setText(String.valueOf(numM));
                }
            }*/


        }
    });

       n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Myage.setText("");
                nM.setText("");
                warn.setVisibility(View.INVISIBLE);
                warn.setText("");
            //  n2.setEnabled(true);
            }
        });




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });


    }
}