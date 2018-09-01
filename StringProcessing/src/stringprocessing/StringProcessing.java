/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Justi
 */
public class StringProcessing {
 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String[] records =new String[100];
        char ch;
       
       System.out.println("Enter firstName: ");
       Scanner input=new Scanner(System.in);
       String name1=input.next();
        try {
            Scanner reader = new Scanner(new File(args[0]));
            int currentIndex=0;
            while(reader.hasNext()){
                
        String[]line = reader.nextLine().split(",");
  
        String firstName = line[0];
        String lastName= line[1];
        String gender = line[2];
        String age=line[3];
        String phoneNumber=line[4];
        String email=line[5];
       
        if(FirstNameValid(firstName)){
            records[currentIndex]=String.format("%-20s",firstName);//Check
                    }else{
            System.err.println(String.format("error"));
        }
          if(LastNameValid(lastName)){
            records[currentIndex]=String.format("%-20s%-20s",firstName,lastName);//Check
            System.out.print(records[currentIndex]);
                    }else{
            System.err.println(String.format("error"));
        }
        
        if(genderIsValid(gender)){
         records[currentIndex] = String.format("%-20s%-20s%-20s",firstName,lastName,gender);  //Check if element is added
        }else{
            System.err.println(String.format("error"));
        }
         
        if(validAge(age)){
         records[currentIndex] = String.format("%-20s%-20s%-20s%-20s",firstName,lastName,gender,age);  //Check if element is added
        }else{
            System.err.println(String.format("error"));
       }
        if (validPhoneNumber(phoneNumber)){
         records[currentIndex] = String.format("%-20s%-20s%-20s",firstName,lastName,gender);  //Check if element is added
        }else{
            System.err.println(String.format("error"));
        }
         if (validEmail(email)){
         records[currentIndex] = String.format("%-20s%-20s%-20s",firstName,lastName,gender);  //Check if element is added
        }else{
            System.err.println(String.format("error"));
        }
        
        records[currentIndex]=String.format("%-20s%-20s%-20s%-20s%-20s%-20s",firstName,lastName,gender,age,phoneNumber,email);
        
        System.out.println(records[currentIndex]);
        currentIndex++;
            
      
              }
        } catch (FileNotFoundException ex) {
            System.err.println("File could not be found");
        }
        catch(NumberFormatException nfe){
            System.err.println("File could not be found ");
        }
    
    
    }
    private static boolean genderIsValid(String gender){
        if(gender.trim().equalsIgnoreCase("male")){
            return true;
        }else if(gender.trim().equalsIgnoreCase("female")){
            return true;
        }
    return false;
}
    public static boolean FirstNameValid(String firstName ){
      //password.matches("[A-Za-z0-9 ]*"); 
      firstName=firstName.trim();
     boolean checkingLetters=firstName.matches("[a-zA-Z]*");
        if(checkingLetters){
            return true;
        }else{
            System.out.println("error");
        return false;
        }
         }
     public static boolean LastNameValid(String lastName ){
      //password.matches("[A-Za-z0-9 ]*"); 
      lastName=lastName.trim();
     boolean checkingLetters=lastName.matches("[a-zA-Z]*");
        if(checkingLetters){
            return true;
        }else{
        
        return false;
        }
     }

public static boolean validAge(String age){
    age = age.trim();
    
       if(age.isEmpty()){
           return true;
       }
    int ageNum=Integer.parseInt(age);
    
    if(1<=ageNum && ageNum<=130){
        return true;
    }
    
else{
return false;
}
}
public static boolean validPhoneNumber(String phoneNumber){
    phoneNumber=phoneNumber.trim();
    phoneNumber.replaceAll("()","").replaceAll("-","");
 phoneNumber=phoneNumber.trim();

   if(phoneNumber.length()==10){
       return true;
}else {
    return false;

}    
} 
public static boolean validEmail(String email){
    email=email.trim();
    if(email.startsWith("[a-zA-Z]*")){
    return true;
}

else if(email.matches("[a-zA-Z]")){
    return true;

}
else if(email.matches("[\\d]*")){
    }
else if(email.matches("(.)")){
    }
else if(email.matches("(@)")){
    return true;
}
return false;
}
}
