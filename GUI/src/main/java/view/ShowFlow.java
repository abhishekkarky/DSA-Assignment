package view;

import javax.swing.*;
import java.awt.*;

import static view.Homepage.JOB_NAME;
import static view.JobDesc.flow;

public class ShowFlow extends JFrame {
    JLabel jobname,label;
    ShowFlow(){
        System.out.println(JOB_NAME);
        uI();
        jobName();
        addLabel();
        setLayout(null);
        setVisible(true);
    }
    void uI(){
        setTitle("Flow of the Job");
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 10, 489, 650);
        setBackground(Color.decode(("#EBEBEB")));
    }
    public void jobName(){
        jobname= new Base.Label(JOB_NAME,20);
        jobname.setForeground(Color.BLACK);
        add(jobname);
    }
    public void addLabel(){
        int val=30;
        for(int i=0;i<flow.size();i++){
            String dep= flow.get(i);
            label= new Base.Label(dep,15);
            add(label);
        }
    }
    public static void main(String[] args) {
        new ShowFlow().setVisible(true);
    }
}
