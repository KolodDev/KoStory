package com.kolodadev.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private var edTextUsername:EditText? = null
    private var edTextPassword:EditText? = null
    private var buttonLogin:Button? = null
    private var checkBoxView:CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectView()
        login()
//        checkFiled()
    }

    private fun connectView() {
        edTextUsername = findViewById(R.id.edUsername)
        edTextPassword = findViewById(R.id.edPassword)
        buttonLogin = findViewById(R.id.btnLogin)
        checkBoxView = findViewById(R.id.checkbox)
    }
    private fun login(){
        val arr:ArrayList<User> = ArrayList()
        arr.add(User("kolod@test.com","12345"))
        arr.add(User("alanoud@test.com","2468"))
        arr.add(User("ahmad@test.com","987654"))
        buttonLogin?.setOnClickListener {
            val username = edTextUsername?.text.toString()
            val password = edTextPassword?.text.toString()

            val user = User(username,password)

            for (userArray in arr){
                if(userArray.email == user.email && userArray.password == user.password){
                    finish()
                    val i = Intent(this,MainActivity::class.java)
                    i.putExtra("email",userArray.email)
                    startActivity(i)
                    break
                }else{
                    Toast.makeText(this,"Check your data",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun checkFiled(){
        buttonLogin?.setOnClickListener {
            if(edTextUsername?.text?.isEmpty() == true){
                edTextUsername?.setError("Enter your email")
            }else if(edTextPassword?.text?.isEmpty()== true){
                edTextPassword?.error = "Enter the password"
            }
        }

    }
}