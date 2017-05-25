package com.example.hanheedo.test2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Pattern;

/**
 * Created by Han Heedo on 2017-03-29.
 */

public class SignUp extends AppCompatActivity {
    private EditText ID, NAME, PW, REPW, PNUM, GNAME;
    ArrayAdapter<CharSequence> spinner1, spinner2; // adapter 선언
    String sd, sgg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tag", "debugging message");
        setContentView(R.layout.signup);
        Log.d("tag", "debugging message");

        Intent intent = getIntent();
        String data = intent.getStringExtra("Login_SignUp");
        Log.d("tag", "debugging message");

        /////////////////////////////////////////////////////////////////

        ID = (EditText) findViewById(R.id.Id);
        NAME = (EditText) findViewById(R.id.Name);
        PW = (EditText) findViewById(R.id.Password);
        REPW = (EditText) findViewById(R.id.Password_confirm);
        PNUM = (EditText) findViewById(R.id.Phone_number);
        GNAME = (EditText) findViewById(R.id.custom_Group);

        final Spinner spin1 = (Spinner) findViewById(R.id.local_spinner1);
        final Spinner spin2 = (Spinner) findViewById(R.id.local_spinner2);

        spinner1 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_SD, R.layout.spinnerlayout);
        spin1.setAdapter(spinner1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sd = spinner1.getItem(i).toString();
                String sd = adapterView.getItemAtPosition(i).toString();

                if (spinner1.getItem(i).equals("")) {
                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_null_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("서울특별시")) {
                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_seoul_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("인천광역시")) {
                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_incheon_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("부산광역시")) {
                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Busan_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("대전광역시")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Daejeon_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("대구광역시")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Daegu_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("광주광역시")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Gwangju_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("울산광역시")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Ulsan_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("경기도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Gyeonggi_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("강원도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Gangwon_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("경상남도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Gyeongnam_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("경상북도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Gyeongbuk_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("전라남도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Jeollanam_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("전라북도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Jeollabuk_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("제주도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Jeju_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("충청남도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Chungcheongnam_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (spinner1.getItem(i).equals("충청북도")) {

                    spinner2 = ArrayAdapter.createFromResource(SignUp.this, R.array.spinner_Chungcheongbuk_SGG, R.layout.spinnerlayout);
                    spin2.setAdapter(spinner2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            sgg = spinner2.getItem(i).toString();
                            String sgg = adapterView.getItemAtPosition(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        /////////////////////////////////////////////////////////////////

        final EditText Id = (EditText) findViewById(R.id.Id); //Id
        Id.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout = (LinearLayout) findViewById(R.id.signup); //Id
        MainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Id.getWindowToken(), 0);
            }
        });

        final EditText Password = (EditText) findViewById(R.id.Password); //Password
        Password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout2 = (LinearLayout) findViewById(R.id.signup); //Password
        MainLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Password.getWindowToken(), 0);
            }
        });

        final EditText Name = (EditText) findViewById(R.id.Name); //Name
        Name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout3 = (LinearLayout) findViewById(R.id.signup); //Name
        MainLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Name.getWindowToken(), 0);
            }
        });

        final EditText RePassword = (EditText) findViewById(R.id.Password_confirm); //RePassword
        RePassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout4 = (LinearLayout) findViewById(R.id.signup); //RePassword
        MainLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(RePassword.getWindowToken(), 0);
            }
        });

        final EditText PhoneNumber = (EditText) findViewById(R.id.Phone_number); //P/N
        PhoneNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout5 = (LinearLayout) findViewById(R.id.signup); //P/N
        MainLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(PhoneNumber.getWindowToken(), 0);
            }
        });

        final EditText GroupName = (EditText) findViewById(R.id.custom_Group); //GroupName
        GroupName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout6 = (LinearLayout) findViewById(R.id.signup); //GroupName
        MainLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(GroupName.getWindowToken(), 0);
            }
        });
    }


    public void CancelClick(View view) {
        finish();
    }



    public void btn_regist(View view) {

        String id = ID.getText().toString();
        String name = NAME.getText().toString();
        String pw = PW.getText().toString();
        String pnum = PNUM.getText().toString();
        String gname = GNAME.getText().toString();

        if (ID.getText().toString().length() == 0) {
            Toast.makeText(SignUp.this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
            ID.requestFocus();
            return;
        }

        if (NAME.getText().toString().length() == 0) {
            Toast.makeText(SignUp.this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
            NAME.requestFocus();
            return;
        }

        if (PW.getText().toString().length() == 0) {
            Toast.makeText(SignUp.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            PW.requestFocus();
            return;
        }

        if (REPW.getText().toString().length() == 0) {
            Toast.makeText(SignUp.this, "비밀번호 확인을 입력하세요.", Toast.LENGTH_SHORT).show();
            REPW.requestFocus();
            return;
        }

        if (!PW.getText().toString().equals(REPW.getText().toString())) {
            Toast.makeText(SignUp.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            PW.setText("");
            REPW.setText("");
            PW.requestFocus();
            return;
        }

        if (!Pattern.matches("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$", pw)) // 4자리 - 16자리까지 가능
        {
            Toast.makeText(SignUp.this, "비밀번호 형식을 지켜주십시오.", Toast.LENGTH_SHORT).show();
            return;
        }

        insertToDataBase(id, name, pw, pnum, gname, sd, sgg);
        finish();
    }



    private void insertToDataBase(String id, String name, String pw, String pnum, String gname, String sd, String sgg) {
        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SignUp.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                try {
                    String id = (String) params[0];
                    String name = (String) params[1];
                    String pw = (String) params[2];
                    String pnum = (String) params[3];
                    String gname = (String) params[4];
                    String sd = (String) params[5];
                    String sgg = (String) params[6];


                    String link = "http://hido0604.dothome.co.kr/YI/signup.php";
                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                    data += "&" + URLEncoder.encode("pw", "UTF-8") + "=" + URLEncoder.encode(pw, "UTF-8");
                    data += "&" + URLEncoder.encode("pnum", "UTF-8") + "=" + URLEncoder.encode(pnum, "UTF-8");
                    data += "&" + URLEncoder.encode("gname", "UTF-8") + "=" + URLEncoder.encode(gname, "UTF-8");
                    data += "&" + URLEncoder.encode("sd", "UTF-8") + "=" + URLEncoder.encode(sd, "UTF-8");
                    data += "&" + URLEncoder.encode("sgg", "UTF-8") + "=" + URLEncoder.encode(sgg, "UTF-8");

                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
        }

        InsertData task = new InsertData();
        task.execute(id, name, pw, pnum, gname, sd, sgg);
    }

}