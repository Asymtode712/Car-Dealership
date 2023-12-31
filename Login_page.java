import java.awt.event.KeyEvent;
  import java.sql.*;
import javax.swing.JOptionPane;


public class Login_page extends javax.swing.JFrame {

 

        public void keyPressed() {

           Var x=new Var();
         String userId=UserName.getText();
        String pass=pwd.getText();
        
       try{
                Class.forName("java.sql.DriverManager");
                Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/cardb","root","");
                Statement stmt=(Statement) con.createStatement();
                String sql1="select * from adminDB where userid='"+userId+"';";
                ResultSet rs1=stmt.executeQuery(sql1);
               String sql2="select * from clientdb where userid='"+userId+"';";
                
               String userIdDB=null;
                String passDB=null;
                   String name=null;
                //     data from Admin Database
                while(rs1.next())
             {      
                 userIdDB=rs1.getString(1);
                 passDB=rs1.getString(2);
                 x.User_id=userIdDB;
                 x.CatlogKey=1;
             }
             
                if(userId.equals(userIdDB)&&pass.equals(passDB)){
                this.setVisible(false);
                new Admin().setVisible(true);
                }
                
                //Data From Client Database
                else
                {
                      ResultSet rs2=stmt.executeQuery(sql2);
                      
                 while(rs2.next()){      
                 userIdDB=rs2.getString(1);
                 passDB=rs2.getString(2);
                x.User_id=userIdDB;
                x.CatlogKey=2;
                 }
             
                if(userId.equals(userIdDB)&&pass.equals(passDB)){
                this.setVisible(false);
                new Client().setVisible(true);
                        rs2.close();
                     }
                
                 //No Data found
                else
                    JOptionPane.showMessageDialog(rootPane,"Wrong UserName/Password");
                    }
                
                rs1.close();
                stmt.close();
                con.close();
        }
       
        catch(Exception e){
            System.out.println(e);
        JOptionPane.showMessageDialog(null,e);
        System.exit(0);
        }

        }

    
    /**
     * Creates new form Login_page
     */
    public Login_page() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ravie", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login Panel");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 30, 370, 70);

        UserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UserNameKeyPressed(evt);
            }
        });
        jPanel1.add(UserName);
        UserName.setBounds(320, 150, 260, 30);

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(570, 280, 80, 40);

        jLabel5.setFont(new java.awt.Font("Poor Richard", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("View Catalog");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(180, 280, 120, 40);

        pwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwdKeyPressed(evt);
            }
        });
        jPanel1.add(pwd);
        pwd.setBounds(320, 210, 260, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 150, 130, 30);

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 210, 110, 30);

        jButton3.setText("Sign up");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(450, 280, 80, 40);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(330, 280, 80, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogin.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 740, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      keyPressed();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(rootPane,"Are you sure,You want to Exit","Select an Option",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       if(x==0)
        {
       System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Catlog().setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
           this.setVisible(false);
        new Signup().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void pwdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        keyPressed();
    }//GEN-LAST:event_pwdKeyPressed

    private void UserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UserNameKeyPressed
        // TODO add your handling code here:
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        keyPressed();
    }//GEN-LAST:event_UserNameKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pwd;
    // End of variables declaration//GEN-END:variables

   
}
