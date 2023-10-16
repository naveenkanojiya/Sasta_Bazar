package com.example.sastabazar

class UserModel {
    var firstName :String= ""
    var lastNAme : String = ""
    var email : String = ""
    var password : String = ""
    constructor()
    constructor(firstName: String, lastNAme: String, email: String, password: String) {
        this.firstName = firstName
        this.lastNAme = lastNAme
        this.email = email
        this.password = password
    }

}