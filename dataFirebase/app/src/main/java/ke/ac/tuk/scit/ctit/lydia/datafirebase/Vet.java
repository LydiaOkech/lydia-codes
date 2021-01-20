package ke.ac.tuk.scit.ctit.lydia.datafirebase;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class Vet {

    public String name;
    public String phoneNumber;
    public String specialty;
    public String status="Active";

    public Vet() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }


    public Vet(String name, String phoneNumber, String specialty, String status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
        this.status = status;
    }

    public String getname() {
        return name;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public String getspecialty() {
        return specialty;
    }

    public String getstatus() {
        return status;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setspecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setstatus(String status) {
        this.status = status;
    }



    /* public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("PhoneNumber", phoneNumber);
        result.put("author", name);
        result.put("title", specialty);
        result.put("body", status);

        return result;
    }*/


}

