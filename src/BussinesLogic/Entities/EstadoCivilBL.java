package BussinesLogic.Entities;

import java.util.List;

import DataAcces.DTO.EstadoCivilDTO;
import DataAcces.DTO.EstadoCivilDAO;

public class EstadoCivilBL {

    private EstadoCivilDTO ecDTO;
    private EstadoCivilDAO ecDAO = new EstadoCivilDAO();

    public EstadoCivilBL() {}

    public List<EstadoCivilDTO> getAll() throws Exception {
        List<EstadoCivilDTO> lst = ecDAO.readAll();
        for (EstadoCivilDTO sDTO : lst) {
            sDTO.setNombre(sDTO.getNombre().toUpperCase());
        }
        return lst;
        // return ecDAO.readAll();
    }

    public EstadoCivilDTO getBy(int idRegistro) throws Exception {
        ecDTO = ecDAO.readBy(idRegistro);
        return ecDTO;
    }

    public boolean add(EstadoCivilDTO regDTO) throws Exception {
        return ecDAO.create(regDTO);
    }

    public boolean update(EstadoCivilDTO regDTO) throws Exception {
        return ecDAO.update(regDTO);

    }

    public boolean delete(int idRegistro) throws Exception {
        return ecDAO.delete(idRegistro);
    }

    public Integer getRowCount() throws Exception {
        return ecDAO.getRowCount();
    }

}
