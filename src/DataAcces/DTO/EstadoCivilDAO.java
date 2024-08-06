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

public class EstadoCivilDAO extends SQLiteDataHelper implements IDAO<EstadoCivilDTO> {

    @Override
    public boolean create(EstadoCivilDTO entity) throws Exception {
        String query = "INSERT INTO Catalogo (IdCatalogoTipo,Nombre,Descripcion) VALUES(?,?,?)";
        try {
            Connection conn = opConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<EstadoCivilDTO> readAll() throws Exception {

        List<EstadoCivilDTO> lst = new ArrayList<>();
        String query = "SELECT IdCatalogo "
                + " ,IdCatalogoTipo  "
                + " ,Nombre          "
                + " ,Descripcion     "
                + " ,Estado          "
                + " ,FechaCrea       "
                + " ,FechaModifica   "
                + " From Catalogo    "
                + " WHERE Estado='A' "
                + " AND   IdCatalogoTipo = 3";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                EstadoCivilDTO s = new EstadoCivilDTO(rs.getInt(1)
                                        , rs.getInt(2)
                                        , rs.getString(3)
                                        , rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        , rs.getString(7));
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean update(EstadoCivilDTO entity) throws Exception {
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
    public EstadoCivilDTO readBy(Integer id) throws Exception {
        EstadoCivilDTO s = new EstadoCivilDTO();
        String query = "SELECT IdCatalogo "
                + " ,IdCatalogoTipo  "
                + " ,Nombre          "
                + " ,Descripcion     "
                + " ,Estado          "
                + " ,FechaCrea       "
                + " ,FechaModifica   "
                + " From Catalogo    "
                + " WHERE Estado='A' "
                + " AND   IdCatalogoTipo = 3"
                + " AND   IdCatalogo = " + id.toString();

        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                s = new EstadoCivilDTO(rs.getInt(1)
                                        , rs.getInt(2)
                                        , rs.getString(3)
                                        , rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        , rs.getString(7));
                                    }
        } catch (SQLException e) {
            throw e;
        }
        return s;
    }

    public Integer getRowCount() throws Exception {
        String query = "SELECT COUNT(*) TotalReg"
                + "FROM Catalogo"
                + "WHERE Estado='A'"
                + "AND IdCatalogoTipo=2";
        try {
            Connection conn = opConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }
}
