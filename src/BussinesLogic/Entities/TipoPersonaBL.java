package BussinesLogic.Entities;

import java.util.List;

import DataAcces.DTO.PersonaTipoDAO;
import DataAcces.DTO.PersonaTipoDTO;

public class TipoPersonaBL {

    private PersonaTipoDTO ptDTO;
    private PersonaTipoDAO ptDAO = new PersonaTipoDAO();

    public TipoPersonaBL() {}

    public List<PersonaTipoDTO> getAll() throws Exception {
        return ptDAO.readAll();
    }

    public PersonaTipoDTO getBy(int idRegistro) throws Exception {
        ptDTO = ptDAO.readBy(idRegistro);
        return ptDTO;
    }

    public boolean add(PersonaTipoDTO regDTO) throws Exception {
        return ptDAO.create(regDTO);
    }

    public boolean update(PersonaTipoDTO regDTO) throws Exception {
        return ptDAO.update(regDTO);

    }

    public boolean delete(int idRegistro) throws Exception {
        return ptDAO.delete(idRegistro);
    }

    public Integer getRowCount() throws Exception {
        return ptDAO.getRowCount();
    }

}
