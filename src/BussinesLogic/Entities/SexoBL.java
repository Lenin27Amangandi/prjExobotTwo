package BussinesLogic.Entities;

import java.util.List;

import DataAcces.DTO.SexoDAO;
import DataAcces.DTO.SexoDTO;

public class SexoBL {

    private SexoDTO sexo;
    private SexoDAO sDao = new SexoDAO();

    public SexoBL() {}

    public List<SexoDTO> getAll() throws Exception {
        // List<SexoDTO> lst =sDao.readAll();
        // for (SexoDTO sexoDTO : lst) {
        //     sexoDTO.setNombre(sexoDTO.getNombre().toLowerCase());
        // }
        // return lst;

        return sDao.readAll();
    }

    public SexoDTO getBy(int idSexo) throws Exception {
        sexo = sDao.readBy(idSexo);
        return sexo;
    }

    public boolean add(SexoDTO sexoDTO) throws Exception {
        return sDao.create(sexoDTO);
    }

    public boolean update(SexoDTO sexoDTO) throws Exception {
        return sDao.update(sexoDTO);

    }

    public boolean delete(int idSexo) throws Exception {
        return sDao.delete(idSexo);
    }

    public Integer getRowCount() throws Exception {
        return sDao.getRowCount();
    }

}
