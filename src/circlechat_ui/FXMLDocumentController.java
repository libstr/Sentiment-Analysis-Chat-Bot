/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;

import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.TextFlow;

/**
 *
 * @author libin
 */
public class FXMLDocumentController implements Initializable {
    
        File path=new File("Happy.txt");
       File path1=new File("Sad.txt");
       File path2=new File("Neutral.txt");
    
    @FXML
    private ImageView bot;
    @FXML
    private ImageView settings;
    @FXML
    private ImageView about;
    
    @FXML
    private AnchorPane a_bot;
    @FXML
    private AnchorPane a_settings;
    @FXML
    private AnchorPane a_about;
    @FXML
    public Label userlabel,botlabel,lab[];
    @FXML
    public TextField message;   
    @FXML
    public TextFlow txtf;
    
    
    @FXML
    private void handleClose() {
        System.exit(0);
    }
    
    @FXML
    private void LogOut(){
         MainController.primaryStage.hide();
         CircleChat_UI.MainLogin.show();
    }
    
    public void handleButtonAction1() throws FileNotFoundException{
        
        
        
        String s=message.getText();
        userlabel.setText(s);
        message.setText("");
        userlabel.setTranslateY(10);
        
        switch(s){
            //conversation starters:
            case "hi": botlabel.setText("Hello, how are you?");
                        break;    
            case "hello": botlabel.setText("Hello, how are you?");
                        break;
            case "hey": botlabel.setText("Hello, how are you?");
                        break;
            //simple statement:
            case "i am fine": botlabel.setText("good to hear that!");
                        break;
            case "i am fine.": botlabel.setText("good to hear that!");
                        break;         
            case "so":  botlabel.setText("so..");
                        break; 
            //simple questions:
            case "how are you?": botlabel.setText("i am fine, thank you!");
                        break;
            case "who are you": botlabel.setText("i am circle. a chatbot!");
                        break;
            case "who are you?": botlabel.setText("i am circle. a chatbot!");
                        break;
            case "what are you?":botlabel.setText("i am circle. a Chatbot.");
                        break;
            case "what are you exactly?":botlabel.setText("i am circle, a chatbot!");
                        break;
            case "what is your name?":botlabel.setText("my name is circle. i am a chatbot.");
                        break;
            case "who created you?":botlabel.setText("i was created by libin,tridhe,elvis and rinchen.");
                        break;            
            case "what are you doing?": botlabel.setText("answering your questions!");
                        break;                
            default:botlabel.setText("sorry, i didnt get that!");
            
                        break;
        }
      coreNlp(s);


    }  
    
    public void cut(File path) throws FileNotFoundException{
        Scanner in=new Scanner(path);
         String g=in.nextLine();
        int s=g.length();
        char z;
        int pos=0,count=0,r=0;
        String a[]=new String[s];
         for(int l=0;l<s;l++){
             z=g.charAt(l);
             if(z=='.'){
               a[count]=g.substring(pos,l);
               pos=l;
               count++;
               
             
             }
         } 
          r=(int)(Math.random()*count);
          for(int i=0;i<a[r].length();i++){
              botlabel.setText(botlabel.getText()+a[r].charAt(i));
              if(i%40==0)
                 botlabel.setText(botlabel.getText()+"\n");
          }
    }
    
    
    int p=0;
    public void coreNlp(String st) throws FileNotFoundException{
        String line;
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        //Scanner sc = new Scanner(System.in);
        //line = sc.nextLine();
        line = st;
        line = line.replaceAll(" ", " . ");
        System.out.println(line);
        //sentiment ana
          Annotation annotation = new Annotation(line);
          pipeline.annotate(annotation);
          List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        String sm = "Null";
        int s=2,k=0,s2=2,k2=0,s3=0,n=0;
        String neg="";
        if (sentences != null && !sentences.isEmpty()) {
             int small=3;
        for (int i = 0; i < sentences.size (); i++) {
            CoreMap sentence = sentences.get(i);
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
            String sentimentName = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            if(sentiment<small)
                small = sentiment;
            if(sentiment<2){
                s=sentiment;
                neg=sentence.toString();
                k++;
            }
            else if(sentiment>2){
               s2=sentiment;
               k2++;
           }
            else{
                n++;
            }
               
          }
        
        if(s<2){
            if(p==1){
                botlabel.setText("No problem if u have been "+neg.substring(0, neg.length()-1)+" ");cut(path1);
                p=0;
            }else{botlabel.setText("");
            botlabel.setText("I am sorry to Hear that \nWhat happened ?");
            p=1;
            }
        }
       if(k==0){
           botlabel.setText(botlabel.getText()+"\n ,Since you seem to be neutral\n so a small quote for you\n");cut(path2);
       }
            
        if(k2>k){
                botlabel.setText("Oh I am Glad To hear That but remember \n");cut(path);
        }
    }
    }
    
    @FXML
    private void handleButtons(MouseEvent e){
        if(e.getTarget() == bot){
            
            a_settings.setVisible(false);
            a_about.setVisible(false);
            if(a_bot.isVisible()){
                a_bot.setVisible(false);
            }else{
                a_bot.setVisible(true);
            }
        }
        else if(e.getTarget() == settings){
           
             a_bot.setVisible(false);
             a_about.setVisible(false);
             if(a_settings.isVisible()){
                a_settings.setVisible(false);
            }else{
                a_settings.setVisible(true);
            }
        }
        else if(e.getTarget() == about){
            
            a_settings.setVisible(false);
             a_bot.setVisible(false);
                if(a_about.isVisible()){
                a_about.setVisible(false);
            }else{
                a_about.setVisible(true);
            }
        }
    }
    @FXML
public void onEnter(ActionEvent ae) throws FileNotFoundException{
   handleButtonAction1();
}
    
    @FXML
    private void botClick(){
        bot.opacityProperty().setValue(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
