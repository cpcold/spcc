package Texteditor;


import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JPanel;


public class TextEditoe extends javax.swing.JFrame implements ActionListener
{
    MenuBar mbr;
    Menu file,edit,help;
    MenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9;
    JPanel mainpanel;
    TextArea text;
    Font f;
    String command="";
    String str1="";
    String str2="";
    String str3="";
    String str4="";
    String str5="";
    String str6="";
    String str7="";
    String str8="";
    String str9="";
    int len,pos1,len1,i=0;
    
    
    public TextEditoe(String str) 
    {
        //initComponents();
        
        super(str);
        mainpanel=new JPanel();
        mainpanel=(JPanel)getContentPane();
        mainpanel.setLayout(new FlowLayout());
        
        mbr=new MenuBar();
        setMenuBar(mbr);
        file=new Menu("File");
        help=new Menu("Help");
        edit=new Menu("Edit");
        
        file.add(item1=new MenuItem("New"));
        file.add(item2=new MenuItem("Open"));
        file.add(item3=new MenuItem("Exit"));
        file.add(item4=new MenuItem("Save as..."));
        mbr.add(file);
        
        edit.add(item5=new MenuItem("Cut"));
        edit.add(item5=new MenuItem("Copy"));
        edit.add(item5=new MenuItem("Paste"));
        edit.add(item5=new MenuItem("Select All"));
        edit.add(item5=new MenuItem("Delete"));
        mbr.add(edit);
        mbr.add(help);
        
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
        item6.addActionListener(this);
        item7.addActionListener(this);
        item8.addActionListener(this);
        item9.addActionListener(this);
        
        text=new TextArea(30,60);
        mainpanel.add(text);
        f=new Font("Times New Roman",Font.PLAIN,15);
        text.setFont(f);    
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) 
    {
        TextEditoe note=new TextEditoe("Untitled-Notepad");
        note.setSize(500,500);
        note.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
         command=(String)ae.getActionCommand();
        if(command.equals("New"))
        {
            dispose();
            TextEditoe note1=new TextEditoe("Untitled-notepad");
            note1.setSize(500,500);
            note1.setVisible(true);
        }
        try
        {
            if(command.equals("Open"))
            {
                str4="";
                FileDialog dialog=new FileDialog(this,"Open");
                dialog.setVisible(true);
                str1=dialog.getDirectory();
                str2=dialog.getFile();
                File f=new File(str3);
                FileInputStream fobj=new FileInputStream(f);
                len=(int)f.length();
                for(int j=0;j<len;j++)
                {
                    char str5=(char)fobj.read();
                    str4=str4+str5;
                }
                text.setText(str4);
            }
        }catch(Exception e2)
        {          
        }
        
        
        try
        {
            if(command.equals("Save As..."))
            {
                FileDialog dialog=new FileDialog(this,"Save as...",FileDialog.SAVE);
                dialog.setVisible(true);
                str7=dialog.getDirectory();
                str8=dialog.getFile();
                str9=str7+str8;
                str6=text.getText();
                len1=str6.length();
                byte buf[]=str6.getBytes();
                
                File f1=new File(str6);
                FileOutputStream fobj1=new FileOutputStream(f1);
                for(int k=1;k<len1;k++)
                {
                    fobj1.write(buf[k]);
                }
                fobj1.close();
            }
            this.setTitle(str8);
        }catch(IOException e1)
        {}
        if(command.equals("Exit"))
            System.exit(0);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
