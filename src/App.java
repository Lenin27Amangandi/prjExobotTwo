import DataAcces.DTO.SexoDAO;
import DataAcces.DTO.SexoDTO;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            SexoDAO sDAO = new SexoDAO();
            for (SexoDTO s : sDAO.readAll()) {
                System.out.println(s.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
