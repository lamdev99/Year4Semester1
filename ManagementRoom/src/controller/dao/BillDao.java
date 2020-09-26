/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;

/**
 *
 * @author lamit
 */
public class BillDao extends MainDao{

    public BillDao() {
        super();
    }
    
    public boolean insertBill(Bill bill){
        try {
            PreparedStatement pre = super.getConnection().prepareStatement(MainSQLStatement.INSERT_BILL);
            pre.setInt(1, bill.getBr().getId());
            pre.setInt(2, (int) bill.getTotal());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
