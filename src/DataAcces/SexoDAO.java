package DataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.naming.spi.DirStateFactory.Result;

import DataAcces.DTO.SexoDTO;

public class SexoDAO extends SQLiteDataHelper implements IDAO<SexoDTO> {

    @Override
    public boolean create(SexoDTO entity) throws Exception {
        String query="INSERT INTO SEXO (Nombre) VALUES(?)";
        try {
            Connection          conn=opConnection();
            PreparedStatement   pstmt=conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return false;
    }

    @Override
    public List<SexoDTO> readAll() throws Exception {
        return null;
    }

    @Override
    public SexoDTO readBy(Integer id) throws Exception {
        SexoDTO oS=new SexoDTO();
        String query="  SELECT IdSexo "
                    +" ,Nombre        "
                    +" ,Estado        "
                    +" ,FechaCrea     "
                    +" ,FechaModifica "
                    +" FROM SEXO "
                    +" WHERE Estado=`a`AND IdSexo= "+id.toString();

        try {
            Connection conn=opConnection();
            Statement  stmt=conn.createStatement();
            ResultSet  rs=stmt.executeQuery(query);
            while (rs.next()) {
                oS=new SexoDTO(rs.getInt(1)
                    ,rs.getString(2)
                    ,rs.getString(3)
                    ,rs.getString(4)
                    ,rs.getString(5));
            }            
        } catch (Exception e) {
            throw e;
        }
        return oS;
    }

    @Override
    public boolean update(SexoDTO entity) throws Exception {
        return false;
    }
}
