package ru.samsung.itschool.mdev;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@Controller
public class MyController {

    private ArrayList<Student> students = new ArrayList<>();
    private Gson gson = new Gson();

    @PostMapping(value = "/result",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String result(@RequestBody Student student) {
        students.add(student);
        Answer answer = new Answer();
        answer.setStatus("Saved!");
        answer.setStudent(student);
        return gson.toJson(answer);
    }

    @GetMapping("/getall")
    public @ResponseBody String getAllStudents(){
        return gson.toJson(students);
    }
}
class Answer {
    private String status;
    private Student student;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
