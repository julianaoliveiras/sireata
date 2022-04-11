package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.CampusDAO;
import br.edu.utfpr.dv.sireata.model.Campus;

public class CampusBO {
	CampusDAO dao = new CampusDAO();
	
	public Campus buscarPorId(int id) throws Exception{
		try{
			return dao.buscarPorId(id);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public Campus buscarPorDepartamento(int idDepartamento) throws Exception{
		try{
			return dao.buscarPorDepartamento(idDepartamento);
		}catch(Exception e){
			exception(e);			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Campus> listarTodos(boolean apenasAtivos) throws Exception{
		try{
			return dao.listarTodos(apenasAtivos);
		}catch(Exception e){
			exception(e);			
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Campus> listarParaCriacaoAta(int idUsuario) throws Exception{
		try{
			return dao.listarParaCriacaoAta(idUsuario);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Campus> listarParaConsultaAtas(int idUsuario) throws Exception{
		try{
			return dao.listarParaConsultaAtas(idUsuario);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public int salvar(Campus campus) throws Exception{
		if(campus.getNome().isEmpty()){
			throw new Exception("Informe o nome do câmpus.");
		}
		
		try{
		return dao.salvar(campus);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	private void exception(Exception e){
		Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
	}

}
