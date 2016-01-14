    package com.omkar.bestbuyapi.studentregistration;

    import android.app.ActionBar;
    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.widget.Toast;
    import com.omkar.bestbuyapi.model.Student;
    import java.util.ArrayList;

    /**
     * Created by omkardokur on 12/18/15.
     */
    public class SqliteHelper extends SQLiteOpenHelper
    {

        private  static final String  DATABASE_STUDENT_NAME="student.db";
        private String TABLE_NAME="marks";
        private String STUDENT_ID = "student_id";
        private String STUDENT_NAME="name";
        private String STUDENT_MARKS="marks";
        private String STUDENT_CLASS="class";
        Context context;
        public SqliteHelper(Context applicationContext) {
            super(applicationContext,DATABASE_STUDENT_NAME,null,1);
            this.context = applicationContext;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //create table
            String CREATE_STUDENTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + STUDENT_ID + " INTEGER PRIMARY KEY," + STUDENT_NAME + " TEXT,"
                    + STUDENT_MARKS + " TEXT," + STUDENT_CLASS + " TEXT" +")";
            db.execSQL(CREATE_STUDENTS_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            // Create tables again
            onCreate(db);
        }

        //Creating the student details
        public void createStudentDetails(Student student){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();
            values.put(STUDENT_NAME,student.getStudentName());
            values.put(STUDENT_CLASS,student.getStudentClass());
            values.put(STUDENT_MARKS,student.getStudentMarks());

        db.insert(TABLE_NAME, null, values);
            Toast.makeText(context,"Inserted a row successfully", Toast.LENGTH_LONG).show();
        }

        //reading the  student details4
        public ArrayList<Student> getStudentDetails()
        {ArrayList<Student> list=new ArrayList<Student>();

            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Student student = new Student();
                    student.setStudentId(cursor.getString(0));
                    student.setStudentName(cursor.getString(1));
                    student.setStudentMarks(cursor.getString(2));
                    student.setStudentClass(cursor.getString(3));
                    // Adding contact to list
                    list.add(student);
                } while (cursor.moveToNext());
            }
            // return contact list
            return list;
        }

        public void deleteTheStudent(String studentId) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_NAME, STUDENT_ID + " = ?",
                    new String[] {studentId });
            db.close();
        }

        // Updating single contact
        public void updateStudent(Student student, String i) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(STUDENT_NAME, student.getStudentName());
            values.put(STUDENT_MARKS, student.getStudentMarks());
            values.put(STUDENT_CLASS, student.getStudentClass());

            // updating row
            db.update(TABLE_NAME, values, STUDENT_ID + " = ?",
                    new String[]{i});
            db.close();
        }
    }
