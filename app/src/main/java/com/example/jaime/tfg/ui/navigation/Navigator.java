package com.example.jaime.tfg.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.example.jaime.tfg.ui.student.MainStudentActivity;
import com.example.jaime.tfg.ui.student.firstAvatarSelection.FirstSelectAvatarActivity;
import com.example.jaime.tfg.ui.student.operationsGroup.SelectOperationsGroupActivity;
import com.example.jaime.tfg.ui.student.operationsGroup.resolveOperations.ResolveOperationsActivity;
import com.example.jaime.tfg.ui.student.problemsGroup.SelectProblemsGroupActivity;
import com.example.jaime.tfg.ui.student.problemsGroup.resolveProblems.ResolveProblemsActivity;
import com.example.jaime.tfg.ui.student.record.ChooseRecordActivity;
import com.example.jaime.tfg.ui.student.record.operationsGroup.OperationsGroupRecordActivity;
import com.example.jaime.tfg.ui.student.record.problemsGroup.ProblemsGroupRecordActivity;
import com.example.jaime.tfg.ui.student.selectAvatar.SelectAvatarActivity;
import com.example.jaime.tfg.ui.student.shop.AvatarShopActivity;
import com.example.jaime.tfg.ui.teacher.MainTeacherActivity;
import com.example.jaime.tfg.ui.teacher.classroom.edit.EditClassroomActivity;
import com.example.jaime.tfg.ui.teacher.classroom.insert.InsertClassroomActivity;
import com.example.jaime.tfg.ui.teacher.classroom.student.ShowStudentsActivity;
import com.example.jaime.tfg.ui.teacher.classroom.student.edit.EditStudentActivity;
import com.example.jaime.tfg.ui.teacher.classroom.student.insert.InsertStudentActivity;
import com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup.ShowOperationsGroupStudentProgressActivity;
import com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup.ShowProblemsGroupProgressActivity;
import com.example.jaime.tfg.ui.teacher.operationsgroup.availability.OperationGroupAvailabilityActivity;
import com.example.jaime.tfg.ui.teacher.operationsgroup.availability.addstudents.ShowStudentNoAttachedOperationsGroupActivity;
import com.example.jaime.tfg.ui.teacher.operationsgroup.edit.EditOperationsGroupActivity;
import com.example.jaime.tfg.ui.teacher.operationsgroup.insert.InsertOperationsGroupActivity;
import com.example.jaime.tfg.ui.teacher.operationsgroup.operation.ShowOperationsActivity;
import com.example.jaime.tfg.ui.teacher.operationsgroup.operation.edit.EditOperationActivity;
import com.example.jaime.tfg.ui.teacher.operationsgroup.operation.insert.InsertOperationActivity;
import com.example.jaime.tfg.ui.teacher.problemsgroup.availability.ProblemsGroupAvailabilityActivity;
import com.example.jaime.tfg.ui.teacher.problemsgroup.availability.addStudents.ShowStudentNoAttachedProblemsGroupActivity;
import com.example.jaime.tfg.ui.teacher.problemsgroup.edit.EditProblemsGroupActivity;
import com.example.jaime.tfg.ui.teacher.problemsgroup.insert.InsertProblemsGroupActivity;
import com.example.jaime.tfg.ui.teacher.problemsgroup.problem.ShowProblemsActivity;
import com.example.jaime.tfg.ui.teacher.problemsgroup.problem.edit.EditProblemActivity;
import com.example.jaime.tfg.ui.teacher.problemsgroup.problem.insert.InsertProblemActivity;
import com.example.jaime.tfg.ui.teacher.profile.edit.EditTeacherProfileActivity;

/**
 * Created by Jaime on 16/11/2017.
 */


public class Navigator {

    private static Navigator instance = null;

    private Navigator(){

    }

    public synchronized static Navigator getInstance() {
        if(instance == null) {
            instance = new Navigator();
        }

        return instance;
    }

    /**
     * MainActivity navigations
     */

    public void navigateToMainTeachers(Context context) {
        if(context != null) {
            Intent intent = MainTeacherActivity.getCallingIntent(context);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * MainTeacherActivity navigations
     */

    public void navigateToInsertClassroom(Context context, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = InsertClassroomActivity.getCallingIntent(context, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToShowStudents(Context context, String idClassroom, String name, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = ShowStudentsActivity.getCallingIntent(context, idClassroom, name, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToEditClassRoom(Context context, String idClassroom , String name, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = EditClassroomActivity.getCallingIntent(context, idClassroom, name, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToInsertOperationsGroup(Context context, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = InsertOperationsGroupActivity.getCallingIntent(context, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToShowOperations(Context context, String idGroup, String idTeacher, String idUuid, String name) {
        if(context != null) {
            Intent intent = ShowOperationsActivity.getCallingIntent(context, idGroup, idTeacher, idUuid, name);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToEditOperationsGroup(Context context, String idGroup, String name, String difficulty, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = EditOperationsGroupActivity.getCallingIntent(context, idGroup, name, difficulty, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToInsertProblemsGroup(Context context, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = InsertProblemsGroupActivity.getCallingIntent(context, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToShowProblems(Context context, String idProblemsGroup, String idProfesor, String idUnico, String name) {
        if(context != null) {
            Intent intent = ShowProblemsActivity.getCallingIntent(context, idProblemsGroup, idProfesor, idUnico, name);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToEditProblemsGroup(Context context, String idProblemsGroup, String name, String difficulty, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = EditProblemsGroupActivity.getCallingIntent(context, idProblemsGroup, name, difficulty, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToEditProfile(Context context) {
        if(context != null) {
            Intent intent = EditTeacherProfileActivity.getCallingIntent(context);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * ShowStudentsActivity navigations
     */

    public void navigateToInsertStudent(Context context, String idClassroom, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = InsertStudentActivity.getCallingIntent(context, idClassroom, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToShowOperationsProgress(Context context, String idTeacher, String idClassroom, String idStudent, String studentName, String token) {
        if(context != null) {
            Intent intent = ShowOperationsGroupStudentProgressActivity.getCallingIntent(context, idTeacher, idClassroom, idStudent, studentName, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToEditStudent(Context context, String idClassroom, String idTeacher, String idUuid, String idStudent, String name, String surname) {
        if(context != null) {
            Intent intent = EditStudentActivity.getCallingIntent(context, idClassroom, idTeacher, idUuid, idStudent, name, surname);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * ShowOperationsActivity navigations
     */

    public void navigateToInsertOperation(Context context, String idOperationsGroup, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = InsertOperationActivity.getCallingIntent(context, idOperationsGroup, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToEditOperation(Context context, String idOperationsGroup, String idOperation, String idTeacher, String idUuid, String statement, int points) {
        if(context != null) {
            Intent intent = EditOperationActivity.getCallingIntent(context, idOperationsGroup, idOperation, idTeacher, idUuid, statement, points);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * ShowProblemsActivity navigations
     */

    public void navigateToInsertProblem(Context context, String idProblemsGroup, String idTeacher, String idUuid) {
        if(context != null) {
            Intent intent = InsertProblemActivity.getCallingIntent(context, idProblemsGroup, idTeacher, idUuid);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToEditProblem(Context context, String idProblemsGroup, String idProblem, String idTeacher, String idUuid, String statement, String operation, int points, String help, String operationType) {
        if(context != null) {
            Intent intent = EditProblemActivity.getCallingIntent(context, idProblemsGroup, idProblem, idTeacher, idUuid, statement, operation, points, help, operationType);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToMainStudent(Context context) {
        if (context != null) {
            Intent intent = MainStudentActivity.getCallingIntent(context);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToSelectAvatar(Context context) {
        if (context != null) {
            Intent intent = FirstSelectAvatarActivity.getCallingIntent(context);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToSelectOperationsGroups(Context context, String idStudent, String token) {
        if(context != null) {
            Intent intent = SelectOperationsGroupActivity.getCallingIntent(context, idStudent, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToSelectProblemsGroups(Context context, String idStudent, String token) {
        if(context != null) {
            Intent intent = SelectProblemsGroupActivity.getCallingIntent(context, idStudent, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /*********/

    public void navigateToSelectClassroom(Context context, String idOperationsGroup, String name, String idTeacher, String token) {
        if(context != null) {
            Intent intent = OperationGroupAvailabilityActivity.getCallingIntent(context, idOperationsGroup, name, idTeacher, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToProblemsGroupAvailability(Context context, String idProblemsGroup, String name, String idTeacher, String token) {
        if(context != null) {
            Intent intent = ProblemsGroupAvailabilityActivity.getCallingIntent(context, idProblemsGroup, name, idTeacher, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToShop(Context context) {
        if(context != null) {
            Intent intent = AvatarShopActivity.getCallingIntent(context);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToChangeAvatar(Context context) {
        if(context != null) {
            Intent intent = SelectAvatarActivity.getCallingIntent(context);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToResolveOperations(Context context, String idStudent, String idOperationsGroup, String difficulty, String token) {
        if(context != null) {
            Intent intent = ResolveOperationsActivity.getCallingIntent(context, idStudent, idOperationsGroup, difficulty, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToResolveProblems(Context context, String idStudent, String idProblemsGroup, String difficulty, String token) {
        if(context != null) {
            Intent intent = ResolveProblemsActivity.getCallingIntent(context, idStudent, idProblemsGroup, difficulty, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToAttachStudentOperationGroup(Context context, String idTeacher, String idClassroom, String idOperationsGroup, String classroomName, String operationsGroupName, String token) {
        if(context != null) {
            Intent intent = ShowStudentNoAttachedOperationsGroupActivity.getCallingIntent(context, idTeacher, idClassroom, idOperationsGroup, classroomName, operationsGroupName, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToAttachStudentProblemsGroup(Context context, String idTeacher, String idClassroom, String idProblemsGroup, String classroomName, String problemsGroupName, String token) {
        if(context != null) {
            Intent intent = ShowStudentNoAttachedProblemsGroupActivity.getCallingIntent(context, idTeacher, idClassroom, idProblemsGroup, classroomName, problemsGroupName, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToChooseRecord(Context context, String idStudent, String token) {
        if(context != null) {
            Intent intent = ChooseRecordActivity.getCallingIntent(context, idStudent, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToOperationsGroupRecord(Context context, String idStudent, String token) {
        if(context != null) {
            Intent intent = OperationsGroupRecordActivity.getCallingIntent(context, idStudent, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToProblemsGroupRecord(Context context, String idStudent, String token) {
        if(context != null) {
            Intent intent = ProblemsGroupRecordActivity.getCallingIntent(context, idStudent, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void navigateToShowProblemsProgress(Context context, String idTeacher, String idClassroom, String s, String s1, String token) {
        if(context != null) {
            Intent intent = ShowProblemsGroupProgressActivity.getCallingIntent(context, idTeacher, idClassroom, s, s1, token);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
