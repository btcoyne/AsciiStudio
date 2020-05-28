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
package asciicomponent;

/**
 * UI for showing progress.
 *
 * @author Ian Martinez
 */
public class ProgressPanel extends javax.swing.JPanel {
    private int lastValue = -1;

    /**
     * Creates new form ProgressPanel
     */
    public ProgressPanel() {
        initComponents();
    }

    public int getProgress() {
        return this.progressBar.getValue();
    }

    public void setProgress(int value, int min, int max) {
        int percent = (int) (value / (double) (max - min)) * 100;
        
        if(percent != lastValue) {
            this.progressBar.setValue(percent);
            this.progressLabel.setText(percent + "%");        
            lastValue = percent;
        }
    }
    
    public void setProgress(int value) {
        this.setProgress(value, 0, 100);
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

        progressLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setLayout(new java.awt.GridBagLayout());

        progressLabel.setText("0%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(progressLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 6);
        add(progressBar, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLabel;
    // End of variables declaration//GEN-END:variables
}
