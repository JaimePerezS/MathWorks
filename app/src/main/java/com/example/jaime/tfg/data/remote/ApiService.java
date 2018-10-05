package com.example.jaime.tfg.data.remote;

import com.example.jaime.tfg.data.model.Avatar;
import com.example.jaime.tfg.data.model.Classroom;
import com.example.jaime.tfg.data.model.Operation;
import com.example.jaime.tfg.data.model.OperationsGroup;
import com.example.jaime.tfg.data.model.OperationsGroupRecord;
import com.example.jaime.tfg.data.model.OperationsRecord;
import com.example.jaime.tfg.data.model.Problem;
import com.example.jaime.tfg.data.model.ProblemsGroup;
import com.example.jaime.tfg.data.model.ProblemsGroupRecord;
import com.example.jaime.tfg.data.model.ProblemsRecord;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.data.model.Teacher;
import com.example.jaime.tfg.data.remote.request.InsertAvatarBougthRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertClassroomRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertOperationRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertOperationsGroupRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertOperationsGroupRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertOperationsRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertProblemRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertProblemsGroupRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertProblemsGroupRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertProblemsRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertStudentRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertStudentVisibilityOperationsGroup;
import com.example.jaime.tfg.data.remote.request.InsertStudentVisibilityProblemsGroup;
import com.example.jaime.tfg.data.remote.request.InsertTeacherRequestBody;
import com.example.jaime.tfg.data.remote.request.LoginStudentRequestBody;
import com.example.jaime.tfg.data.remote.request.LoginTeacherRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateClassroomRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateOperationRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateOperationsGroupRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateProblemRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateProblemsGroupRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateStudentAvatarRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateStudentPointsRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateStudentRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateTeacherRequestBody;
import com.example.jaime.tfg.data.remote.response.InsertOperationsGroupRecordResponse;
import com.example.jaime.tfg.data.remote.response.InsertProblemsGroupRecordResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Jaime on 28/11/2017.
 */

public interface ApiService {

    @POST("profesores/login")
    Call<Teacher> teacherLogin(@Body LoginTeacherRequestBody request);

    @POST("profesores/nuevo")
    Call<String> newTeacher(@Body InsertTeacherRequestBody request);

    @POST("profesores/{idProfesor}")
    Call<String> updateTeacher(@Body UpdateTeacherRequestBody request, @Path("idProfesor") String idTeacher, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}")
    Call<String> deleteTeacher(@Path("idProfesor") String idTeacher, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases")
    Call<List<Classroom>> getClassrooms(@Path("idProfesor") String idTeacher, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/clases")
    Call<String> insertClassroom(@Body InsertClassroomRequestBody request, @Path("idProfesor") String idTeacher, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/clases/{idClase}")
    Call<String> updateClassroom(@Body UpdateClassroomRequestBody request, @Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases/{idClase}")
    Call<String> deleteClassroom(@Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases/{idClase}/alumnos")
    Call<List<Student>> getStudents(@Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/clases/{idClase}/alumnos")
    Call<String> insertStudent(@Body InsertStudentRequestBody requestBody, @Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/clases/{idClase}/alumnos/{idAlumno}")
    Call<String> updateStudent(@Body UpdateStudentRequestBody requestBody, @Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases/{idClase}/alumnos/{idAlumno}")
    Call<String> deleteStudent(@Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Header("Authorization") String toke);

    @GET("profesores/{idProfesor}/grupos_operaciones")
    Call<List<OperationsGroup>> getOperationsGroups(@Path("idProfesor") String idTeacher, @Header("Authorization") String toke);

    @POST("profesores/{idProfesor}/grupos_operaciones")
    Call<String> insertOperationsGroup(@Body InsertOperationsGroupRequestBody request, @Path("idProfesor") String idTeacher, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}")
    Call<String> updateOperationsGroup(@Body UpdateOperationsGroupRequestBody request, @Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}")
    Call<String> deleteOperationsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/operaciones")
    Call<List<Operation>> getOperations(@Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/operaciones")
    Call<String> insertOperation(@Body InsertOperationRequestBody request, @Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/operaciones/{idOperacion}")
    Call<String> updateOperation(@Body UpdateOperationRequestBody request, @Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idOperacion") String idOperation, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/operaciones/{idOperacion}")
    Call<String> deleteOperation(@Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idOperacion") String idOperation, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_problemas")
    Call<List<ProblemsGroup>> getProblemsGroups(@Path("idProfesor") String idTeacher, @Header("Authorization") String toke);

    @POST("profesores/{idProfesor}/grupos_problemas")
    Call<String> insertProblemsGroup(@Body InsertProblemsGroupRequestBody request, @Path("idProfesor") String idTeacher, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}")
    Call<String> updateProblemsGroup(@Body UpdateProblemsGroupRequestBody request, @Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}")
    Call<String> deleteProblemsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/problemas")
    Call<List<Problem>> getProblems(@Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/problemas")
    Call<String> insertProblem(@Body InsertProblemRequestBody request, @Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/problemas/{idProblema}")
    Call<String> updateProblem(@Body UpdateProblemRequestBody request, @Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idProblema") String idProblem, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/problemas/{idProblema}")
    Call<String> deleteProblem(@Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idProblema") String idProblem, @Header("Authorization") String token);

    @POST("alumnos/login")
    Call<Student> studentLogin(@Body LoginStudentRequestBody request);

    @GET("alumnos/{idAlumno}/grupos_operaciones")
    Call<List<OperationsGroup>> getOperationsGroupsByStudentId(@Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/grupos_operaciones/{idGrupoOperaciones}/operaciones")
    Call<List<Operation>> getOperationsStudent(@Path("idAlumno") String idStudent, @Path("idGrupoOperaciones") String idOperationsGroup, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/grupos_problemas/{idGrupoProblemas}/problemas")
    Call<List<Problem>> getProblemsStudent(@Path("idAlumno") String idStudent, @Path("idGrupoProblemas") String idProblemsGroup, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/grupos_problemas")
    Call<List<ProblemsGroup>> getProblemsGroupsByStudentId(@Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @POST("alumnos/{idAlumno}/avatar")
    Call<String> updateAvatar(@Body UpdateStudentAvatarRequestBody request, @Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @POST("alumnos/{idAlumno}/puntuacion")
    Call<String> updatePoints(@Path("idAlumno") String idStudent, @Body UpdateStudentPointsRequestBody request, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/tienda/avatares")
    Call<List<Avatar>> getAvatarToBuy(@Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/tienda/avatares-comprados")
    Call<List<Avatar>> getAvatarBougth(@Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @POST("alumnos/{idAlumno}/tienda/avatares-comprados")
    Call<String> insertAvatarBougth(@Body InsertAvatarBougthRequestBody avatarBougthRequestBody, @Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/clases/{idClase}/alumnos")
    Call<List<Student>> getStudentsAttachedProblemsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/clases/{idClase}/alumnos-no-asignados")
    Call<List<Student>> getStudentsNoAttachedProblemsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/clases/{idClase}/alumnos")
    Call<String> insertStudentVisibilityProblemsGroup(@Body InsertStudentVisibilityProblemsGroup insertStudentVisibilityProblemsGroup, @Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idGrupoOperaciones, @Path("idClase") String idClase, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_problemas/{idGrupoProblemas}/clases/{idClase}/alumnos/{idAlumno}")
    Call<String> deleteStudentVisibilityProblemsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/clases/{idClase}/alumnos")
    Call<List<Student>> getStudentsAttachedOperationsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/clases/{idClase}/alumnos-no-asignados")
    Call<List<Student>> getStudentsNoAttachedOperationsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idClase") String idClassroom, @Header("Authorization") String token);

    @POST("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/clases/{idClase}/alumnos")
    Call<String> insertStudentVisibilityOperationsGroup(@Body InsertStudentVisibilityOperationsGroup insertStudentVisibilityOperationsGroup, @Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idGrupoOperaciones, @Path("idClase") String idClase, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/grupos_operaciones/{idGrupoOperaciones}/clases/{idClase}/alumnos/{idAlumno}")
    Call<String> deleteStudentVisibilityOperationsGroup(@Path("idProfesor") String idTeacher, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases/{idClase}/alumnos/{idAlumno}/grupos_operaciones/registro")
    Call<List<OperationsGroupRecord>> getOperationsGroupRecordByStudentId(@Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases/{idClase}/alumnos/{idAlumno}/grupos_operaciones/registro/{idGrupoOperaciones}/{idRegistro}")
    Call<List<OperationsRecord>> getOperationsRecordByStudentId(@Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idRegistro") String idRecord, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases/{idClase}/alumnos/{idAlumno}/grupos_problemas/registro")
    Call<List<ProblemsGroupRecord>> getProblemsGroupRecordByStudentId(@Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @GET("profesores/{idProfesor}/clases/{idClase}/alumnos/{idAlumno}/grupos_problemas/registro/{idGrupoProblemas}/{idRegistro}")
    Call<List<ProblemsRecord>> getProblemsRecordByStudentId(@Path("idProfesor") String idTeacher, @Path("idClase") String idClassroom, @Path("idAlumno") String idStudent, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idRegistro") String idRecord, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/grupos_operaciones/registro")
    Call<List<OperationsGroupRecord>> getOperationsGroupRecords(@Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @POST("alumnos/{idAlumno}/grupos_operaciones/registro/{idGrupoOperaciones}")
    Call<InsertOperationsGroupRecordResponse> insertOperationsGroupRecord(@Path("idAlumno") String idStudent, @Path("idGrupoOperaciones") String idOperationsGroup, @Body InsertOperationsGroupRecordRequestBody insertOperationsGroupRecordRequestBody, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/grupos_operaciones/registro/{idGrupoOperaciones}/{idRegistro}")
    Call<List<OperationsRecord>> getOperationsRecord(@Path("idAlumno") String idStudent, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idRegistro") String idRecord, @Header("Authorization") String token);

    @POST("alumnos/{idAlumno}/grupos_operaciones/registro/{idGrupoOperaciones}/{idRegistro}")
    Call<String> insertOperationsRecord(@Path("idAlumno") String idStudent, @Path("idGrupoOperaciones") String idOperationsGroup, @Path("idRegistro") String idRecord, @Body InsertOperationsRecordRequestBody insertOperationsRecordRequestBody, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/grupos_problemas/registro")
    Call<List<ProblemsGroupRecord>> getProblemsGroupRecords(@Path("idAlumno") String idStudent, @Header("Authorization") String token);

    @POST("alumnos/{idAlumno}/grupos_problemas/registro/{idGrupoProblemas}")
    Call<InsertProblemsGroupRecordResponse> insertProblemsGroupRecord(@Path("idAlumno") String idStudent, @Path("idGrupoProblemas") String idProblemsGroup, @Body InsertProblemsGroupRecordRequestBody requestBody, @Header("Authorization") String token);

    @GET("alumnos/{idAlumno}/grupos_problemas/registro/{idGrupoProblemas}/{idRegistro}")
    Call<List<ProblemsRecord>> getProblemsRecord(@Path("idAlumno") String idStudent, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idRegistro") String idRecord, @Header("Authorization") String token);

    @POST("alumnos/{idAlumno}/grupos_problemas/registro/{idGrupoProblemas}/{idRegistro}")
    Call<String> insertProblemsRecord(@Path("idAlumno") String idStudent, @Path("idGrupoProblemas") String idProblemsGroup, @Path("idRegistro") String idRecord, @Body InsertProblemsRecordRequestBody insertProblemspRecordRequestBody, @Header("Authorization") String token);

}
