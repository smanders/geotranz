/*
 * CreateHeaderDlg.java
 *
 * Created on January 14, 2002, 12:17 PM
 */

package geotrans.gui;


import geotrans.enumerations.ConversionState;
import geotrans.enumerations.SourceOrTarget;
import geotrans.gui.MasterPanel;
import geotrans.jni.*;
import geotrans.utility.Center;
import geotrans.utility.DATFileFilter;
import geotrans.utility.Directory;


/**
 *
 * @author  amyc
 * @version 
 */
public class CreateFileHeaderDlg extends javax.swing.JDialog {

    private Directory currentDir;
    private MasterPanel headerPanel;
    private javax.swing.JFrame parentFrame;
    private jOptions options;
    
    /** Creates new form CreateHeaderDlg */
    public CreateFileHeaderDlg(javax.swing.JFrame parent,boolean modal,Directory dir,jOptions joptions) {
        super (parent, modal);
        currentDir = dir;
        options = joptions;
        parentFrame = parent;
        initComponents ();
        headerPanel = new MasterPanel(ConversionState.CREATE_HEADER, SourceOrTarget.TARGET, joptions);
        createFileHeaderPanel.add(headerPanel, java.awt.BorderLayout.CENTER);
        pack ();
        new Center(parent, this);        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        createFileHeaderPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        getContentPane().setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints1;
        setTitle("Create File Header");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        }
        );
        
        createFileHeaderPanel.setLayout(new java.awt.BorderLayout());
        createFileHeaderPanel.setPreferredSize(new java.awt.Dimension(467, 185));
        createFileHeaderPanel.setBorder(new javax.swing.border.LineBorder(java.awt.Color.black));
        createFileHeaderPanel.setMinimumSize(new java.awt.Dimension(467, 185));
        
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        getContentPane().add(createFileHeaderPanel, gridBagConstraints1);
        
        
        buttonsPanel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gridBagConstraints2;
        buttonsPanel.setPreferredSize(new java.awt.Dimension(330, 50));
        buttonsPanel.setMinimumSize(new java.awt.Dimension(330, 50));
        
        createButton.setPreferredSize(new java.awt.Dimension(80, 21));
          createButton.setBorder(new javax.swing.border.BevelBorder(0));
          createButton.setMnemonic(java.awt.event.KeyEvent.VK_C);
          createButton.setMaximumSize(new java.awt.Dimension(80, 21));
          createButton.setText("Create");
          createButton.setMinimumSize(new java.awt.Dimension(80, 21));
          createButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  createButtonActionPerformed(evt);
              }
          }
          );
          gridBagConstraints2 = new java.awt.GridBagConstraints();
          gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
          gridBagConstraints2.insets = new java.awt.Insets(0, 0, 12, 45);
          buttonsPanel.add(createButton, gridBagConstraints2);
          
          
        cancelButton.setPreferredSize(new java.awt.Dimension(80, 21));
          cancelButton.setBorder(new javax.swing.border.BevelBorder(0));
          cancelButton.setMnemonic(java.awt.event.KeyEvent.VK_A);
          cancelButton.setMaximumSize(new java.awt.Dimension(80, 21));
          cancelButton.setText("Cancel");
          cancelButton.setMinimumSize(new java.awt.Dimension(80, 21));
          cancelButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  cancelButtonActionPerformed(evt);
              }
          }
          );
          gridBagConstraints2 = new java.awt.GridBagConstraints();
          gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
          gridBagConstraints2.insets = new java.awt.Insets(0, 0, 12, 0);
          buttonsPanel.add(cancelButton, gridBagConstraints2);
          
          
        gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 4;
        getContentPane().add(buttonsPanel, gridBagConstraints1);
        
    }//GEN-END:initComponents

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible (false);
        dispose ();
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
    setVisible( false );
    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser(currentDir.getDirectory());
    fileChooser.setDialogTitle("Save As");
    fileChooser.addChoosableFileFilter(new DATFileFilter()); 
    fileChooser.setSelectedFile(new java.io.File("*.dat"));
    int state = fileChooser.showSaveDialog(parentFrame);   
    if( state == javax.swing.JFileChooser.APPROVE_OPTION )
    {
       // if engine is set & no Jni errors
        headerPanel.setEngine();
        if (!headerPanel.JNIError())
        {
            // if no engine errors
            if(!headerPanel.engineError())
            {
                java.io.File file = fileChooser.getSelectedFile();
                currentDir.setDirectory(file.getAbsolutePath());
                if( file != null )
                {
                    JNIFiomeths jniFiomeths = new JNIFiomeths();
                    try
                    {
                        // Set Formats
                        jniFiomeths.JNIUseNSEW(options.getUseNSEW());
                        jniFiomeths.JNIUseMinutes(options.getUseMinutes());
                        jniFiomeths.JNIUseSeconds(options.getUseSeconds());

                        jniFiomeths.JNISetOutputFilename(file.getPath());  
                        jniFiomeths.JNIWriteExampleCoord();
                        jniFiomeths.JNICloseOutputFile();
                        javax.swing.JOptionPane.showMessageDialog(parentFrame, "File header creation complete.", new JNIStrtoval().getTitle(), javax.swing.JOptionPane.PLAIN_MESSAGE);
                        dispose();
                    }
                    catch(GeotransError e)
                    {
                        new JNIStrtoval().displayErrorMsg(this, e.getMessage());
                        jniFiomeths.JNICloseOutputFile();
                    }
                    catch(JNIException e)
                    {
                        new JNIStrtoval().displayErrorMsg(this, e.getMessage());
                        jniFiomeths.JNICloseOutputFile();
                    }                   
                }
            }
            else
                headerPanel.showErrors(this);    
        }
        else
            headerPanel.showErrors(this);
    }
  }//GEN-LAST:event_createButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible (false);
        dispose ();
    }//GEN-LAST:event_closeDialog

    /**
    * @param args the command line arguments
    */
   /* public static void main (String args[]) {
        new CreateHeaderDlg (new javax.swing.JFrame (), true).show ();
    }*/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel createFileHeaderPanel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton createButton;
    private javax.swing.JButton cancelButton;
    // End of variables declaration//GEN-END:variables

}
