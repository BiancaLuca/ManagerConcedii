/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.model.User;
import server.DBcontroller;


public class SolicitConcediuCommand extends Command
{
    User user;
    String startDate;
    String endDate;
    long diff;

    public SolicitConcediuCommand(User user, String startDate, String endDate, long diff) 
    {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.diff = diff;
        
    }
    
    @Override
    public Object execute()
    {
        ResultSet rs=null;
        try 
        {
            String sql;
            Statement st = DBcontroller.getI().getSt();                
                
            sql = "select tip from angajat where angajat_id = " + user.id;
             rs = st.executeQuery(sql);
            rs.next();
            int tip = rs.getInt("tip");
            
            if (tip == 1)
            {
                sql = "INSERT INTO Concedii (start_date, end_date, stare, angajat_id) VALUES ( to_date('" +
                    startDate + "', 'dd-mm-yyyy'), to_date(' " + endDate + "','dd-mm-yyyy'), 1 ," + user.id + ")";
            } 
            else 
            {
                sql = "INSERT INTO Concedii (start_date, end_date, stare, angajat_id) VALUES ( to_date('" +
                    startDate + "', 'dd-mm-yyyy'), to_date(' " + endDate + "','dd-mm-yyyy'), 0 ," + user.id + ")";
            }
 
            st.executeUpdate(sql);
            rs.close();
            

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LogCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(rs!=null)
                try {
                    rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(SolicitAprobareCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
