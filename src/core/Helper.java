
package core;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;


public class Helper {
    
    
    
    public static boolean isEmailValid(String mail){
        if(mail == null || mail.trim().isEmpty()) return false;
        
        if(!mail.contains("@")) return false;
        
        String[] parts = mail.split("@");
        if(parts.length !=2) return false;
        if(parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;
        if(!parts[1].contains(".")) return false;
        
        return true;
    }
    
    public static void showMsg(String message){
        
        String msg;
        String title;
        
        switch(message){
            case "fill" : 
                msg = "Please, fill in the empty fields.";
                title = "Error";
                break;
            case "done" :
                msg = "Done.";
                title = "Done";
                break;
            case "error" :
                msg = "Error.";
                title = "Error";
                break;
            default : 
                msg = message;
                title = "Message";
                        
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(String str){
        String msg;
        if(str.equals("sure")){
            msg = "ARE YOU SURE YOU WANT TO CARRY OUT THIS OPERATION?";
        }else{
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null, msg,"Are you sure?",JOptionPane.YES_NO_OPTION)==0;
    }
    
}
