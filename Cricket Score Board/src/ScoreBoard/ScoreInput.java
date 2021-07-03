


package ScoreBoard;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.awt.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ScoreInput extends javax.swing.JFrame {

     Connection connection; 
    Statement statement;
    ResultSet resultset;
    int matchId;
    String inning="First Inning";
    String inningsTable="firstInningTable";
    String battingTeam="";
    String bowlingTeam="";
    String bowlerPlaying="";
    String batsman1st="";
    String batsman2nd="";
    String batsmanPlaying="";
    Boolean select1stBatsman=true;
    Boolean select2ndBatsman=true;
    int runtaken=0;
    int countfour=0;
    int countsix=0;
    int balldone=0;
    int overdone=0;
    int rungiven=0;
    int noballgiven=0;
    int wickettaken=0;
    int temp1=0;
    int temp2=0;
    int temp3=0;
    String temp4="";
    
    
    
    public ScoreInput() {
        initComponents();
    }
    

    public ScoreInput(int matchId){
        initComponents();
        this.matchId=matchId;
        SECONDPANEL.setVisible(false);
        THIRDPANEL.setVisible(false);
        connection = ConnectMSSQL.connectDB();
        Inning();
        selectBatBowl();
        RUN.setEditable(false);
        WICKET.setEditable(false);
        OVER.setEditable(false);
       
    }
    
    public void Inning(){
        HEADIN2.setText(inning);
        HEADING3.setText(inning);
        HEADING4.setText(inning);
    }
    
    
    public void selectBatBowl(){
    
         try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select TeamA,TeamB from matchTable where MatchID="+matchId+"");
            resultset.next();
            TEAM_A.setText(resultset.getString("TeamA"));
            TEAM_B.setText(resultset.getString("TeamB"));    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
}
    
    public void toSecondPanel(){
        if(ABATTING.isSelected()){
            battingTeam=TEAM_A.getText().toString();
            bowlingTeam=TEAM_B.getText().toString();
            //System.out.println(battingTeam );
            
            
        }else{
            bowlingTeam=TEAM_A.getText().toString();
            battingTeam=TEAM_B.getText().toString();
           // System.out.println(battingTeam );
        }
    }
    
        public void PlayerBox(){
        BATSMAN.removeAllItems();
        BOWLER.removeAllItems();
        try {
            
            statement=connection.createStatement();
            
             resultset=statement.executeQuery("select playerInformationTable.PlayerName,playingTeamTable.MatchID from playingTeamTable left join playerInformationTable on playingTeamTable.PlayerID=playerInformationTable.PlayerID WHERE playingTeamTable.MatchID="+matchId+" AND playingTeamTable.TeamName='"+battingTeam+"' except select PlayerName,MatchID from "+inningsTable+";");
        
           
            while(resultset.next()){
                BATSMAN.addItem(resultset.getString("PlayerName"));
            }
            
            resultset=statement.executeQuery("select PlayerName from playerInformationTable where playerID in(select playerID from playingTeamTable where MatchID="+matchId+" and TeamName='"+bowlingTeam+"')");
            
            while(resultset.next()){
                BOWLER.addItem(resultset.getString("PlayerName"));
            }
            
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        
        
        public void selectBowler(){
            BOWLERP.setEditable(false);
            bowlerPlaying=BOWLER.getSelectedItem().toString();
            BOWLERP.setText(bowlerPlaying);
            
        }
        
        public void addToInningsTable(){
        try {
            statement=connection.createStatement();
            resultset=statement.executeQuery("select PlayerName from "+inningsTable+" where PlayerName='"+bowlerPlaying+"' and MatchID='"+matchId+"'");
            if(!resultset.next())
            {
            statement.executeUpdate("insert into "+inningsTable+" values('"+matchId+"','"+bowlingTeam+"','"+bowlerPlaying+"',0,0,0,0,0,0,0,0);");
            }
            resultset=statement.executeQuery("select PlayerName from "+inningsTable+" where PlayerName='"+batsman1st+"' and MatchID='"+matchId+"'");
            if(!resultset.next())
            {
            statement.executeUpdate("insert into "+inningsTable+" values('"+matchId+"','"+battingTeam+"','"+batsman1st+"',0,0,0,0,0,0,0,0);");    
            }
            
             resultset=statement.executeQuery("select PlayerName from "+inningsTable+" where PlayerName='"+batsman2nd+"' and MatchID='"+matchId+"'");
            if(!resultset.next()){
                statement.executeUpdate("insert into "+inningsTable+" values('"+matchId+"','"+battingTeam+"','"+batsman2nd+"',0,0,0,0,0,0,0,0);");
            }
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
         }
        }
        
        public void calculate(){
              try {
                  
            statement=connection.createStatement();
            
            resultset=statement.executeQuery("select * from "+inningsTable+" where PlayerName='"+bowlerPlaying+"' and MatchID="+matchId+"");
            while(resultset.next()){
               rungiven+= Integer.parseInt(resultset.getString("runGiven"));
                noballgiven+=Integer.parseInt(resultset.getString("noBall"));
                wickettaken+=Integer.parseInt(resultset.getString("wicket"));
                overdone=Integer.parseInt(resultset.getString("overs"));
            }
            temp1=(rungiven/6);
            temp2=rungiven-(temp1*6);
            overdone=overdone+temp1;
            
            statement.executeUpdate("update "+inningsTable+" set runGiven="+rungiven+",noBall="+noballgiven+",wicket="+wickettaken+",overs="+overdone+" where PlayerName='"+bowlerPlaying+"';");
            
            resultset=statement.executeQuery("select runGiven from "+inningsTable+" where PlayerName='"+bowlerPlaying+"' and MatchID="+matchId+"");
            
            if(FIRSTBATSMAN.isSelected()){
            resultset=statement.executeQuery("select * from "+inningsTable+" where PlayerName='"+batsman1st+"' and MatchID="+matchId+"");
            batsmanPlaying=batsman1st;
            }else{
                 resultset=statement.executeQuery("select * from "+inningsTable+" where PlayerName='"+batsman2nd+"' and MatchID="+matchId+"");
                 batsmanPlaying=batsman2nd;
            }
            while(resultset.next()){
               runtaken+= Integer.parseInt(resultset.getString("runTaken"));
                countfour+=Integer.parseInt(resultset.getString("fours"));
                countsix+=Integer.parseInt(resultset.getString("sixs"));
                balldone+=Integer.parseInt(resultset.getString("ball"));
            }
            
            statement.executeUpdate("update "+inningsTable+" set runTaken="+runtaken+",fours="+countfour+",sixs="+countsix+",ball="+balldone+" where PlayerName='"+batsmanPlaying+"'");
                
            resultset=statement.executeQuery("select sum(ball) as totalBall,sum(runGiven) as totalRun, sum(wicket) as totalWicket , MatchID from "+inningsTable+" where MatchID="+matchId+" group by MatchID ");
            while(resultset.next()){
               RUN.setText(resultset.getString("totalRun"));
               WICKET.setText(resultset.getString("totalWicket"));
               temp3=Integer.parseInt(resultset.getString("totalBall"));
            }
            temp1=temp3/6;
            temp2=temp3-(temp1*6);
            OVER.setText(temp1+"/"+temp2);
            
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        }
        
        
        public void delete(){
         try {
             statement=connection.createStatement();
             statement.executeUpdate("delete from playingTeamTable where MatchID="+matchId+";");
         } catch (SQLException ex) {
             Logger.getLogger(ScoreInput.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FIRSTPANEL = new javax.swing.JPanel();
        ABOWLING = new javax.swing.JRadioButton();
        ABATTING = new javax.swing.JRadioButton();
        BBATTING = new javax.swing.JRadioButton();
        BBOWLING = new javax.swing.JRadioButton();
        TEAM_B = new javax.swing.JLabel();
        HEADIN2 = new javax.swing.JLabel();
        NEXT = new javax.swing.JButton();
        TEAM_A = new javax.swing.JLabel();
        SECONDPANEL = new javax.swing.JPanel();
        bowler = new javax.swing.JLabel();
        batsman = new javax.swing.JLabel();
        BOWLER = new javax.swing.JComboBox<>();
        SET = new javax.swing.JButton();
        BATSMAN = new javax.swing.JComboBox<>();
        FIRSTBATSMAN = new javax.swing.JRadioButton();
        SECONDBATSMAN = new javax.swing.JRadioButton();
        RUN6 = new javax.swing.JRadioButton();
        RUN4 = new javax.swing.JRadioButton();
        RUN3 = new javax.swing.JRadioButton();
        RUN2 = new javax.swing.JRadioButton();
        RUN1 = new javax.swing.JRadioButton();
        onthisball = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        OUT = new javax.swing.JRadioButton();
        NOBALL = new javax.swing.JRadioButton();
        HEADING3 = new javax.swing.JLabel();
        BOWLERP = new javax.swing.JTextField();
        THIRDPANEL = new javax.swing.JPanel();
        RUN = new javax.swing.JTextField();
        WICKET = new javax.swing.JTextField();
        run = new javax.swing.JLabel();
        wicket = new javax.swing.JLabel();
        over = new javax.swing.JLabel();
        OVER = new javax.swing.JTextField();
        DONE = new javax.swing.JButton();
        HEADING4 = new javax.swing.JLabel();
        SUBMIT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 188, 19));

        FIRSTPANEL.setBackground(new java.awt.Color(255, 247, 239));

        ABOWLING.setFont(ADD.getFont());
        ABOWLING.setText("Bowling");
        ABOWLING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABOWLINGActionPerformed(evt);
            }
        });

        ABATTING.setFont(DONE.getFont());
        ABATTING.setText("Batting");
        ABATTING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABATTINGActionPerformed(evt);
            }
        });

        BBATTING.setFont(ADD.getFont());
        BBATTING.setText("Batting");
        BBATTING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBATTINGActionPerformed(evt);
            }
        });

        BBOWLING.setFont(ADD.getFont());
        BBOWLING.setText("Bowling");
        BBOWLING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBOWLINGActionPerformed(evt);
            }
        });

        TEAM_B.setBackground(new java.awt.Color(255, 255, 255));
        TEAM_B.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        TEAM_B.setText("...");

        HEADIN2.setFont(new java.awt.Font("Bauhaus 93", 1, 50)); // NOI18N
        HEADIN2.setText("...");

        NEXT.setBackground(new java.awt.Color(255, 247, 239));
        NEXT.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        NEXT.setText("Next");
        NEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEXTActionPerformed(evt);
            }
        });

        TEAM_A.setBackground(new java.awt.Color(255, 255, 255));
        TEAM_A.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        TEAM_A.setText("...");

        javax.swing.GroupLayout FIRSTPANELLayout = new javax.swing.GroupLayout(FIRSTPANEL);
        FIRSTPANEL.setLayout(FIRSTPANELLayout);
        FIRSTPANELLayout.setHorizontalGroup(
            FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FIRSTPANELLayout.createSequentialGroup()
                .addGroup(FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FIRSTPANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(FIRSTPANELLayout.createSequentialGroup()
                                .addComponent(TEAM_B, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123)
                                .addComponent(BBATTING))
                            .addGroup(FIRSTPANELLayout.createSequentialGroup()
                                .addComponent(TEAM_A, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ABATTING)))
                        .addGap(157, 157, 157)
                        .addGroup(FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ABOWLING)
                            .addComponent(BBOWLING)
                            .addComponent(NEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FIRSTPANELLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(HEADIN2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        FIRSTPANELLayout.setVerticalGroup(
            FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FIRSTPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HEADIN2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ABOWLING)
                    .addComponent(ABATTING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TEAM_A, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FIRSTPANELLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(FIRSTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BBOWLING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BBATTING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(NEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(FIRSTPANELLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(TEAM_B, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(131, Short.MAX_VALUE))))
        );

        SECONDPANEL.setBackground(new java.awt.Color(255, 247, 239));

        bowler.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        bowler.setText("Bowler");

        batsman.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        batsman.setText("Batsman");

        SET.setBackground(new java.awt.Color(255, 247, 239));
        SET.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        SET.setText("SET");
        SET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SETActionPerformed(evt);
            }
        });

        FIRSTBATSMAN.setText("First Batsman");
        FIRSTBATSMAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FIRSTBATSMANActionPerformed(evt);
            }
        });

        SECONDBATSMAN.setText("Second Batsman");
        SECONDBATSMAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SECONDBATSMANActionPerformed(evt);
            }
        });

        RUN6.setFont(new java.awt.Font("Bauhaus 93", 1, 16)); // NOI18N
        RUN6.setText("6 run");
        RUN6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUN6ActionPerformed(evt);
            }
        });

        RUN4.setFont(new java.awt.Font("Bauhaus 93", 1, 16)); // NOI18N
        RUN4.setText("4 run");
        RUN4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUN4ActionPerformed(evt);
            }
        });

        RUN3.setFont(new java.awt.Font("Bauhaus 93", 1, 16)); // NOI18N
        RUN3.setText("3 run");
        RUN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUN3ActionPerformed(evt);
            }
        });

        RUN2.setFont(new java.awt.Font("Bauhaus 93", 1, 16)); // NOI18N
        RUN2.setText("2 run");
        RUN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUN2ActionPerformed(evt);
            }
        });

        RUN1.setFont(new java.awt.Font("Bauhaus 93", 1, 16)); // NOI18N
        RUN1.setText("1 run");
        RUN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUN1ActionPerformed(evt);
            }
        });

        onthisball.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        onthisball.setText("On This Ball ");

        ADD.setBackground(new java.awt.Color(255, 247, 239));
        ADD.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        OUT.setFont(new java.awt.Font("Bauhaus 93", 1, 16)); // NOI18N
        OUT.setText("Out");
        OUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OUTActionPerformed(evt);
            }
        });

        NOBALL.setFont(new java.awt.Font("Bauhaus 93", 1, 16)); // NOI18N
        NOBALL.setText("No Ball");
        NOBALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOBALLActionPerformed(evt);
            }
        });

        HEADING3.setFont(new java.awt.Font("Bauhaus 93", 1, 50)); // NOI18N
        HEADING3.setText("...");

        javax.swing.GroupLayout SECONDPANELLayout = new javax.swing.GroupLayout(SECONDPANEL);
        SECONDPANEL.setLayout(SECONDPANELLayout);
        SECONDPANELLayout.setHorizontalGroup(
            SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SECONDPANELLayout.createSequentialGroup()
                .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(onthisball))
                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bowler)
                            .addComponent(batsman))))
                .addGap(84, 84, 84)
                .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                        .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SECONDPANELLayout.createSequentialGroup()
                                .addComponent(RUN1)
                                .addGap(67, 67, 67)
                                .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NOBALL)
                                    .addComponent(RUN2)))
                            .addComponent(BATSMAN, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(SECONDPANELLayout.createSequentialGroup()
                                    .addComponent(RUN6)
                                    .addGap(234, 234, 234)
                                    .addComponent(OUT))
                                .addComponent(RUN3))
                            .addComponent(BOWLER, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SECONDPANELLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))
                            .addGroup(SECONDPANELLayout.createSequentialGroup()
                                .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(RUN4))
                                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(SET, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                        .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HEADING3, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FIRSTBATSMAN)
                            .addComponent(SECONDBATSMAN)
                            .addComponent(BOWLERP, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        SECONDPANELLayout.setVerticalGroup(
            SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SECONDPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HEADING3)
                .addGap(22, 22, 22)
                .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                        .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bowler)
                            .addComponent(SET, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batsman)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(SECONDPANELLayout.createSequentialGroup()
                        .addComponent(BOWLER, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BOWLERP, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BATSMAN, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(FIRSTBATSMAN)
                .addGap(18, 18, 18)
                .addComponent(SECONDBATSMAN)
                .addGap(30, 30, 30)
                .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onthisball)
                    .addComponent(RUN1)
                    .addComponent(RUN2)
                    .addComponent(RUN3)
                    .addComponent(RUN4))
                .addGap(28, 28, 28)
                .addGroup(SECONDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RUN6)
                    .addComponent(NOBALL)
                    .addComponent(OUT)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        THIRDPANEL.setBackground(new java.awt.Color(255, 247, 239));

        run.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        run.setText("Run");

        wicket.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        wicket.setText("Wicket");

        over.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        over.setText("Over");

        DONE.setBackground(new java.awt.Color(255, 255, 255));
        DONE.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        DONE.setText("Done");
        DONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DONEActionPerformed(evt);
            }
        });

        HEADING4.setFont(new java.awt.Font("Bauhaus 93", 1, 50)); // NOI18N
        HEADING4.setText("...");

        javax.swing.GroupLayout THIRDPANELLayout = new javax.swing.GroupLayout(THIRDPANEL);
        THIRDPANEL.setLayout(THIRDPANELLayout);
        THIRDPANELLayout.setHorizontalGroup(
            THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(THIRDPANELLayout.createSequentialGroup()
                .addGroup(THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(THIRDPANELLayout.createSequentialGroup()
                        .addGroup(THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(THIRDPANELLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RUN, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(OVER, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(over))
                                .addGap(41, 41, 41)
                                .addGroup(THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(WICKET, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wicket, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(THIRDPANELLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(DONE, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addGroup(THIRDPANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HEADING4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        THIRDPANELLayout.setVerticalGroup(
            THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(THIRDPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HEADING4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(run)
                    .addComponent(wicket, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(THIRDPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RUN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WICKET, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(over)
                .addGap(18, 18, 18)
                .addComponent(OVER, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(DONE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        SUBMIT.setBackground(new java.awt.Color(255, 247, 239));
        SUBMIT.setFont(new java.awt.Font("Bauhaus 93", 1, 24)); // NOI18N
        SUBMIT.setText("Submit");
        SUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUBMITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(SECONDPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(THIRDPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(240, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SUBMIT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
            .addGroup(layout.createSequentialGroup()
                .addGap(521, 521, 521)
                .addComponent(FIRSTPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(FIRSTPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(THIRDPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SUBMIT, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SECONDPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEXTActionPerformed
        toSecondPanel();
        PlayerBox();
        FIRSTPANEL.setVisible(false);
        SECONDPANEL.setVisible(true);
        THIRDPANEL.setVisible(true);
    }//GEN-LAST:event_NEXTActionPerformed

    private void ABATTINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABATTINGActionPerformed
        if(ABATTING.isSelected())
        {
            ABOWLING.setSelected(false);
            BBATTING.setSelected(false);
        }
    }//GEN-LAST:event_ABATTINGActionPerformed

    private void ABOWLINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABOWLINGActionPerformed
        if(ABOWLING.isSelected())
        {
            ABATTING.setSelected(false);
            BBOWLING.setSelected(false);
        }
    }//GEN-LAST:event_ABOWLINGActionPerformed

    private void BBATTINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBATTINGActionPerformed
        if(BBATTING.isSelected())
        {
            BBOWLING.setSelected(false);
            ABATTING.setSelected(false);
        }
    }//GEN-LAST:event_BBATTINGActionPerformed

    private void BBOWLINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBOWLINGActionPerformed
        if(BBOWLING.isSelected())
        {
            BBATTING.setSelected(false);
            ABOWLING.setSelected(false);
        }
    }//GEN-LAST:event_BBOWLINGActionPerformed

    private void FIRSTBATSMANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FIRSTBATSMANActionPerformed
        if(FIRSTBATSMAN.isSelected())
        {
            SECONDBATSMAN.setSelected(false);
            if(select1stBatsman==true){
            FIRSTBATSMAN.setText(BATSMAN.getSelectedItem().toString());
            select1stBatsman=false;
            batsman1st=BATSMAN.getSelectedItem().toString();
            }
        }
    }//GEN-LAST:event_FIRSTBATSMANActionPerformed

    private void SECONDBATSMANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SECONDBATSMANActionPerformed
        if(SECONDBATSMAN.isSelected())
        {
            FIRSTBATSMAN.setSelected(false);
            if(select2ndBatsman==true){
            SECONDBATSMAN.setText(BATSMAN.getSelectedItem().toString());
            select2ndBatsman=false;
            batsman2nd=BATSMAN.getSelectedItem().toString();
            }
        }
    }//GEN-LAST:event_SECONDBATSMANActionPerformed

    private void SETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SETActionPerformed
        selectBowler();
        addToInningsTable();
        PlayerBox();
        SECONDBATSMAN.setSelected(false);
        FIRSTBATSMAN.setSelected(false);
        
    }//GEN-LAST:event_SETActionPerformed

    private void RUN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUN1ActionPerformed
        if(RUN1.isSelected())
        {
            RUN2.setSelected(false);
            RUN3.setSelected(false);
            RUN4.setSelected(false);
            RUN6.setSelected(false);
            NOBALL.setSelected(false);
            OUT.setSelected(false);
            runtaken=1;
            balldone=1;
            countfour=0;
            countsix=0;
            
            rungiven=1;
            noballgiven=0;
            wickettaken=0;
        }
    }//GEN-LAST:event_RUN1ActionPerformed

    private void RUN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUN2ActionPerformed
        if(RUN2.isSelected())
        {
            RUN1.setSelected(false);
            RUN3.setSelected(false);
            RUN4.setSelected(false);
            RUN6.setSelected(false);
            NOBALL.setSelected(false);
            OUT.setSelected(false);
            runtaken=2;
            balldone=1;
            countfour=0;
            countsix=0;
            
            rungiven=2;
            noballgiven=0;
            wickettaken=0;
        }
    }//GEN-LAST:event_RUN2ActionPerformed

    private void RUN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUN3ActionPerformed
         if(RUN3.isSelected())
        {
            RUN2.setSelected(false);
            RUN1.setSelected(false);
            RUN4.setSelected(false);
            RUN6.setSelected(false);
            NOBALL.setSelected(false);
            OUT.setSelected(false);
            runtaken=3;
            balldone=1;
            countfour=0;
            countsix=0;
            
            rungiven=3;
            noballgiven=0;
            wickettaken=0;
        }
    }//GEN-LAST:event_RUN3ActionPerformed

    private void RUN4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUN4ActionPerformed
         if(RUN4.isSelected())
        {
            RUN2.setSelected(false);
            RUN3.setSelected(false);
            RUN1.setSelected(false);
            RUN6.setSelected(false);
            NOBALL.setSelected(false);
            OUT.setSelected(false);
            runtaken=4;
            balldone=1;
            countfour=1;
            countsix=0;
            
            rungiven=4;
            noballgiven=0;
            wickettaken=0;
        }
    }//GEN-LAST:event_RUN4ActionPerformed

    private void RUN6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUN6ActionPerformed
         if(RUN6.isSelected())
        {
            RUN2.setSelected(false);
            RUN3.setSelected(false);
            RUN4.setSelected(false);
            RUN1.setSelected(false);
            NOBALL.setSelected(false);
            OUT.setSelected(false);
            runtaken=6;
            balldone=1;
            countfour=0;
            countsix=1;
            
            rungiven=6;
            noballgiven=0;
            wickettaken=0;
        }
    }//GEN-LAST:event_RUN6ActionPerformed

    private void NOBALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOBALLActionPerformed
         if(NOBALL.isSelected())
        {
            RUN2.setSelected(false);
            RUN3.setSelected(false);
            RUN4.setSelected(false);
            RUN6.setSelected(false);
            RUN1.setSelected(false);
            OUT.setSelected(false);
            runtaken=1;
            balldone=0;
            countfour=0;
            countsix=0;
            
            rungiven=1;
            noballgiven=1;
            wickettaken=0;
            
        }
    }//GEN-LAST:event_NOBALLActionPerformed

    private void OUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OUTActionPerformed
         if(OUT.isSelected())
        {
            RUN2.setSelected(false);
            RUN3.setSelected(false);
            RUN4.setSelected(false);
            RUN6.setSelected(false);
            NOBALL.setSelected(false);
            RUN1.setSelected(false);
            runtaken=0;
            balldone=1;
            countfour=0;
            countsix=0;
            
            rungiven=0;
            noballgiven=0;
            wickettaken=1;
            if(FIRSTBATSMAN.isSelected())
            {
            select1stBatsman=true;
            }else{
            select2ndBatsman=true;
            }
        }
    }//GEN-LAST:event_OUTActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        calculate();
    }//GEN-LAST:event_ADDActionPerformed

    private void DONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DONEActionPerformed
        inningsTable="secondInningTable";
        inning="Second Inning";
        Inning();
        select1stBatsman=true;
        select2ndBatsman=true;
        temp4=battingTeam;
        battingTeam=bowlingTeam;
        bowlingTeam=temp4;
        FIRSTPANEL.setVisible(true);
        SECONDPANEL.setVisible(false);
        THIRDPANEL.setVisible(false);
    }//GEN-LAST:event_DONEActionPerformed

    private void SUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBMITActionPerformed
         delete();
         logIn page = new logIn();
         page.setVisible(true);
         this.hide();
    }//GEN-LAST:event_SUBMITActionPerformed

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
            java.util.logging.Logger.getLogger(ScoreInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreInput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ABATTING;
    private javax.swing.JRadioButton ABOWLING;
    private javax.swing.JButton ADD;
    private javax.swing.JComboBox<String> BATSMAN;
    private javax.swing.JRadioButton BBATTING;
    private javax.swing.JRadioButton BBOWLING;
    private javax.swing.JComboBox<String> BOWLER;
    private javax.swing.JTextField BOWLERP;
    private javax.swing.JButton DONE;
    private javax.swing.JRadioButton FIRSTBATSMAN;
    private javax.swing.JPanel FIRSTPANEL;
    private javax.swing.JLabel HEADIN2;
    private javax.swing.JLabel HEADING3;
    private javax.swing.JLabel HEADING4;
    private javax.swing.JButton NEXT;
    private javax.swing.JRadioButton NOBALL;
    private javax.swing.JRadioButton OUT;
    private javax.swing.JTextField OVER;
    private javax.swing.JTextField RUN;
    private javax.swing.JRadioButton RUN1;
    private javax.swing.JRadioButton RUN2;
    private javax.swing.JRadioButton RUN3;
    private javax.swing.JRadioButton RUN4;
    private javax.swing.JRadioButton RUN6;
    private javax.swing.JRadioButton SECONDBATSMAN;
    private javax.swing.JPanel SECONDPANEL;
    private javax.swing.JButton SET;
    private javax.swing.JButton SUBMIT;
    private javax.swing.JLabel TEAM_A;
    private javax.swing.JLabel TEAM_B;
    private javax.swing.JPanel THIRDPANEL;
    private javax.swing.JTextField WICKET;
    private javax.swing.JLabel batsman;
    private javax.swing.JLabel bowler;
    private javax.swing.JLabel onthisball;
    private javax.swing.JLabel over;
    private javax.swing.JLabel run;
    private javax.swing.JLabel wicket;
    // End of variables declaration//GEN-END:variables
}
