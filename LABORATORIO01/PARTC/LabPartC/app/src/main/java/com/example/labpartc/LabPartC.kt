package com.example.labpartc

/**
 * Universidad del Valle de Guatemala
 * Programacion de plataformas moviles
 * Programa Hecho por Ricardo Chuy carne 221007
 * Descripcion: Un programa de practica en kotlin que implementa ejemplos sencillos
 * de herencia e interfaces para realizar operaciones
 */
////////////// IMPLEMENTATION OF INHERITANCE
open class EngineeringStudent(_name: String, _career: String){
    val university = "Universidad del Valle de Guatemala"
    val isGraduatedFromSchool = true
    var name: String =  ""
    var studentCareer: String = ""

    init{
        name = _name
        studentCareer = _career
    }
}

class ComputerScienceStudent(_name: String, _career: String): EngineeringStudent(_name, _career) {
    var takesPhysics3 = true
    init{
        println("Added a new computer science student")
    }
}

class MechatronicStudent(_name: String, _career: String): EngineeringStudent(_name, _career) {
    var takesCalculus3 = true
    init{
        println("Added a new mechatronic student")
    }
}

////////////// IMPLEMENTATION OF INTERFACE

interface Shape {
    var shapeName: String
    var sideQty: Int
    fun calculateArea() {
        println("Calculus for area not defined")
    }
}

class Square() : Shape {
    override var shapeName: String = "Square"
    override var sideQty: Int = 4
    override fun calculateArea() {
        println("What is the length of one side?")
        var intSize = readLine()?.toInt()!!
        println("The area of the square is: ${intSize * intSize}")
    }
}

class Rectangle() : Shape {
    override var shapeName: String = "Rectangle"
    override var sideQty: Int = 4
    override fun calculateArea() {
        println("What is the length of the rectangle?")
        var intSize1 = readLine()?.toInt()!!

        println("What is the height of the rectangle?")
        var intSize2 = readLine()?.toInt()!!

        println("The area of the rectangle is: ${intSize1 * intSize2}")
    }
}
// This class intentionally does not override the area calculation method to demonstrate interface's properties
class Triangle() : Shape{
    override var shapeName: String = "Triangle"
    override var sideQty: Int = 3
}

fun main(){
    var studentList: ArrayList<EngineeringStudent> = ArrayList<EngineeringStudent>()
    var strInput = ""
    var strInput2 = ""

    while (!strInput.equals("3")){
        println("Which example do you want to run: \n|1| Student manager \n|2| Calculate areas of shapes \n|3| Exit")

        strInput = readLine()!!

        if(strInput.equals("1")){
            println("These are the options: \n|1| Add CS Student \n|2| Add Mechatronic Student \n|3| Show Student list \n" +
                    "|4| Exit")
            strInput2 = readLine()!!

            when(strInput2){
                "1" -> addCsStudent(studentList)
                "2" -> addMechStudent(studentList)
                "3" -> showStudentList(studentList)
            }

        }
        else if(strInput.equals("2")){
            println("These are the options: \n|1| Area of a Square \n|2| Area of a rectangle \n|3| Area of a triangle (intentionally not implemented) \n" +
                    "|4| Exit")
            strInput2 = readLine()!!

            var geometricalShape: Shape? = null

            when(strInput2){
                "1" -> geometricalShape = Square()
                "2" -> geometricalShape = Rectangle()
                "3" -> geometricalShape = Triangle()
            }

            if (geometricalShape != null) {
                println("The shape's name is: ${geometricalShape.shapeName}\n" +
                        "The amount of sides it has is: ${geometricalShape.sideQty}")
                geometricalShape.calculateArea()
                println()
            }
        }
    }

}

fun showStudentList(studentList: ArrayList<EngineeringStudent>) {
    for(item in studentList){
        println("Graduated from school: ${item.isGraduatedFromSchool}\n" +
                "Study House: ${item.university}\n" +
                "Name: ${item.name}\n" +
                "Career: ${item.studentCareer}")
        println()
    }
}
fun addCsStudent(studentList: ArrayList<EngineeringStudent>) {
    println("What is the student's name: ")
    var studentName = readLine()!!
    var newCsStudent = ComputerScienceStudent(studentName, "Computer Science")
    studentList.add(newCsStudent)
}
fun addMechStudent(studentList: ArrayList<EngineeringStudent>) {
    println("What is the student's name: ")
    var studentName = readLine()!!
    var newMechStudent = MechatronicStudent(studentName, "Mechatronic")
    studentList.add(newMechStudent)
}