import BussinesLogic.Entities.SexoBL;
import DataAcces.DTO.EstadoCivilDAO;
import DataAcces.DTO.EstadoCivilDTO;
import DataAcces.DTO.PersonaTipoDAO;
import DataAcces.DTO.PersonaTipoDTO;
import DataAcces.DTO.SexoDAO;
import DataAcces.DTO.SexoDTO;

public class App {
    public static void main(String[] args) throws Exception {

        //Pruebas Dao
        // try {
        //     SexoDAO sDAO = new SexoDAO();
        //     for (SexoDTO s : sDAO.readAll()) {
        //         System.out.println(s.toString());
        //     }
        //     System.out.println("------------------");
        //     PersonaTipoDAO pDAO = new PersonaTipoDAO();
        //     for (PersonaTipoDTO reg : pDAO.readAll()) {
        //         System.out.println(reg.toString());
        //     }
        //     System.out.println("------------------");
        // } catch (Exception e) {
        //     System.out.println(e.toString());
        // }

        try {
            SexoBL sBL = new SexoBL();
            for (SexoDTO s : sBL.getAll()) {
                System.out.println(s.toString());
            }
            System.out.println("------------------");

            EstadoCivilDAO ecDao = new EstadoCivilDAO();
            for (EstadoCivilDTO reg : ecDao.readAll()) {
                System.out.println(reg.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
