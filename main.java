
//DEVELOPER: Ryan Sherwood
package im.client.pkg1.pkg0;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class main extends javax.swing.JFrame {
//Version: 1.0 Development
  
    
    
private ObjectOutputStream output;
private ObjectInputStream input;
private String message = "";
private String serverIP ;
private Socket connection;

  public void startRunning(){
		try{
			connectToServer();
			setupStreams();
			whileChatting();
                            if(InputField .equals("/end")){
                            closeConnection();
                        }
		}catch(EOFException eofException){
			showMessage("\n Client terminated the connection\n");
		}catch(IOException ioException){
			ServerConsole.setText("Cannot connect");
                       
                                
		}finally{
		
		}
	}
  private void connectToServer() throws IOException{
		showMessage("\nAttempting connection... \n");
		connection = new Socket("25.97.54.64", 6789);
		showMessage("\nConnection Established! Connected to: " + connection.getInetAddress().getHostName());
	}
  private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n The streams are now set up! \n");
	}
  private void whileChatting() throws IOException{
		
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException classNotFoundException){
				showMessage("\nUnknown data received!");
			}
		}while(!message.equals("/end"));	
	}
  private void closeConnection(){
		showMessage("\n Closing the connection!\n");
		
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioException){
		ServerConsole.setText("Unable to close connection!");
		}
	}
  private void sendMessage(String message){
		try{
			output.writeObject("CLIENT - " + message);
			output.flush();
			showMessage("\nCLIENT - " + message);
		}catch(IOException ioException){
			ServerConsole.setText("Excepton " + ioException);
		}
	}
  private void showMessage(final String message){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					ChatOutputField.append(message);
				}
			}
		);
	}
  
    public main() {
  
        initComponents();
    }

    

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ChatOutputField = new javax.swing.JTextArea();
        InputField = new javax.swing.JTextField();
        ChatWindowLabel = new javax.swing.JLabel();
        ServerConsole = new javax.swing.JTextField();
        VersionLabel = new javax.swing.JLabel();
        ConnectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ChatOutputField.setEditable(false);
        ChatOutputField.setColumns(20);
        ChatOutputField.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        ChatOutputField.setRows(5);
        jScrollPane1.setViewportView(ChatOutputField);

        InputField.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        InputField.setText("Enter a message here");
        InputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputFieldActionPerformed(evt);
            }
        });

        ChatWindowLabel.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        ChatWindowLabel.setText("Chat window");

        ServerConsole.setEditable(false);
        ServerConsole.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        ServerConsole.setText("Server Console");
        ServerConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerConsoleActionPerformed(evt);
            }
        });

        VersionLabel.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        VersionLabel.setText("Version: 1.0 Client");

        ConnectButton.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        ConnectButton.setText("Connect!");
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(InputField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChatWindowLabel)
                    .addComponent(ServerConsole)
                    .addComponent(VersionLabel)
                    .addComponent(ConnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ChatWindowLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ServerConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConnectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VersionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    private void ServerConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerConsoleActionPerformed
           sendMessage(evt.getActionCommand());
           InputField.setText("");
    }//GEN-LAST:event_ServerConsoleActionPerformed

    private void InputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputFieldActionPerformed

    private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectButtonActionPerformed
        try{
            startRunning();
        }catch(Exception e){
            ServerConsole.setText("Exception: " + e);
        }
    }//GEN-LAST:event_ConnectButtonActionPerformed

    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ChatOutputField;
    private javax.swing.JLabel ChatWindowLabel;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JTextField InputField;
    private javax.swing.JTextField ServerConsole;
    private javax.swing.JLabel VersionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
