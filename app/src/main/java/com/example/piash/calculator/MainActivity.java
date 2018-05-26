package com.example.piash.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTV, screenTV;
    private Button sinBtn, cosBtn, tanBtn, factorialBtn, onoffBtn;
    private Button openBBtn, closeBBtn, clearBtn, cleanBtn, powerBtn;
    private Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
    private Button plus, minus, multiplication, division, rootBtn, percent, onebyx;
    private Button pointBtn, equalBtn, piBtn;

    StringBuilder textMath = new StringBuilder("");
    StringBuilder textAns = new StringBuilder("");
    StringBuilder screenTextMath = new StringBuilder("");
    //double num1 = 0, num2 = 0, ans = 0;
    int checkSubmit = 0;
    int flag = 0;
    long factorial = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = findViewById(R.id.resultTV);
        screenTV = findViewById(R.id.screenTV);
        sinBtn = findViewById(R.id.sinBtn);
        sinBtn.setOnClickListener(this);
        cosBtn = findViewById(R.id.cosBtn);
        cosBtn.setOnClickListener(this);
        tanBtn = findViewById(R.id.tanBtn);
        tanBtn.setOnClickListener(this);
        factorialBtn = findViewById(R.id.factorialBtn);
        factorialBtn.setOnClickListener(this);
        openBBtn = findViewById(R.id.openBBtn);
        openBBtn.setOnClickListener(this);
        closeBBtn = findViewById(R.id.closeBBtn);
        closeBBtn.setOnClickListener(this);
        clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(this);
        cleanBtn = findViewById(R.id.cleanBtn);
        cleanBtn.setOnClickListener(this);
        powerBtn = findViewById(R.id.powerBtn);
        powerBtn.setOnClickListener(this);
        oneBtn = findViewById(R.id.oneBtn);
        oneBtn.setOnClickListener(this);
        twoBtn = findViewById(R.id.twoBtn);
        twoBtn.setOnClickListener(this);
        threeBtn = findViewById(R.id.threeBtn);
        threeBtn.setOnClickListener(this);
        fourBtn = findViewById(R.id.fourBtn);
        fourBtn.setOnClickListener(this);
        fiveBtn = findViewById(R.id.fiveBtn);
        fiveBtn.setOnClickListener(this);
        sixBtn = findViewById(R.id.sixBtn);
        sixBtn.setOnClickListener(this);
        sevenBtn = findViewById(R.id.sevenBtn);
        sevenBtn.setOnClickListener(this);
        eightBtn = findViewById(R.id.eightBtn);
        eightBtn.setOnClickListener(this);
        nineBtn = findViewById(R.id.nineBtn);
        nineBtn.setOnClickListener(this);
        zeroBtn = findViewById(R.id.zeroBtn);
        zeroBtn.setOnClickListener(this);
        plus = findViewById(R.id.plus);
        plus.setOnClickListener(this);
        minus = findViewById(R.id.minus);
        minus.setOnClickListener(this);
        multiplication = findViewById(R.id.multiplication);
        multiplication.setOnClickListener(this);
        division = findViewById(R.id.division);
        division.setOnClickListener(this);
        rootBtn = findViewById(R.id.rootBtn);
        rootBtn.setOnClickListener(this);
        percent = findViewById(R.id.percent);
        percent.setOnClickListener(this);
        onebyx = findViewById(R.id.onebyx);
        onebyx.setOnClickListener(this);
        pointBtn = findViewById(R.id.pointBtn);
        pointBtn.setOnClickListener(this);
        equalBtn = findViewById(R.id.equalBtn);
        equalBtn.setOnClickListener(this);
        piBtn = findViewById(R.id.piBtn);
        piBtn.setOnClickListener(this);
        onoffBtn = findViewById(R.id.onoffBtn);
        onoffBtn.setOnClickListener(this);

        OFFBtnPress();
    }


    public void error() {
        resultTV.setText("Math Error !");
        textAns = textMath = screenTextMath = new StringBuilder("");
    }


    public void submit(String[] elementMath) {
        InFixToPostFix ITP = new InFixToPostFix();
        if (textMath.length() > 0) {
            try {
                if (!ITP.check_error)
                    elementMath = ITP.processString(textMath.toString());        //	split expression to element
                if (!ITP.check_error)
                    elementMath = ITP.postfix(elementMath);        // 	format elements to postfix
                if (!ITP.check_error)
                    textAns = new StringBuilder(ITP.valueMath(elementMath));        // get result
                resultTV.setText(textAns);

                screenTextMath = new StringBuilder();
                textMath = new StringBuilder();
                checkSubmit = 1;

            } catch (Exception e) {
                error();
            }
            if (ITP.check_error) error();
        }
    }

    private void calcFactorial() {
        if (screenTV.getText().toString().equals("")) screenTV.setText("0");
        int num = Integer.parseInt(screenTV.getText().toString());
        for (int i = 1; i <= num; i++) {
            factorial = i * factorial;
        }

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String elementMath[] = null;


        if (id == R.id.zeroBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("0");
                screenTextMath.append("0");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.oneBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1");
                screenTextMath.append("1");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.twoBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("2");
                screenTextMath.append("2");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.threeBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("3");
                screenTextMath.append("3");
            }

            screenTV.setText(screenTextMath);
        } else if (id == R.id.fourBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("4");
                screenTextMath.append("4");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.fiveBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("5");
                screenTextMath.append("5");
            }
            screenTV.setText(screenTextMath.toString());
        } else if (id == R.id.sixBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("6");
                screenTextMath.append("6");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.sevenBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("7");
                screenTextMath.append("7");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.eightBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("8");
                screenTextMath.append("8");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.nineBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("9");
                screenTextMath.append("9");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.pointBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append(".");
                screenTextMath.append(".");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.piBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("π");
                screenTextMath.append("π");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.plus) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("+");
                screenTextMath.append("+");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.minus) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("-");
                screenTextMath.append("-");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.multiplication) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("*");
                screenTextMath.append("*");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.division) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("/");
                screenTextMath.append("/");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.powerBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("^(");
                screenTextMath.append("^(");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.rootBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("@");
                screenTextMath.append("√");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.sinBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("s(");
                screenTextMath.append("Sin(");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.cosBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("c(");
                screenTextMath.append("Cos(");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.tanBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("t(");
                screenTextMath.append("Tan(");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.openBBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("(");
                screenTextMath.append("(");
            }
            screenTV.setText(screenTextMath);
        } else if (id == R.id.closeBBtn) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append(")");
                screenTextMath.append(")");
            }
            screenTV.setText(screenTextMath);
        }


        //==========================================================
        else if (id == R.id.percent) {
            if (screenTextMath.length() == 0) screenTextMath = new StringBuilder("0");
            screenTextMath = new StringBuilder("(" + screenTextMath + ")%");
            screenTV.setText(screenTextMath.toString());
            if (checkSubmit == 0) submit(elementMath);
            textMath = new StringBuilder(textAns + "/100");
            submit(elementMath);
        } else if (id == R.id.onebyx) {
            if (screenTextMath.length() == 0) screenTextMath = new StringBuilder("0");
            screenTextMath = new StringBuilder("1/(" + screenTextMath + ")");
            screenTV.setText(screenTextMath);
            if (checkSubmit == 0) submit(elementMath);
            textMath = new StringBuilder("1/" + textAns);
            submit(elementMath);
        } else if (id == R.id.factorialBtn) {
            calcFactorial();
            resultTV.setText("Factorial of " + screenTV.getText().toString() + " is : " + factorial);
        } else if (id == R.id.equalBtn) {
            submit(elementMath);
        } else {
            if (id == R.id.cleanBtn) {
                textMath = new StringBuilder("");
                screenTextMath = new StringBuilder("");
                textAns = new StringBuilder("");
                resultTV.setText(textAns);
                factorial = 1;
                screenTV.setText("|");
            } else if (id == R.id.clearBtn) {
                if (screenTV.length() > 0) {
                    char c = textMath.charAt(textMath.length() - 1);
                    if (textMath.length() > 1 && c == '(' && textMath.charAt(textMath.length() - 2) == '^') {
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 2));
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                    } else if (textMath.length() > 1 && c == '(' && (textMath.charAt(textMath.length() - 2) == 's' || textMath.charAt(textMath.length() - 2) == 'c' || textMath.charAt(textMath.length() - 2) == 't')) {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 4));
                    } else {
                        textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                        screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                    }
                }
                screenTV.setText(screenTextMath);
            } else if (id == R.id.onoffBtn) {
                if (flag == 0) {
                    Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
                    onoffBtn.setTextColor(Color.RED);
                    ONBtnPress();
                    flag = 1;
                } else if (flag == 1) {
                    Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();
                    textMath = new StringBuilder("");
                    screenTextMath = new StringBuilder("");
                    textAns = new StringBuilder("");
                    resultTV.setText("");
                    factorial = 1;
                    screenTV.setText("");
                    OFFBtnPress();
                    onoffBtn.setTextColor(Color.GREEN);
                    flag = 0;
                }
            }
        }

    }

    private void ONBtnPress() {
        onoffBtn.setText("OFF");
        resultTV.setVisibility(View.VISIBLE);
        screenTV.setVisibility(View.VISIBLE);
        sinBtn.setEnabled(true);
        cosBtn.setEnabled(true);
        tanBtn.setEnabled(true);
        factorialBtn.setEnabled(true);
        //onoffBtn.setEnabled(false);
        openBBtn.setEnabled(true);
        closeBBtn.setEnabled(true);
        clearBtn.setEnabled(true);
        cleanBtn.setEnabled(true);
        powerBtn.setEnabled(true);
        oneBtn.setEnabled(true);
        twoBtn.setEnabled(true);
        threeBtn.setEnabled(true);
        fourBtn.setEnabled(true);
        fiveBtn.setEnabled(true);
        sixBtn.setEnabled(true);
        sevenBtn.setEnabled(true);
        eightBtn.setEnabled(true);
        nineBtn.setEnabled(true);
        zeroBtn.setEnabled(true);
        plus.setEnabled(true);
        minus.setEnabled(true);
        multiplication.setEnabled(true);
        division.setEnabled(true);
        rootBtn.setEnabled(true);
        percent.setEnabled(true);
        onebyx.setEnabled(true);
        pointBtn.setEnabled(true);
        equalBtn.setEnabled(true);
        piBtn.setEnabled(true);
    }


    private void OFFBtnPress() {
        onoffBtn.setText("ON");
        onoffBtn.setTextColor(Color.GREEN);
        resultTV.setVisibility(View.INVISIBLE);
        screenTV.setVisibility(View.INVISIBLE);
        sinBtn.setEnabled(false);
        cosBtn.setEnabled(false);
        tanBtn.setEnabled(false);
        factorialBtn.setEnabled(false);
        //onoffBtn.setEnabled(false);
        openBBtn.setEnabled(false);
        closeBBtn.setEnabled(false);
        clearBtn.setEnabled(false);
        cleanBtn.setEnabled(false);
        powerBtn.setEnabled(false);
        oneBtn.setEnabled(false);
        twoBtn.setEnabled(false);
        threeBtn.setEnabled(false);
        fourBtn.setEnabled(false);
        fiveBtn.setEnabled(false);
        sixBtn.setEnabled(false);
        sevenBtn.setEnabled(false);
        eightBtn.setEnabled(false);
        nineBtn.setEnabled(false);
        zeroBtn.setEnabled(false);
        plus.setEnabled(false);
        minus.setEnabled(false);
        multiplication.setEnabled(false);
        division.setEnabled(false);
        rootBtn.setEnabled(false);
        percent.setEnabled(false);
        onebyx.setEnabled(false);
        pointBtn.setEnabled(false);
        equalBtn.setEnabled(false);
        piBtn.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculator_menu, menu);
        return true;
    }

    public void exit(MenuItem item) {
        //Toast.makeText(this, "Bye Bye!!", Toast.LENGTH_SHORT).show();
        System.exit(0);
    }
}
