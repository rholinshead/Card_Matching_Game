/*
 Programmer: Ryan Holinshead
 Date: November 3, 2012
 Program Name: NHL Matching Game
 Program Description: This program uses arrays to simulate a matching game.
 * A grid of cards will be displayed and the user is to select 2 cards at a time
 * looking for matching cards. The goal of this game is to see how quickly
 * the user can find all the matches.
 */

package matchinggame;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.util.*;
import javax.swing.ImageIcon;




/**
 * The application's main frame.
 */
public class MatchingGameView extends FrameView {
    /* creates arraylists to store string type value*/
ArrayList <String> cards = new ArrayList ();
ArrayList <String> set = new ArrayList ();
/* Sets variables to hold necessary images*/
ImageIcon a = new ImageIcon("bostonbruins.jpg");
ImageIcon b = new ImageIcon("calgaryflames.jpg");
ImageIcon c = new ImageIcon("coloradoavalanche.jpg");
ImageIcon d = new ImageIcon("dallasstars.jpg");
ImageIcon e = new ImageIcon("minnesotawild.jpg");
ImageIcon f = new ImageIcon("montrealcanadiens.jpg");
ImageIcon g = new ImageIcon("pittsburghpenguins.jpg");
ImageIcon h = new ImageIcon("torontomapleleafs.jpg");
ImageIcon i = new ImageIcon("vancouvercanucks.jpg");
ImageIcon j = new ImageIcon("winnipegjets.jpg");
ImageIcon back = new ImageIcon("NHLcardback.jpg");
ImageIcon done = new ImageIcon("welldone.jpg");
/* declares integer variable types*/
int count, c1, c2, card1, card2;

int[] change = new int [20];
//  declares array of 20 integers named change

int cardsLeft = 20;
// variable cardsLeft is integer type, initialized to store 20

    public MatchingGameView(SingleFrameApplication app)  {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = MatchingGameApp.getApplication().getMainFrame();
            aboutBox = new MatchingGameAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        MatchingGameApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Card1 = new javax.swing.JButton();
        Card2 = new javax.swing.JButton();
        Card3 = new javax.swing.JButton();
        Card4 = new javax.swing.JButton();
        Card5 = new javax.swing.JButton();
        Card6 = new javax.swing.JButton();
        Card7 = new javax.swing.JButton();
        Card8 = new javax.swing.JButton();
        Card9 = new javax.swing.JButton();
        Card10 = new javax.swing.JButton();
        Card11 = new javax.swing.JButton();
        Card12 = new javax.swing.JButton();
        Card13 = new javax.swing.JButton();
        Card14 = new javax.swing.JButton();
        Card15 = new javax.swing.JButton();
        Card16 = new javax.swing.JButton();
        play = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        guessAgain = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        Card17 = new javax.swing.JButton();
        Card18 = new javax.swing.JButton();
        Card19 = new javax.swing.JButton();
        Card20 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(matchinggame.MatchingGameApp.class).getContext().getResourceMap(MatchingGameView.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        Card1.setIcon(resourceMap.getIcon("Card1.icon")); // NOI18N
        Card1.setText(resourceMap.getString("Card1.text")); // NOI18N
        Card1.setName("Card1"); // NOI18N
        Card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card1MouseClicked(evt);
            }
        });

        Card2.setIcon(resourceMap.getIcon("Card2.icon")); // NOI18N
        Card2.setText(resourceMap.getString("Card2.text")); // NOI18N
        Card2.setName("Card2"); // NOI18N
        Card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card2MouseClicked(evt);
            }
        });

        Card3.setIcon(resourceMap.getIcon("Card3.icon")); // NOI18N
        Card3.setText(resourceMap.getString("Card3.text")); // NOI18N
        Card3.setName("Card3"); // NOI18N
        Card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card3MouseClicked(evt);
            }
        });

        Card4.setIcon(resourceMap.getIcon("Card4.icon")); // NOI18N
        Card4.setText(resourceMap.getString("Card4.text")); // NOI18N
        Card4.setName("Card4"); // NOI18N
        Card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card4MouseClicked(evt);
            }
        });

        Card5.setIcon(resourceMap.getIcon("Card5.icon")); // NOI18N
        Card5.setText(resourceMap.getString("Card5.text")); // NOI18N
        Card5.setName("Card5"); // NOI18N
        Card5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card5MouseClicked(evt);
            }
        });

        Card6.setIcon(resourceMap.getIcon("Card6.icon")); // NOI18N
        Card6.setText(resourceMap.getString("Card6.text")); // NOI18N
        Card6.setName("Card6"); // NOI18N
        Card6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card6MouseClicked(evt);
            }
        });

        Card7.setIcon(resourceMap.getIcon("Card7.icon")); // NOI18N
        Card7.setText(resourceMap.getString("Card7.text")); // NOI18N
        Card7.setName("Card7"); // NOI18N
        Card7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card7MouseClicked(evt);
            }
        });

        Card8.setIcon(resourceMap.getIcon("Card8.icon")); // NOI18N
        Card8.setText(resourceMap.getString("Card8.text")); // NOI18N
        Card8.setName("Card8"); // NOI18N
        Card8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card8MouseClicked(evt);
            }
        });

        Card9.setIcon(resourceMap.getIcon("Card9.icon")); // NOI18N
        Card9.setText(resourceMap.getString("Card9.text")); // NOI18N
        Card9.setName("Card9"); // NOI18N
        Card9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card9MouseClicked(evt);
            }
        });

        Card10.setIcon(resourceMap.getIcon("Card10.icon")); // NOI18N
        Card10.setText(resourceMap.getString("Card10.text")); // NOI18N
        Card10.setName("Card10"); // NOI18N
        Card10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card10MouseClicked(evt);
            }
        });

        Card11.setIcon(resourceMap.getIcon("Card11.icon")); // NOI18N
        Card11.setText(resourceMap.getString("Card11.text")); // NOI18N
        Card11.setName("Card11"); // NOI18N
        Card11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card11MouseClicked(evt);
            }
        });

        Card12.setIcon(resourceMap.getIcon("Card12.icon")); // NOI18N
        Card12.setText(resourceMap.getString("Card12.text")); // NOI18N
        Card12.setName("Card12"); // NOI18N
        Card12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card12MouseClicked(evt);
            }
        });

        Card13.setIcon(resourceMap.getIcon("Card13.icon")); // NOI18N
        Card13.setText(resourceMap.getString("Card13.text")); // NOI18N
        Card13.setName("Card13"); // NOI18N
        Card13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card13MouseClicked(evt);
            }
        });

        Card14.setIcon(resourceMap.getIcon("Card14.icon")); // NOI18N
        Card14.setText(resourceMap.getString("Card14.text")); // NOI18N
        Card14.setName("Card14"); // NOI18N
        Card14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card14MouseClicked(evt);
            }
        });

        Card15.setIcon(resourceMap.getIcon("Card15.icon")); // NOI18N
        Card15.setText(resourceMap.getString("Card15.text")); // NOI18N
        Card15.setName("Card15"); // NOI18N
        Card15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card15MouseClicked(evt);
            }
        });

        Card16.setIcon(resourceMap.getIcon("Card16.icon")); // NOI18N
        Card16.setText(resourceMap.getString("Card16.text")); // NOI18N
        Card16.setName("Card16"); // NOI18N
        Card16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card16MouseClicked(evt);
            }
        });

        play.setText(resourceMap.getString("play.text")); // NOI18N
        play.setName("play"); // NOI18N
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        Exit.setText(resourceMap.getString("Exit.text")); // NOI18N
        Exit.setName("Exit"); // NOI18N
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        guessAgain.setText(resourceMap.getString("guessAgain.text")); // NOI18N
        guessAgain.setName("guessAgain"); // NOI18N
        guessAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessAgainActionPerformed(evt);
            }
        });

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        Card17.setIcon(resourceMap.getIcon("Card17.icon")); // NOI18N
        Card17.setName("Card17"); // NOI18N
        Card17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card17MouseClicked(evt);
            }
        });

        Card18.setIcon(resourceMap.getIcon("Card18.icon")); // NOI18N
        Card18.setName("Card18"); // NOI18N
        Card18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card18MouseClicked(evt);
            }
        });

        Card19.setIcon(resourceMap.getIcon("Card19.icon")); // NOI18N
        Card19.setName("Card19"); // NOI18N
        Card19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card19MouseClicked(evt);
            }
        });

        Card20.setIcon(resourceMap.getIcon("Card20.icon")); // NOI18N
        Card20.setName("Card20"); // NOI18N
        Card20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Card20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Card1)
                                .addGap(18, 18, 18)
                                .addComponent(Card2))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Card6)
                                .addGap(18, 18, 18)
                                .addComponent(Card7))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Card11)
                                .addGap(18, 18, 18)
                                .addComponent(Card12)))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Card8)
                                .addGap(18, 18, 18)
                                .addComponent(Card9)
                                .addGap(18, 18, 18)
                                .addComponent(Card10))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Card13)
                                .addGap(18, 18, 18)
                                .addComponent(Card14, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Card15)
                                .addGap(92, 92, 92))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Card3)
                                .addGap(18, 18, 18)
                                .addComponent(Card4)
                                .addGap(18, 18, 18)
                                .addComponent(Card5))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(play)
                                .addGap(49, 49, 49)
                                .addComponent(guessAgain))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Card16)
                                .addGap(18, 18, 18)
                                .addComponent(Card17)))
                        .addGap(18, 18, 18)
                        .addComponent(Card18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(Exit))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Card19)
                                .addGap(18, 18, 18)
                                .addComponent(Card20))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1)))
                .addGap(144, 144, 144))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Card2)
                    .addComponent(Card1)
                    .addComponent(Card3)
                    .addComponent(Card4)
                    .addComponent(Card5))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Card6)
                    .addComponent(Card7)
                    .addComponent(Card8)
                    .addComponent(Card9)
                    .addComponent(Card10))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Card11)
                    .addComponent(Card12)
                    .addComponent(Card13)
                    .addComponent(Card14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Card15))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Card16)
                            .addComponent(Card17)
                            .addComponent(Card19)
                            .addComponent(Card20))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guessAgain)
                            .addComponent(play)
                            .addComponent(Exit)))
                    .addComponent(Card18))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(matchinggame.MatchingGameApp.class).getContext().getActionMap(MatchingGameView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 813, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents



    /* if exitButton is pressed, program is exited*/
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

  
/* if play button is pressed, the following actions occur*/
    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed

        /** Set change array */
        for (int z=0; z<=19; z++) {
            // for loop counts from 0 to 19 intervals with z increasing by one each time
            change[z] = 1;
        }

        /** Assign cards at random */
        String temp;
        // temp declared as String variable type
        for (int x=0; x<=9;x++){
            // for loop counting up by 1 from 0 as long as x is less than 9
            for (int y=1; y<=2;y++){
            temp = Integer.toString(x);
            // temp stores string value of integer stored in x
            set.add(temp);
            // adds temp to the arraylist set
            }
        }
        for (int x=0; x<=19; x++) {
            // for loop counting up by 1 from 0 as long as x is less than 19
            double index = Math.floor(Math.random()*(20-x));
            // index variable is double type, stores lowest integer value of the product of a random number and 20-x
            int index1 = (int) index;
            // index1 is integer type, stores integer value of index
            cards.add(set.get(index1));

            set.remove(set.get(index1));
        }

        
    }//GEN-LAST:event_playActionPerformed

    private void Card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card1MouseClicked
        
        String temp = cards.get(0);
// checks to see what random picture is placed in the box

        /* if structure checks card and assigns proper picture*/
        if (temp.equals ("0")) {
            Card1.setIcon(a);
            // changes button icon to picture stored in a
        } else if (temp.equals ("1")) {
            Card1.setIcon(b);
            // changes button icon to picture stored in b
        } else if (temp.equals ("2")) {
            Card1.setIcon(c);
            // changes button icon to picture stored in c
        } else if (temp.equals ("3")) {
            Card1.setIcon(d);
            // changes button icon to picture stored in d
        } else if (temp.equals ("4")) {
            Card1.setIcon(e);
            // changes button icon to picture stored in e
        } else if (temp.equals ("5")) {
            Card1.setIcon(f);
            // changes button icon to picture stored in f
        } else if (temp.equals ("6")) {
            Card1.setIcon(g);
            // changes button icon to picture stored in g
        } else if (temp.equals ("7")) {
            Card1.setIcon(h);
            // changes button icon to picture stored in h
        } else if (temp.equals ("8")) {
            Card1.setIcon(i);
            // changes button icon to picture stored in i
        } else if (temp.equals ("9")) {
            Card1.setIcon(j);
            // changes button icon to picture stored in j
        }
        count++;
        /* card chosen is set to 1 or 2 so it can be checked for a match*/

        /* if structure sets the appropriate card chosen, and then sets the change array to show the card icon has been changed*/
        if (count==1){
            c1=Integer.parseInt(temp);
            change[0]=0;
        } else if (count==2){
            c2=Integer.parseInt(temp);
            change[0]=0;
        }
            
    }//GEN-LAST:event_Card1MouseClicked

    private void Card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card2MouseClicked
       // refer to Card1MouseClicked for explanation of code

        String temp = cards.get(1);


        if (temp.equals ("0")) {
            Card2.setIcon(a);
        } else if (temp.equals ("1")) {
            Card2.setIcon(b);
        } else if (temp.equals ("2")) {
            Card2.setIcon(c);
        } else if (temp.equals ("3")) {
            Card2.setIcon(d);
        } else if (temp.equals ("4")) {
            Card2.setIcon(e);
        } else if (temp.equals ("5")) {
            Card2.setIcon(f);
        } else if (temp.equals ("6")) {
            Card2.setIcon(g);
        } else if (temp.equals ("7")) {
            Card2.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card2.setIcon(i);
        } else if (temp.equals ("9")) {
            Card2.setIcon(j);
        }


        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[1]=0;
        } else if (count==2){
            c2=Integer.parseInt(temp);
            change[1]=0;
        } 


    }//GEN-LAST:event_Card2MouseClicked

    private void Card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card3MouseClicked
       // refer to Card1MouseClicked for explanation of code
        String temp = cards.get(2);

        if (temp.equals ("0")) {
            Card3.setIcon(a);
        } else if (temp.equals ("1")) {
            Card3.setIcon(b);
        } else if (temp.equals ("2")) {
            Card3.setIcon(c);
        } else if (temp.equals ("3")) {
            Card3.setIcon(d);
        } else if (temp.equals ("4")) {
            Card3.setIcon(e);
        } else if (temp.equals ("5")) {
            Card3.setIcon(f);
        } else if (temp.equals ("6")) {
            Card3.setIcon(g);
        } else if (temp.equals ("7")) {
            Card3.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card3.setIcon(i);
        } else if (temp.equals ("9")) {
            Card3.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[2]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[2]=0;
        }

    }//GEN-LAST:event_Card3MouseClicked

    private void Card4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card4MouseClicked
         // refer to Card1MouseClicked for explanation of code
        String temp = cards.get(3);

        if (temp.equals ("0")) {
            Card4.setIcon(a);
        } else if (temp.equals ("1")) {
            Card4.setIcon(b);
        } else if (temp.equals ("2")) {
            Card4.setIcon(c);
        } else if (temp.equals ("3")) {
            Card4.setIcon(d);
        } else if (temp.equals ("4")) {
            Card4.setIcon(e);
        } else if (temp.equals ("5")) {
            Card4.setIcon(f);
        } else if (temp.equals ("6")) {
            Card4.setIcon(g);
        } else if (temp.equals ("7")) {
            Card4.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card4.setIcon(i);
        } else if (temp.equals ("9")) {
            Card4.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[3]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[3]=0;
        }

    }//GEN-LAST:event_Card4MouseClicked

    private void Card5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card5MouseClicked
         // refer to Card1MouseClicked for explanation of code
        String temp = cards.get(4);

        if (temp.equals ("0")) {
            Card5.setIcon(a);
        } else if (temp.equals ("1")) {
            Card5.setIcon(b);
        } else if (temp.equals ("2")) {
            Card5.setIcon(c);
        } else if (temp.equals ("3")) {
            Card5.setIcon(d);
        } else if (temp.equals ("4")) {
            Card5.setIcon(e);
        } else if (temp.equals ("5")) {
            Card5.setIcon(f);
        } else if (temp.equals ("6")) {
            Card5.setIcon(g);
        } else if (temp.equals ("7")) {
            Card5.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card5.setIcon(i);
        } else if (temp.equals ("9")) {
            Card5.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[4]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[4]=0;
        }

    }//GEN-LAST:event_Card5MouseClicked

    private void Card6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card6MouseClicked
         // refer to Card1MouseClicked for explanation of code
        String temp = cards.get(5);

        if (temp.equals ("0")) {
            Card6.setIcon(a);
        } else if (temp.equals ("1")) {
            Card6.setIcon(b);
        } else if (temp.equals ("2")) {
            Card6.setIcon(c);
        } else if (temp.equals ("3")) {
            Card6.setIcon(d);
        } else if (temp.equals ("4")) {
            Card6.setIcon(e);
        } else if (temp.equals ("5")) {
            Card6.setIcon(f);
        } else if (temp.equals ("6")) {
            Card6.setIcon(g);
        } else if (temp.equals ("7")) {
            Card6.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card6.setIcon(i);
        } else if (temp.equals ("9")) {
            Card6.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[5]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[5]=0;
        }

    }//GEN-LAST:event_Card6MouseClicked

    private void Card7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card7MouseClicked
        String temp = cards.get(6);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card7.setIcon(a);
        } else if (temp.equals ("1")) {
            Card7.setIcon(b);
        } else if (temp.equals ("2")) {
            Card7.setIcon(c);
        } else if (temp.equals ("3")) {
            Card7.setIcon(d);
        } else if (temp.equals ("4")) {
            Card7.setIcon(e);
        } else if (temp.equals ("5")) {
            Card7.setIcon(f);
        } else if (temp.equals ("6")) {
            Card7.setIcon(g);
        } else if (temp.equals ("7")) {
            Card7.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card7.setIcon(i);
        } else if (temp.equals ("9")) {
            Card7.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[6]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[6]=0;
        }

    }//GEN-LAST:event_Card7MouseClicked

    private void Card8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card8MouseClicked
        String temp = cards.get(7);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card8.setIcon(a);
        } else if (temp.equals ("1")) {
            Card8.setIcon(b);
        } else if (temp.equals ("2")) {
            Card8.setIcon(c);
        } else if (temp.equals ("3")) {
            Card8.setIcon(d);
        } else if (temp.equals ("4")) {
            Card8.setIcon(e);
        } else if (temp.equals ("5")) {
            Card8.setIcon(f);
        } else if (temp.equals ("6")) {
            Card8.setIcon(g);
        } else if (temp.equals ("7")) {
            Card8.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card8.setIcon(i);
        } else if (temp.equals ("9")) {
            Card8.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[7]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[7]=0;
        }

    }//GEN-LAST:event_Card8MouseClicked

    private void Card9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card9MouseClicked
        String temp = cards.get(8);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card9.setIcon(a);
        } else if (temp.equals ("1")) {
            Card9.setIcon(b);
        } else if (temp.equals ("2")) {
            Card9.setIcon(c);
        } else if (temp.equals ("3")) {
            Card9.setIcon(d);
        } else if (temp.equals ("4")) {
            Card9.setIcon(e);
        } else if (temp.equals ("5")) {
            Card9.setIcon(f);
        } else if (temp.equals ("6")) {
            Card9.setIcon(g);
        } else if (temp.equals ("7")) {
            Card9.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card9.setIcon(i);
        } else if (temp.equals ("9")) {
            Card9.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[8]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[8]=0;
        }

    }//GEN-LAST:event_Card9MouseClicked

    private void Card10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card10MouseClicked
        String temp = cards.get(9);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card10.setIcon(a);
        } else if (temp.equals ("1")) {
            Card10.setIcon(b);
        } else if (temp.equals ("2")) {
            Card10.setIcon(c);
        } else if (temp.equals ("3")) {
            Card10.setIcon(d);
        } else if (temp.equals ("4")) {
            Card10.setIcon(e);
        } else if (temp.equals ("5")) {
            Card10.setIcon(f);
        } else if (temp.equals ("6")) {
            Card10.setIcon(g);
        } else if (temp.equals ("7")) {
            Card10.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card10.setIcon(i);
        } else if (temp.equals ("9")) {
            Card10.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[9]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[9]=0;
        }

    }//GEN-LAST:event_Card10MouseClicked

    private void Card11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card11MouseClicked
        String temp = cards.get(10);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card11.setIcon(a);
        } else if (temp.equals ("1")) {
            Card11.setIcon(b);
        } else if (temp.equals ("2")) {
            Card11.setIcon(c);
        } else if (temp.equals ("3")) {
            Card11.setIcon(d);
        } else if (temp.equals ("4")) {
            Card11.setIcon(e);
        } else if (temp.equals ("5")) {
            Card11.setIcon(f);
        } else if (temp.equals ("6")) {
            Card11.setIcon(g);
        } else if (temp.equals ("7")) {
            Card11.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card11.setIcon(i);
        } else if (temp.equals ("9")) {
            Card11.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[10]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[10]=0;
        }


    }//GEN-LAST:event_Card11MouseClicked

    private void Card12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card12MouseClicked
        String temp = cards.get(11);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card12.setIcon(a);
        } else if (temp.equals ("1")) {
            Card12.setIcon(b);
        } else if (temp.equals ("2")) {
            Card12.setIcon(c);
        } else if (temp.equals ("3")) {
            Card12.setIcon(d);
        } else if (temp.equals ("4")) {
            Card12.setIcon(e);
        } else if (temp.equals ("5")) {
            Card12.setIcon(f);
        } else if (temp.equals ("6")) {
            Card12.setIcon(g);
        } else if (temp.equals ("7")) {
            Card12.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card12.setIcon(i);
        } else if (temp.equals ("9")) {
            Card12.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[11]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[11]=0;
        }

    }//GEN-LAST:event_Card12MouseClicked

    private void Card13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card13MouseClicked
        String temp = cards.get(12);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card13.setIcon(a);
        } else if (temp.equals ("1")) {
            Card13.setIcon(b);
        } else if (temp.equals ("2")) {
            Card13.setIcon(c);
        } else if (temp.equals ("3")) {
            Card13.setIcon(d);
        } else if (temp.equals ("4")) {
            Card13.setIcon(e);
        } else if (temp.equals ("5")) {
            Card13.setIcon(f);
        } else if (temp.equals ("6")) {
            Card13.setIcon(g);
        } else if (temp.equals ("7")) {
            Card13.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card13.setIcon(i);
        } else if (temp.equals ("9")) {
            Card13.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[12]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[12]=0;
        }

    }//GEN-LAST:event_Card13MouseClicked

    private void Card14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card14MouseClicked
        String temp = cards.get(13);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card14.setIcon(a);
        } else if (temp.equals ("1")) {
            Card14.setIcon(b);
        } else if (temp.equals ("2")) {
            Card14.setIcon(c);
        } else if (temp.equals ("3")) {
            Card14.setIcon(d);
        } else if (temp.equals ("4")) {
            Card14.setIcon(e);
        } else if (temp.equals ("5")) {
            Card14.setIcon(f);
        } else if (temp.equals ("6")) {
            Card14.setIcon(g);
        } else if (temp.equals ("7")) {
            Card14.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card14.setIcon(i);
        } else if (temp.equals ("9")) {
            Card14.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[13]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[13]=0;
        }

    }//GEN-LAST:event_Card14MouseClicked

    private void Card15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card15MouseClicked
        String temp = cards.get(14);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card15.setIcon(a);
        } else if (temp.equals ("1")) {
            Card15.setIcon(b);
        } else if (temp.equals ("2")) {
            Card15.setIcon(c);
        } else if (temp.equals ("3")) {
            Card15.setIcon(d);
        } else if (temp.equals ("4")) {
            Card15.setIcon(e);
        } else if (temp.equals ("5")) {
            Card15.setIcon(f);
        } else if (temp.equals ("6")) {
            Card15.setIcon(g);
        } else if (temp.equals ("7")) {
            Card15.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card15.setIcon(i);
        } else if (temp.equals ("9")) {
            Card15.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[14]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[14]=0;
        }

    }//GEN-LAST:event_Card15MouseClicked

    private void Card16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card16MouseClicked
        String temp = cards.get(15);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card16.setIcon(a);
        } else if (temp.equals ("1")) {
            Card16.setIcon(b);
        } else if (temp.equals ("2")) {
            Card16.setIcon(c);
        } else if (temp.equals ("3")) {
            Card16.setIcon(d);
        } else if (temp.equals ("4")) {
            Card16.setIcon(e);
        } else if (temp.equals ("5")) {
            Card16.setIcon(f);
        } else if (temp.equals ("6")) {
            Card16.setIcon(g);
        } else if (temp.equals ("7")) {
            Card16.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card16.setIcon(i);
        } else if (temp.equals ("9")) {
            Card16.setIcon(j);
        }
        
        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[15]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[15]=0;
        }

    }//GEN-LAST:event_Card16MouseClicked


    private void guessAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessAgainActionPerformed
        count = 0;
        if (c1==c2){
            //checks to see if the same card has been chosen, then changes the buttons to the done icon.
            for (int y=1; y<=2; y++) {
            if (change[0]==0){
                Card1.setIcon(done);
                Card1.setEnabled(false);
                change[0]=2;
                cardsLeft --;
            } else if (change[1]==0) {
                Card2.setIcon(done);
                change[1]=2;
                cardsLeft --;
            } else if (change[2]==0) {
                Card3.setIcon(done);
                change[2]=2;
                cardsLeft --;
            } else if (change[3]==0) {
                Card4.setIcon(done);
                change[3]=2;
                cardsLeft --;
            } else if (change[4]==0) {
                Card5.setIcon(done);
                change[4]=2;
                cardsLeft --;
            } else if (change[5]==0) {
                Card6.setIcon(done);
                change[5]=2;
                cardsLeft --;
            } else if (change[6]==0) {
                Card7.setIcon(done);
                change[6]=2;
                cardsLeft --;
            } else if (change[7]==0) {
                Card8.setIcon(done);
                change[7]=2;
                cardsLeft --;
            } else if (change[8]==0) {
                Card9.setIcon(done);
                change[8]=2;
                cardsLeft --;
            } else if (change[9]==0) {
                Card10.setIcon(done);
                change[9]=2;
                cardsLeft --;
            } else if (change[10]==0) {
                Card11.setIcon(done);
                change[10]=2;
                cardsLeft --;
            } else if (change[11]==0) {
                Card12.setIcon(done);
                change[11]=2;
                cardsLeft --;
            } else if (change[12]==0) {
                Card13.setIcon(done);
                change[12]=2;
                cardsLeft --;
            } else if (change[13]==0) {
                Card14.setIcon(done);
                change[13]=2;
                cardsLeft --;
            } else if (change[14]==0) {
                Card15.setIcon(done);
                change[14]=2;
                cardsLeft --;
            } else if (change[15]==0) {
                Card16.setIcon(done);
                change[15]=2;
                cardsLeft --;
            } else if (change[16]==0){
                Card17.setIcon(done);
                cardsLeft --;
            } else if (change[17]==0){
                Card18.setIcon(done);
                cardsLeft --;
            } else if (change[18]==0){
                Card19.setIcon(done);
                cardsLeft --;
            } else if (change[19]==0){
                Card20.setIcon(done);
                cardsLeft --;
            }
            }
     } else {
            /* if c1 and c2 are not equal, the buttons change back to the card icon*/
            for (int y=1; y<=2; y++){
            if (change[0]==0){
                Card1.setIcon(back);
                change[0]=1;
            } else if (change[1]==0) {
                Card2.setIcon(back);
                change[1]=1;
            } else if (change[2]==0) {
                Card3.setIcon(back);
                change[2]=1;
            } else if (change[3]==0) {
                Card4.setIcon(back);
                change[3]=1;
            } else if (change[4]==0) {
                Card5.setIcon(back);
                change[4]=1;
            } else if (change[5]==0) {
                Card6.setIcon(back);
                change[5]=1;
            } else if (change[6]==0) {
                Card7.setIcon(back);
                change[6]=1;
            } else if (change[7]==0) {
                Card8.setIcon(back);
                change[7]=1;
            } else if (change[8]==0) {
                Card9.setIcon(back);
                change[8]=1;
            } else if (change[9]==0) {
                Card10.setIcon(back);
                change[9]=1;
            } else if (change[10]==0) {
                Card11.setIcon(back);
                change[10]=1;
            } else if (change[11]==0) {
                Card12.setIcon(back);
                change[11]=1;
            } else if (change[12]==0) {
                Card13.setIcon(back);
                change[12]=1;
            } else if (change[13]==0) {
                Card14.setIcon(back);
                change[13]=1;
            } else if (change[14]==0) {
                Card15.setIcon(back);
                change[14]=1;
            } else if (change[15]==0) {
                Card16.setIcon(back);
                change[15]=1;
            } else if (change[16]==0) {
                Card17.setIcon(back);
                change[16]=1;
            } else if (change[17]==0) {
                Card18.setIcon(back);
                change[17]=1;
            }else if (change[18]==0) {
                Card19.setIcon(back);
                change[18]=1;
     }else if (change[19]==0) {
                Card20.setIcon(back);
                change[19]=1;
            }
            }
        }
        if (cardsLeft ==0) {
            jTextField1.setText("Congratulations. You have found all the matches.");
        }

    }//GEN-LAST:event_guessAgainActionPerformed

    private void Card17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card17MouseClicked
         String temp = cards.get(16);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card17.setIcon(a);
        } else if (temp.equals ("1")) {
            Card17.setIcon(b);
        } else if (temp.equals ("2")) {
            Card17.setIcon(c);
        } else if (temp.equals ("3")) {
            Card17.setIcon(d);
        } else if (temp.equals ("4")) {
            Card17.setIcon(e);
        } else if (temp.equals ("5")) {
            Card17.setIcon(f);
        } else if (temp.equals ("6")) {
            Card17.setIcon(g);
        } else if (temp.equals ("7")) {
            Card17.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card17.setIcon(i);
        } else if (temp.equals ("9")) {
            Card17.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[16]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[16]=0;
        }
    }//GEN-LAST:event_Card17MouseClicked

    private void Card18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card18MouseClicked
        String temp = cards.get(17);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card18.setIcon(a);
        } else if (temp.equals ("1")) {
            Card18.setIcon(b);
        } else if (temp.equals ("2")) {
            Card18.setIcon(c);
        } else if (temp.equals ("3")) {
            Card18.setIcon(d);
        } else if (temp.equals ("4")) {
            Card18.setIcon(e);
        } else if (temp.equals ("5")) {
            Card18.setIcon(f);
        } else if (temp.equals ("6")) {
            Card18.setIcon(g);
        } else if (temp.equals ("7")) {
            Card18.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card18.setIcon(i);
        } else if (temp.equals ("9")) {
            Card18.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[17]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[17]=0;
        }
    }//GEN-LAST:event_Card18MouseClicked

    private void Card19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card19MouseClicked
         String temp = cards.get(18);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card19.setIcon(a);
        } else if (temp.equals ("1")) {
            Card19.setIcon(b);
        } else if (temp.equals ("2")) {
            Card19.setIcon(c);
        } else if (temp.equals ("3")) {
            Card19.setIcon(d);
        } else if (temp.equals ("4")) {
            Card19.setIcon(e);
        } else if (temp.equals ("5")) {
            Card19.setIcon(f);
        } else if (temp.equals ("6")) {
            Card19.setIcon(g);
        } else if (temp.equals ("7")) {
            Card19.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card19.setIcon(i);
        } else if (temp.equals ("9")) {
            Card19.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[18]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[18]=0;
        }
    }//GEN-LAST:event_Card19MouseClicked

    private void Card20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Card20MouseClicked
          String temp = cards.get(19);
 // refer to Card1MouseClicked for explanation of code
        if (temp.equals ("0")) {
            Card20.setIcon(a);
        } else if (temp.equals ("1")) {
            Card20.setIcon(b);
        } else if (temp.equals ("2")) {
            Card20.setIcon(c);
        } else if (temp.equals ("3")) {
            Card20.setIcon(d);
        } else if (temp.equals ("4")) {
            Card20.setIcon(e);
        } else if (temp.equals ("5")) {
            Card20.setIcon(f);
        } else if (temp.equals ("6")) {
            Card20.setIcon(g);
        } else if (temp.equals ("7")) {
            Card20.setIcon(h);
        }  else if (temp.equals ("8")) {
            Card20.setIcon(i);
        } else if (temp.equals ("9")) {
            Card20.setIcon(j);
        }

        count++;
        if (count==1){
            c1=Integer.parseInt(temp);
            change[19]=0;
        } else {
            c2=Integer.parseInt(temp);
            change[19]=0;
        }
    }//GEN-LAST:event_Card20MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Card1;
    private javax.swing.JButton Card10;
    private javax.swing.JButton Card11;
    private javax.swing.JButton Card12;
    private javax.swing.JButton Card13;
    private javax.swing.JButton Card14;
    private javax.swing.JButton Card15;
    private javax.swing.JButton Card16;
    private javax.swing.JButton Card17;
    private javax.swing.JButton Card18;
    private javax.swing.JButton Card19;
    private javax.swing.JButton Card2;
    private javax.swing.JButton Card20;
    private javax.swing.JButton Card3;
    private javax.swing.JButton Card4;
    private javax.swing.JButton Card5;
    private javax.swing.JButton Card6;
    private javax.swing.JButton Card7;
    private javax.swing.JButton Card8;
    private javax.swing.JButton Card9;
    private javax.swing.JButton Exit;
    private javax.swing.JButton guessAgain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton play;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables


    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
