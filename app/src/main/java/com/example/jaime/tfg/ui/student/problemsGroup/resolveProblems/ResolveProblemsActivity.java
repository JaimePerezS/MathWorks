package com.example.jaime.tfg.ui.student.problemsGroup.resolveProblems;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.StudentSessionManager;
import com.example.jaime.tfg.data.model.Problem;
import com.example.jaime.tfg.data.model.ProblemsRecord;
import com.example.jaime.tfg.ui.base.BaseActivity;
import com.example.jaime.tfg.utils.CheckFragmentDialog;
import com.example.jaime.tfg.utils.CheckOperationTypeFragmentDialog;
import com.example.jaime.tfg.utils.FinishFragmentDialog;
import com.example.jaime.tfg.utils.HelpFragmentDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ResolveProblemsActivity extends BaseActivity implements ResolveProblemsView, CheckFragmentDialog.CallBackCheckFragmentDialog, FinishFragmentDialog.CallBackCheckFragmentDialog {

    private static final String TAG = ResolveProblemsActivity.class.getSimpleName();

    private static final String ID_STUDENT = "idStudent";
    private static final String ID_PROBLEMS_GROUP = "idProblemsGroup";
    private static final String DIFFICULTY = "difficuly";
    private static final String ID_UUID = "idUuid";

    private ConstraintLayout izqLayout;

    private ConstraintLayout operLayout;
    private GridLayout keyboard;

    private ConstraintLayout sumResLayout;

    private TextView txtViewOperatorSumRes;

    private View sumResSeparator;

    private EditText edTxtAddSub11;
    private EditText edTxtAddSub12;
    private EditText edTxtAddSub13;

    private EditText edTxtAddSub21;
    private EditText edTxtAddSub22;
    private EditText edTxtAddSub23;

    private EditText edTxtResultSumRes4;
    private EditText edTxtResultSumRes3;
    private EditText edTxtResultSumRes2;
    private EditText edTxtResultSumRes1;

    private ConstraintLayout multLayout;

    private EditText edTxtMult11;
    private EditText edTxtMult12;
    private EditText edTxtMult13;
    private EditText edTxtMult14;

    private EditText edTxtMult21;
    private EditText edTxtMult22;

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

    private TextView txtViewStatement;

    private Button btnAdd;
    private Button btnSub;
    private Button btnMult;

    private Button btnCheck;
    private Button btnExit;

    private Button btnHelp;

    private List<Problem> problems;

    private List<ProblemsRecord> problemsRecordList = new ArrayList<ProblemsRecord>();

    ProblemsRecord problemsRecord;

    private int position = 0;

    private String idStudent;
    private String idProblemsGroup;
    private String difficulty;
    private String token;

    private ResolveProblemsPresenterImp presenter;

    private int value1, value2;

    private StudentSessionManager session;

    boolean firstError;

    public static Intent getCallingIntent(Context context, String idStudent, String idProblemsGroup, String difficulty, String token){
        Intent intent = new Intent(context, ResolveProblemsActivity.class);

        intent.putExtra(ID_STUDENT, idStudent);
        intent.putExtra(ID_PROBLEMS_GROUP, idProblemsGroup);
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

        setContentView(R.layout.activity_resolve_problems);

        session = new StudentSessionManager(getApplicationContext());

        presenter = new ResolveProblemsPresenterImp(this);

        izqLayout = findViewById(R.id.izqLayout);

        sumResLayout = findViewById(R.id.sumResLayout);

        edTxtAddSub11 = findViewById(R.id.edTxtSumRes11);
        edTxtAddSub12 = findViewById(R.id.edTxtSumRes12);
        edTxtAddSub13 = findViewById(R.id.edTxtSumRes13);

        edTxtAddSub21 = findViewById(R.id.edTxtSumRes21);
        edTxtAddSub22 = findViewById(R.id.edTxtSumRes22);
        edTxtAddSub23 = findViewById(R.id.edTxtSumRes23);

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

        edTxtAddSub11.setShowSoftInputOnFocus(false);
        edTxtAddSub12.setShowSoftInputOnFocus(false);
        edTxtAddSub13.setShowSoftInputOnFocus(false);

        edTxtAddSub21.setShowSoftInputOnFocus(false);
        edTxtAddSub22.setShowSoftInputOnFocus(false);
        edTxtAddSub23.setShowSoftInputOnFocus(false);

        edTxtResultSumRes4.setShowSoftInputOnFocus(false);
        edTxtResultSumRes3.setShowSoftInputOnFocus(false);
        edTxtResultSumRes2.setShowSoftInputOnFocus(false);
        edTxtResultSumRes1.setShowSoftInputOnFocus(false);

        edTxtAddSub11.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtAddSub11);
                }
            }
        });

        edTxtAddSub12.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtAddSub12);
                }
            }
        });

        edTxtAddSub13.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtAddSub13);
                }
            }
        });

        edTxtAddSub21.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtAddSub21);
                }
            }
        });

        edTxtAddSub22.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtAddSub22);
                }
            }
        });

        edTxtAddSub23.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtAddSub23);
                }
            }
        });

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

        edTxtMult11 = findViewById(R.id.edTxtMult11);
        edTxtMult12 = findViewById(R.id.edTxtMult12);
        edTxtMult13 = findViewById(R.id.edTxtMult13);
        edTxtMult14 = findViewById(R.id.edTxtMult14);

        edTxtMult21 = findViewById(R.id.edTxtMult21);
        edTxtMult22 = findViewById(R.id.edTxtMult22);

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

        edTxtMult11.setShowSoftInputOnFocus(false);
        edTxtMult12.setShowSoftInputOnFocus(false);
        edTxtMult13.setShowSoftInputOnFocus(false);
        edTxtMult14.setShowSoftInputOnFocus(false);

        edTxtMult21.setShowSoftInputOnFocus(false);
        edTxtMult22.setShowSoftInputOnFocus(false);

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

        edTxtMult11.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtMult11);
                }
            }
        });

        edTxtMult12.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtMult12);
                }
            }
        });

        edTxtMult13.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtMult13);
                }
            }
        });

        edTxtMult14.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtMult14);
                }
            }
        });

        edTxtMult21.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtMult21);
                }
            }
        });

        edTxtMult22.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    setKeyBoardEvents(edTxtMult22);
                }
            }
        });

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

        Bundle bundle = getIntent().getExtras();

        idStudent = bundle.getString(ID_STUDENT);
        idProblemsGroup = bundle.getString(ID_PROBLEMS_GROUP);
        difficulty = bundle.getString(DIFFICULTY);
        token = bundle.getString(ID_UUID);

        operLayout = findViewById(R.id.operLayout);
        keyboard = findViewById(R.id.tecladoLayout);

        txtViewStatement = findViewById(R.id.txtViewEnunciado);

        btnAdd = findViewById(R.id.btnSumar);
        btnSub = findViewById(R.id.btnRestar);
        btnMult = findViewById(R.id.btnMultiplicar);

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

        btnHelp = findViewById(R.id.btnAyuda);

        presenter.getProblems(idStudent, idProblemsGroup, token);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(problems.get(position).getOperationType().equals("Sumar")) {
                    showOperation();
                }
                else {
                    problemsRecord.setMistakesIdent(problemsRecord.getMistakesIdent() + 1);
                    showCheckOperationTypeFragmentDialog();
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(problems.get(position).getOperationType().equals("Restar")) {
                    showOperation();
                }
                else {
                    problemsRecord.setMistakesIdent(problemsRecord.getMistakesIdent() + 1);
                    showCheckOperationTypeFragmentDialog();
                }
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(problems.get(position).getOperationType().equals("Multiplicar")) {
                    showOperation();
                } else {
                    problemsRecord.setMistakesIdent(problemsRecord.getMistakesIdent() + 1);
                    showCheckOperationTypeFragmentDialog();
                }
            }
        });

        btnExit = findViewById(R.id.btnSalir);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ResolveProblemsActivity.this);

                alertDialog.setTitle("Salir");
                alertDialog.setMessage("Aún te quedan problemas por hacer. ¿Estás seguro de que deseas salir?");
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

        if(difficulty.equals("Fácil")) {
            btnHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showHelpFragmentDialog(problems.get(position).getHelp());
                }
            });
        } else if(difficulty.equals("Medio")) {
            btnHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showHelpFragmentDialog(problems.get(position).getHelp());
                }
            });
        } else {
            btnHelp.setVisibility(View.INVISIBLE);
        }

        getSupportActionBar().hide();
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void loadProblems(List<Problem> problems) {
        this.problems = problems;

        Log.d(TAG, String.valueOf(problems.get(position).getPuntos()));

        loadProblem();
    }

    void showElection() {
        operLayout.setVisibility(View.VISIBLE);

        keyboard.setVisibility(View.INVISIBLE);

        btnCheck.setVisibility(View.INVISIBLE);

        problemsRecord = new ProblemsRecord(0,0,problems.get(position).getPuntos(), problems.get(position).getId());
    }

    void showOperation(){

        firstError = false;

        operLayout.setVisibility(View.INVISIBLE);

        btnCheck.setVisibility(View.VISIBLE);

        keyboard.setVisibility(View.VISIBLE);

        String operation = problems.get(position).getOperation();
        final String solution = problems.get(position).getSolution();
        final String operators[];

        if(operation.contains("+") || operation.contains("-")){

            if(operation.contains("+")) {
                txtViewOperatorSumRes.setText("\n" + "+");
                operators = operation.split("\\+");
            } else {
                txtViewOperatorSumRes.setText("\n" + "-");
                operators = operation.split("\\-");
            }

            multLayout.setVisibility(View.INVISIBLE);
            sumResLayout.setVisibility(View.VISIBLE);

            setEditTextVisibleSumRes(operators, solution.length());

            btnCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean result;

                    result = checkSumResSolution(operators);

                    if(!result) {
                        problemsRecord.setMistakesOper(problemsRecord.getMistakesOper() + 1);
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

        } else if(operation.contains("*")) {

            operators = operation.split("\\*");
            txtViewOperatorMult.setText("\n" + "x");

            sumResLayout.setVisibility(View.INVISIBLE);
            multLayout.setVisibility(View.VISIBLE);

            setEditTextVisibleMult(operators, solution);

            btnCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean result;

                    result = checkMultSolution(operators);

                    if(!result) {
                        problemsRecord.setMistakesOper(problemsRecord.getMistakesOper() + 1);

                        if(firstError == false) {
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

    void loadProblem() {
        txtViewStatement.setText(problems.get(position).getStatement());
        showElection();
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

    private void setEditTextVisibleSumRes(String[] operators, int solutionLength) {

        sumResSeparator.setVisibility(View.VISIBLE);
        txtViewOperatorSumRes.setVisibility(View.VISIBLE);

        if(operators[0].length() == 3) {
            edTxtAddSub11.setVisibility(View.VISIBLE);
            edTxtAddSub12.setVisibility(View.VISIBLE);
            edTxtAddSub13.setVisibility(View.VISIBLE);

        } else if (operators[0].length() == 2) {
            edTxtAddSub12.setVisibility(View.VISIBLE);
            edTxtAddSub13.setVisibility(View.VISIBLE);

        } else {
            edTxtAddSub13.setVisibility(View.VISIBLE);
        }

        if(operators[1].length() == 3) {
            edTxtAddSub21.setVisibility(View.VISIBLE);
            edTxtAddSub22.setVisibility(View.VISIBLE);
            edTxtAddSub23.setVisibility(View.VISIBLE);

        } else if (operators[1].length() == 2) {
            edTxtAddSub22.setVisibility(View.VISIBLE);
            edTxtAddSub23.setVisibility(View.VISIBLE);

        } else {
            edTxtAddSub23.setVisibility(View.VISIBLE);
        }

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
    }

    private boolean checkSumResSolution(String[] operators) {
        String[] operator1Splited = operators[0].split("(?!^)");
        String[] operator2Splited = operators[1].split("(?!^)");

        String[] solutionSplited = problems.get(position).getSolution().split("(?!^)");
        int position = 0;

        boolean solution = true;

        if(edTxtAddSub11.getVisibility() == View.VISIBLE) {
            if(!edTxtAddSub11.getText().toString().equals(operator1Splited[position])) {
                solution = false;
                edTxtAddSub11.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtAddSub11.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtAddSub12.getVisibility() == View.VISIBLE) {
            if(!edTxtAddSub12.getText().toString().equals(operator1Splited[position])) {
                solution = false;
                edTxtAddSub12.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtAddSub12.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtAddSub13.getVisibility() == View.VISIBLE) {
            if(!edTxtAddSub13.getText().toString().equals(operator1Splited[position])) {
                solution = false;
                edTxtAddSub13.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtAddSub13.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        position = 0;

        if(edTxtAddSub21.getVisibility() == View.VISIBLE) {
            if(!edTxtAddSub21.getText().toString().equals(operator2Splited[position])) {
                solution = false;
                edTxtAddSub21.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtAddSub21.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtAddSub22.getVisibility() == View.VISIBLE) {
            if(!edTxtAddSub22.getText().toString().equals(operator2Splited[position])) {
                solution = false;
                edTxtAddSub22.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtAddSub22.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtAddSub23.getVisibility() == View.VISIBLE) {
            if(!edTxtAddSub23.getText().toString().equals(operator2Splited[position])) {
                solution = false;
                edTxtAddSub23.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtAddSub23.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        position = 0;

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

        txtViewStatement.setText("");

        edTxtAddSub11.setText("");
        edTxtAddSub12.setText("");
        edTxtAddSub13.setText("");

        edTxtAddSub21.setText("");
        edTxtAddSub22.setText("");
        edTxtAddSub23.setText("");

        edTxtResultSumRes1.setText("");
        edTxtResultSumRes2.setText("");
        edTxtResultSumRes3.setText("");
        edTxtResultSumRes4.setText("");

        edTxtAddSub11.setVisibility(View.GONE);
        edTxtAddSub12.setVisibility(View.GONE);
        edTxtAddSub13.setVisibility(View.GONE);

        edTxtAddSub21.setVisibility(View.GONE);
        edTxtAddSub22.setVisibility(View.GONE);
        edTxtAddSub23.setVisibility(View.GONE);

        sumResSeparator.setVisibility(View.INVISIBLE);
        txtViewOperatorSumRes.setVisibility(View.INVISIBLE);

        edTxtResultSumRes4.setVisibility(View.GONE);
        edTxtResultSumRes3.setVisibility(View.GONE);
        edTxtResultSumRes2.setVisibility(View.GONE);
        edTxtResultSumRes1.setVisibility(View.GONE);

        izqLayout.requestFocus();
    }

    private void setEditTextVisibleMult(String[] operands, String solution) {

        String multiplying = operands[0];
        char [] multiplier = operands[1].toCharArray();

        if(multiplying.length() == 4) {
            edTxtMult11.setVisibility(View.VISIBLE);
            edTxtMult12.setVisibility(View.VISIBLE);
            edTxtMult13.setVisibility(View.VISIBLE);
            edTxtMult14.setVisibility(View.VISIBLE);

        } else if (multiplying.length() == 3) {
            edTxtMult12.setVisibility(View.VISIBLE);
            edTxtMult13.setVisibility(View.VISIBLE);
            edTxtMult14.setVisibility(View.VISIBLE);

        } else if (multiplying.length() == 2) {
            edTxtMult13.setVisibility(View.VISIBLE);
            edTxtMult14.setVisibility(View.VISIBLE);

        } else {
            edTxtMult14.setVisibility(View.VISIBLE);
        }

        if(multiplier.length == 1) {

            edTxtMult22.setVisibility(View.VISIBLE);

            txtViewOperatorMult.setVisibility(View.VISIBLE);
            separator1Mult.setVisibility(View.VISIBLE);
            separator2Mult.setVisibility(View.INVISIBLE);
            txtViewOperatorMult2.setVisibility(View.INVISIBLE);

            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) separator1Mult.getLayoutParams();

            if(problems.get(position).getSolution().length() == 5) {

                edTxtResultMult11.setVisibility(View.VISIBLE);
                edTxtResultMult12.setVisibility(View.VISIBLE);
                edTxtResultMult13.setVisibility(View.VISIBLE);
                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);

            } else if(problems.get(position).getSolution().length() == 4) {

                edTxtResultMult12.setVisibility(View.VISIBLE);
                edTxtResultMult13.setVisibility(View.VISIBLE);
                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);

            } else if(problems.get(position).getSolution().length() == 3) {

                edTxtResultMult13.setVisibility(View.VISIBLE);
                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);
                params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());;
                separator1Mult.setLayoutParams(params);

            } else if(problems.get(position).getSolution().length() == 2) {

                edTxtResultMult14.setVisibility(View.VISIBLE);
                edTxtResultMult15.setVisibility(View.VISIBLE);
                params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 160, getResources().getDisplayMetrics());;
                separator1Mult.setLayoutParams(params);

            } else if(problems.get(position).getSolution().length() == 1) {
                edTxtResultMult15.setVisibility(View.VISIBLE);
                params.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, getResources().getDisplayMetrics());;
                separator1Mult.setLayoutParams(params);
            }

        } else {

            edTxtMult21.setVisibility(View.VISIBLE);
            edTxtMult22.setVisibility(View.VISIBLE);

            separator1Mult.setVisibility(View.VISIBLE);
            separator2Mult.setVisibility(View.VISIBLE);
            txtViewOperatorMult.setVisibility(View.VISIBLE);
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
    }

    private boolean checkMultSolution(String[] operators) {
        String[] operator1Splited = operators[0].split("(?!^)");;
        String[] operator2Splited = operators[1].split("(?!^)");;
        String[] value1Splited = String.valueOf(value1).split("(?!^)");
        String[] value2Splited = String.valueOf(value2).split("(?!^)");
        String[] solutionSplited = problems.get(position).getSolution().split("(?!^)");

        int position = 0;

        boolean solution = true;

        if(edTxtMult11.getVisibility() == View.VISIBLE) {
            if(!edTxtMult11.getText().toString().equals(operator1Splited[position])) {
                solution = false;
                edTxtMult11.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtMult11.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtMult12.getVisibility() == View.VISIBLE) {
            if(!edTxtMult12.getText().toString().equals(operator1Splited[position])) {
                solution = false;
                edTxtMult12.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtMult12.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtMult13.getVisibility() == View.VISIBLE) {
            if(!edTxtMult13.getText().toString().equals(operator1Splited[position])) {
                solution = false;
                edTxtMult13.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtMult13.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtMult14.getVisibility() == View.VISIBLE) {
            if(!edTxtMult14.getText().toString().equals(operator1Splited[position])) {
                solution = false;
                edTxtMult14.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtMult14.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        position = 0;

        if(edTxtMult21.getVisibility() == View.VISIBLE) {
            if(!edTxtMult21.getText().toString().equals(operator2Splited[position])) {
                solution = false;
                edTxtMult21.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtMult21.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        if(edTxtMult22.getVisibility() == View.VISIBLE) {
            if(!edTxtMult22.getText().toString().equals(operator2Splited[position])) {
                solution = false;
                edTxtMult22.setBackgroundResource(R.drawable.edtxt_error);
            } else {
                edTxtMult22.setBackgroundResource(R.drawable.edtxt);
            }
            ++position;
        }

        position = 0;

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

        txtViewStatement.setText("");

        edTxtMult11.setText("");
        edTxtMult12.setText("");
        edTxtMult13.setText("");
        edTxtMult14.setText("");

        edTxtMult21.setText("");
        edTxtMult22.setText("");

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

        edTxtMult11.setVisibility(View.GONE);
        edTxtMult12.setVisibility(View.GONE);
        edTxtMult13.setVisibility(View.GONE);
        edTxtMult14.setVisibility(View.GONE);

        txtViewOperatorMult.setVisibility(View.INVISIBLE);

        edTxtMult21.setVisibility(View.GONE);
        edTxtMult22.setVisibility(View.GONE);

        separator1Mult.setVisibility(View.INVISIBLE);

        edTxtResultMult11.setVisibility(View.GONE);
        edTxtResultMult12.setVisibility(View.GONE);
        edTxtResultMult13.setVisibility(View.GONE);
        edTxtResultMult14.setVisibility(View.GONE);
        edTxtResultMult15.setVisibility(View.GONE);

        txtViewOperatorMult2.setVisibility(View.INVISIBLE);

        edTxtResultMult21.setVisibility(View.GONE);
        edTxtResultMult22.setVisibility(View.GONE);
        edTxtResultMult23.setVisibility(View.GONE);
        edTxtResultMult24.setVisibility(View.GONE);
        edTxtResultMult25.setVisibility(View.GONE);

        separator2Mult.setVisibility(View.INVISIBLE);

        edTxtResultMult31.setVisibility(View.GONE);
        edTxtResultMult32.setVisibility(View.GONE);
        edTxtResultMult33.setVisibility(View.GONE);
        edTxtResultMult34.setVisibility(View.GONE);
        edTxtResultMult35.setVisibility(View.GONE);
        edTxtResultMult36.setVisibility(View.GONE);

        izqLayout.requestFocus();

    }

    @Override
    public void onClickBtnNext() {
        if(position < problems.size() - 1) {
            position++;
            problemsRecordList.add(problemsRecord);
            clearEditextSumRes();
            clearMultEditSolution();
            loadProblem();
        } else if(position == problems.size() - 1){

            problemsRecordList.add(problemsRecord);

            int totalPoints = 0;

            for(int i = 0; i < problemsRecordList.size(); i++) {
                totalPoints += problemsRecordList.get(i).getPointsObtained();
            }

            presenter.insertProblemsGroupRecord(getDateTime(), totalPoints, problemsRecordList, idStudent, idProblemsGroup, token);

            presenter.updatePoints(idStudent, totalPoints + session.getStudentDetails().getPoints(), token);
            session.updatePoints(totalPoints +  session.getStudentDetails().getPoints());

            FragmentManager fm = getFragmentManager();

            FinishFragmentDialog finishFragmentDialog = FinishFragmentDialog.newInstance(totalPoints);
            finishFragmentDialog.show(fm, "fragment_dialog_finish");
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    private void showCheckOperationTypeFragmentDialog() {
        FragmentManager fm = getFragmentManager();

        CheckOperationTypeFragmentDialog checkFragmentDialog = CheckOperationTypeFragmentDialog.newInstance();

        checkFragmentDialog.show(fm, "fragment_dialog_comprobar_tipo_operacion");
    }

    private void showHelpFragmentDialog(String help) {
        FragmentManager fm = getFragmentManager();

        HelpFragmentDialog checkFragmentDialog = HelpFragmentDialog.newInstance(help);

        checkFragmentDialog.show(fm, "fragment_dialog_ayuda");
    }

    private void subPoints() {
        if(difficulty.equals("Medio")) {
            problemsRecord.setPointsObtained(problems.get(position).getPuntos() - 1);
        } else if(difficulty.equals("Difícil")) {
            problemsRecord.setPointsObtained(problems.get(position).getPuntos() - 2);
        }
    }

    @Override
    public void onClickBtnExit() {
        finish();
    }
}
