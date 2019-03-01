package com.example.praveshsingh.mycalculator;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import bsh.EvalError;
import bsh.Interpreter;


public class
MainActivity extends AppCompatActivity {
    LinearLayout linear;
    GridLayout gridLayout;
    Button butleft, butdel, butright, but7, but8, but9, but4, but5, but6, but1, but2, but3, butpoint, butzero, butequal, butdivide, butmultiply, butsubtract, butplus;
    TextView input, result;
    StringBuffer res = new StringBuffer("");
    StringBuffer show = new StringBuffer("");
    boolean addzerodot = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Use long tap clear  to clear all", Toast.LENGTH_SHORT).show();
        gridLayout = findViewById(R.id.gridlayout);
        butleft = findViewById(R.id.butleftparanthesis);
        butdel = findViewById(R.id.butdel);
        linear = findViewById(R.id.linearlayout);
        butright = findViewById(R.id.butrightparanthesis);
        butdivide = findViewById(R.id.butdivide);
        butmultiply = findViewById(R.id.butmultiply);
        butsubtract = findViewById(R.id.butminus);
        butplus = findViewById(R.id.butplus);
        butequal = findViewById(R.id.butequals);
        butpoint = findViewById(R.id.butpoint);
        butzero = findViewById(R.id.but0);
        but9 = findViewById(R.id.but9);
        but8 = findViewById(R.id.but8);
        but7 = findViewById(R.id.but7);
        but6 = findViewById(R.id.but6);
        but5 = findViewById(R.id.but5);
        but4 = findViewById(R.id.but4);
        but3 = findViewById(R.id.but3);
        but2 = findViewById(R.id.but2);
        but1 = findViewById(R.id.but1);
        input = findViewById(R.id.calculations);
        result = findViewById(R.id.result);


        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("9");
                show.append("9");
                addzerodot = false;
                input.setText(show);
                doCalc(res);
            }
        });
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("8");
                show.append("8");
                addzerodot = false;
                input.setText(show);
                doCalc(res);
            }
        });
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("7");
                show.append("7");
                addzerodot = false;
                input.setText(show);
                doCalc(res);
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("6");
                show.append("6");
                addzerodot = false;
                input.setText(show);
                doCalc(res);
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("5");
                show.append("5");
                addzerodot = false;
                input.setText(show);
                doCalc(res);

            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("4");
                show.append("4");
                addzerodot = false;
                input.setText(show);
                doCalc(res);

            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("3");
                show.append("3");
                addzerodot = false;
                input.setText(show);
                doCalc(res);

            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("2");
                show.append("2");
                addzerodot = false;
                input.setText(show);
                doCalc(res);

            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.append("1");
                show.append("1");
                addzerodot = false;
                input.setText(show);
                doCalc(res);

            }
        });
        butzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addzerodot = false;
                res.append("0");
                show.append("0");
                input.setText(show);
                doCalc(res);
            }
        });
        butmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addzerodot = true;

                if (show.toString().endsWith("×")) {
                    return;
                } else if (show.toString().endsWith("-") || show.toString().endsWith("+") || show.toString().endsWith("÷") || show.toString().endsWith("%")) {
                    show.setCharAt(show.length() - 1, '×');
                    res.setCharAt(res.length() - 1, '*');
                } else {
                    show.append("×");
                    res.append("*");
                }
                input.setText(show);

            }
        });
        butplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addzerodot = true;
                if (show.toString().endsWith("+")) {
                    return;
                } else if (show.toString().endsWith("-") || show.toString().endsWith("×") || show.toString().endsWith("÷") || show.toString().endsWith("%")) {
                    show.setCharAt(show.length() - 1, '+');
                    res.setCharAt(res.length() - 1, '+');
                } else {
                    show.append("+");
                    res.append("+");
                }
                input.setText(show);

            }
        });
        butsubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addzerodot = true;

                if (show.toString().endsWith("-")) {
                    return;
                } else if (show.toString().endsWith("+") || show.toString().endsWith("×") || show.toString().endsWith("÷") || show.toString().endsWith("%")) {
                    show.setCharAt(show.length() - 1, '-');
                    res.setCharAt(res.length() - 1, '-');
                } else {
                    show.append("-");
                    res.append("-");
                }
                input.setText(show);
            }
        });

        butdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addzerodot = true;


                if (show.toString().endsWith("÷")) {
                    return;
                } else if (show.toString().endsWith("-") || show.toString().endsWith("+") || show.toString().endsWith("×") || show.toString().endsWith("%")) {
                    show.setCharAt(show.length() - 1, '÷');
                    res.setCharAt(res.length() - 1, '/');
                } else {
                    show.append("÷");
                    res.append("/");
                }
                input.setText(show);
            }
        });
        butequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCalc(res);
            }
        });
        butpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter = 0;
                if (show.toString().equals("")) {
                    show.append("0.");
                    res.append("0.");
                    input.setText(show);

                } else {
                    for (int i = 0; i < res.length(); i++) {
                        if (res.charAt(i) == '.') {
                            counter++;
                        }
                        if (res.charAt(i) == '+' ||
                                res.charAt(i) == '-' ||
                                res.charAt(i) == '/' ||
                                res.charAt(i) == '*') {
                            counter = 0;
                        }
                    }
                    if (counter == 0 && !addzerodot) {
                        show.append(".");
                        res.append(".");
                        input.setText(show);
                    }
                    if (counter == 0 && addzerodot) {
                        show.append("0.");
                        res.append("0.");
                        input.setText(show);
                    }
                }

            }
        });
        butdel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                show.delete(0, show.length());
                res.delete(0, res.length());
                makeAnimation(view);
                input.setText("");
                result.setText("");
                return false;
            }
        });
        butdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show.length() > 0) {
                    show.delete(show.length() - 1, show.length());
                    res.delete(res.length() - 1, res.length());
                    input.setText(show);
                }
            }
        });
        butleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addzerodot = true;
                show.append("(");
                res.append("(");

                input.setText(show);

            }
        });
        butright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addzerodot = true;
                show.append(")");
                res.append(")");

                input.setText(show);

            }
        });

    }

    void doCalc(StringBuffer calc) {
        Interpreter interpreter = new Interpreter();
        String answer = new String();
        try {
            answer = String.valueOf(interpreter.eval(calc.toString()));

        } catch (EvalError evalError) {
            evalError.printStackTrace();
        } finally {
            if (answer.equals("null")) {
                result.setText("Invalid Input");
            } else {
                result.setText(answer);
            }
        }
    }

    void makeAnimation(View view) {
        int centerx = view.getLeft();
        int centery = view.getHeight()+view.getWidth();
        float finalradius = Math.max(linear.getWidth(), linear.getHeight()) * 2.0f;
        Animator animator = ViewAnimationUtils.createCircularReveal(linear, centerx, centery, 0, finalradius);
        animator.setDuration(700);
        animator.start();
    }
}



