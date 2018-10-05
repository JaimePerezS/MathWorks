package com.example.jaime.tfg.ui.student.operationsGroup.resolveOperations;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.StudentSessionManager;
import com.example.jaime.tfg.data.model.Operation;
import com.example.jaime.tfg.data.model.OperationsRecord;
import com.example.jaime.tfg.ui.base.BaseActivity;
import com.example.jaime.tfg.utils.CheckFragmentDialog;
import com.example.jaime.tfg.utils.FinishFragmentDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ResolveOperationsActivity extends BaseActivity implements ResolveOperationsView, CheckFragmentDialog.CallBackCheckFragmentDialog, FinishFragmentDialog.CallBackCheckFragmentDialog {

    private static final String TAG = ResolveOperationsActivity.class.getSimpleName();

    private static final String ID_STUDENT = "idStudent";
    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String DIFFICULTY = "difficulty";
    private static final String ID_UUID = "idUuid";

    private Display display;

    private ConstraintLayout izqLayout;

    private ConstraintLayout sumResLayout;

    private TextView txtViewOperationSumRes;
    private TextView txtViewOperatorSumRes;

    private ConstraintLayout sumResSeparator;

    private EditText edTxtResultSumRes4;
    private EditText edTxtResultSumRes3;
    private EditText edTxtResultSumRes2;
    private EditText edTxtResultSumRes1;

    private ConstraintLayout multLayout;

    private TextView txtViewOperationMult1;
    private TextView txtViewOperationMult2;
    private TextView txtViewOperatorMult;
    private TextView txtViewOperatorMult2;
    private View separator1Mult;
    private View separator2Mult;

    private EditText edTxtResultMult15;
    private EditText edTxtResultMult14;
    private EditText edTxtResultMult13;
    private EditText edTxtResultMult12;
    private EditText edTxtResultMult11;

    private EditText edTxtResultMult25;
    private EditText edTxtResultMult24;
    private EditText edTxtResultMult23;
    private EditText edTxtResultMult22;
    private EditText edTxtResultMult21;

    private EditText edTxtResultMult36;
    private EditText edTxtResultMult35;
    private EditText edTxtResultMult34;
    private EditText edTxtResultMult33;
    private EditText edTxtResultMult32;
    private EditText edTxtResultMult31;

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_0;
    private Button btn_clear;

    private Button btnCheck;
    private Button btnExit;

    private String idStudent, idOperationsGroup, difficulty, token;

    private int value1, value2;

    private List<Operation> operationsList;

    private List<OperationsRecord> operationsRecordList = new ArrayList<OperationsRecord>();

    OperationsRecord operationsRecord;

    private ResolveOperationsPresenterImp presenter;

    private int position = 0;

    private StudentSessionManager session;

    boolean firstError;

    public static Intent getCallingIntent(Context context, String idStudent, String idOperationsGroup, String difficulty, String token){
        Intent intent = new Intent(context, ResolveOperationsActivity.class);

        intent.putExtra(ID_STUDENT, idStudent);
        intent.putExtra(ID_OPERATIONS_GROUP, idOperationsGroup);
        intent.putExtra(DIFFICULTY, difficulty);
        intent.putExtra(ID_UUID, token);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_resolve_operations);

        display = getWindowManager().getDefaultDisplay();

        session = new StudentSessionManager(getApplicationContext());

        presenter = new ResolveOperationsPresenterImp(this);

        izqLayout = findViewById(R.id.izqLayout);

        sumResLayout = findViewById(R.id.sumResLayout);

        txtViewOperationSumRes = findViewById(R.id.txtViewOperacionE);
        txtViewOperatorSumRes = findViewById(R.id.txtViewOperador);

        sumResSeparator = findViewById(R.id.separator);

        edTxtResultSumRes4 = findViewById(R.id.edTxtResultado5);
        edTxtResultSumRes3 = findViewById(R.id.edTxtResultado4);
        edTxtResultSumRes2 = findViewById(R.id.edTxtResultado2);
        edTxtResultSumRes1 = findViewById(R.id.edTxtResultado1);

        edTxtResultSumRes4.setShowSoftInputOnFocus(false);
        edTxtResultSumRes3.setShowSoftInputOnFocus(false);
        edTxtResultSumRes2.setShowSoftInputOnFocus(false);
        edTxtResultSumRes1.setShowSoftInputOnFocus(false);

        edTxtResultSumRes4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultSumRes4);
                }
            }
        });

        edTxtResultSumRes3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultSumRes3);
                }
            }
        });

        edTxtResultSumRes2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultSumRes2);
                }
            }
        });

        edTxtResultSumRes1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultSumRes1);
                }
            }
        });

        multLayout = findViewById(R.id.multLayout);

        txtViewOperationMult1 = findViewById(R.id.txtViewOperacionMult1);
        txtViewOperationMult2 = findViewById(R.id.txtViewOperacionMult2);
        txtViewOperatorMult = findViewById(R.id.txtViewOperadorMult);
        txtViewOperatorMult2 = findViewById(R.id.txtViewOperadorMult2);
        separator1Mult = findViewById(R.id.separatorMult);
        separator2Mult = findViewById(R.id.separator2Mult);

        edTxtResultMult11 = findViewById(R.id.edTxtResultadoMult11);
        edTxtResultMult12 = findViewById(R.id.edTxtResultadoMult12);
        edTxtResultMult13 = findViewById(R.id.edTxtResultadoMult13);
        edTxtResultMult14 = findViewById(R.id.edTxtResultadoMult14);
        edTxtResultMult15 = findViewById(R.id.edTxtResultadoMult15);

        edTxtResultMult21 = findViewById(R.id.edTxtResultadoMult21);
        edTxtResultMult22 = findViewById(R.id.edTxtResultadoMult22);
        edTxtResultMult23 = findViewById(R.id.edTxtResultadoMult23);
        edTxtResultMult24 = findViewById(R.id.edTxtResultadoMult24);
        edTxtResultMult25 = findViewById(R.id.edTxtResultadoMult25);

        edTxtResultMult31 = findViewById(R.id.edTxtResultadoMult31);
        edTxtResultMult32 = findViewById(R.id.edTxtResultadoMult32);
        edTxtResultMult33 = findViewById(R.id.edTxtResultadoMult33);
        edTxtResultMult34 = findViewById(R.id.edTxtResultadoMult34);
        edTxtResultMult35 = findViewById(R.id.edTxtResultadoMult35);
        edTxtResultMult36 = findViewById(R.id.edTxtResultadoMult36);

        edTxtResultMult11.setShowSoftInputOnFocus(false);
        edTxtResultMult12.setShowSoftInputOnFocus(false);
        edTxtResultMult13.setShowSoftInputOnFocus(false);
        edTxtResultMult14.setShowSoftInputOnFocus(false);
        edTxtResultMult15.setShowSoftInputOnFocus(false);

        edTxtResultMult21.setShowSoftInputOnFocus(false);
        edTxtResultMult22.setShowSoftInputOnFocus(false);
        edTxtResultMult23.setShowSoftInputOnFocus(false);
        edTxtResultMult24.setShowSoftInputOnFocus(false);
        edTxtResultMult25.setShowSoftInputOnFocus(false);

        edTxtResultMult31.setShowSoftInputOnFocus(false);
        edTxtResultMult32.setShowSoftInputOnFocus(false);
        edTxtResultMult33.setShowSoftInputOnFocus(false);
        edTxtResultMult34.setShowSoftInputOnFocus(false);
        edTxtResultMult35.setShowSoftInputOnFocus(false);
        edTxtResultMult36.setShowSoftInputOnFocus(false);

        edTxtResultMult11.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult11);
                }
            }
        });

        edTxtResultMult12.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult12);
                }
            }
        });

        edTxtResultMult13.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult13);
                }
            }
        });

        edTxtResultMult14.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult14);
                }
            }
        });

        edTxtResultMult15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult15);
                }
            }
        });

        edTxtResultMult21.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult21);
                }
            }
        });

        edTxtResultMult22.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult22);
                }
            }
        });

        edTxtResultMult23.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult23);
                }
            }
        });

        edTxtResultMult24.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult24);
                }
            }
        });

        edTxtResultMult25.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult25);
                }
            }
        });

        edTxtResultMult31.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult31);
                }
            }
        });

        edTxtResultMult32.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult32);
                }
            }
        });

        edTxtResultMult33.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult33);
                }
            }
        });

        edTxtResultMult34.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult34);
                }
            }
        });

        edTxtResultMult35.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult35);
                }
            }
        });

        edTxtResultMult36.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtResultMult36);
                }
            }
        });

        btn_1 = findViewById(R.id.numero_1);
        btn_2 = findViewById(R.id.numero_2);
        btn_3 = findViewById(R.id.numero_3);
        btn_4 = findViewById(R.id.numero_4);
        btn_5 = findViewById(R.id.numero_5);
        btn_6 = findViewById(R.id.numero_6);
        btn_7 = findViewById(R.id.numero_7);
        btn_8 = findViewById(R.id.numero_8);
        btn_9 = findViewById(R.id.numero_9);
        btn_0 = findViewById(R.id.numero_0);

        btn_clear = findViewById(R.id.borrar);

        btnCheck = findViewById(R.id.btnComprobar);
        btnExit = findViewById(R.id.btnSalir);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ResolveOperationsActivity.this);

                alertDialog.setTitle("Salir");
                alertDialog.setMessage("Aún te quedan operaciones por hacer. ¿Estás seguro de que deseas salir?");
                alertDialog.setPositiveButton(R.string.alertDialog_si, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        finish();
                    }
                });

                alertDialog.setNegativeButton(R.string.alertDialog_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialog.show();
            }
        });

        Bundle bundle = getIntent().getExtras();

        idStudent = bundle.getString(ID_STUDENT);
        idOperationsGroup = bundle.getString(ID_OPERATIONS_GROUP);
        difficulty = bundle.getString(DIFFICULTY);
        token = bundle.getString(ID_UUID);

        presenter.getOperations(idStudent, idOperationsGroup, token);

        getSupportActionBar().hide();

    }

    @Override
    public void loadOperations(List<Operation> operationList) {
        this.operationsList = operationList;
        showOperation();
    }

    private void showOperation() {

        firstError = false;

        Operation operation = operationsList.get(position);
        final String statement = operation.getStatement();
        final String solution = operation.getSolution();

        operationsRecord = new OperationsRecord(0,operation.getPuntos(), operation.getId());

        String operators[];

        if(statement.contains("+") || statement.contains("-")){

            if(statement.contains("+")) {
                txtViewOperatorSumRes.setText("\n" + "+");
                operators = statement.split("\\+");
            } else {
                txtViewOperatorSumRes.setText("\n" + "-");
                operators = statement.split("\\-");
            }

            multLayout.setVisibility(View.INVISIBLE);
            sumResLayout.setVisibility(View.VISIBLE);

            setEditTextVisibleSumRes(solution.length());

            for(int i = 0; i < operators.length -1 ; i++) {
                txtViewOperationSumRes.append(operators[i] + "\n");
            }
            txtViewOperationSumRes.append(operators[operators.length - 1]);

            btnCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean result;

                    result = checkSumResSolution();

                    if(!result) {
                        operationsRecord.setMistakes(operationsRecord.getMistakes() + 1);
                        if(firstError == false) {
                            firstError = true;
                            subPoints();
                        }
                    }

                    FragmentManager fm = getFragmentManager();
                    CheckFragmentDialog checkFragmentDialog = CheckFragmentDialog.newInstance(result);
                    checkFragmentDialog.show(fm, "fragment_dialog_comprobar");
                }
            });

        } else if(statement.contains("*")) {

            edTxtResultMult15.requestFocus();

            operators = statement.split("\\*");
            txtViewOperatorMult.setText("\n" + "x");

            sumResLayout.setVisibility(View.INVISIBLE);
            multLayout.setVisibility(View.VISIBLE);

            setEditTextVisibleMult(operators, solution);

            txtViewOperationMult1.append(operators[0]);
            txtViewOperationMult2.append(operators[1]);

            btnCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean result;

                    result = checkMultSolution();

                    if(!result) {
                        operationsRecord.setMistakes(operationsRecord.getMistakes() + 1);
                        if(firstError == false) {
                            firstError = true;
                            subPoints();
                        }
                    }

                    FragmentManager fm = getFragmentManager();

                    CheckFragmentDialog checkFragmentDialog = CheckFragmentDialog.newInstance(result);
                    checkFragmentDialog.show(fm, "fragment_dialog_comprobar");
                }
            });

        }
    }

    private void setKeyBoardEvents(final EditText currentFocus) {
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("9");
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentFocus.append("0");
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentFocus.getText().length() != 0) {
                    currentFocus.setText(currentFocus.getText().subSequence(0, currentFocus.getText().length() -1));
                }
            }
        });
    }

    private void setEditTextVisibleSumRes(int solutionLength) {

        if(solutionLength == 4) {
            edTxtResultSumRes1.setVisibility(View.VISIBLE);
            edTxtResultSumRes2.setVisibility(View.VISIBLE);
            edTxtResultSumRes3.setVisibility(View.VISIBLE);
            edTxtResultSumRes4.setVisibility(View.VISIBLE);

        } else if(solutionLength == 3) {
            edTxtResultSumRes2.setVisibility(View.VISIBLE);
            edTxtResultSumRes3.setVisibility(View.VISIBLE);
            edTxtResultSumRes4.setVisibility(View.VISIBLE);
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) sumResSeparator.getLayoutParams();
            params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());;
            sumResSeparator.setLayoutParams(params);

        } else if(solutionLength == 2) {
            edTxtResultSumRes3.setVisibility(View.VISIBLE);
            edTxtResultSumRes4.setVisibility(View.VISIBLE);
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) sumResSeparator.getLayoutParams();
            params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 160, getResources().getDisplayMetrics());;
            sumResSeparator.setLayoutParams(params);

        } else {
            edTxtResultSumRes4.setVisibility(View.VISIBLE);
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) sumResSeparator.getLayoutParams();
            params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, getResources().getDisplayMetrics());;

            sumResSeparator.setLayoutParams(params);
        }
        edTxtResultSumRes4.requestFocus();
    }

    private boolean checkSumResSolution() {
        String[] solutionSplited = operationsList.get(position).getSolution().split("(?!^)");
        int position = 0;

        boolean solution = true;

        if(edTxtResultSumRes1.getVisibility() == View.VISIBLE) {
            if(!solutionSplited[position].equals(edTxtResultSumRes1.getText().toString())) {
                solution = false;
                edTxtResultSumRes1.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtResultSumRes1.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtResultSumRes2.getVisibility() == View.VISIBLE) {
            if(!solutionSplited[position].equals(edTxtResultSumRes2.getText().toString())) {
                solution = false;
                edTxtResultSumRes2.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtResultSumRes2.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtResultSumRes3.getVisibility() == View.VISIBLE) {
            if(!solutionSplited[position].equals(edTxtResultSumRes3.getText().toString())) {
                solution = false;
                edTxtResultSumRes3.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtResultSumRes3.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtResultSumRes4.getVisibility() == View.VISIBLE) {
            if(!solutionSplited[position].equals(edTxtResultSumRes4.getText().toString())) {
                solution = false;
                edTxtResultSumRes4.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtResultSumRes4.setBackgroundResource(R.drawable.edtxt);
            }
        }

        return solution;
    }

    private void clearEditextSumRes() {
        txtViewOperationSumRes.setText("");

        edTxtResultSumRes1.setText("");
        edTxtResultSumRes2.setText("");
        edTxtResultSumRes3.setText("");
        edTxtResultSumRes4.setText("");

        edTxtResultSumRes4.setVisibility(View.GONE);
        edTxtResultSumRes3.setVisibility(View.GONE);
        edTxtResultSumRes2.setVisibility(View.GONE);
        edTxtResultSumRes1.setVisibility(View.GONE);

        izqLayout.requestFocus();
    }

    private void setEditTextVisibleMult(String[] operands, String solution) {

        String multiplying = operands[0];
        char [] multiplier = operands[1].toCharArray();

        if(multiplier.length == 1) {

            separator2Mult.setVisibility(View.INVISIBLE);
            txtViewOperatorMult2.setVisibility(View.INVISIBLE);

            if(operationsList.get(position).getSolution().length() == 5) {

                edTxtResultMult11.setVisibility(View.VISIBLE);
                edTxtResultMult12.setVisibility(View.VISIBLE);
                edTxtResultMult13.setVisibility(View.VISIBLE);
                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);

            } else if(operationsList.get(position).getSolution().length() == 4) {

                edTxtResultMult12.setVisibility(View.VISIBLE);
                edTxtResultMult13.setVisibility(View.VISIBLE);
                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);

            } else if(operationsList.get(position).getSolution().length() == 3) {

                edTxtResultMult13.setVisibility(View.VISIBLE);
                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) separator1Mult.getLayoutParams();
                params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());;
                separator1Mult.setLayoutParams(params);

            } else if(operationsList.get(position).getSolution().length() == 2) {

                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) separator1Mult.getLayoutParams();
                params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 160, getResources().getDisplayMetrics());;
                separator1Mult.setLayoutParams(params);

            } else if(operationsList.get(position).getSolution().length() == 1) {
                edTxtResultMult15.setVisibility(View.VISIBLE);
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) separator1Mult.getLayoutParams();
                params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, getResources().getDisplayMetrics());;
                separator1Mult.setLayoutParams(params);
            }

        } else {

            separator2Mult.setVisibility(View.VISIBLE);
            txtViewOperatorMult2.setVisibility(View.VISIBLE);

            value1 = Integer.parseInt(multiplying) * Character.getNumericValue(multiplier[1]);
            value2 = Integer.parseInt(multiplying) * Character.getNumericValue(multiplier[0]);

            int value1Length = String.valueOf(value1).length();
            int value2Length = String.valueOf(value2).length();

            ConstraintLayout.LayoutParams paramsMult = (ConstraintLayout.LayoutParams) separator1Mult.getLayoutParams();

            switch (value1Length) {

                case 5:
                    edTxtResultMult11.setVisibility(View.VISIBLE);
                    edTxtResultMult12.setVisibility(View.VISIBLE);
                    edTxtResultMult13.setVisibility(View.VISIBLE);
                    edTxtResultMult14.setVisibility(View.VISIBLE);
                    edTxtResultMult15.setVisibility(View.VISIBLE);
                case 4:
                    edTxtResultMult12.setVisibility(View.VISIBLE);
                    edTxtResultMult13.setVisibility(View.VISIBLE);
                    edTxtResultMult14.setVisibility(View.VISIBLE);
                    edTxtResultMult15.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    edTxtResultMult13.setVisibility(View.VISIBLE);
                    edTxtResultMult14.setVisibility(View.VISIBLE);
                    edTxtResultMult15.setVisibility(View.VISIBLE);
                    paramsMult.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());;
                    separator1Mult.setLayoutParams(paramsMult);
                    break;
                case 2:
                    edTxtResultMult14.setVisibility(View.VISIBLE);
                    edTxtResultMult15.setVisibility(View.VISIBLE);
                    paramsMult.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 160, getResources().getDisplayMetrics());;
                    separator1Mult.setLayoutParams(paramsMult);

                    break;
                case 1:
                    edTxtResultMult15.setVisibility(View.VISIBLE);
                    paramsMult.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, getResources().getDisplayMetrics());;
                    separator1Mult.setLayoutParams(paramsMult);
                    break;
            }

            switch (value2Length) {
                case 5:
                    edTxtResultMult21.setVisibility(View.VISIBLE);
                    edTxtResultMult22.setVisibility(View.VISIBLE);
                    edTxtResultMult23.setVisibility(View.VISIBLE);
                    edTxtResultMult24.setVisibility(View.VISIBLE);
                    edTxtResultMult25.setVisibility(View.VISIBLE);
                    break;

                case 4:
                    edTxtResultMult22.setVisibility(View.VISIBLE);
                    edTxtResultMult23.setVisibility(View.VISIBLE);
                    edTxtResultMult24.setVisibility(View.VISIBLE);
                    edTxtResultMult25.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    edTxtResultMult23.setVisibility(View.VISIBLE);
                    edTxtResultMult24.setVisibility(View.VISIBLE);
                    edTxtResultMult25.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    edTxtResultMult24.setVisibility(View.VISIBLE);
                    edTxtResultMult25.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    edTxtResultMult25.setVisibility(View.VISIBLE);
                    break;
            }

            if(solution.length() == 6) {
                edTxtResultMult31.setVisibility(View.VISIBLE);
                edTxtResultMult32.setVisibility(View.VISIBLE);
                edTxtResultMult33.setVisibility(View.VISIBLE);
                edTxtResultMult34.setVisibility(View.VISIBLE);
                edTxtResultMult35.setVisibility(View.VISIBLE);
                edTxtResultMult36.setVisibility(View.VISIBLE);

            } else if(solution.length() == 5) {
                edTxtResultMult32.setVisibility(View.VISIBLE);
                edTxtResultMult33.setVisibility(View.VISIBLE);
                edTxtResultMult34.setVisibility(View.VISIBLE);
                edTxtResultMult35.setVisibility(View.VISIBLE);
                edTxtResultMult36.setVisibility(View.VISIBLE);

            } else if(solution.length() == 4) {
                edTxtResultMult33.setVisibility(View.VISIBLE);
                edTxtResultMult34.setVisibility(View.VISIBLE);
                edTxtResultMult35.setVisibility(View.VISIBLE);
                edTxtResultMult36.setVisibility(View.VISIBLE);

            } else if(solution.length() == 3) {
                edTxtResultMult34.setVisibility(View.VISIBLE);
                edTxtResultMult35.setVisibility(View.VISIBLE);
                edTxtResultMult36.setVisibility(View.VISIBLE);

            } else if(solution.length() == 2) {
                edTxtResultMult35.setVisibility(View.VISIBLE);
                edTxtResultMult36.setVisibility(View.VISIBLE);
            } else {
                edTxtResultMult36.setVisibility(View.VISIBLE);
            }
        }
        edTxtResultMult15.requestFocus();
    }

    private boolean checkMultSolution() {
        String[] value1Splited = String.valueOf(value1).split("(?!^)");
        String[] value2Splited = String.valueOf(value2).split("(?!^)");
        String[] solutionSplited = operationsList.get(position).getSolution().split("(?!^)");

        int position = 0;

        boolean solution = true;

        if(edTxtResultMult36.getVisibility() == View.VISIBLE) {

            if(edTxtResultMult11.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult11.getText().toString().equals(value1Splited[position])) {
                    solution = false;
                    edTxtResultMult11.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult11.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult12.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult12.getText().toString().equals(value1Splited[position])) {
                    solution = false;
                    edTxtResultMult12.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult12.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult13.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult13.getText().toString().equals(value1Splited[position])) {
                    solution = false;
                    edTxtResultMult13.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult13.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult14.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult14.getText().toString().equals(value1Splited[position])) {
                    solution = false;
                    edTxtResultMult14.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult14.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult15.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult15.getText().toString().equals(value1Splited[position])) {
                    solution = false;
                    edTxtResultMult15.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult15.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            position = 0;

            if(edTxtResultMult21.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult21.getText().toString().equals(value2Splited[position])) {
                    solution = false;
                    edTxtResultMult21.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult21.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult22.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult22.getText().toString().equals(value2Splited[position])) {
                    solution = false;
                    edTxtResultMult22.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult22.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult23.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult23.getText().toString().equals(value2Splited[position])) {
                    solution = false;
                    edTxtResultMult23.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult23.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult24.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult24.getText().toString().equals(value2Splited[position])) {
                    solution = false;
                    edTxtResultMult24.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult24.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult25.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult25.getText().toString().equals(value2Splited[position])) {
                    solution = false;
                    edTxtResultMult25.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult25.setBackgroundResource(R.drawable.edtxt);
                }
            }

            position = 0;

            if(edTxtResultMult31.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult31.getText().toString().equals(solutionSplited[position])){
                    solution = false;
                    edTxtResultMult31.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult31.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult32.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult32.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult32.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult32.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult33.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult33.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult33.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult33.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult34.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult34.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult34.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult34.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }
            if(edTxtResultMult35.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult35.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult35.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult35.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(!edTxtResultMult36.getText().toString().equals(solutionSplited[position])) {
                solution = false;
                edTxtResultMult36.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtResultMult36.setBackgroundResource(R.drawable.edtxt);
            }

        } else {
            if(edTxtResultMult11.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult11.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult11.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult31.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult12.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult12.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult12.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult31.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult13.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult13.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult13.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult13.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult14.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult14.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult14.setBackgroundResource(R.drawable.edtxt_error);
                } else {
                    edTxtResultMult14.setBackgroundResource(R.drawable.edtxt);
                }
                ++position;
            }

            if(edTxtResultMult15.getVisibility() == View.VISIBLE) {
                if(!edTxtResultMult15.getText().toString().equals(solutionSplited[position])) {
                    solution = false;
                    edTxtResultMult15.setBackgroundResource(R.drawable.edtxt_error);
                } else  {
                    edTxtResultMult15.setBackgroundResource(R.drawable.edtxt);
                }
            }
        }

        return solution;
    }

    private void clearMultEditSolution() {

        txtViewOperationMult1.setText("");
        txtViewOperationMult2.setText("");

        edTxtResultMult11.setText("");
        edTxtResultMult12.setText("");
        edTxtResultMult13.setText("");
        edTxtResultMult14.setText("");
        edTxtResultMult15.setText("");

        edTxtResultMult21.setText("");
        edTxtResultMult22.setText("");
        edTxtResultMult23.setText("");
        edTxtResultMult24.setText("");
        edTxtResultMult25.setText("");

        edTxtResultMult31.setText("");
        edTxtResultMult32.setText("");
        edTxtResultMult33.setText("");
        edTxtResultMult34.setText("");
        edTxtResultMult35.setText("");
        edTxtResultMult36.setText("");

        edTxtResultMult11.setVisibility(View.GONE);
        edTxtResultMult12.setVisibility(View.GONE);
        edTxtResultMult13.setVisibility(View.GONE);
        edTxtResultMult14.setVisibility(View.GONE);
        edTxtResultMult15.setVisibility(View.GONE);

        txtViewOperatorMult2.setVisibility(View.GONE);

        edTxtResultMult21.setVisibility(View.GONE);
        edTxtResultMult22.setVisibility(View.GONE);
        edTxtResultMult23.setVisibility(View.GONE);
        edTxtResultMult24.setVisibility(View.GONE);
        edTxtResultMult25.setVisibility(View.GONE);

        separator2Mult.setVisibility(View.GONE);

        edTxtResultMult31.setVisibility(View.GONE);
        edTxtResultMult32.setVisibility(View.GONE);
        edTxtResultMult33.setVisibility(View.GONE);
        edTxtResultMult34.setVisibility(View.GONE);
        edTxtResultMult35.setVisibility(View.GONE);
        edTxtResultMult36.setVisibility(View.GONE);

        izqLayout.requestFocus();

    }

    private void subPoints() {
        if(difficulty.equals("Medio")) {
            operationsRecord.setPointsObtained(operationsList.get(position).getPuntos() - 1);
        } else if(difficulty.equals("Difícil")) {
            operationsRecord.setPointsObtained(operationsList.get(position).getPuntos() - 2);
        }
    }

    @Override
    public void onClickBtnNext() {
        if(position < operationsList.size() - 1) {
            position++;
            clearEditextSumRes();
            clearMultEditSolution();
            operationsRecordList.add(operationsRecord);
            showOperation();
        } else if(position == operationsList.size() - 1){

            operationsRecordList.add(operationsRecord);

            int totalPoints = 0;

            for(int i = 0; i < operationsRecordList.size(); i++) {
                totalPoints += operationsRecordList.get(i).getPointsObtained();
            }

            presenter.insertOperationsGroupRecord(getDateTime(), totalPoints, operationsRecordList, idStudent, idOperationsGroup, token);

            presenter.updatePoints(idStudent,totalPoints + session.getStudentDetails().getPoints(), token);
            session.updatePoints(totalPoints + session.getStudentDetails().getPoints());

            FragmentManager fm = getFragmentManager();

            FinishFragmentDialog finishFragmentDialog = FinishFragmentDialog.newInstance(totalPoints);
            finishFragmentDialog.show(fm, "fragment_dialog_finish");
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    @Override
    public void onClickBtnExit() {
        finish();
    }
}
