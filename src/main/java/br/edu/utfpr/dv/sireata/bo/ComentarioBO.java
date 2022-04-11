package br.edu.utfpr.dv.sireata.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.utfpr.dv.sireata.dao.ComentarioDAO;
import br.edu.utfpr.dv.sireata.model.Comentario;
import br.edu.utfpr.dv.sireata.model.Comentario.SituacaoComentario;

public class ComentarioBO {
	ComentarioDAO dao = new ComentarioDAO();
	
	public Comentario buscarPorId(int id) throws Exception{
		try{
			return dao.buscarPorId(id);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public Comentario buscarPorUsuario(int idUsuario, int idPauta) throws Exception{
		try{
			return dao.buscarPorUsuario(idUsuario, idPauta);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Comentario> listarPorPauta(int idPauta) throws Exception{
		try{
			return dao.listarPorPauta(idPauta);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public void validarDados(Comentario comentario) throws Exception{
		if((comentario.getSituacao() == SituacaoComentario.RECUSADO) && (comentario.getComentarios().trim().isEmpty())){
			throw new Exception("Informe o seu comentário.");
		}
		if((comentario.getSituacaoComentarios() == SituacaoComentario.RECUSADO) && (comentario.getMotivo().trim().isEmpty())){
			throw new Exception("Informe o motivo da recusa.");
		}
	}
	
	public int salvar(Comentario comentario) throws Exception{
		try{
			if((comentario.getPauta() == null) || (comentario.getPauta().getIdPauta() == 0)){
				throw new Exception("Informe a pauta.");
			}		
			this.validarDados(comentario);			
			return dao.salvar(comentario);
		}catch(Exception e){
			exception(e);
			throw new Exception(e.getMessage());
		}
	}
	private void exception(Exception e){
		Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
	}

}
