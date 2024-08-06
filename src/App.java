import BussinesLogic.Entities.EstadoCivilBL;
import BussinesLogic.Entities.SexoBL;
import BussinesLogic.Entities.TipoPersonaBL;
import DataAcces.DTO.EstadoCivilDAO;
import DataAcces.DTO.EstadoCivilDTO;
import DataAcces.DTO.PersonaTipoDAO;
import DataAcces.DTO.PersonaTipoDTO;
import DataAcces.DTO.SexoDAO;
import DataAcces.DTO.SexoDTO;

public class App {
    public static void main(String[] args) throws Exception {

        // Pruebas Dao
        // try {
        // SexoDAO sDAO = new SexoDAO();
        // for (SexoDTO s : sDAO.readAll()) {
        // System.out.println(s.toString());
        // }
        // System.out.println("------------------");
        // PersonaTipoDAO pDAO = new PersonaTipoDAO();
        // for (PersonaTipoDTO reg : pDAO.readAll()) {
        // System.out.println(reg.toString());
        // }
        // System.out.println("------------------");
        // EstadoCivilDAO ecDao = new EstadoCivilDAO();
        // for (EstadoCivilDTO reg : ecDao.readAll()) {
        // System.out.println(reg.toString());
        // }
        // System.out.println("------------------");
        // } catch (Exception e) {
        // System.out.println(e.toString());
        // }

        // int a;
        // try {
        // a = 10 / 0;
        // } catch (ArithmeticException e) {
        // System.out.println("Thu erro es divicion para cero ,,, " + e.getMessage());
        // }

        try {
            SexoBL sBL = new SexoBL();
            for (SexoDTO s : sBL.getAll()) {
                System.out.println(s.toString());
            }
            System.out.println("-----------------------");

            EstadoCivilBL ecBL = new EstadoCivilBL();
            for (EstadoCivilDTO reg : ecBL.getAll()) {
                System.out.println(reg.toString());
            }

            System.out.println("----------------------");

            TipoPersonaBL tpBL = new TipoPersonaBL();
            for (PersonaTipoDTO reg : tpBL.getAll()) {
                System.out.println(reg.toString());
            }
            System.out.println("----------------------");

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
