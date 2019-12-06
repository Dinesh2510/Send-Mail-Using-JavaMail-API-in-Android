package com.demo.mail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;


public class test extends AppCompatActivity {
    EditText d_name, d_phone, d_address, d_lic, d_pan;
    Button btn_submit;

    private String str_name;
    private String str_phone;
    private String str_address;
    private String str_licence;
    private String str_pan_no;

    private JSONObject user_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_form);

        //EditText
        d_name = findViewById(R.id.driver_name);
        d_phone = findViewById(R.id.driver_phone_no);
        d_address = findViewById(R.id.driver_address);
        d_lic = findViewById(R.id.driver_lic);
        d_pan = findViewById(R.id.driver_pan_no);

        //Button
        btn_submit = findViewById(R.id.btn_driver_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_name = d_name.getText().toString().trim();
                str_phone = d_phone.getText().toString().trim();
                str_address = d_address.getText().toString().trim();
                str_licence = d_lic.getText().toString().trim();
                str_pan_no = d_pan.getText().toString().trim();


                if (!str_name.equals("")) {
                    if (!str_address.equals("")) {
                        if (!str_licence.equals("")) {

                            if (!str_pan_no.equals("")) {
                                //######MY MAIN ACTION IS HERE!
                                sendEmail();
                                Toast.makeText(test.this, "Data:" + str_name + str_address + str_phone + str_licence + str_pan_no, Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(test.this, "enter no person", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(test.this, "enter time", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(test.this, "enter to date", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(test.this, "enter from date", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    private void sendEmail() {
        //Getting content for email

        user_data = new JSONObject();
        try {
            user_data.put("name", str_name);
            user_data.put("phone", str_phone);
            user_data.put("address", str_address);
            user_data.put("license", str_licence);
            user_data.put("panNo", str_pan_no);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //run
        String email = "ENTER SENDER EMAIL HERE ";
        String subject = "EMAIL SUBJECT HERE";
        String message = "Name:"  + str_name + "\n" + "Phone NO.:" + str_phone + "\n" + "Address:" + str_address + "\n" + "Licence No.:" + str_licence + "\n" + " Pan Card/Addhar No:" + str_pan_no+"\n"+ str_name +"";
        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

}