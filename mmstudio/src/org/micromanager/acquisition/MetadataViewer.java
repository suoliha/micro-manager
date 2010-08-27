/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MetadataViewer.java
 *
 * Created on Jul 16, 2010, 11:18:45 AM
 */
package org.micromanager.acquisition;

import ij.ImageListener;
import ij.ImagePlus;
import ij.ImageStack;
import ij.WindowManager;
import ij.gui.ImageWindow;
import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.util.Arrays;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import mmcorej.TaggedImage;
import org.micromanager.acquisition.MMImageCache;
import org.micromanager.utils.GUIUtils;

/**
 *
 * @author arthur
 */
public class MetadataViewer extends javax.swing.JFrame
        implements ImageListener, AWTEventListener {

   private static MetadataViewer singletonViewer_ = null;
   private final MetadataTableModel imageMetadataModel_;
   private final MetadataTableModel summaryMetadataModel_;
   private ImageWindow currentWindow_;
   private final String [] columnNames_ = {"Property","Value"};
   private MMImageCache cache_;
   
   /** Creates new form MetadataViewer */
   public MetadataViewer() {
      initComponents();
      imageMetadataModel_ = new MetadataTableModel();
      summaryMetadataModel_ = new MetadataTableModel();

      ImagePlus.addImageListener(this);
      update(ij.IJ.getImage());
      imageMetadataTable.setModel(imageMetadataModel_);
      summaryMetadataTable.setModel(summaryMetadataModel_);

      this.getToolkit().addAWTEventListener(this, AWTEvent.WINDOW_FOCUS_EVENT_MASK);
   }

   public static MetadataViewer showMetadataViewer() {
      if (singletonViewer_ == null) {
         singletonViewer_ = new MetadataViewer();
         GUIUtils.recallPosition(singletonViewer_);
      }
      singletonViewer_.setVisible(true);
      return singletonViewer_;
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane2 = new javax.swing.JScrollPane();
      jTextArea1 = new javax.swing.JTextArea();
      tabbedPane = new javax.swing.JTabbedPane();
      Comments = new javax.swing.JScrollPane();
      commentsTextArea = new javax.swing.JTextArea();
      Summary = new javax.swing.JScrollPane();
      summaryMetadataTable = new javax.swing.JTable();
      Image = new javax.swing.JPanel();
      metadataTableScrollPane = new javax.swing.JScrollPane();
      imageMetadataTable = new javax.swing.JTable();
      jCheckBox1 = new javax.swing.JCheckBox();
      saveButton = new javax.swing.JButton();
      closeButton = new javax.swing.JButton();

      jTextArea1.setColumns(20);
      jTextArea1.setRows(5);
      jScrollPane2.setViewportView(jTextArea1);

      setTitle("Metadata and Comments");

      tabbedPane.setFocusable(false);

      commentsTextArea.setColumns(20);
      commentsTextArea.setLineWrap(true);
      commentsTextArea.setRows(5);
      commentsTextArea.setWrapStyleWord(true);
      Comments.setViewportView(commentsTextArea);

      tabbedPane.addTab("Comments", Comments);

      summaryMetadataTable.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
         },
         new String [] {
            "Property", "Value"
         }
      ) {
         boolean[] canEdit = new boolean [] {
            false, false
         };

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      Summary.setViewportView(summaryMetadataTable);

      tabbedPane.addTab("Summary", Summary);

      Image.setOpaque(false);

      imageMetadataTable.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Property", "Value"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class
         };
         boolean[] canEdit = new boolean [] {
            false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      imageMetadataTable.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
      imageMetadataTable.setDoubleBuffered(true);
      metadataTableScrollPane.setViewportView(imageMetadataTable);

      jCheckBox1.setText("Show unchanging properties");

      org.jdesktop.layout.GroupLayout ImageLayout = new org.jdesktop.layout.GroupLayout(Image);
      Image.setLayout(ImageLayout);
      ImageLayout.setHorizontalGroup(
         ImageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(ImageLayout.createSequentialGroup()
            .add(jCheckBox1)
            .addContainerGap(32, Short.MAX_VALUE))
         .add(metadataTableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
      );
      ImageLayout.setVerticalGroup(
         ImageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(ImageLayout.createSequentialGroup()
            .add(jCheckBox1)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(metadataTableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
      );

      tabbedPane.addTab("Image", Image);

      saveButton.setText("Save");
      saveButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveButtonActionPerformed(evt);
         }
      });

      closeButton.setText("Close");
      closeButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            closeButtonActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                  .addContainerGap()
                  .add(saveButton)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                  .add(closeButton))
               .add(layout.createSequentialGroup()
                  .add(13, 13, 13)
                  .add(tabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(closeButton)
               .add(saveButton))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(tabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
      String text = commentsTextArea.getText();
      cache_.setComment(text);
   }//GEN-LAST:event_saveButtonActionPerformed

   private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
      this.setVisible(false);
   }//GEN-LAST:event_closeButtonActionPerformed

   class MetadataTableModel extends AbstractTableModel {

      Vector<Vector<String>> data_;

      MetadataTableModel() {
         data_ = new Vector<Vector<String>>();
      }

      public int getRowCount() {
         return data_.size();
      }

      public void addRow(Vector<String> rowData) {
         data_.add(rowData);
      }

      public int getColumnCount() {
         return 2;
      }

      public synchronized Object getValueAt(int rowIndex, int columnIndex) {
         if (data_.size() > rowIndex) {
            Vector<String> row = data_.get(rowIndex);
            if (row.size() > columnIndex)
               return data_.get(rowIndex).get(columnIndex);
            else
               return "";
         } else {
            return "";
         }
      }

      public void clear() {
         data_.clear();
      }

      @Override
      public String getColumnName(int colIndex) {
         return columnNames_[colIndex];
      }

      public synchronized void setMetadata(Map<String,String> md) {
         clear();
         if (md != null) {
            Object[] keys = (Object[]) md.keySet().toArray();
            Arrays.sort(keys);

            for (Object key : keys) {
               Vector<String> rowData = new Vector<String>();
               rowData.add((String) key);
               rowData.add(md.get((String) key));
               addRow(rowData);
            }
         }
         fireTableDataChanged();
      }
   }

   private AcquisitionVirtualStack getAcquisitionStack(ImagePlus imp) {
      ImageStack stack = imp.getStack();
      if (stack instanceof AcquisitionVirtualStack) {
         return (AcquisitionVirtualStack) stack;
      } else {
         return null;
      }
   }

   public void update(ImagePlus imp) {
      if (this.isVisible()) {
         if (imp == null) {
            imageMetadataModel_.setMetadata(null);
            commentsTextArea.setText(null);
         } else {
            AcquisitionVirtualStack stack = getAcquisitionStack(imp);
            if (stack != null) {
               int slice = imp.getCurrentSlice();
               TaggedImage taggedImg = stack.getTaggedImage(slice);
               if (taggedImg == null) {
                  imageMetadataModel_.setMetadata(null);
               } else {
                  Map<String,String> md = stack.getTaggedImage(slice).tags;
                  imageMetadataModel_.setMetadata(md);
               }
            } else {
               imageMetadataModel_.setMetadata(null);
            }


         }
      }
   }

   @Override
   public void setVisible(boolean visible) {
      super.setVisible(visible);
      if (visible)
         eventDispatched(null);
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JScrollPane Comments;
   private javax.swing.JPanel Image;
   private javax.swing.JScrollPane Summary;
   private javax.swing.JButton closeButton;
   private javax.swing.JTextArea commentsTextArea;
   private javax.swing.JTable imageMetadataTable;
   private javax.swing.JCheckBox jCheckBox1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTextArea jTextArea1;
   private javax.swing.JScrollPane metadataTableScrollPane;
   private javax.swing.JButton saveButton;
   private javax.swing.JTable summaryMetadataTable;
   private javax.swing.JTabbedPane tabbedPane;
   // End of variables declaration//GEN-END:variables


   //Implements ImageListener
   public void imageOpened(ImagePlus imp) {
      update(imp);
   }

   //Implements ImageListener
   public void imageClosed(ImagePlus imp) {
      if (WindowManager.getCurrentWindow() == null) {
         update((ImagePlus) null);
      }
   }

   //Implements ImageListener
   public void imageUpdated(ImagePlus imp) {
      update(imp);
   }

   private MMImageCache getCache(ImagePlus imgp) {
      AcquisitionVirtualStack stack = getAcquisitionStack(imgp);
      if (stack != null)
         return stack.getCache();
      else
         return null;
   }


   //Implements AWTEventListener
   public void eventDispatched(AWTEvent event) {
      ImageWindow currentWindow = WindowManager.getCurrentWindow();
      Map<String, String> md = null;
      if (currentWindow_ != currentWindow) {
         ImagePlus imgp = currentWindow.getImagePlus();
         cache_ = getCache(imgp);

         if (cache_ != null) {
            commentsTextArea.setText(cache_.getComment());
            md = cache_.getAcquisitionMetadata();
            summaryMetadataModel_.setMetadata(md);

         }  else {
            commentsTextArea.setText(null);
         }

         update(imgp);
         
      }
   }
   

}
