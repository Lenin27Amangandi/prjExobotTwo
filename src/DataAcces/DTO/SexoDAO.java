package DataAcces.DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAcces.IDAO;
import DataAcces.SQLiteDataHelper;

public class SexoDAO extends SQLiteDataHelper implements IDAO<SexoDTO> {

    @Override
    public boolean create(SexoDTO entity) throws Exception {
        String query = "INSERT INTO Catalogo (IdCatalogoTipo,Nombre,Descripcion) VALUES(?,?,?)";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<SexoDTO> readAll() throws Exception {

        // ,IdCatalogoTipo
        // ,Nombre
        // ,Descripcion
        // ,Estado
        // ,FechaCrea
        // ,FechaModifica

        List<SexoDTO> lst = new ArrayList<>();
        String query = "SELECT IdCatalogo "
                + " ,IdCatalogoTipo  "
                + " ,Nombre          "
                + " ,Descripcion     "
                + " ,Estado          "
                + " ,FechaCrea       "
                + " ,FechaModifica   "
                + " From Catalogo    "
                + " WHERE Estado='A' "
                + " AND   IdCatalogoTipo = 2";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                SexoDTO s = new SexoDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7));
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean update(SexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CATALOGO SET Nombre=?, Descriipcion=?, FechaModifica=?, WHERE IdCatalogo=?";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "INSERT INTO Catalogo SET Estado=? WHERE IdCatalogo=?";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }

    }

    @Override
    public SexoDTO readBy(Integer id) throws Exception {
        SexoDTO s = new SexoDTO();
        String query = "SELECT IdCatalogo "
                + " ,IdCatalogoTipo  "
                + " ,Nombre          "
                + " ,Descripcion     "
                + " ,Estado          "
                + " ,FechaCrea       "
                + " ,FechaModifica   "
                + " From Catalogo    "
                + " WHERE Estado='A' "
                + " AND   IdCatalogoTipo = 2"
                + " AND   IdCatalogo = " + id.toString();

        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                s = new SexoDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            throw e;
        }
        return s;
    }

    // public Integer getRowCount() throws Exception {
    //     String query = "SELECT COUNT(*) TotalReg"
    //             + "FROM Catalogo"
    //             + "WHERE Estado='A'"
    //             + "AND IdCatalogoTipo=2";
    //     try {
    //         Connection conn = opConnection();
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery(query);
    //         while (rs.next()) {
    //             return rs.getInt(1);

    //         }
    //     } catch (SQLException e) {
    //         throw new PatException(e.getMessage(), getClass().getName(), "getMaxRow");
    //     }
    //     return 0;
    // }

}
