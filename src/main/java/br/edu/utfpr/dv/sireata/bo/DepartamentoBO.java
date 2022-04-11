package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.DepartamentoDAO;
import br.edu.utfpr.dv.sireata.model.Departamento;

public class DepartamentoBO {
	DepartamentoDAO dao = new DepartamentoDAO();
	
	public Departamento buscarPorId(int id) throws Exception{
		try{
			return dao.buscarPorId(id);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public Departamento buscarPorOrgao(int idOrgao) throws Exception{
		try{
			return dao.buscarPorOrgao(idOrgao);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Departamento> listarTodos(boolean apenasAtivos) throws Exception{
		try{
			return dao.listarTodos(apenasAtivos);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Departamento> listarPorCampus(int idCampus, boolean apenasAtivos) throws Exception{
		try{
			return dao.listarPorCampus(idCampus, apenasAtivos);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Departamento> listarParaCriacaoAta(int idCampus, int idUsuario) throws Exception{
		try{
			return dao.listarParaCriacaoAta(idCampus, idUsuario);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Departamento> listarParaConsultaAtas(int idCampus, int idUsuario) throws Exception{
		try{
			return dao.listarParaConsultaAtas(idCampus, idUsuario);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public int salvar(Departamento departamento) throws Exception{
		if((departamento.getCampus() == null) || (departamento.getCampus().getIdCampus() == 0)){
			throw new Exception("Informe o câmpus do departamento.");
		}
		if(departamento.getNome().isEmpty()){
			throw new Exception("Informe o nome do departamento.");
		}
		
		try{			
			return dao.salvar(departamento);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	private void exception(Exception e){
		Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
	}
}
