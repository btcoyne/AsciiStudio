/*
 * Copyright (C) 2020 Ian Martinez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package asciistudio;

import asciilib.ImageResizer;
import giflib.Gif;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ian Martinez
 */
public class MainWindow extends javax.swing.JFrame {
    public String sourceImagePath = ""; // The source image's location
    public boolean isGif = false; // If the source image is a GIF or still image
    public Gif sourceGif; // The source image if it's a GIF
    public BufferedImage sourceCurrentFrame; // If a GIF, the current frame, if not the whole image
    public BufferedImage sampledCurrentFrame; // The current frame at the sampling size
    
    // File dialogs
    JFileChooser importImageDialog = new JFileChooser();
    JFileChooser exportImageDialog = new JFileChooser();
    JFileChooser exportTextDialog = new JFileChooser();
    
    // Filters for file dialogs
    public FileNameExtensionFilter importImageFilter = new FileNameExtensionFilter("Image Files(*.jpeg, *.jpg, *.gif, *.png)", "jpeg", "jpg", "gif", "png");
    public FileNameExtensionFilter exportImageFilter = new FileNameExtensionFilter("Image Files(*.gif, *.png)", "gif", "png");
    public FileNameExtensionFilter exportTextFilter = new FileNameExtensionFilter("Text Files(*.txt)", "txt");

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        beforeAfterSplitter.setDividerLocation(beforeAfterSplitter.getWidth() / 2);            	
    	importImageDialog.addChoosableFileFilter(importImageFilter);        	
    	exportImageDialog.addChoosableFileFilter(exportImageFilter);        	
    	exportTextDialog.addChoosableFileFilter(exportTextFilter);
    }
    
    private String getExt(String path) 
    {
        int dot = path.lastIndexOf(".");
        return path.substring(dot + 1).toLowerCase();
    }
    
    private void refreshPreview() {
        if(sourceCurrentFrame != null) {
            var samplingRatio = (double)samplingSizeSpinner.getValue();
            sampledCurrentFrame = ImageResizer.getSample(sourceCurrentFrame, samplingRatio); 
            sampleWidthLabel.setText(sampledCurrentFrame.getWidth() + "px");
            sampleHeightLabel.setText(sampledCurrentFrame.getHeight() + "px");            
            renderedImageView.setIcon(new StretchIcon(sampledCurrentFrame));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainSplitter = new javax.swing.JSplitPane();
        settingsImageSplitter = new javax.swing.JSplitPane();
        currentPaletteContainer = new javax.swing.JPanel();
        currentPalette = new ascomponent.PalettePanel();
        beforeAfterSplitter = new javax.swing.JSplitPane();
        originalImageView = new javax.swing.JLabel();
        renderedImageView = new javax.swing.JLabel();
        sidebarScroll = new javax.swing.JScrollPane();
        sidebarPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        frameCountLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        widthLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        samplingSizeSpinner = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sampleWidthLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sampleHeightLabel = new javax.swing.JLabel();
        mainToolbar = new javax.swing.JToolBar();
        importButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        exportTextButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        importMenuItem = new javax.swing.JMenuItem();
        exportMenuItem = new javax.swing.JMenuItem();
        exportTextMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        paletteMenu = new javax.swing.JMenu();
        editBasePaletteMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        loadPaletteMenuItem = new javax.swing.JMenuItem();
        savePaletteMenuItem = new javax.swing.JMenuItem();
        resetPaletteMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        refreshMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("MainWindowFrame"); // NOI18N
        setSize(new java.awt.Dimension(700, 500));

        mainSplitter.setDividerLocation(700);
        mainSplitter.setResizeWeight(0.85);
        mainSplitter.setDoubleBuffered(true);

        settingsImageSplitter.setDividerLocation(120);
        settingsImageSplitter.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        currentPaletteContainer.setMinimumSize(new java.awt.Dimension(550, 55));
        currentPaletteContainer.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        currentPaletteContainer.add(currentPalette, gridBagConstraints);

        settingsImageSplitter.setLeftComponent(currentPaletteContainer);

        beforeAfterSplitter.setDividerLocation(350);
        beforeAfterSplitter.setResizeWeight(0.5);

        originalImageView.setToolTipText("");
        originalImageView.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        beforeAfterSplitter.setLeftComponent(originalImageView);

        renderedImageView.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        beforeAfterSplitter.setRightComponent(renderedImageView);

        settingsImageSplitter.setRightComponent(beforeAfterSplitter);

        mainSplitter.setLeftComponent(settingsImageSplitter);

        sidebarScroll.setBorder(null);
        sidebarScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sidebarScroll.setMinimumSize(new java.awt.Dimension(120, 5));

        sidebarPanel.setMinimumSize(new java.awt.Dimension(120, 300));
        java.awt.GridBagLayout sidebarPanelLayout = new java.awt.GridBagLayout();
        sidebarPanelLayout.columnWeights = new double[] {1.0};
        sidebarPanelLayout.rowWeights = new double[] {-1.0, -1.0, -1.0};
        sidebarPanel.setLayout(sidebarPanelLayout);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Frames:");
        jPanel5.add(jLabel6, java.awt.BorderLayout.WEST);

        frameCountLabel.setText("0");
        jPanel5.add(frameCountLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(jPanel5, gridBagConstraints);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Width:");
        jPanel2.add(jLabel3, java.awt.BorderLayout.WEST);

        widthLabel.setText("900 px");
        jPanel2.add(widthLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Height:");
        jPanel3.add(jLabel5, java.awt.BorderLayout.WEST);

        heightLabel.setText("600 px");
        jPanel3.add(heightLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(jPanel3, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Current Frame:");
        jPanel1.add(jLabel1, java.awt.BorderLayout.WEST);
        jLabel1.getAccessibleContext().setAccessibleName("Sample Size (%):");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        jSpinner1.setMinimumSize(new java.awt.Dimension(40, 26));
        jSpinner1.setPreferredSize(new java.awt.Dimension(50, 26));
        jPanel1.add(jSpinner1, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(jPanel1, gridBagConstraints);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Sample Ratio:");
        jPanel4.add(jLabel2, java.awt.BorderLayout.WEST);

        samplingSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(10.0d, null, 100.0d, 1.0d));
        samplingSizeSpinner.setMinimumSize(new java.awt.Dimension(40, 26));
        samplingSizeSpinner.setPreferredSize(new java.awt.Dimension(50, 26));
        jPanel4.add(samplingSizeSpinner, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(jPanel4, gridBagConstraints);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Sample Width:");
        jPanel6.add(jLabel4, java.awt.BorderLayout.WEST);

        sampleWidthLabel.setText("900 px");
        jPanel6.add(sampleWidthLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(jPanel6, gridBagConstraints);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Sample Height:");
        jPanel7.add(jLabel7, java.awt.BorderLayout.WEST);

        sampleHeightLabel.setText("600 px");
        jPanel7.add(sampleHeightLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(jPanel7, gridBagConstraints);

        sidebarScroll.setViewportView(sidebarPanel);

        mainSplitter.setRightComponent(sidebarScroll);

        mainToolbar.setRollover(true);

        importButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciistudio/icons/document-open.png"))); // NOI18N
        importButton.setText("Import");
        importButton.setFocusable(false);
        importButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(importButton);

        exportButton.setIcon(new javax.swing.ImageIcon("/Users/ianmartinez/GitHub/taiga-icons/png/32/filetype-image.png")); // NOI18N
        exportButton.setText("Export Image");
        exportButton.setFocusable(false);
        exportButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolbar.add(exportButton);

        exportTextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciistudio/icons/filetype-text.png"))); // NOI18N
        exportTextButton.setText("Export Text");
        exportTextButton.setFocusable(false);
        exportTextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportTextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolbar.add(exportTextButton);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciistudio/icons/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(refreshButton);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        importMenuItem.setMnemonic('o');
        importMenuItem.setText("Import...");
        importMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(importMenuItem);

        exportMenuItem.setMnemonic('s');
        exportMenuItem.setText("Export Image...");
        fileMenu.add(exportMenuItem);

        exportTextMenuItem.setMnemonic('a');
        exportTextMenuItem.setText("Export Text...");
        fileMenu.add(exportTextMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        paletteMenu.setText("Palette");

        editBasePaletteMenuItem.setText("Edit Base Palette...");
        editBasePaletteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBasePaletteMenuItemActionPerformed(evt);
            }
        });
        paletteMenu.add(editBasePaletteMenuItem);
        paletteMenu.add(jSeparator1);

        loadPaletteMenuItem.setText("Load Palette");
        paletteMenu.add(loadPaletteMenuItem);

        savePaletteMenuItem.setText("Save Palette");
        paletteMenu.add(savePaletteMenuItem);

        resetPaletteMenuItem.setText("Reset Palette");
        paletteMenu.add(resetPaletteMenuItem);

        menuBar.add(paletteMenu);

        jMenu1.setText("Preview");

        refreshMenuItem.setText("Refresh");
        refreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(refreshMenuItem);

        menuBar.add(jMenu1);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitter, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
            .addComponent(mainToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainSplitter, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void editBasePaletteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBasePaletteMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBasePaletteMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        var aboutDialog = new AboutDialog(this, true);
        aboutDialog.setLocationRelativeTo(this);
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        importMenuItemActionPerformed(evt);
    }//GEN-LAST:event_importButtonActionPerformed

    private void importMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuItemActionPerformed
    	if (importImageDialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)  {
            var importedPath = importImageDialog.getSelectedFile().getAbsolutePath();
                
            try {
                var importingGif = getExt(importedPath).equals("gif");
                
                if(importingGif) {                
                    var importedGif = new Gif(importedPath);
                    var importedCurrentFrame = importedGif.getFrameImage(0);
                    
                    // All importing succeeded, so update data
                    sourceImagePath = importedPath;
                    isGif = true;
                    sourceGif = importedGif;
                    sourceCurrentFrame = importedCurrentFrame;                    
                } else {
                    var importedImage =  ImageIO.read(new File(importedPath));
                    
                    // All importing succeeded, so update data
                    sourceImagePath = importedPath;
                    isGif = false;
                    sourceGif = null;
                    sourceCurrentFrame = importedImage;                      
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error importing " + importedPath + "!");
            }
            
            // Update UI
            originalImageView.setIcon(new StretchIcon(sourceCurrentFrame));
            frameCountLabel.setText(String.valueOf(isGif ? sourceGif.getFrameCount() : 1));
            widthLabel.setText(sourceCurrentFrame.getWidth() + "px");
            heightLabel.setText(sourceCurrentFrame.getHeight() + "px");      
            
            // Set sampling image            
            var samplingRatio = currentPalette.getPalette().getSamplingRatio(sourceCurrentFrame.getWidth(), sourceCurrentFrame.getHeight());
            samplingSizeSpinner.setValue(samplingRatio);
            refreshPreview();
        }
    }//GEN-LAST:event_importMenuItemActionPerformed

    private void refreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMenuItemActionPerformed
        refreshPreview();
    }//GEN-LAST:event_refreshMenuItemActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshMenuItemActionPerformed(evt);
    }//GEN-LAST:event_refreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenuItem aboutMenuItem;
    protected javax.swing.JSplitPane beforeAfterSplitter;
    protected ascomponent.PalettePanel currentPalette;
    protected javax.swing.JPanel currentPaletteContainer;
    protected javax.swing.JMenuItem editBasePaletteMenuItem;
    protected javax.swing.JMenuItem exitMenuItem;
    protected javax.swing.JButton exportButton;
    protected javax.swing.JMenuItem exportMenuItem;
    protected javax.swing.JButton exportTextButton;
    protected javax.swing.JMenuItem exportTextMenuItem;
    protected javax.swing.JMenu fileMenu;
    protected javax.swing.JLabel frameCountLabel;
    protected javax.swing.JLabel heightLabel;
    protected javax.swing.JMenu helpMenu;
    protected javax.swing.JButton importButton;
    protected javax.swing.JMenuItem importMenuItem;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JMenu jMenu1;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JPanel jPanel5;
    protected javax.swing.JPanel jPanel6;
    protected javax.swing.JPanel jPanel7;
    protected javax.swing.JPopupMenu.Separator jSeparator1;
    protected javax.swing.JSpinner jSpinner1;
    protected javax.swing.JMenuItem loadPaletteMenuItem;
    protected javax.swing.JSplitPane mainSplitter;
    protected javax.swing.JToolBar mainToolbar;
    protected javax.swing.JMenuBar menuBar;
    protected javax.swing.JLabel originalImageView;
    protected javax.swing.JMenu paletteMenu;
    protected javax.swing.JButton refreshButton;
    protected javax.swing.JMenuItem refreshMenuItem;
    protected javax.swing.JLabel renderedImageView;
    protected javax.swing.JMenuItem resetPaletteMenuItem;
    protected javax.swing.JLabel sampleHeightLabel;
    protected javax.swing.JLabel sampleWidthLabel;
    protected javax.swing.JSpinner samplingSizeSpinner;
    protected javax.swing.JMenuItem savePaletteMenuItem;
    protected javax.swing.JSplitPane settingsImageSplitter;
    protected javax.swing.JPanel sidebarPanel;
    protected javax.swing.JScrollPane sidebarScroll;
    protected javax.swing.JLabel widthLabel;
    // End of variables declaration//GEN-END:variables

}
