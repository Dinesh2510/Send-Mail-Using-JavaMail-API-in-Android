# Send-a-mail-using-Java-in-Android
## 1.Initially Add the 3 Jar file in android library
Link: [JavaMail API](https://code.google.com/archive/p/javamail-android/downloads"MailAPI")

## 2.Implement the jar file in Gradle build 

    implementation files('libs\\mail.jar')
    implementation files('libs\\activation.jar')
    implementation files('libs\\additionnal.jar')
    
## 3.sendMail.java is main method file by using Async Task send the mail.

## 4.Config.java (add your own Email and Passowrd)

    public class Config {
    public static final String EMAIL ="ENTER YOUR EMAIL ADDRESS";
    public static final String PASSWORD ="ENTER YOUR EMAIL ID PASSWORD";
    }
