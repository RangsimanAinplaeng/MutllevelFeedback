package Feedback.View;

import Feedback.Controller.Controller;

import javax.swing.table.DefaultTableModel;
import java.util.Timer;
import java.util.TimerTask;

public class View extends javax.swing.JFrame {

    Timer mytime = new Timer();
    Controller controller = new Controller();
    private int clock;
    //TODO setTimeQuantum
    private int timeQuantumQ1 = 5;
    private int timeQuantumQ2 = 10;
    // Variables declaration - do not modify
    private javax.swing.JButton jButtonAddIO;
    private javax.swing.JButton jButtonAddProcess;
    private javax.swing.JButton jButtonEndIO;
    private javax.swing.JButton jButtonTerminate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAvgTurnaorundTime;
    private javax.swing.JLabel jLabelAvgWaitingTime;
    private javax.swing.JLabel jLabelClock;
    private javax.swing.JLabel jLabelClockTime1;
    private javax.swing.JLabel jLabelQ3;
    private javax.swing.JLabel jLabelRR1;
    private javax.swing.JLabel jLabelRR2;
    private javax.swing.JLabel jLabelTimeQ1;
    private javax.swing.JLabel jLabelTimeQ2;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTurnaroundTime1;
    private javax.swing.JLabel jLabelWaitingTime;
    private javax.swing.JLabel jLabeljobqueue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFCFS;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelRR1;
    private javax.swing.JPanel jPanelRR2;
    private javax.swing.JPanel jPaneljobqueue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableIOCD;
    private javax.swing.JTable jTableTerminate;
    private javax.swing.JTable jTableJobQueue;
    private javax.swing.JTable jTableQueue1;
    private javax.swing.JTable jTableQueue2;
    private javax.swing.JTable jTableQueue3;

    public View() {
        //TODO View
        initComponents();
        clockTime();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // End of variables declaration
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelClock = new javax.swing.JLabel();
        jLabelAvgWaitingTime = new javax.swing.JLabel();
        jLabelAvgTurnaorundTime = new javax.swing.JLabel();
        jButtonAddProcess = new javax.swing.JButton();
        jButtonTerminate = new javax.swing.JButton();
        jLabelWaitingTime = new javax.swing.JLabel();
        jLabelClockTime1 = new javax.swing.JLabel();
        jLabelTurnaroundTime1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableJobQueue = new javax.swing.JTable();
        jPaneljobqueue = new javax.swing.JPanel();
        jLabeljobqueue = new javax.swing.JLabel();
        jPanelRR1 = new javax.swing.JPanel();
        jLabelRR1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTimeQ1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableQueue1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableQueue3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableQueue2 = new javax.swing.JTable();
        jPanelRR2 = new javax.swing.JPanel();
        jLabelRR2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelTimeQ2 = new javax.swing.JLabel();
        jPanelFCFS = new javax.swing.JPanel();
        jLabelQ3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableIOCD = new javax.swing.JTable();
        jButtonEndIO = new javax.swing.JButton();
        jButtonAddIO = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableTerminate = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitle.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Mutilevel Queue Feedback");
        jLabelTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jLabelClock.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelClock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelClock.setText("Clock");

        jLabelAvgWaitingTime.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelAvgWaitingTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAvgWaitingTime.setText("AVG WaitingTime");

        jLabelAvgTurnaorundTime.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelAvgTurnaorundTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAvgTurnaorundTime.setText("AVG TurnaroundTime");

        jButtonAddProcess.setBackground(new java.awt.Color(51, 204, 0));
        jButtonAddProcess.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jButtonAddProcess.setText("AddProcess");
        jButtonAddProcess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProcessActionPerformed(evt);
            }
        });

        jButtonTerminate.setBackground(new java.awt.Color(255, 51, 0));
        jButtonTerminate.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jButtonTerminate.setText("Terminate");
        jButtonTerminate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonTerminate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTerminate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminateActionPerformed(evt);
            }
        });

        jLabelWaitingTime.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelWaitingTime.setText("---");

        jLabelClockTime1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelClockTime1.setText("---");

        jLabelTurnaroundTime1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelTurnaroundTime1.setText("---");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jButtonTerminate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButtonAddProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabelAvgWaitingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabelTurnaroundTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabelWaitingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabelClock).addGap(35, 35, 35).addComponent(jLabelClockTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addComponent(jLabelAvgTurnaorundTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(0, 65, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jButtonAddProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButtonTerminate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelClock).addComponent(jLabelClockTime1)).addGap(18, 18, 18).addComponent(jLabelAvgTurnaorundTime).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabelTurnaroundTime1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE).addComponent(jLabelAvgWaitingTime).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelWaitingTime).addGap(32, 32, 32)));

        jTableJobQueue.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTableJobQueue.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}}, new String[]{"ProcessID", "BurstTime", "ArrvalTime", "WaitingTime", "Status", "I/O Time", "QueueID"}));
        jScrollPane2.setViewportView(jTableJobQueue);

        jPaneljobqueue.setBackground(new java.awt.Color(255, 204, 0));

        jLabeljobqueue.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabeljobqueue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeljobqueue.setText("Job Queue");

        javax.swing.GroupLayout jPaneljobqueueLayout = new javax.swing.GroupLayout(jPaneljobqueue);
        jPaneljobqueue.setLayout(jPaneljobqueueLayout);
        jPaneljobqueueLayout.setHorizontalGroup(jPaneljobqueueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPaneljobqueueLayout.createSequentialGroup().addGap(365, 365, 365).addComponent(jLabeljobqueue, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPaneljobqueueLayout.setVerticalGroup(jPaneljobqueueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPaneljobqueueLayout.createSequentialGroup().addContainerGap().addComponent(jLabeljobqueue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanelRR1.setBackground(new java.awt.Color(255, 204, 0));

        jLabelRR1.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabelRR1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRR1.setText("Q1");

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Quantum Time =");

        jLabelTimeQ1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelTimeQ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeQ1.setText("---");

        javax.swing.GroupLayout jPanelRR1Layout = new javax.swing.GroupLayout(jPanelRR1);
        jPanelRR1.setLayout(jPanelRR1Layout);
        jPanelRR1Layout.setHorizontalGroup(jPanelRR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelRR1Layout.createSequentialGroup().addContainerGap().addComponent(jLabelRR1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelTimeQ1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE).addContainerGap()));
        jPanelRR1Layout.setVerticalGroup(jPanelRR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelRR1Layout.createSequentialGroup().addContainerGap(9, Short.MAX_VALUE).addGroup(jPanelRR1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelRR1).addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabelTimeQ1))));

        jTableQueue1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTableQueue1.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null}, {null, null}, {null, null}, {null, null}}, new String[]{"ProcessID", "Status"}));
        jScrollPane4.setViewportView(jTableQueue1);

        jTableQueue3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTableQueue3.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null}, {null, null}, {null, null}, {null, null}}, new String[]{"ProcessID", "Status"}));
        jScrollPane6.setViewportView(jTableQueue3);

        jTableQueue2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTableQueue2.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null}, {null, null}, {null, null}, {null, null}}, new String[]{"ProcessID", "Status"}));
        jScrollPane7.setViewportView(jTableQueue2);

        jPanelRR2.setBackground(new java.awt.Color(255, 204, 0));

        jLabelRR2.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabelRR2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRR2.setText("Q2");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Quantum Time = ");

        jLabelTimeQ2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelTimeQ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTimeQ2.setText("---");

        javax.swing.GroupLayout jPanelRR2Layout = new javax.swing.GroupLayout(jPanelRR2);
        jPanelRR2.setLayout(jPanelRR2Layout);
        jPanelRR2Layout.setHorizontalGroup(jPanelRR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelRR2Layout.createSequentialGroup().addContainerGap().addComponent(jLabelRR2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabelTimeQ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        jPanelRR2Layout.setVerticalGroup(jPanelRR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelRR2Layout.createSequentialGroup().addContainerGap(9, Short.MAX_VALUE).addGroup(jPanelRR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelRR2).addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabelTimeQ2))));

        jPanelFCFS.setBackground(new java.awt.Color(255, 204, 0));

        jLabelQ3.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabelQ3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQ3.setText("Q3  FCFS");

        javax.swing.GroupLayout jPanelFCFSLayout = new javax.swing.GroupLayout(jPanelFCFS);
        jPanelFCFS.setLayout(jPanelFCFSLayout);
        jPanelFCFSLayout.setHorizontalGroup(jPanelFCFSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelFCFSLayout.createSequentialGroup().addContainerGap().addComponent(jLabelQ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        jPanelFCFSLayout.setVerticalGroup(jPanelFCFSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFCFSLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabelQ3)));

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        jTable1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}}, new String[]{"ProcessID", "Status", "QueueID"}));
        jScrollPane3.setViewportView(jTable1);

        jTableIOCD.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTableIOCD.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"ProcessID", "Satus", "I/O Time", "WaitingTime"}));
        jScrollPane5.setViewportView(jTableIOCD);

        jButtonEndIO.setBackground(new java.awt.Color(255, 51, 0));
        jButtonEndIO.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jButtonEndIO.setText("END I/O");
        jButtonEndIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEndIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndIOActionPerformed(evt);
            }
        });

        jButtonAddIO.setBackground(new java.awt.Color(0, 255, 204));
        jButtonAddIO.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jButtonAddIO.setText("ADD CD I/O");
        jButtonAddIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddIOActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CPU");

        jTableTerminate.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jTableTerminate.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"ProcessID", "Satus", "TrunaroundTime", "WaitingTime"}));
        jScrollPane8.setViewportView(jTableTerminate);

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Terminate");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(106, 106, 106)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jButtonAddIO).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButtonEndIO, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))).addContainerGap()))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(jLabel4)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButtonEndIO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButtonAddIO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(26, 26, 26)));

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelMainLayout.createSequentialGroup().addContainerGap().addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelMainLayout.createSequentialGroup().addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(jPanelMainLayout.createSequentialGroup().addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPaneljobqueue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jScrollPane2))).addGroup(jPanelMainLayout.createSequentialGroup().addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanelRR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPanelRR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE).addComponent(jPanelFCFS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jLabelTitle)).addContainerGap(16, Short.MAX_VALUE)));
        jPanelMainLayout.setVerticalGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelMainLayout.createSequentialGroup().addContainerGap().addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanelMainLayout.createSequentialGroup().addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanelMainLayout.createSequentialGroup().addComponent(jPaneljobqueue, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPanelRR1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanelRR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanelFCFS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jScrollPane1.setViewportView(jPanelMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1690, Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE).addContainerGap()));

        pack();
    }// </editor-fold>

    private void jButtonAddProcessActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        controller.addProcess(clock, timeQuantumQ1, timeQuantumQ2);
        showJob(controller.showJobQueue());
    }

    private void jButtonTerminateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        controller.removeQueue(clock);
    }

    private void jButtonEndIOActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonAddIOActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    //TODO run
    public void clockTime() {
        TimerTask task = new TimerTask() {
            public void run() {
                //TODO run
                //ตัวแปร count ในส่วนนี้ คือส่วนที่จะไปแสดง บนหน้า View ที่เราเห็นกันคือ นับเวลา Clock หรือ CPU Time
                clock++;
                jLabelClockTime1.setText(Integer.toString(clock));
                jLabelTimeQ1.setText(Integer.toString(timeQuantumQ1));
                jLabelTimeQ2.setText(Integer.toString(timeQuantumQ2));
                controller.running();
                controller.waitingTime();

                showJob(controller.showJobQueue());
                showQueue1(controller.showQueue1());
                showQueue2(controller.showQueue2());
                showQueue3(controller.showQueue3());
                showTerminateQueue(controller.showTerminateQueue());
            }
        };
        mytime.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void showJob(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableJobQueue.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2], textTable1[3], textTable1[4], textTable1[5], textTable1[6]});
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }
    public void showQueue1(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableQueue1.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1]});
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }
    public void showQueue2(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableQueue2.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1]});
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }
    public void showQueue3(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableQueue3.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1]});
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }
    public void showTerminateQueue(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableTerminate.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1],textTable1[2], textTable1[3]});
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }


}