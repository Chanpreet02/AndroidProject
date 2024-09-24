package com.example.signup

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log



class MainActivity : AppCompatActivity() {
    private lateinit var myButton: Button //variable created for Sign Up Button
    private lateinit var nameEditText: EditText //edit text variable for name
    private lateinit var emailEditText: EditText //edit text variable for email
    private lateinit var aboutEditText: EditText //edit text variable for about
    private lateinit var passwordEditText: EditText //edit text variable for password
    private lateinit var radioGroup: RadioGroup //RadioGroup variable
    private lateinit var radioButtonMale: RadioButton //Radio Button variable for male button
    private lateinit var radioButtonFemale: RadioButton //Radio Button variable for female button
    private lateinit var radioButtonHijda: RadioButton //radio button variable for psychological problem
    private lateinit var JavaCheckbox:CheckBox
    private lateinit var PythonCheckbox:CheckBox
    private lateinit var SQLCheckbox:CheckBox
    private lateinit var KotlinCheckbox:CheckBox
    private lateinit var spinnerId: Spinner
    private var country= arrayOf("India","Australia","England","New Zealand","South Africa")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        this.InitializeViews()
        myButton.setOnClickListener{
            Toast.makeText(this, "Button is clicked", Toast.LENGTH_SHORT).show()

            var name:String = nameEditText.text.toString()
            var email:String = emailEditText.text.toString()
            var password:String = passwordEditText.text.toString()
            lateinit var gender:String
            if(radioButtonMale.isChecked){
                gender="Male"
            }
            if(radioButtonFemale.isChecked){
                gender="Female"
            }
            if(radioButtonHijda.isChecked){
                gender = "Hijda"
            }
            else{
                gender="Not entered"
            }
            lateinit var skills:String
            if(JavaCheckbox.isChecked){
                skills +="Java "
            }
            if(PythonCheckbox.isChecked){
                skills +="Python "
            }
            if(SQLCheckbox.isChecked){
                skills +="SQL "
            }
            if(KotlinCheckbox.isChecked){
                skills +="Kotlin "
            }
            Log.w("Name", name)

        }
        var arrayAdap:Adapter= ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_dropdown_item,country)
        spinnerId.adapter = arrayAdap as SpinnerAdapter?
        spinnerId.setSelection(4)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


//        Log.e("testing","This is a testing warning message")//e matlab error message


    }
    fun InitializeViews(){
        myButton = findViewById(R.id.sign_up_button)
        nameEditText=findViewById(R.id.Full_Name)
        emailEditText = findViewById(R.id.editTextEmailAddress)
        aboutEditText = findViewById(R.id.editTextAbout)
        passwordEditText = findViewById(R.id.editTextPassword)
        radioGroup = findViewById(R.id.gender_button)
        radioButtonMale = findViewById(R.id.male)
        radioButtonFemale = findViewById(R.id.female)
        radioButtonHijda = findViewById(R.id.hijda)
        JavaCheckbox = findViewById(R.id.java)
        PythonCheckbox = findViewById(R.id.python)
        SQLCheckbox = findViewById(R.id.sql)
        KotlinCheckbox = findViewById(R.id.kotlin)
        spinnerId=findViewById(R.id.country_spinner)
    }
}