package battlebunnies;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mhc31
 */
public class BattleBunniesFrameMain extends javax.swing.JFrame {

    static boolean turnFlag;
    static boolean gameOver = false;

    /**
     * tutor helped with setting up some of these variables, and how to get them to work.
     */
    
    //ABILITY CREATION
        static CharacterAbility attack = new CharacterAbility("Attack", "A simple physical attack", "Physical", 5, 0);
        static CharacterAbility fireball = new CharacterAbility("Fireball", "Shoots a fireball dealing a little damage", "Fire", 10, 3);
        static CharacterAbility rockspike = new CharacterAbility("Rock Spike", "Rock juts out of the ground dealing a little damage", "Earth", 10, 4);
        static CharacterAbility airBlast = new CharacterAbility("Air Blast", "Shoots a bullet of air dealing a little damage", "Air", 10, 3);
        static CharacterAbility bubbles = new CharacterAbility("Bubbles", "Bubbles pop in the enemy's face dealing a little damage", "Water", 10, 4);
        static CharacterAbility headbutt = new CharacterAbility("Headbutt", "A karate chop on the enemy dealing a little damage", "Physical", 15, 5);
        static CharacterAbility tidalwave = new CharacterAbility("Tidal Wave", "A huge wave of water dealing a lot of damage", "Water", 20, 7);
        static CharacterAbility fireblast = new CharacterAbility("Fire Blast", "A large ball of fire dealing a lot of damage", "Fire", 20, 8);
        static CharacterAbility hurricane = new CharacterAbility("Hurricane", "A hurricane is summoned dealing a lot of damage", "Air", 20, 7);
        static CharacterAbility steelspike = new CharacterAbility("Steel Spike", "A steel spike shoots from the ground dealing a lot of damage", "Earth", 20, 8);
        static CharacterAbility flurrystrike = new CharacterAbility("Flurry Strike", "A flurry of strikes too fast to see dealing a lot of damage", "Physical", 20, 7);
        static CharacterAbility heal = new CharacterAbility("Heal", "Heal a small amount of HP", "Support", 15, 8);
        static CharacterAbility lucky = new CharacterAbility("Lucky", "On the next turn, a critical hit is guaranteed, but defence is halved", "Support", 0, 6);
        static CharacterAbility ironwall = new CharacterAbility("Iron Wall", "Defence is doubled for one turn.", "Support", 0, 6);
        static CharacterAbility stab = new CharacterAbility("Stab", "Stab the enemy", "Physical", 15, 3);
        static CharacterAbility windcutter = new CharacterAbility("Wind Cutter", "Swings knife at blinding speed damaging all enemies", "Air", 20, 10);
        static CharacterAbility eviscerate = new CharacterAbility("Eviscerate", "Tears into the enemy with wild abandon", "Physical", 30, 7);
        static CharacterAbility shadowedwind = new CharacterAbility("Shadowed Wind", "The wind tears into all enemies", "Air", 10, 5);
        static CharacterAbility starstrike = new CharacterAbility("Star Strike", "A star falls on the enemy", "Fire", 45, 12);
        static CharacterAbility colorswap = new CharacterAbility("Color Swap", "Changes an enemy's weakness to a random weakness for the rest of the battle", "Support", 0, 3);
        static CharacterAbility ironhooves = new CharacterAbility("Iron Hooves", "Kicks an enemy with iron hooves", "Earth", 20, 4);

        //PORTRAIT CREATION
        static ImageIcon hero1Portrait = new ImageIcon("src\\battlebunnies\\images\\AllyRedSlime.png");
        static ImageIcon hero2Portrait = new ImageIcon("src\\battlebunnies\\images\\AllyBlueSlime.png");
        static ImageIcon hero3Portrait = new ImageIcon("src\\battlebunnies\\images\\AllyGreenSlime.png");
        static ImageIcon boss1Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyBunny.png");
        static ImageIcon boss2Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyKnifeBunny.png");
        static ImageIcon boss3Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyNightBunny.png");
        static ImageIcon boss4Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyAlbinoBunny.png");
        static ImageIcon boss5Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyZebraBunny.png");
        static ImageIcon boss6Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyStarBunny.png");


    
    //CHARACTER CREATION
    static GameCharacter hero1 = new GameCharacter("Red Slime", 1, 100, 20, "Water", 1, 1, 0.25, 0.25, attack, fireball, heal, hero1Portrait);
    static GameCharacter hero2 = new GameCharacter("Blue Slime", 2, 100, 20, "Earth", 1, 1, 0.25, 0.25, attack, bubbles, lucky, hero2Portrait);
    static GameCharacter hero3 = new GameCharacter("Green Slime", 3, 100, 20, "Fire", 1, 1, 0.25, 0.25, attack, steelspike, ironwall, hero3Portrait);
    static ArrayList<GameCharacter> playerParty = new ArrayList();
    static GameCharacter currentHero = hero1;
    static GameCharacter nextHero = hero2;
    static int characterIndex = 0;

    //BOSS CREATION
    static Boss boss1 = new Boss("Lazy Bunny", 4, 300, 50, "Earth", 1, 1, 0.25, 0.25, attack, windcutter, colorswap, boss1Portrait);
    static Boss boss2 = new Boss("Knife Bunny", 5, 300, 50, "Air", 1, 1, 0.25, 0.25, attack, stab, rockspike, boss2Portrait);
    static Boss boss3 = new Boss("Night Bunny", 6, 300, 50, "Fire", 1, 1, 0.25, 0.25, attack, hurricane, tidalwave, boss3Portrait);
    static Boss boss4 = new Boss("Albino Bunny", 7, 300, 50, "Physical", 1, 1, 0.25, 0.25, attack, eviscerate, shadowedwind, boss4Portrait);
    static Boss boss5 = new Boss("Zebra Bunny", 8, 300, 50, "Water", 1, 1, 0.25, 0.25, attack, headbutt, ironhooves, boss5Portrait);
    static Boss boss6 = new Boss("Star Bunny", 9, 300, 50, "Water", 1, 1, 0.25, 0.25, attack, starstrike, fireblast, boss6Portrait);
    static ArrayList<Boss> bossList = new ArrayList();
    static Boss currentBoss = boss1;
    static int bossIndex = 0;
    
    /**
     * Creates new form NewJFrame
     */
    public BattleBunniesFrameMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        BossImage = new javax.swing.JLabel();
        Ally1HP = new javax.swing.JLabel();
        BossInformation = new javax.swing.JLabel();
        CurrentPlayerImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Ally1MP = new javax.swing.JLabel();
        HeroHP = new javax.swing.JLabel();
        HeroMP = new javax.swing.JLabel();
        Ally2HP = new javax.swing.JLabel();
        Ally2MP = new javax.swing.JLabel();
        CombatFeed = new javax.swing.JLabel();
        Ally2Label = new javax.swing.JLabel();
        Ally1Label = new javax.swing.JLabel();
        HeroLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 1000));

        BossImage.setIcon(currentBoss.getPortrait()); // NOI18N

        Ally1HP.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Ally1HP.setText("HP: " + hero1.getCurrentHP() + "/" + hero1.getMaxHP());

        BossInformation.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        BossInformation.setText("Boss HP: " + currentBoss.getCurrentHP() + "/" + currentBoss.getMaxHP());

        CurrentPlayerImage.setIcon(currentHero.getPortrait()); // NOI18N

        jButton1.setText(currentHero.getBasicAttack().getName() + " - " + currentHero.getBasicAttack().getMPRequired());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText(currentHero.getSpecialAbility2().getName() + " - " + currentHero.getSpecialAbility2().getMPRequired());

        jButton2.setText(currentHero.getSpecialAbility1().getName() + " - " + currentHero.getSpecialAbility1().getMPRequired());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                redraw(false);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        Ally1MP.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Ally1MP.setText("MP: " + hero1.getCurrentMP() + "/" + hero1.getMaxMP());//redslime

        HeroHP.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        HeroHP.setText("HP: " + hero2.getCurrentHP() + "/" + hero2.getMaxHP());

        HeroMP.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        HeroMP.setText("MP: " + hero2.getCurrentMP() + "/" + hero2.getMaxMP());//blue

        Ally2HP.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Ally2HP.setText("HP: " + hero3.getCurrentHP() + "/" + hero3.getMaxHP());

        Ally2MP.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Ally2MP.setText("MP: " + hero3.getCurrentMP() + "/" + hero3.getMaxMP());//Green

        CombatFeed.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        CombatFeed.setText("");

        Ally2Label.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Ally2Label.setText(hero3.getName());

        Ally1Label.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Ally1Label.setText(hero1.getName());

        HeroLabel.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        HeroLabel.setText(hero2.getName());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(CurrentPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BossInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(8, 8, 8)
                                                .addComponent(BossImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(CombatFeed, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(Ally1HP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(Ally1MP, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(99, 99, 99)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(HeroMP, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(HeroHP, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(149, 149, 149))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(Ally1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(HeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(157, 157, 157)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Ally2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Ally2HP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(Ally2MP, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(151, 151, 151)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(BossImage, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BossInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CurrentPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CombatFeed, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Ally2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(HeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Ally1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(Ally1MP, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Ally1HP, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(HeroHP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Ally2HP, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Ally2MP, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(HeroMP, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(599, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold> 

    private void redraw(boolean bossTurn) {
        if(currentBoss.getCurrentHP() <= 0)
        {
            bossIndex++;
            if(bossIndex < bossList.size())
            {
                currentBoss = bossList.get(bossIndex);
                for (GameCharacter currentCharacter : playerParty)
                {
                    if (currentCharacter.getCurrentHP() > 0)
                    {
                        currentCharacter.setCurrentHP(currentCharacter.getMaxHP());
                        currentCharacter.setCurrentMP(currentCharacter.getMaxMP());
                    }
                }
            }
        }
        Ally2HP.setText("HP: " + hero3.getCurrentHP() + "/" + hero3.getMaxHP() + "");
        HeroHP.setText("HP: " + hero2.getCurrentHP() + "/" + hero2.getMaxHP() + "");
        Ally1HP.setText("HP: " + hero1.getCurrentHP() + "/" + hero1.getMaxHP() + "");
        Ally2MP.setText("MP: " + hero3.getCurrentMP() + "/" + hero3.getMaxMP() + "");
        Ally1MP.setText("MP: " + hero1.getCurrentMP() + "/" + hero1.getMaxMP() + "");
        HeroMP.setText("MP: " + hero2.getCurrentMP() + "/" + hero2.getMaxMP() + "");
        BossInformation.setText("Boss HP: " + currentBoss.getCurrentHP() + "/" + currentBoss.getMaxHP());
        jButton1.setText(nextHero.getBasicAttack().getName() + " - " + nextHero.getBasicAttack().getMPRequired());
        jButton2.setText(nextHero.getSpecialAbility1().getName() + " - " + nextHero.getSpecialAbility1().getMPRequired());
        jButton3.setText(nextHero.getSpecialAbility2().getName() + " - " + nextHero.getSpecialAbility2().getMPRequired());
        CurrentPlayerImage.setIcon(nextHero.getPortrait());
        BossImage.setIcon(currentBoss.getPortrait());
        if(bossTurn)
        {
            CombatFeed.setText(currentHero.printCombatFeed() + " " + currentBoss.getCombatFeed());
        }
        

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(!gameOver)
        {
            boolean worked = currentHero.ability1(currentBoss);
            CombatFeed.setText(currentHero.printCombatFeed());
            if (worked) {
                turnFlag = true;
                if(currentHero.equals(hero3) && hero3.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() < 0 || currentHero.equals(hero1) && hero3.getCurrentHP() < 0 && hero2.getCurrentHP() < 0)
                {
                    if(currentBoss.getCurrentHP() > 0)
                    {
                        currentBoss.turn(hero1, hero2, hero3);
                    }
                    if(currentHero.equals(hero1) && hero2.getCurrentHP() > 0 || currentHero.equals(hero3) && hero1.getCurrentHP() <= 0 && hero2.getCurrentHP() > 0)
                    {
                        nextHero=hero2;
                    }
                    else if (currentHero.equals(hero2) && hero3.getCurrentHP() > 0 || currentHero.equals(hero1) && hero2.getCurrentHP() <= 0 && hero3.getCurrentHP() > 0)
                    {
                        nextHero=hero3;
                    }
                    else if (currentHero.equals(hero3) && hero1.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() <= 0 && hero1.getCurrentHP() > 0)
                    {
                        nextHero=hero1;
                    }
                    else
                    {
                        nextHero=currentHero;
                    }
                    redraw(true);
                }
                else
                {
                    if(currentHero.equals(hero1) && hero2.getCurrentHP() > 0 || currentHero.equals(hero3) && hero1.getCurrentHP() <= 0 && hero2.getCurrentHP() > 0)
                    {
                        nextHero=hero2;
                    }
                    else if (currentHero.equals(hero2) && hero3.getCurrentHP() > 0 || currentHero.equals(hero1) && hero2.getCurrentHP() <= 0 && hero3.getCurrentHP() > 0)
                    {
                        nextHero=hero3;
                    }
                    else if (currentHero.equals(hero3) && hero1.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() <= 0 && hero1.getCurrentHP() > 0)
                    {
                        nextHero=hero1;
                    }
                    else
                    {
                        nextHero=currentHero;
                    }
                    redraw(false);
                }

            } else {
                turnFlag = false;
                CombatFeed.setText("You do not have enough MP to take this action. Please select a different action.");
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(!gameOver)
        {
            boolean worked = currentHero.ability2(currentBoss);
            CombatFeed.setText(currentHero.printCombatFeed());
            if (worked) {
                turnFlag = true;
                if(currentHero.equals(hero3) && hero3.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() < 0 || currentHero.equals(hero1) && hero3.getCurrentHP() < 0 && hero2.getCurrentHP() < 0)
                {
                    if(currentBoss.getCurrentHP() > 0)
                    {
                        currentBoss.turn(hero1, hero2, hero3);
                    }
                    if(currentHero.equals(hero1) && hero2.getCurrentHP() > 0 || currentHero.equals(hero3) && hero1.getCurrentHP() <= 0 && hero2.getCurrentHP() > 0)
                    {
                        nextHero=hero2;
                    }
                    else if (currentHero.equals(hero2) && hero3.getCurrentHP() > 0 || currentHero.equals(hero1) && hero2.getCurrentHP() <= 0 && hero3.getCurrentHP() > 0)
                    {
                        nextHero=hero3;
                    }
                    else if (currentHero.equals(hero3) && hero1.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() <= 0 && hero1.getCurrentHP() > 0)
                    {
                        nextHero=hero1;
                    }
                    else
                    {
                        nextHero=currentHero;
                    }
                    redraw(true);
                }
                else
                {
                    if(currentHero.equals(hero1) && hero2.getCurrentHP() > 0 || currentHero.equals(hero3) && hero1.getCurrentHP() <= 0 && hero2.getCurrentHP() > 0)
                    {
                        nextHero=hero2;
                    }
                    else if (currentHero.equals(hero2) && hero3.getCurrentHP() > 0 || currentHero.equals(hero1) && hero2.getCurrentHP() <= 0 && hero3.getCurrentHP() > 0)
                    {
                        nextHero=hero3;
                    }
                    else if (currentHero.equals(hero3) && hero1.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() <= 0 && hero1.getCurrentHP() > 0)
                    {
                        nextHero=hero1;
                    }
                    else
                    {
                        nextHero=currentHero;
                    }
                    redraw(false);
                }

            } else {
                turnFlag = false;
                CombatFeed.setText("You do not have enough MP to take this action. Please select a different action.");
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(!gameOver)
        {
            boolean worked = currentHero.ability3(currentBoss);
            CombatFeed.setText(currentHero.printCombatFeed());

            if (worked) {
                turnFlag = true;
                if(currentHero.equals(hero3) && hero3.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() < 0 || currentHero.equals(hero1) && hero3.getCurrentHP() < 0 && hero2.getCurrentHP() < 0)
                {
                    if(currentBoss.getCurrentHP() > 0)
                    {
                        currentBoss.turn(hero1, hero2, hero3);
                    }
                    if(currentHero.equals(hero1) && hero2.getCurrentHP() > 0 || currentHero.equals(hero3) && hero1.getCurrentHP() <= 0 && hero2.getCurrentHP() > 0)
                    {
                        nextHero=hero2;
                    }
                    else if (currentHero.equals(hero2) && hero3.getCurrentHP() > 0 || currentHero.equals(hero1) && hero2.getCurrentHP() <= 0 && hero3.getCurrentHP() > 0)
                    {
                        nextHero=hero3;
                    }
                    else if (currentHero.equals(hero3) && hero1.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() <= 0 && hero1.getCurrentHP() > 0)
                    {
                        nextHero=hero1;
                    }
                    else
                    {
                        nextHero=currentHero;
                    }
                    redraw(true);
                }
                else
                {
                    if(currentHero.equals(hero1) && hero2.getCurrentHP() > 0 || currentHero.equals(hero3) && hero1.getCurrentHP() <= 0 && hero2.getCurrentHP() > 0)
                    {
                        nextHero=hero2;
                    }
                    else if (currentHero.equals(hero2) && hero3.getCurrentHP() > 0 || currentHero.equals(hero1) && hero2.getCurrentHP() <= 0 && hero3.getCurrentHP() > 0)
                    {
                        nextHero=hero3;
                    }
                    else if (currentHero.equals(hero3) && hero1.getCurrentHP() > 0 || currentHero.equals(hero2) && hero3.getCurrentHP() <= 0 && hero1.getCurrentHP() > 0)
                    {
                        nextHero=hero1;
                    }
                    else
                    {
                        nextHero=currentHero;
                    }
                    redraw(false);
                }

            } else {
                turnFlag = false;
                CombatFeed.setText("You do not have enough MP to take this action. Please select a different action.");
            }
        }
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BattleBunniesFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BattleBunniesFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BattleBunniesFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleBunniesFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BattleBunniesFrameMain().setVisible(true);
            }

        }
        );
        String lineBreak = "---------------------------------------------------------------------------------";

        System.out.println("Welcome to Battle Bunnies! This is the text based simulation of the game that will eventually be put into a graphical interface."
                + "\n The purpose of this test is to verify that the battle calculations work under the hood before making it visual.");

        playerParty.add(hero1);
        playerParty.add(hero2);
        playerParty.add(hero3);
        bossList.add(boss1);
        bossList.add(boss2);
        bossList.add(boss3);
        bossList.add(boss4);
        bossList.add(boss5);
        bossList.add(boss6);
        
        while (bossIndex < bossList.size() && (hero1.getCurrentHP() > 0 || hero2.getCurrentHP() > 0 || hero3.getCurrentHP() > 0)) //set conditions for the game to run
        {
            //currentBoss = bossList.get(bossIndex);
            System.out.println(lineBreak + "\n" + currentBoss.getName() + " approaches!");

            //if a boss is alive and at least one party member is alive, then a turn will happen.
            while (currentBoss.getCurrentHP() > 0 && (hero1.getCurrentHP() > 0 || hero2.getCurrentHP() > 0 || hero3.getCurrentHP() > 0)) {
                for (GameCharacter currentCharacter : playerParty) {
                    if (currentCharacter.getCurrentHP() > 0) {
                        currentHero = currentCharacter;
                        turnFlag = false;
                        while (!turnFlag) {
                            pause(5); //slight delay in checking if turn has been taken since the program otherwise stopped working
                            //System.out.println("Busy Waiting on " + currentHero.getName());
                        }
                        

                    }
                }
                /*for (GameCharacter currentCharacter : playerParty) {
                    if (currentCharacter.getCurrentHP() > 0) {
                        currentCharacter.printCombatFeed();
                    }
                }*/
                
            }
            //reset hp and mp between battles
            /*for (GameCharacter currentCharacter : playerParty) {
                if (currentCharacter.getCurrentHP() > 0) {
                    currentCharacter.setCurrentHP(currentCharacter.getMaxHP());
                    currentCharacter.setCurrentMP(currentCharacter.getMaxMP());
                    System.out.println(currentCharacter.getName() + " has been reset");
                }
            }*/
            System.out.println(lineBreak + "\n" + currentBoss.getName() + " has been defeated!");
            //bossIndex++;
        }
        gameOver=true;
        //if you beat all of the bosses, the game ends.
        if ((hero1.getCurrentHP() > 0 || hero2.getCurrentHP() > 0 || hero3.getCurrentHP() > 0)) {
            System.out.println(lineBreak + "\n Congratulations, you have beat Battle Bunnies! \n Developed By: The Java Juice Team (Riley Fiske, Emily Liddell, Nathan Kraft)");
        } //if all your characters die, the game ends.
        else {
            System.out.println("Game Over.");
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel Ally1HP;
    private javax.swing.JLabel Ally1Label;
    private javax.swing.JLabel Ally1MP;
    private javax.swing.JLabel Ally2HP;
    private javax.swing.JLabel Ally2Label;
    private javax.swing.JLabel Ally2MP;
    private javax.swing.JLabel BossImage;
    private javax.swing.JLabel BossInformation;
    private javax.swing.JLabel CombatFeed;
    private javax.swing.JLabel CurrentPlayerImage;
    private javax.swing.JLabel HeroHP;
    private javax.swing.JLabel HeroLabel;
    private javax.swing.JLabel HeroMP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   

    /**
     * Method from CSC-125 project to put a slight pause in run time as to not overload
     * @param pauseTime milliseconds of pause time
     */
    public static void pause(int pauseTime)
    {
        try
              {
                    Thread.sleep(pauseTime);
              }
              catch(InterruptedException ex)
              {
               Thread.currentThread().interrupt();
              }
}
}
